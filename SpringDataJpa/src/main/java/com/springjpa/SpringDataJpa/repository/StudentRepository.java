package com.springjpa.SpringDataJpa.repository;

import com.springjpa.SpringDataJpa.dto.StudentDTO;
import com.springjpa.SpringDataJpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository  extends JpaRepository<Student, Long> {
    public Student findStudentByName(String name);

    // DERIVED QUERIES
    // 1. Simple lookup by unique field
    Optional<Student> findByEmail(String email);

    // 2. Multi-condition (AND/OR)
    List<Student> findByNameAndEmail(String name, String email);

    // 3. Partial matching (LIKE)
    List<Student> findByNameContaining(String keyword);

    // 4. Case-insensitive lookup
    List<Student> findByNameIgnoreCase(String name);

    // 5. Querying across relationships (Student -> Department)
    // Spring navigates to Student.department.name
    List<Student> findByDepartmentName(String deptName);

    // 6. Ordering results
    List<Student> findByOrderByNameDesc();

    // 7. Check existence
    boolean existsByEmail(String email);


    //CUSTOME QUERIES
    // JPQL with Named Parameters (Recommended for readability)
    @Query("SELECT s FROM Student s WHERE s.email = :email AND s.name = :name")
    Student findByEmailAndNameCustom(@Param("email") String email, @Param("name") String name);

    // JPQL with Positional Parameters (?1, ?2)
    @Query("SELECT s FROM Student s WHERE s.name LIKE %?1%")
    List<Student> searchByName(String name);

    // Native SQL (Targeting the actual database table 'student')
    @Query(value = "SELECT * FROM student WHERE email LIKE %:domain", nativeQuery = true)
    List<Student> findByEmailDomain(@Param("domain") String domain);

    // Complex Join in JPQL
    @Query("SELECT s FROM Student s JOIN s.courses c WHERE c.courseCode = :code")
    List<Student> findStudentsByCourseCode(@Param("code") String code);

    //NAMED QUERY
    Student findByName(@Param("name") String name);


    //JOIN QUERIES

    // Standard JOIN: Only filters Students who have a department
    @Query("SELECT s FROM Student s JOIN s.department d WHERE d.name = :name")
    List<Student> findByDeptName(@Param("name") String name);

    // JOIN FETCH: Fetches Student AND Department in ONE query
    // Use this when you know you'll need the Department data later
    @Query("SELECT s FROM Student s JOIN FETCH s.department WHERE s.email LIKE %:domain%")
    List<Student> findAllWithDepartmentByEmail(@Param("domain") String domain);

    // Many-to-Many FETCH
    @Query("SELECT s FROM Student s LEFT JOIN FETCH s.courses WHERE s.id = :id")
    Optional<Student> findStudentWithCourses(@Param("id") Long id);


    //PROJECTIONS USING INTERFACE
    @Query("SELECT s FROM Student s")
    List<StudentClosedProjection> getStudents();

    @Query("SELECT s FROM Student s WHERE s.name=:name")
    StudentOpenProjection getStudentByName(@Param("name") String name);


    //PROJECTIONS USING CLASS DTO

    /*// You must use the FULL package path for the DTO inside the query
    @Query("SELECT new com.springjpa.SpringDataJpa.dto.StudentDTO(s.name, s.email) FROM Student s")
    List<StudentDTO> findAllStudentDTOs();

    @Query("SELECT new com.springjpa.SpringDataJpa.dto.StudentDTO(s.name, s.email) FROM Student s WHERE s.name = :name")
    List<StudentDTO> findStudentDTOByName(@Param("name") String name);*/

    // 1. Get All with Department ID
    @Query("SELECT new com.springjpa.SpringDataJpa.dto.StudentDTO(s.name, s.email, s.department.id) " +
            "FROM Student s")
    List<StudentDTO> findAllStudentDTOs();

    // 2. Get by Name with Department ID
    @Query("SELECT new com.springjpa.SpringDataJpa.dto.StudentDTO(s.name, s.email, s.department.id) " +
            "FROM Student s WHERE s.name = :name")
    List<StudentDTO> findStudentDTOByName(@Param("name") String name);
}


