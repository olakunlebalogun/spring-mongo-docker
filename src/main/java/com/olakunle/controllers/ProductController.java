package com.olakunle.controllers;


import com.olakunle.entities.Product;
import com.olakunle.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getProducts () {
        return productService.getProducts();

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProduct (@PathVariable("id") Integer id) {
        return productService.getProduct(id.longValue());
    }

    @PostMapping ("")
    @ResponseStatus(HttpStatus.CREATED)
    public String addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }



}
