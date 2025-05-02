package com.example.SpringProject.dto;

public class ArticleForm {
    private String title;
    private String content;

    public ArticleForm(String title, String content) { // 생성자
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() { // 데이터를 잘 받았는지 확인할 메서드
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
