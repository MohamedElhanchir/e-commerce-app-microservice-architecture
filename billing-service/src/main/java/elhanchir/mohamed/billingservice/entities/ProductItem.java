package elhanchir.mohamed.billingservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import elhanchir.mohamed.billingservice.model.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Bill bill;
    private double price;
    private int quantity;
    private double discount;
    @Transient
    private Product product;

}
