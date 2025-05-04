package com.example.SpringProject.dto;

import com.example.SpringProject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor // 롬복을 이용한 리팩터링. 생성자 대체
@ToString
public class ArticleForm {
    private Long id;
    private String title;
    private String content;

    public Article toEntity() {
        return new Article(id, title, content);
    }
}
