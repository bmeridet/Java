package com.dev.ecom.controller;

import com.dev.ecom.model.Purchase;
import com.dev.ecom.model.User;
import com.dev.ecom.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @GetMapping("/purchase/{id}")
    public Purchase GetPurchaseById(@PathVariable long id) { return purchaseService.GetPurchaseById(id); }

    @GetMapping("/purchases")
    public List<Purchase> GetAllPurchases() { return purchaseService.GetAllPurchases(); }

    @GetMapping("/purchasesbyuser")
    public List<Purchase> GetAllPurchasesByUser(@RequestBody User user) { return purchaseService.GetAllPurchasesByUser(user); }

    @PutMapping("/purchase")
    public void UpdatePurchase(@RequestBody Purchase purchase) { purchaseService.UpdatePurchase(purchase); }
}
