package com.vanlang.webbanhang.controller;

import com.vanlang.webbanhang.model.Category;
import com.vanlang.webbanhang.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/categories")
public class CategoryApiController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategory() {
        return categoryService.getAllCategories();
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Category category = categoryService.getCategoryById(id).orElseThrow(() -> new RuntimeException("Category not found on :: " + id));
        return ResponseEntity.ok().body(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category categoryDetails) {
        Category category = categoryService.getCategoryById(id).orElseThrow(() -> new RuntimeException("Category not found on :: " + id));
        category.setName(categoryDetails.getName());

        final Category updatedCategory = categoryService.saveCategory(category);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        Category product = categoryService.getCategoryById(id).orElseThrow(() -> new RuntimeException("Category not found on :: "
                + id));
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().build();
    }
    
    
    
    
    
    
    
    
    
}
