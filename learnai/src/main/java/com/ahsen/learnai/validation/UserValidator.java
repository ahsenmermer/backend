package com.ahsen.learnai.validation;

import com.ahsen.learnai.entity.User;
import com.ahsen.learnai.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UserValidator {

    private final UserRepository userRepository;
    public void createUser(User user) throws Exception {
        if(userRepository.existsByUsername(user.getUsername())){
            throw new Exception("User already exists");
        }
    }
    public void findUserById(User user) throws Exception {
        if (user == null) {
            throw new Exception("User not found.");
        }
        if(user.getPassword().length() < 6){
            throw new Exception("Password length greater than 6.");
        }
    }

    public void login(String username, String password) throws Exception {
        if(!userRepository.existsByUsernameAndPassword(username, password)){
            throw new Exception("Username or password not found");
        }
    }
}
