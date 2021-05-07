package com.dev.ecom.controller;

import com.dev.ecom.model.User;
import com.dev.ecom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/User/{userId}/{pwd}")
    public User Authenticate(@PathVariable String userId, @PathVariable String pwd) { return userService.Authenticate(userId, pwd); }

    @PostMapping("/User")
    public User CreateUser(@RequestBody User user) { return userService.CreateUser(user); }

    @GetMapping("/User/{id}")
    public User GetUserById(@PathVariable long id) { return userService.GetUserById(id); }

    @GetMapping("/User/{email}")
    public User GetUserByEmail(@PathVariable String email) { return userService.GetUserByEmailId(email); }

    @PutMapping("/User")
    public void UpdateUser(@RequestBody User user) { userService.UpdateUser(user); }

    @DeleteMapping("/User/{id}")
    public void DeleteUserById(@PathVariable long id) { userService.DeleteUserById(id); }

    @GetMapping("/Users")
    public List<User> GetAllUsers() { return userService.GetAllUsers(); }

}
