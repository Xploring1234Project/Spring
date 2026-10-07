package com.cognizant.training;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Student {

    //@Value("1003")
    private int id;
    //@Value("Minu")
    private String name;
    //@Value("true")
    private boolean active;

    @Value("#{'${student.subjects}'.split(':')}")
    //@Value("${student.subjects}")
    private List<String> subjects;


   /* public Student()
    {}*/
    public Student(
            @Value("${student.id}") int id,
            @Value("${student.name}") String name,
            @Value("${student.active}") boolean active) {

        this.id = id;
        this.name = name;
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

   // @Value("true")
    public void setActive(boolean active) {
        this.active = active;
    }

    public int getId() {
        return id;
    }
   // @Value("1002")
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    //@Value("Sri")
    public void setName(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println(id + " " + name + " " + active+" "+subjects);
    }
}


