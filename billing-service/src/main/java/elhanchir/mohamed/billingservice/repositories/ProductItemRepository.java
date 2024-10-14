package elhanchir.mohamed.billingservice.repositories;

import elhanchir.mohamed.billingservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
   
}
