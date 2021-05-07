package com.dev.ecom.repository;

import com.dev.ecom.model.Purchase;
import com.dev.ecom.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    public List<Purchase> findAllByUser(User user);
    public List<Purchase> findAllByUserAndDate(User user, Date date);
}
