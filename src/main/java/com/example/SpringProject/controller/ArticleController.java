package com.example.SpringProject.controller;

import com.example.SpringProject.dto.ArticleForm;
import com.example.SpringProject.entity.Article;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {
    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){ // 폼데이터를 DTO 객체로 받기
        System.out.println(form.toString());
        // 1. DTO를 엔티티로 변환
        Article article = form.toEntity();
        // 2. 리파지터리로 엔티티를 DB에 저장
        return "";
    }
}
