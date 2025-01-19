package com.rak.agora.orderservice.repository;

import com.rak.agora.orderservice.models.OrderItem;
import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, BigInteger> {
}
