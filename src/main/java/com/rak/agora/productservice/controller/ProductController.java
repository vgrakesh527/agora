package com.rak.agora.productservice.controller;

import com.rak.agora.productservice.exceptions.CategoryNotFoundException;
import com.rak.agora.productservice.exceptions.ProductNotFoundException;
import com.rak.agora.productservice.payloads.ProductPayload;
import com.rak.agora.productservice.response.ProductResponse;
import com.rak.agora.productservice.service.ProductService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/products")
public class ProductController {
  private final ProductService productService;

  @GetMapping
  public ResponseEntity<List<ProductResponse>> getAllProducts() {
    return ResponseEntity.ok(productService.getAllProducts());
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductResponse> getProduct(@PathVariable("id") String id)
      throws ProductNotFoundException {
    return ResponseEntity.ok(productService.getProduct(id));
  }

  @PostMapping
  public ResponseEntity<ProductResponse> create(@RequestBody ProductPayload payload)
      throws CategoryNotFoundException {
    return new ResponseEntity<>(productService.create(payload), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ProductResponse> update(@PathVariable("id") String id,
                                                @RequestBody ProductPayload payload)
      throws CategoryNotFoundException, ProductNotFoundException {
    return new ResponseEntity<>(productService.update(id, payload), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") String id)
      throws ProductNotFoundException {
    productService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
