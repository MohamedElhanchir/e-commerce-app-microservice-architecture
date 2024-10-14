package elhanchir.mohamed.billingservice.repositories;

import elhanchir.mohamed.billingservice.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {

}
