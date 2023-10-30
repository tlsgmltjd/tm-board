package com.example.tmboard.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Board {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private Integer likes;
    @CreationTimestamp
    private Timestamp data;

    public void createBoard(String title, String content) {
        this.title = title;
        this.content = content;
        this.likes = 0;
    }

    public void modifyBoard(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void likes(Integer likes) {
        this.likes = likes;
    }
}

