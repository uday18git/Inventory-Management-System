package com.example.order.service.model;
import jakarta.persistence.*;

@Entity
public class orderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private int quantity;
    private String status;

    // Getters and Setters
    public orderModel() {

    }
    public orderModel(Long productId, int quantity, String status) {
        this.productId = productId;
        this.quantity = quantity;
        this.status = status;
    }
    public Long getId() {
        return id;

    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;

    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

}
