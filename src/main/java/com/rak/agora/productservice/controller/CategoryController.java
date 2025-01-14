package com.rak.agora.productservice.controller;

import com.rak.agora.productservice.exceptions.CategoryNotFoundException;
import com.rak.agora.productservice.payloads.CategoryPayload;
import com.rak.agora.productservice.response.CategoryResponse;
import com.rak.agora.productservice.service.CategoryService;
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
@RequestMapping("api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable String id) throws CategoryNotFoundException {
        return new ResponseEntity<>(categoryService.getCategory(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> create(@RequestBody CategoryPayload payload) {
        return new ResponseEntity<>(categoryService.create(payload), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> update(@PathVariable String id, @RequestBody CategoryPayload payload) throws CategoryNotFoundException {
        return ResponseEntity.ok(categoryService.update(id, payload));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) throws CategoryNotFoundException {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
