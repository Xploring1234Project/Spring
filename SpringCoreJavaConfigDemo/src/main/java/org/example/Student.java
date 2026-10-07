package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Student {
    //injecting values from properties file directly into fields
    //@Value("${app.name}")
    private String name;
    //@Value("${app.rollNo}")
    private int rollNo;
    //@Value("${app.department}")
    private String department;

    //@Value("#{'${app.marks}'.split(',')}")
    private List<Integer> marks =  new ArrayList<>();

    //public Student(){}

    public Student( @Value("${app.name}") String name,
                    @Value("${app.rollNo}") int rollNo,
                    @Value("${app.department}") String department,
                    @Value("#{'${app.marks}'.split(',')}") List<Integer> marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.department = department;
        this.marks = marks;
    }



    // assigning the values from properties file using setter methods
   /* @Value("${app.name}")
    public void setName(String name)
    { this.name = name; }

    @Value("${app.rollNo}")
    public void setRollNo(int rollNo)
    { this.rollNo = rollNo; }

    @Value("${app.department}")
    public void setDepartment(String department)
    { this.department = department; }

    @Value("#{'${app.marks}'.split(',')}")
    public void setMarks(List<Integer> marks)
    { this.marks = marks; }*/


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNo=" + rollNo +
                ", department='" + department + '\'' +
                ", marks=" + marks +
                '}';
    }
}
