package com.test.project;

public class DataModel {
    private String title;
    private String content;

    public DataModel(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return  title;
    }

    public String getContent() {
        return content;
    }
}
