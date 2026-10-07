package com.springjpa.SpringDataJpa.dto;

import lombok.*;

@Data
@NoArgsConstructor
public class StudentDTO {
    private String name;
    private String email;
    private Long departmentId;

    // CONSTRUCTOR FOR JPQL PROJECTION
    // Matches: new StudentDTO(s.name, s.email, s.department.id)
    public StudentDTO(String name, String email, Long departmentId) {
        this.name = name;
        this.email = email;
        this.departmentId = departmentId;
    }
}