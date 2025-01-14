package com.rak.agora.productservice.service.impl;

import com.rak.agora.productservice.exceptions.CategoryNotFoundException;
import com.rak.agora.productservice.exceptions.ProductNotFoundException;
import com.rak.agora.productservice.models.Product;
import com.rak.agora.productservice.payloads.ProductPayload;
import com.rak.agora.productservice.repositories.ProductRepository;
import com.rak.agora.productservice.response.ProductResponse;
import com.rak.agora.productservice.service.CategoryService;
import com.rak.agora.productservice.service.ProductService;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
  private final ProductRepository productRepository;
  private final CategoryService categoryService;

  @Override
  public ProductResponse getProduct(String productId) throws ProductNotFoundException {
    var product = getId(productId);
    return ProductResponse.toResponse(product);
  }

  @Override
  public List<ProductResponse> getAllProducts() {
    return productRepository.findAll().stream().map(ProductResponse::toResponse).toList();
  }

  @Override
  public ProductResponse create(ProductPayload payload) throws CategoryNotFoundException {
    Product product = payload.toEntity();
    product.setCategory(categoryService.getId(payload.categoryId()));
    var result = productRepository.save(product);
    return ProductResponse.toResponse(result);
  }

  @Override
  public ProductResponse update(String productId, ProductPayload payload)
      throws ProductNotFoundException, CategoryNotFoundException {
    var product = getId(productId);
    product.setPrice(payload.price());
    product.setTitle(payload.title());
    product.setDescription(payload.description());
    product.setCategory(categoryService.getId(payload.categoryId()));
    var result = productRepository.save(product);
    return ProductResponse.toResponse(result);
  }

  @Override
  public void delete(String productId) throws ProductNotFoundException {
    var product = getId(productId);
    productRepository.delete(product);
  }

  private Product getId(String productId) throws ProductNotFoundException {
    try {

      return productRepository.findById(UUID.fromString(productId))
          .orElseThrow(
              () -> new ProductNotFoundException(111, productId + " is not available!!!"));
    } catch (Exception e) {
      throw new ProductNotFoundException(222, e.getMessage());
    }
  }

}
