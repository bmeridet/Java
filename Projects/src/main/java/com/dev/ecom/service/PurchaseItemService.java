package com.dev.ecom.service;

import com.dev.ecom.model.Purchase;
import com.dev.ecom.model.PurchaseItem;
import com.dev.ecom.repository.PurchaseItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseItemService {

    @Autowired
    private PurchaseItemRepository purchaseItemRepo;

    public PurchaseItem GetPurchaseItemById(long id) { return purchaseItemRepo.findById(id).get(); }

    public List<PurchaseItem> GetAllPurchaseItemsByPurchase(Purchase purchase) { return purchaseItemRepo.findAllByPurchase(purchase); }

    public void UpdatePurchaseItem(PurchaseItem purchaseItem) { purchaseItemRepo.save(purchaseItem); }

    public void DeletePurchaseItemById(long id) { purchaseItemRepo.deleteById(id); }

    public void DeleteAllPurchaseItemsByPurchase(Purchase purchase) { purchaseItemRepo.deleteAllByPurchase(purchase); }
}