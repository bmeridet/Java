package com.dev.ecom.repository;

import com.dev.ecom.model.Purchase;
import com.dev.ecom.model.PurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseItemRepository extends JpaRepository<PurchaseItem, Long> {

    public List<PurchaseItem> findAllByPurchase(Purchase purchase);
    public void deleteAllByPurchase(Purchase purchase);
}
