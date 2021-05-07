package com.dev.ecom.controller;

import com.dev.ecom.model.*;
import com.dev.ecom.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private PurchaseItemService purchaseItemService;

    @Autowired
    private UserService userService;


    @PostMapping("/admin/{adminId}/{password}")
    public String Login(@PathVariable String adminId, @PathVariable String password, javax.servlet.http.HttpServletRequest request)
    {
        Admin admin = adminService.Authenticate(adminId, password);

        if (admin == null)
            return "Invalid id or password";

        HttpSession session = request.getSession();
        session.setAttribute("admin", admin);

        return "dashboard";
    }

    @GetMapping("/adminlogout")
    public String Logout(javax.servlet.http.HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        session.invalidate();
        return "Successfully logged out";
    }

    @GetMapping("/admin/{Id}")
    public Admin GetAdminById(@PathVariable long Id)
    {
        return adminService.GetAdminById(Id);
    }

    @PutMapping("/admin")
    public String UpdatePwd(@RequestBody String password, javax.servlet.http.HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");

        if (admin == null)
            return "redirect to admin login";

        admin.setPwd(password);

        adminService.UpdatePwd(admin);
        return "Password updated";
    }

    @PutMapping("/admin/new")
    public void CreateAdmin(Admin admin) { adminService.UpdatePwd(admin); }

    @GetMapping("/admin/products")
    public List<Product> Products(javax.servlet.http.HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") == null)
            return null;

        return productService.GetAllProducts();
    }

    @GetMapping("/admin/categories")
    public List<Category> Categories(javax.servlet.http.HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") == null)
            return null;

        return categoryService.GetAllCategories();
    }

    @GetMapping("/admin/users")
    public List<User> Users(javax.servlet.http.HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") == null)
            return null;

        return userService.GetAllUsers();
    }

    @GetMapping("/admin/user/{id}")
    public User UserById(@PathVariable long id, javax.servlet.http.HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") == null)
            return null;

        return userService.GetUserById(id);
    }

    @GetMapping("/admin/purchases")
    public List<Purchase> Purchases(javax.servlet.http.HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") == null)
            return null;

        return purchaseService.GetAllPurchases();
    }

    @GetMapping("/admin/purchases/{uid}/{date}")
    public List<PurchaseItem> PurchasesByUserAndDate(@PathVariable long uid, @PathVariable Date date, javax.servlet.http.HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") == null)
            return null;

        User user = userService.GetUserById(uid);

        List<Purchase> list = purchaseService.GetAllPurchasesByUserAndDate(user, date);
        List<PurchaseItem> results = new ArrayList<>();

        for (Purchase p : list)
        {
            results.add(purchaseItemService.GetPurchaseItemById(p.getId()));
        }

        return results;
    }

    @DeleteMapping("/admin/delete/category/{id}")
    public String DeleteCategory(@PathVariable long id, javax.servlet.http.HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") == null)
            return "Admin not logged in.";

        categoryService.DeleteCategoryById(id);
        return "Delete successful";
    }

    @PutMapping("/admin/update/category/{id}/{name}")
    public String UpdateCategory(@PathVariable long id, @PathVariable String name, javax.servlet.http.HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") == null)
            return "Admin not logged in.";

        Category category = categoryService.GetCategoryById(id);
        category.setName(name);
        categoryService.UpdateCategory(category);

        return "Category updated.";
    }

    @DeleteMapping("/admin/delete/product/{id}")
    public String DeleteProduct(@PathVariable long id, javax.servlet.http.HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") == null)
            return "Admin not logged in.";

        productService.DeleteProductById(id);
        return "Delete successful.";
    }

    @PutMapping("/admin/update/product/{id}/{cid}/{name}/{price}")
    public String UpdateProduct(@PathVariable long id, @PathVariable long cid, @PathVariable String name, @PathVariable BigDecimal price, javax.servlet.http.HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") == null)
            return "Admin not logged in.";

        Product product = productService.GetProductById(id);
        Category category = categoryService.GetCategoryById(cid);
        product.setCategory(category);
        product.setName(name);
        product.setPrice(price);
        productService.UpdateProduct(product);

        return "Product updated.";
    }
}
