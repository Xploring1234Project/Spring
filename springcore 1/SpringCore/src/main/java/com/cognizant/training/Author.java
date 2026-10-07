package com.cognizant.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Author {
    //@Value("Gosling")
    private String authorName;
    //field injection
    //@Autowired
    private Book book;

    //constructor injection
    public Author(@Value("James") String authorName, @Autowired Book book) {
        this.authorName = authorName;
        this.book = book;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Book getBook() {
        return book;
    }

    //setter injection
    /*@Autowired
    public void setBook(Book book) {
        this.book = book;
    }*/
}
