package com.test.project;

public class Post {
    public String title;
    public String content;

    // Firebase에서 데이터를 읽어올 때 필요
    public Post() {
    }

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Getter와 Setter 추가

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}