package com.example.order.service.controller;
import com.example.order.service.model.orderModel;
import com.example.order.service.repository.orderRepository;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class orderController {

    private final orderRepository orderRepository;
    private final ProductServiceClient productServiceClient;

    public orderController(orderRepository orderRepository, ProductServiceClient productServiceClient) {
        this.orderRepository = orderRepository;
        this.productServiceClient = productServiceClient;
    }

    @GetMapping("/getAll")
    public List<orderModel> getAllOrders() {
        return orderRepository.findAll();
    }
    @PostMapping("/place")
    public orderModel placeOrder(@RequestBody orderModel order) {
        // Check product availability
//        boolean isAvailable=true;
        boolean isAvailable = productServiceClient.checkProductAvailability(order.getProductId(), order.getQuantity());

        if (!isAvailable) {
            throw new RuntimeException("Product not available in sufficient quantity");
        }
        // Save the order
        return orderRepository.save(order);
    }
    @FeignClient(name = "product-service")
    public interface ProductServiceClient {
        @GetMapping("/products/{id}/check-availability")
        boolean checkProductAvailability(@PathVariable("id") Long productId, @RequestParam("quantity") int quantity);
    }
}

