package com.nimap.ProductCategory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nimap.ProductCategory.repository.CategoryRepository;
import com.nimap.ProductCategory.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

import com.nimap.ProductCategory.entity.Category;
import com.nimap.ProductCategory.entity.Product;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    
    public Product createProduct(Product product) {
        if (product.getCategory() != null && product.getCategory().getId() != null) {
            Optional<Category> category = categoryRepository.findById(product.getCategory().getId());
            if (category.isPresent()) {
                product.setCategory(category.get());
            } else {
                
                throw new RuntimeException("Category not found");
            }
        }
        return productRepository.save(product);
    }

    
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

   
    public Product updateProduct(Long id, Product product) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found");
        }
        product.setId(id);  
        return productRepository.save(product);
    }

   
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found");
        }
        productRepository.deleteById(id);
    }
}
