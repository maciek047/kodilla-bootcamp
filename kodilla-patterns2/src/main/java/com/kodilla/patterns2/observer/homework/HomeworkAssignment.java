package com.kodilla.patterns2.observer.homework;

public class HomeworkAssignment {
    private String name;
    private String content;

    public HomeworkAssignment(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }
}
