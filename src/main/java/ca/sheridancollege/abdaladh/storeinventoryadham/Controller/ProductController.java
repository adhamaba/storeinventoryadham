package ca.sheridancollege.abdaladh.storeinventoryadham.controller;

import ca.sheridancollege.abdaladh.storeinventoryadham.model.Product;
import ca.sheridancollege.abdaladh.storeinventoryadham.model.Store;
import ca.sheridancollege.abdaladh.storeinventoryadham.repository.ProductRepository;
import ca.sheridancollege.abdaladh.storeinventoryadham.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StoreRepository storeRepository;

    // GET mapping to display the add product page
    @GetMapping("/addProduct")
    public String addProductPage(Model model) {
        // Pass the current list of products and stores to the view
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("stores", storeRepository.findAll());
        return "addProduct";
    }

    // POST mapping to handle form submission and add a new product
    @PostMapping("/addProduct")
    public String addProduct(@RequestParam String productName,
                             @RequestParam double productPrice,
                             @RequestParam int productQuantity,
                             @RequestParam Long storeId) {
        // Find the store by ID; if not found, throw an exception
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new RuntimeException("Store not found"));
        // Create a new product associated with the store
        Product product = new Product(null, productName, productPrice, productQuantity, store);
        productRepository.save(product);
        // Redirect to the same page to display the updated product list
        return "redirect:/addProduct";
    }
}
