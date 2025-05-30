package com.example.SpringProject.service;

import com.example.SpringProject.dto.ArticleForm;
import com.example.SpringProject.entity.Article;
import com.example.SpringProject.repository.ArticleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ActiveProfiles("test")
@SpringBootTest
class ArticleServiceTest {
    @Autowired
    ArticleService articleService;

    @Test
    void index() {
        List<Article> expected = new ArrayList<>(Arrays.asList(
                new Article(1L, "가가가가", "1111"),
                new Article(2L, "나나나나", "2222"),
                new Article(3L, "다다다다", "3333"),
                new Article(4L, "영화 추천", "댓글 부탁"),
                new Article(5L, "음식 추천", "댓글 달아주세요"),
                new Article(6L, "취미 추천", "부탁드립니다")
        ));
        List<Article> articles = articleService.index();
        assertEquals(expected.toString(), articles.toString());
    }

    @Test
    void show_success() {
        Long id = 1L;
        Article expected = new Article(id, "가가가가", "1111");
        Article article = articleService.show(id);
        assertEquals(expected.toString(), article.toString());
    }
    @Test
    void show_failed(){
        Long id = -1L;
        Article expected = null;

        Article article = articleService.show(id);

        assertEquals(expected,article);
    }

    @Test
    @Transactional
    void create_success() {
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(null, title, content);
        Article expected = new Article(7L, title, content);

        Article article = articleService.create(dto);

        assertEquals(expected.toString(), article.toString());
    }
    @Test
    @Transactional
    void create_failed(){
        Long id = 4L;
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = null;

        Article article = articleService.create(dto);

        assertEquals(expected, article);
    }
}