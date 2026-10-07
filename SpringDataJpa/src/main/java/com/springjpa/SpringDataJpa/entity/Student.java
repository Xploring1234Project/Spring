package com.springjpa.SpringDataJpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NamedQuery(name="Student.findByName" , query="SELECT s FROM Student s WHERE s.name = :name")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="email" , unique = true)
    private String email;

    // 1. ONE-TO-ONE: Student <-> Profile
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="profile_id", referencedColumnName = "id")
    @JsonProperty("profile")
    @JsonManagedReference
    private Profile profile;

    // 2. MANY-TO-ONE: Many Students -> One Department
    @ManyToOne
    @JoinColumn(name="department_id")
    @JsonProperty("department")
    @JsonBackReference
    private Department department;

    // 3. MANY-TO-MANY: Many Students <-> Many Courses
    @ManyToMany
    @JoinTable(
            name="student_course_enrollment",
            joinColumns = @JoinColumn(name="student_id"),
            inverseJoinColumns = @JoinColumn(name="course_id")
    )
    @JsonProperty("courses")
    @JsonIgnoreProperties("students")
    private Set<Course> courses  = new HashSet<>();


}
