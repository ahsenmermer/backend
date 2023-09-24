package com.ahsen.learnai.controller;

import com.ahsen.learnai.entity.Topic;
import com.ahsen.learnai.pojo.TopicP;
import com.ahsen.learnai.service.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/topics")
@RestController
@AllArgsConstructor
public class TopicController {
    private final TopicService topicService;

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody Topic topic) {
        return ResponseEntity.ok(topicService.create(topic));
    }

    @GetMapping("/gettopicsbyuserid")
    public ResponseEntity<List<TopicP>> getTopicByUserId(@RequestParam("userId") Long userId) {
        return ResponseEntity.ok(topicService.getTopicsByUserId(userId));
    }

    @PostMapping("/addusertopic")
    public ResponseEntity<String> addUserTopic(@RequestParam("userId") Long userId, @RequestBody Topic topic) {
        topicService.addUserTopic(userId, topic);
        return ResponseEntity.ok("Ok");
    }

    @GetMapping("/getrndfourtopic")
    public ResponseEntity<Object> getRndFourTopic(@RequestParam("userId") Long userId){
        return ResponseEntity.ok(topicService.getRndFouTopic(userId));
    }
}

