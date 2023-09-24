package com.ahsen.learnai.repository;

import com.ahsen.learnai.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findOneById(Long id);

    boolean existsByUsername(String username);

    boolean existsByUsernameAndPassword(String username, String password);

    User findUserByUsername(String username);
}
