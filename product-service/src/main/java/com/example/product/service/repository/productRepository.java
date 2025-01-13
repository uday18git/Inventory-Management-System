package com.example.product.service.repository;
import com.example.product.service.model.productModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productRepository extends JpaRepository<productModel, Long> {
}