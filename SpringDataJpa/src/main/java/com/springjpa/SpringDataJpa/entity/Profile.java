package com.springjpa.SpringDataJpa.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="bio")
    private String bio;
    @Column(name="phone_number")
    @JsonProperty("phone_number")
    private String phoneNumber;

    @OneToOne(mappedBy = "profile")
    @JsonBackReference
    private Student student;
}
