package com.dev.ecom.controller;

import com.dev.ecom.model.Category;
import com.dev.ecom.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/category/{id}")
    public Category GetCategoryById(@PathVariable long id) { return categoryService.GetCategoryById(id); }

    @PutMapping("/category")
    public void UpdateCategory(@RequestBody Category category) { categoryService.UpdateCategory(category); }

    @DeleteMapping("/category/{id}")
    public void DeleteCategoryById(@PathVariable long id) { categoryService.DeleteCategoryById(id); }

    @GetMapping("/categories")
    public List<Category> GetAllCategories() { return categoryService.GetAllCategories(); }

    @GetMapping("/categories/{id}")
    public String GetCategoriesDropDown(@PathVariable long id) { return categoryService.GetCategoriesDropDown(id); }
}
