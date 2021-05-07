package com.dev.ecom.repository;

import com.dev.ecom.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByEmailAndPwd(String email, String pwd);
    User findUserByEmail(String email);
}
