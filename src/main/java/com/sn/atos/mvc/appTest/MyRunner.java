package com.sn.atos.mvc.appTest;

import com.sn.atos.mvc.appTest.entities.Comment;
import com.sn.atos.mvc.appTest.entities.Product;
import com.sn.atos.mvc.appTest.repositories.CommentRepository;
import com.sn.atos.mvc.appTest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void run(String... args) throws Exception {
        Product product1 = new Product("Iphone 11", "Telephone", 300000);
        Product product2 = new Product("Samsung A20", "Telephone", 150000);

        product1 = productRepository.save(product1);
        productRepository.save(product2);

        /*
        Comment comment = new Comment("Ceci est un message");
        comment.setProduct(product1);
        commentRepository.save(comment);

         */

        List<Product> products = productRepository.findByNameQuery("Iphone 11");

        products.forEach((product) ->
        {
            System.out.println(product.getName()+ " count ->"+ product.getComments().size());
        });
    }
}
