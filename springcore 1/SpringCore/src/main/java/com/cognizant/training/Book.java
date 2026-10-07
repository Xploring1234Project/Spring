package com.cognizant.training;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book
{
    //field injection
    //@Value("B001")
    private String bookCode;
    //@Value("Spring in action")
    private String bookName;
    //public Book(){}

    //constructor injection
    public Book(@Value("B001") String bookCode, @Value("Spring in action") String bookName) {
        this.bookCode = bookCode;
        this.bookName = bookName;
    }

    public String getBookCode() {
        return bookCode;
    }

    //setter injection
   /* @Value("B001")
    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }*/

    public String getBookName() {
        return bookName;
    }

    /*@Value("Spring in action")
    public void setBookName( String bookName) {
        this.bookName = bookName;
    }*/
}
