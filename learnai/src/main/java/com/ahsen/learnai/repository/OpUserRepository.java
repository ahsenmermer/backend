package com.ahsen.learnai.repository;

import com.ahsen.learnai.entity.OpUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpUserRepository extends JpaRepository<OpUser, Long> {
    OpUser findOneById(Long id);

    boolean existsByUsername(String username);

    boolean existsByUsernameAndPassword(String username, String password);

    OpUser findUserByUsername(String username);
}
