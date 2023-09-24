package com.ahsen.learnai.pojo;

import lombok.Data;

@Data
public class TopicP {
    private Long id;
    private String name;
    private String type;
    private Integer messageCount = 0;
}
