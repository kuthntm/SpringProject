package com.example.SpringProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Getter
public class Article {
    @Id // 엔티티 대푯값
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동적으로 1씩 증가
    private Long id;
    @Column
    private String title;
    @Column
    private String content;

    public void patch(Article article) {
        if (article.title != null)
            this.title = article.title;
        if (article.content != null)
            this.content = article.content;
    }

    /*public Long getId() { // Getter 메서드
        return id;
    }*/
}
