package com.dev.ecom.service;

import com.dev.ecom.model.Category;
import com.dev.ecom.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepo;

    public Category GetCategoryById(long id) { return categoryRepo.findById(id).get(); }

    public void UpdateCategory(Category category) { categoryRepo.save(category); }

    public void DeleteCategoryById(long id) { categoryRepo.deleteById(id); }

    public List<Category> GetAllCategories() { return categoryRepo.findAll(); }

    public String GetCategoriesDropDown(long id)
    {
        StringBuilder sb = new StringBuilder();
        List<Category> list = GetAllCategories();
        for (Category cat : list)
        {
            if (cat.getId() == id)
                sb.append("<option>").append(cat.getId()).append(" selected>").append(cat.getName()).append("</option>");
            else
                sb.append("<option>").append(cat.getId()).append(">").append(cat.getName()).append("</option>");
        }

        return sb.toString();
    }
}
