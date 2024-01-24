package com.ahsen.learnai.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;

    @ManyToOne
    @JoinColumn(name = "opUser_id", nullable = false)
    @JsonIgnore
    private OpUser opUser;

    @OneToMany(mappedBy = "topic")
    @JsonIgnore
    private Set<Message> messages = new HashSet<>();

}
