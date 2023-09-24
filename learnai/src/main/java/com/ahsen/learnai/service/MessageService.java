package com.ahsen.learnai.service;

import com.ahsen.learnai.entity.Message;

import java.util.List;

public interface MessageService {
    List<Message> getAll();

    Long create(Long topicId, Message message);

    List<Message> getMessagesByTopicId(Long topicId);
}

