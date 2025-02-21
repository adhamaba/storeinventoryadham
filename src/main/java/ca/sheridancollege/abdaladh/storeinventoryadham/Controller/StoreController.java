package ca.sheridancollege.abdaladh.storeinventoryadham.controller;

import ca.sheridancollege.abdaladh.storeinventoryadham.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StoreController {

    @Autowired
    private StoreRepository storeRepository;

    @GetMapping("/")
    public String index(Model model) {
        // Pass all stores to the view
        model.addAttribute("stores", storeRepository.findAll());
        return "index";
    }
}
