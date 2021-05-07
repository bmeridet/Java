package com.dev.ecom.controller;

import com.dev.ecom.model.Purchase;
import com.dev.ecom.model.PurchaseItem;
import com.dev.ecom.service.PurchaseItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PurchaseItemController {

    @Autowired
    PurchaseItemService purchaseItemService;

    @GetMapping("/purchaseitem/{id}")
    public PurchaseItem GetPurchaseItemById(@PathVariable long id) { return purchaseItemService.GetPurchaseItemById(id); }

    @GetMapping("/purchaseitems")
    public List<PurchaseItem> GetAllPurchaseItemsByPurchase(@RequestBody Purchase purchase)
    {
        return purchaseItemService.GetAllPurchaseItemsByPurchase(purchase);
    }

    @PutMapping("/purchaseitem")
    public void UpdatePurchaseItem(@RequestBody PurchaseItem purchaseItem) { purchaseItemService.UpdatePurchaseItem(purchaseItem); }

    @DeleteMapping("/purchaseitem/{id}")
    public void DeletePurchaseItemById(@PathVariable long id) { purchaseItemService.DeletePurchaseItemById(id); }

    @DeleteMapping("/purchaseitems")
    public void DeleteAllPurchaseItemsByPurchase(@RequestBody Purchase purchase)
    {
        purchaseItemService.DeleteAllPurchaseItemsByPurchase(purchase);
    }
}
