package com.camunda.democamundadb.model;

public class Movie {
    private String title;
    private String gener;

    public Movie(String title, String gener) {
        this.title = title;
        this.gener = gener;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGener() {
        return gener;
    }

    public void setGener(String gener) {
        this.gener = gener;
    }
}
