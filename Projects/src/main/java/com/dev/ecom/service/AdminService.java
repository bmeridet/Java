package com.dev.ecom.service;

import com.dev.ecom.model.Admin;
import com.dev.ecom.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepo;

    public Admin Authenticate(String adminId, String password)
    {
        return adminRepo.findAdminByAdminIdAndPwd(adminId, password);
    }

    public Admin GetAdminById(long Id)
    {
        return adminRepo.findById(Id).get();
    }

    public void UpdatePwd(Admin admin)
    {
        adminRepo.save(admin);
    }
}
