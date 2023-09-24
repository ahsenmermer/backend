package com.ahsen.learnai.service;

import com.ahsen.learnai.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    String create(User user) throws Exception;

    User getUserById(Long id) throws Exception;

    User login(String username, String password) throws Exception;
}
