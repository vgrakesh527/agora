package com.rak.agora.productservice.service;

import com.rak.agora.productservice.exceptions.CategoryNotFoundException;
import com.rak.agora.productservice.exceptions.ProductNotFoundException;
import com.rak.agora.productservice.payloads.ProductPayload;
import com.rak.agora.productservice.response.ProductResponse;
import java.util.List;

public interface ProductService {
    ProductResponse getProduct(String productId) throws ProductNotFoundException;

    List<ProductResponse> getAllProducts();

    ProductResponse create(ProductPayload payload) throws CategoryNotFoundException;

    ProductResponse update(String productId, ProductPayload payload) throws ProductNotFoundException, CategoryNotFoundException;

    void delete(String productId) throws ProductNotFoundException;
}
