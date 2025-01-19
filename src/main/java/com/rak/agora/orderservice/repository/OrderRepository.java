package com.rak.agora.orderservice.repository;

import com.rak.agora.orderservice.models.Order;
import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, BigInteger> {
}
