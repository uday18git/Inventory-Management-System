package com.example.product.service.controller;
import com.example.product.service.model.productModel;
import com.example.product.service.repository.productRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class productController {

    private final productRepository productRepository;

    public productController(productRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/getAll")
    public List<productModel> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping("/add")
    public productModel addProduct(@RequestBody productModel product) {
        return productRepository.save(product);
    }

    @GetMapping("/{id}")
    public productModel getProductById(@PathVariable Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }
    // ProductController (Product Service - Modified)
    @GetMapping("/{id}/check-availability")
    public boolean checkProductAvailability(@PathVariable Long id, @RequestParam int quantity) {
        productModel product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return product.getQuantity() >= quantity;
    }
}
