package com.dev.ecom.controller;

import com.dev.ecom.model.Product;
import com.dev.ecom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/product/{id}")
    public Product GetProductById(@PathVariable long id) { return productService.GetProductById(id); }

    @PutMapping("/product")
    public void UpdateProduct(@RequestBody Product product) { productService.UpdateProduct(product); }

    @DeleteMapping("/product/{id}")
    public void DeleteProductById(@PathVariable long id) { productService.DeleteProductById(id); }

    @GetMapping("/products")
    public List<Product> GetAllProducts() { return productService.GetAllProducts(); }
}
