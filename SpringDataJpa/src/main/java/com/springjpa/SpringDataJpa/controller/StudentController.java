package com.springjpa.SpringDataJpa.controller;

import com.springjpa.SpringDataJpa.dto.StudentDTO;
import com.springjpa.SpringDataJpa.dto.StudentResponse;
import com.springjpa.SpringDataJpa.entity.Department;
import com.springjpa.SpringDataJpa.entity.Student;
import com.springjpa.SpringDataJpa.repository.StudentClosedProjection;
import com.springjpa.SpringDataJpa.repository.StudentOpenProjection;
import com.springjpa.SpringDataJpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getStudents(){
        return  studentService.findAllStudents();
    }
//When you call /student/1, both mappings match (because 1 can be bound as a String and as a Long),
// so Spring MVC can’t decide which method to use and throws IllegalStateException:
// Ambiguous handler methods.
    @GetMapping("/id/{studId}")
    public Student getStudentById(@PathVariable Long studId){
        return studentService.findStudentById(studId);
    }

    @GetMapping("/name/{studName}")
    public Student getStudentByName(@PathVariable String studName){
        return studentService.findStudentByName(studName);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @PutMapping("/{studId}")
    public Student updateStudent(@RequestBody Student student, @PathVariable Long studId){
        Student oldStudent = studentService.findStudentById(studId);
        if(oldStudent != null){
            // not using ! while checking empty
            oldStudent.setName(student.getName()!=null && !student.getName().equals("")?student.getName():oldStudent.getName());
            oldStudent.setEmail(student.getEmail()!=null &&  !student.getEmail().equals("")?student.getEmail():oldStudent.getEmail());
            return studentService.updateStudent(oldStudent);
        }
        return  null;
    }

    @DeleteMapping("/{studId}")
    public void deleteStudent(@PathVariable Long studId){
        studentService.deleteStudentById(studId);
    }

    @PutMapping("/{studId}/course/{courseId}")
    public Student enrollStudentInCourse(@PathVariable Long studId,@PathVariable Long courseId){

        return studentService.enrollStudentInCourse(studId,courseId);

    }

    @PutMapping("/{studId}/department/{deptId}")
    public Department assignDepartmentToStudent(@PathVariable Long studId, @PathVariable Long deptId){
        return studentService.assignDepartmentToStudent(studId,deptId);
    }



    @PutMapping("/{studId}/profile/{profileId}")
    public Student updateStudentProfile(@PathVariable Long studId,@PathVariable Long profileId){
        return studentService.updateStudentProfile(studId,profileId);
    }

    // DERIVED QUERIES spring automatically writes the queries
    @GetMapping("/email/{email}")
    public Optional<Student> findStudentByEmail(@PathVariable String email){
       return studentService.findStudentByEmail(email);
    }

    @PostMapping("/search")
    public List<Student> searchByNameAndEmail(@RequestBody Student filter){
        return studentService.searchByNameAndEmail(filter.getName(),filter.getEmail());
    }


    @GetMapping("/name/contains/{keyword}")
    public List<Student> findByNameContaining(@PathVariable String keyword) {
        return studentService.findByNameContaining(keyword);
    }


    @GetMapping("/department/{deptName}")
    public List<Student> findByDepartmentName(@PathVariable String deptName) {
        return studentService.findByDepartmentName(deptName);
    }


    @GetMapping("/email/{email}/exists")
    public boolean existsByEmail(@PathVariable String email) {
        return studentService.existsByEmail(email);
    }



    @GetMapping("/sorted/name-desc")
    public List<Student> findAllSortedByNameDesc() {
        return studentService.findAllSortedByNameDesc();
    }


    //NAMED QUERY
    @GetMapping("/named/{studName}")
    public Student findByName(@PathVariable String studName) {
        return studentService.findByName(studName);
    }


    //PROJECTIONS
    @GetMapping("/close-projection")
    public List<StudentClosedProjection> getStudentClosedProjections() {
        return studentService.getStudents();
    }

    @GetMapping("/open-projection/{name}")
    public StudentOpenProjection getOpenProjectionByName(@PathVariable String name) {
        return studentService.getStudentByName(name);
    }


    @GetMapping("/dto")
    public List<StudentDTO> getAllDTOs() {
        return studentService.getAllStudentDTOs();
    }

    @GetMapping("/dto/{name}")
    public List<StudentDTO> getDTOByName(@PathVariable String name) {
        return studentService.getStudentDTOByName(name);
    }

    @GetMapping("/students-dto-modelmapper")
    public List<StudentResponse> getStudentsResponsDTOModelMapper() {
        return studentService.getStudentResponseDTOModelMapper();
    }

}
