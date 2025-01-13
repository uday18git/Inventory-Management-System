package com.example.order.service.repository;
import com.example.order.service.model.orderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface orderRepository extends JpaRepository<orderModel, Long> {
}
