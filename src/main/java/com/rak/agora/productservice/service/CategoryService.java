package com.rak.agora.productservice.service;

import com.rak.agora.productservice.exceptions.CategoryNotFoundException;
import com.rak.agora.productservice.models.Category;
import com.rak.agora.productservice.payloads.CategoryPayload;
import com.rak.agora.productservice.response.CategoryResponse;
import java.util.List;

public interface CategoryService {
  CategoryResponse getCategory(String id) throws CategoryNotFoundException;

  List<CategoryResponse> getAllCategories();

  CategoryResponse create(CategoryPayload payload);

  CategoryResponse update(String id, CategoryPayload payload) throws CategoryNotFoundException;

  void delete(String id) throws CategoryNotFoundException;

  Category getId(String id) throws CategoryNotFoundException;
}
