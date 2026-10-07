package com.springjpa.SpringDataJpa.repository;

import org.springframework.beans.factory.annotation.Value;

public interface StudentOpenProjection {
    String getName();
    String getEmail();
    @Value("#{target.name+ '-' +target.email}")
    public String getStudentInfo();

    /*{
        "email": "phani@gmail.com",
        "name": "Phani",
        "studentInfo": "Phani-phani@gmail.com"
    }*/
}
