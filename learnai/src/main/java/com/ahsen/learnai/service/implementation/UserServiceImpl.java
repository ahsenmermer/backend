package com.ahsen.learnai.service.implementation;

import com.ahsen.learnai.entity.User;
import com.ahsen.learnai.repository.TopicRepository;
import com.ahsen.learnai.repository.UserRepository;
import com.ahsen.learnai.service.UserService;
import com.ahsen.learnai.validation.UserValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserValidator userValidator;
    private final TopicRepository topicRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public String create(User user) throws Exception {
        userValidator.createUser(user);

        userRepository.save(user);
        return user.getUsername() + " created.";
    }

    @Override
    public User getUserById(Long id) throws Exception {
        User user = userRepository.findOneById(id);
        userValidator.findUserById(user);

        return user;
    }

    @Override
    public User login(String username, String password) throws Exception {
        userValidator.login(username, password);

        return userRepository.findUserByUsername(username);
    }


}
