package com.dev.ecom.service;

import com.dev.ecom.model.Product;
import com.dev.ecom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    public Product GetProductById(long id) { return productRepo.findById(id).get(); }

    public void UpdateProduct(Product product) { productRepo.save(product); }

    public void DeleteProductById(long id) { productRepo.deleteById(id); }

    public List<Product> GetAllProducts() { return productRepo.findAll(); }
}
