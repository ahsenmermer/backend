package com.ahsen.learnai.repository;

import com.ahsen.learnai.entity.Topic;
import com.ahsen.learnai.entity.OpUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    List<Topic> findAllByOpUser(OpUser opUser);
    Topic findOneById(Long id);
    List<Topic> findAllByOpUserIdNot(Long userId);

}
