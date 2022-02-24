package com.sn.atos.mvc.appTest.controllers;

import com.sn.atos.mvc.appTest.entities.Product;
import com.sn.atos.mvc.appTest.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public String showProducts(Model model){
        model.addAttribute("products", productRepository.findAll());

        return "index";
    }

    @GetMapping("/newProduct")
    public String newProduct(Product product){
        return "new-product";
    }

    @PostMapping("/addProduct")
    public String addProduct(@Valid Product product, BindingResult result, Model model){

        //Todo return to view if error
        productRepository.save(product);
        return "redirect:/";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable("id") long id, Product product, BindingResult result, Model model ){

        //Todo add error redirect to edit-product
        productRepository.save(product);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") long id, Model model){
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Product Id:"+ id));
        model.addAttribute("product", product);
        return "edit-product";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id, Model model){
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Product Id:"+ id));
        productRepository.delete(product);
        return "redirect:/";

    }


}
