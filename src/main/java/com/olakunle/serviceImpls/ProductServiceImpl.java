package com.olakunle.serviceImpls;

import com.olakunle.entities.Product;
import com.olakunle.repositories.ProductRepository;
import com.olakunle.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        List<Product> products = productRepository.findAll();
        if (products.isEmpty()) {
            throw new RuntimeException("The Product List is Empty");
        }
        return new ArrayList<>(products);
    }




    @Override
    public String addProduct(Product product) {
        if (product.getPrice() != null && product.getProductName() != null){
            productRepository.save(product);
            return "Product with ID " + product.getId() + " saved successfully";
        }
        return "Invalid Object! Please provide the necessary product properties";
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No Product with such ID"));
    }

}
