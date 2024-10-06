package elhanchir.mohamed.inventoryservice;

import elhanchir.mohamed.inventoryservice.entities.Product;
import elhanchir.mohamed.inventoryservice.repo.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.stream.Stream;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Product.class);
            Stream.of("Ordinateur","Imprimante","Smartphone").forEach(p->{
                productRepository.save(Product.builder()
                                .name(p)
                                .price(1000+Math.random()*9000)
                                .quantity(3+(int)(Math.random()*100))
                        .build());
            });

        };
    }
}
