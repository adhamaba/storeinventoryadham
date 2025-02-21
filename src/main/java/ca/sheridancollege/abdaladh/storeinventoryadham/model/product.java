package ca.sheridancollege.abdaladh.storeinventoryadham.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRODUCT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(unique = true, nullable = false, length = 255)
    private String productName;

    private double productPrice;
    private int productQuantity;

    // The 'store' field here corresponds to the mappedBy attribute in Store.
    @ManyToOne
    @JoinColumn(name = "STORE_ID")
    private Store store;
}
