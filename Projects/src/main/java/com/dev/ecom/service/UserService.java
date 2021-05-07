package com.dev.ecom.service;

import com.dev.ecom.model.User;
import com.dev.ecom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public User Authenticate(String userId, String pwd)
    {
        return userRepo.findUserByEmailAndPwd(userId, pwd);
    }

    public User CreateUser(User user) { return userRepo.save(user); }

    public User GetUserById(long id) { return userRepo.findById(id).get(); }

    public User GetUserByEmailId(String email) { return userRepo.findUserByEmail(email); }

    public void UpdateUser(User user) { userRepo.save(user); }

    public void DeleteUserById(long id) { userRepo.deleteById(id); }

    public List<User> GetAllUsers() { return userRepo.findAll(); }
}
