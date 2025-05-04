package com.example.SpringProject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Article {
    @Id // 엔티티 대푯값
    @GeneratedValue // 자동적으로 1씩 증가
    private Long id;
    @Column
    private String title;
    @Column
    private String content;
}
