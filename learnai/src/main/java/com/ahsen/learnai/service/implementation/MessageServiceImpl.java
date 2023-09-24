package com.ahsen.learnai.service.implementation;

import com.ahsen.learnai.entity.Message;
import com.ahsen.learnai.entity.Topic;
import com.ahsen.learnai.repository.MessageRepository;
import com.ahsen.learnai.repository.TopicRepository;
import com.ahsen.learnai.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;
    private final TopicRepository topicRepository;
    @Override
    public List<Message> getAll() {
        return messageRepository.findAll();
    }
    @Override
    public Long create(Long topicId, Message message) {
        Topic topic = topicRepository.findOneById(topicId);
        message.setTopic(topic);

        return messageRepository.save(message).getId();
    }
    @Override
    public List<Message> getMessagesByTopicId(Long topicId) {
        return messageRepository.findAllByTopicId(topicId);
    }
}
