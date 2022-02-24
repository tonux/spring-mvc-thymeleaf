package com.sn.atos.mvc.appTest;

import com.sn.atos.mvc.appTest.entities.Product;
import com.sn.atos.mvc.appTest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        Product product1 = new Product("Iphone 11", "Telephone", 300000);
        Product product2 = new Product("Samsung A20", "Telephone", 150000);

        productRepository.save(product1);
        productRepository.save(product2);


    }
}
