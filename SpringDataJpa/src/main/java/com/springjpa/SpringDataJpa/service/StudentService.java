package com.springjpa.SpringDataJpa.service;

import com.springjpa.SpringDataJpa.dto.StudentDTO;
import com.springjpa.SpringDataJpa.dto.StudentResponse;
import com.springjpa.SpringDataJpa.entity.Course;
import com.springjpa.SpringDataJpa.entity.Department;
import com.springjpa.SpringDataJpa.entity.Profile;
import com.springjpa.SpringDataJpa.entity.Student;
import com.springjpa.SpringDataJpa.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepo;
    @Autowired
    private CourseRepository courseRepo;
    @Autowired
    private DepartmentRepository departmentRepo;
    @Autowired
    private ProfileRepository profileRepo;
    @Autowired
    private ModelMapper modelMapper;

    public List<Student> findAllStudents(){
        return studentRepo.findAll();
    }

    public Student findStudentById(Long id){
        return studentRepo.findById(id).get();
    }

    public Student findStudentByName(String name){
        return studentRepo.findStudentByName(name);
    }

    public Student createStudent(Student student){
        return studentRepo.save(student);
    }

    public Student updateStudent(Student student){
        return studentRepo.save(student);
    }

    public void deleteStudentById(Long id){
        studentRepo.deleteById(id);
    }

    public Student enrollStudentInCourse(Long studentId, Long courseId){
        Student student = findStudentById(studentId);
        Course course = courseRepo.findById(courseId).get();

        student.getCourses().add(course);
        return studentRepo.save(student);
    }

    public Department assignDepartmentToStudent(Long studId,Long deptId){
        Student student = studentRepo.findById(studId).get();
        Department department =  departmentRepo.findById(deptId).get();

        // 2. Update Student side (Updates the DB Foreign Key)
        student.setDepartment(department);

        // 3. Update Department side (Updates the Java Collection for the response)
        // This is crucial for the return statement to show the new student immediately
        department.getStudents().add(student);

        // 4. Save the student
        studentRepo.save(student);

        // 5. Return the department so you can see the updated list in Postman
        return department;
    }


    public Student updateStudentProfile(Long studentId, Long profileId){
        Student student = findStudentById(studentId);
        Profile profile = profileRepo.findById(profileId).get();

        student.setProfile(profile);
        return studentRepo.save(student);

    }

    //DERIVED QUERIES
    public Optional<Student> findStudentByEmail(String email){
        return studentRepo.findByEmail(email);
    }

    public List<Student> searchByNameAndEmail(String name, String email){
        return studentRepo.findByNameAndEmail(name,email);
    }

    public List<Student> findByNameContaining(String name){
        return studentRepo.findByNameContaining(name);
    }

    public List<Student> findByDepartmentName(String departmentName){
        return studentRepo.findByDepartmentName(departmentName);
    }

    public boolean existsByEmail(String email){
        return studentRepo.existsByEmail(email);
    }

    public List<Student> findAllSortedByNameDesc(){
        return  studentRepo.findByOrderByNameDesc();
    }

    //NAMED QUERY
    public Student findByName(String name){
        return studentRepo.findByName(name);
    }


    // PROJECTIONS USING INTERFACE
    public List<StudentClosedProjection> getStudents(){
        return studentRepo.getStudents();
    }

    public StudentOpenProjection getStudentByName(String name){
        return studentRepo.getStudentByName(name);
    }

    // PROJECTIONS USING CLASS - DTO
    public List<StudentDTO> getAllStudentDTOs() {
        return studentRepo.findAllStudentDTOs();
    }

    public List<StudentDTO> getStudentDTOByName(String name) {
        return studentRepo.findStudentDTOByName(name);
    }

    //Student Response using model mapper
    public List<StudentResponse> getStudentResponseDTOModelMapper() {
        return studentRepo.findAll().stream()
                .map(stud ->modelMapper.map(stud,StudentResponse.class))
                .toList();
    }
}

