package elhanchir.mohamed.customerservice;

import elhanchir.mohamed.customerservice.entities.Customer;
import elhanchir.mohamed.customerservice.repo.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.RestControllerConfiguration;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration restControllerConfiguration) {
        return args -> {
            restControllerConfiguration.exposeIdsFor(Customer.class);
            customerRepository.saveAll(List.of(
                    Customer.builder().name("Mohamed").email("med@gmail.com").build(),
                    Customer.builder().name("Hassan").email("hasan@gmail.com").build(),
                    Customer.builder().name("IMane").email("imane@gmail.com").build()
            ));
            customerRepository.findAll().forEach(System.out::println);
        };
    }
}
