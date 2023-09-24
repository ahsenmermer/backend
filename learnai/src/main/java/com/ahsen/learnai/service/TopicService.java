package com.ahsen.learnai.service;

import com.ahsen.learnai.entity.Topic;
import com.ahsen.learnai.pojo.TopicP;

import java.util.List;

public interface TopicService {
    Long create(Topic topic);

    List<TopicP> getTopicsByUserId(Long id);

    void addUserTopic(Long userId, Topic topic);

    Object getRndFouTopic(Long userId);
}
