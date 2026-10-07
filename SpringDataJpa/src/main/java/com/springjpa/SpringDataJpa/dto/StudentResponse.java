package com.springjpa.SpringDataJpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {
    private String name;
    private String email;
    private Long departmentId;
    private String profileBio;         // From Profile
    private String profilePhoneNumber; // From Profile
}