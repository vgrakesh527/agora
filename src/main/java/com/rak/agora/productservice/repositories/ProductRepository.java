package com.rak.agora.productservice.repositories;

import com.rak.agora.productservice.models.Product;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
}
