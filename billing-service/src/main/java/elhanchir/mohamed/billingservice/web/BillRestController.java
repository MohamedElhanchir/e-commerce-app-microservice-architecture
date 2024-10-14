package elhanchir.mohamed.billingservice.web;

import elhanchir.mohamed.billingservice.entities.Bill;
import elhanchir.mohamed.billingservice.repositories.BillRepository;
import elhanchir.mohamed.billingservice.repositories.ProductItemRepository;
import elhanchir.mohamed.billingservice.services.CustomerRestClient;
import elhanchir.mohamed.billingservice.services.ProductRestClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {
    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private ProductRestClient productRestClient;
    private CustomerRestClient customerRestClient;

    public BillRestController(BillRepository billRepository, ProductItemRepository productItemRepository, ProductRestClient productRestClient, CustomerRestClient customerRestClient) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.productRestClient = productRestClient;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping(path = "/fullBill/{id}")
    public Bill bill(@PathVariable Long id) {
        Bill bill = billRepository.findById(id).orElseThrow();
        bill.setCustomer(customerRestClient.getCustomerById(bill.getCustomerId()));
        bill.getProductItems().forEach(pi -> {
            pi.setProduct(productRestClient.getProductById(pi.getProductId()));
        });
        return bill;
    }
}
