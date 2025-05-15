package com.example.SpringProject.repository;

import com.example.SpringProject.entity.Article;
import com.example.SpringProject.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository;
    @Test
    @DisplayName("특정 게시글의 모든 댓글 조회")
    void findByArticleId() {
        /* Case 1: 4번 게시글의 모든 댓글 조회 */
        {
            // 1. 입력 데이터 준비
            Long articleId = 4L;
            // 2. 실제 데이터
            List<Comment> comments = commentRepository.findByArticleId(articleId);
            // 3. 예상 데이터
            Article article = new Article(4L, "영화 추천", "댓글 부탁");
            Comment a = new Comment(1L, article, "박", "아이언맨");
            Comment b = new Comment(2L, article, "김", "어벤져스");
            Comment c = new Comment(3L, article, "이", "헐크");
            List<Comment> expected = Arrays.asList(a,b,c);
            // 4. 비교 및 검증
            assertEquals(expected.toString(), comments.toString(), "4번 글의 모든 댓글을 출력");
        }
        /* Case 2: 1번 게시글의 모든 댓글 조회 */
        {
            // 1. 입력 데이터 준비
            Long articleId = 1L;
            // 2. 실제 데이터
            List<Comment> comments = commentRepository.findByArticleId(articleId);
            // 3. 예상 데이터
            Article article = new Article(1L, "가가가가", "1111");
            List<Comment> expected = Arrays.asList();
            // 4. 비교 및 검증
            assertEquals(expected.toString(), comments.toString(), "1번 글은 댓글이 없음");
        }
    }

    @Test
    @DisplayName("특정 닉네임의 모든 댓글 조회")
    void findByNickName() {
        /* Case 1: "박"의 모든 댓글 조회 */
        {
            // 1. 입력 데이터 준비
            String nickname = "박";
            // 2. 실제 데이터
            List<Comment> comments = commentRepository.findByNickName(nickname);
            // 3. 예상 데이터
            Comment a = new Comment(1L, new Article(4L, "영화 추천", "댓글 부탁"), nickname, "아이언맨");
            Comment b = new Comment(4L, new Article(5L, "음식 추천", "댓글 달아주세요"), nickname, "치킨");
            Comment c = new Comment(7L, new Article(6L, "취미 추천", "부탁드립니다"), nickname, "게임");
            List<Comment> expected = Arrays.asList(a, b, c);
            // 4. 비교 및 검증
            assertEquals(expected.toString(), comments.toString(), "박의 모든 댓글을 출력");
        }
    }
}