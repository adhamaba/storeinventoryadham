package ca.sheridancollege.abdaladh.storeinventoryadham.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "STORE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;

    @Column(unique = true, nullable = false, length = 255)
    private String storeName;

    // The mappedBy attribute here must exactly match the field name in the Product entity.
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Product> products;
}
