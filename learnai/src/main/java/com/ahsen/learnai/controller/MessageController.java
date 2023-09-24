package com.ahsen.learnai.controller;

import com.ahsen.learnai.entity.Message;
import com.ahsen.learnai.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/messages")
@AllArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @GetMapping
    public ResponseEntity<List<Message>> getALl() {
        return ResponseEntity.ok(messageService.getAll());
    }

    @PostMapping
    public ResponseEntity<Long> create(@RequestParam("topicId") Long topicId, @RequestBody Message message) {
        return ResponseEntity.ok(messageService.create(topicId, message));
    }

    @GetMapping("/getmessagesbytopicid")
    public ResponseEntity<List<Message>> getMessagesByTopicId(@RequestParam("topicId") Long topicId){
        return ResponseEntity.ok(messageService.getMessagesByTopicId(topicId));
    }
}
