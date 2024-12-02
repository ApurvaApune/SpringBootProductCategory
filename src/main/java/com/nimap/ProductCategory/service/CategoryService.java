package com.nimap.ProductCategory.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nimap.ProductCategory.entity.Category;
import com.nimap.ProductCategory.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

   
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    
    public Category updateCategory(Long id, Category category) {
        if (!categoryRepository.existsById(id)) {
            throw new RuntimeException("Category not found");
        }
        category.setId(id);  
        return categoryRepository.save(category);
    }

   
    public void deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new RuntimeException("Category not found");
        }
        categoryRepository.deleteById(id);
    }
}
