package com.ahsen.learnai.service;

import com.ahsen.learnai.entity.OpUser;

import java.util.List;

public interface UserService {
    List<OpUser> getAll();

    String create(OpUser opUser) throws Exception;

    OpUser getUserById(Long id) throws Exception;

    OpUser login(String username, String password) throws Exception;
}
