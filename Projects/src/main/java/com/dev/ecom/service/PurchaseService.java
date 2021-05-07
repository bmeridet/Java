package com.dev.ecom.service;

import com.dev.ecom.model.Purchase;
import com.dev.ecom.model.User;
import com.dev.ecom.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepo;

    public Purchase GetPurchaseById(long id) { return purchaseRepo.findById(id).get(); }

    public List<Purchase> GetAllPurchases() { return purchaseRepo.findAll(); }

    public List<Purchase> GetAllPurchasesByUser(User user) { return purchaseRepo.findAllByUser(user); }

    public void UpdatePurchase(Purchase purchase) { purchaseRepo.save(purchase); }

    public List<Purchase> GetAllPurchasesByUserAndDate(User user, Date date)
    {
        return purchaseRepo.findAllByUserAndDate(user, date);
    }
}
