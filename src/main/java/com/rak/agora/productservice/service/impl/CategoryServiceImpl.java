package com.rak.agora.productservice.service.impl;

import com.rak.agora.productservice.exceptions.CategoryNotFoundException;
import com.rak.agora.productservice.models.Category;
import com.rak.agora.productservice.payloads.CategoryPayload;
import com.rak.agora.productservice.repositories.CategoryRepository;
import com.rak.agora.productservice.response.CategoryResponse;
import com.rak.agora.productservice.service.CategoryService;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
  private CategoryRepository categoryRepository;

  @Override
  public CategoryResponse getCategory(String id) throws CategoryNotFoundException {
    var category = getId(id);
    return CategoryResponse.toResponse(category);
  }

  @Override
  public List<CategoryResponse> getAllCategories() {
    var categories = categoryRepository.findAll();
    return categories.stream().map(CategoryResponse::toResponse).toList();
  }

  @Override
  public CategoryResponse create(CategoryPayload payload) {
    var category = new Category();
    category.setName(payload.name());
    var result = categoryRepository.save(category);
    return CategoryResponse.toResponse(result);
  }

  @Override
  public CategoryResponse update(String id, CategoryPayload payload)
      throws CategoryNotFoundException {
    var category = getId(id);
    category.setName(payload.name());
    var result = categoryRepository.save(category);
    return CategoryResponse.toResponse(result);
  }

  @Override
  public void delete(String id) throws CategoryNotFoundException {
    var category = getId(id);
    categoryRepository.delete(category);
  }

  public Category getId(String id) throws CategoryNotFoundException {
    try {
      return categoryRepository.findById(UUID.fromString(id))
          .orElseThrow(() -> new CategoryNotFoundException(123, id + " is not found!!!"));
    } catch (Exception e) {
      throw new CategoryNotFoundException(222, e.getMessage());
    }
  }
}
