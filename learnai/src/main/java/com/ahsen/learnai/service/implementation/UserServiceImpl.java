package com.ahsen.learnai.service.implementation;

import com.ahsen.learnai.entity.OpUser;
import com.ahsen.learnai.repository.TopicRepository;
import com.ahsen.learnai.repository.OpUserRepository;
import com.ahsen.learnai.service.UserService;
import com.ahsen.learnai.validation.UserValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final OpUserRepository opUserRepository;

    private final UserValidator userValidator;
    private final TopicRepository topicRepository;

    @Override
    public List<OpUser> getAll() {
        return opUserRepository.findAll();
    }

    @Override
    public String create(OpUser opUser) throws Exception {
        userValidator.createUser(opUser);

        opUserRepository.save(opUser);
        return opUser.getUsername() + " created.";
    }

    @Override
    public OpUser getUserById(Long id) throws Exception {
        OpUser opUser = opUserRepository.findOneById(id);
        userValidator.findUserById(opUser);

        return opUser;
    }

    @Override
    public OpUser login(String username, String password) throws Exception {
        userValidator.login(username, password);

        return opUserRepository.findUserByUsername(username);
    }


}
