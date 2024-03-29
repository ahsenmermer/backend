package com.ahsen.learnai.service.implementation;

import com.ahsen.learnai.entity.OpUser;
import com.ahsen.learnai.entity.Topic;
import com.ahsen.learnai.pojo.TopicP;
import com.ahsen.learnai.repository.TopicRepository;
import com.ahsen.learnai.repository.OpUserRepository;
import com.ahsen.learnai.service.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@AllArgsConstructor
@Service
public class TopicServiceImpl implements TopicService {
    private final TopicRepository topicRepository;
    private final OpUserRepository opUserRepository;


    @Override
    public Long create(Topic topic) {
        topicRepository.save(topic);
        return topic.getId();
    }

    @Override
    public List<TopicP> getTopicsByUserId(Long id) {
        OpUser opUser = opUserRepository.findOneById(id);
        return topicToTopicPList(topicRepository.findAllByOpUser(opUser));
    }

    private List<TopicP> topicToTopicPList(List<Topic> topics) {
        List<TopicP> topicPS = new ArrayList<>();
        for (Topic topic : topics) {
            TopicP topicP = new TopicP();
            topicP.setName(topic.getName());
            topicP.setId(topic.getId());
            topicP.setType(topic.getType());
            topicP.setMessageCount(topic.getMessages().size());

            topicPS.add(topicP);
        }

        return topicPS;
    }

    @Override
    public void addUserTopic(Long userId, Topic topic) {
        OpUser opUser = opUserRepository.findOneById(userId);
        topic.setOpUser(opUser);
        topicRepository.save(topic);
    }

    @Override
    public Object getRndFouTopic(Long userId) {
        List<Topic> topics = topicRepository.findAllByOpUserIdNot(userId);
        List<TopicP> topicPS = new ArrayList<>();
        List<Topic> globalTopic = Arrays.asList(
                new Topic(null, "About ChatGpt", "Writing", null, null),
                new Topic(null, "My Character", "Writing", null, null),
                new Topic(null, "About Science", "Writing", null, null),
                new Topic(null, "About Software", "Writing", null, null)
        );
        if (topics != null && topics.size() >= 4) {
            Collections.shuffle(topics);
            topics = topics.subList(Math.max(topics.size() - 4, 0), topics.size());
            topicPS = topicToTopicPList(topics);
        }

        if (topics != null && topics.size() < 4) {
            return globalTopic;
        }

        return topicPS;
    }
}
