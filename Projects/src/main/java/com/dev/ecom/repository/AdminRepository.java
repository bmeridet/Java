package com.dev.ecom.repository;

import com.dev.ecom.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

        Admin findAdminByAdminIdAndPwd(String adminId, String password);

}
