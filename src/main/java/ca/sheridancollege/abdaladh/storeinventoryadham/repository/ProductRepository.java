package ca.sheridancollege.abdaladh.storeinventoryadham.repository;

import ca.sheridancollege.abdaladh.storeinventoryadham.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
