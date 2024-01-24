package com.ahsen.learnai.validation;

import com.ahsen.learnai.entity.OpUser;
import com.ahsen.learnai.repository.OpUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UserValidator {

    private final OpUserRepository opUserRepository;
    public void createUser(OpUser opUser) throws Exception {
        if(opUserRepository.existsByUsername(opUser.getUsername())){
            throw new Exception("User already exists");
        }
    }
    public void findUserById(OpUser opUser) throws Exception {
        if (opUser == null) {
            throw new Exception("User not found.");
        }
        if(opUser.getPassword().length() < 6){
            throw new Exception("Password length greater than 6.");
        }
    }

    public void login(String username, String password) throws Exception {
        if(!opUserRepository.existsByUsernameAndPassword(username, password)){
            throw new Exception("Username or password not found");
        }
    }
}
