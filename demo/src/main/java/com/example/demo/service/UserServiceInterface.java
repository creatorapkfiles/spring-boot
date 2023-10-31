package com.example.demo.service;

import com.example.demo.model.User;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public interface UserServiceInterface {
    public User findById(Long id);

    public List<User> findAll();
    public void saveUser(User user);

    public void deleteUserById (Long id);
}
