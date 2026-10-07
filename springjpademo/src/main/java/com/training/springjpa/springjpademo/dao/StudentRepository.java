package com.training.springjpa.springjpademo.dao;

import java.util.List;

import com.training.springjpa.springjpademo.dto.StudentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.training.springjpa.springjpademo.model.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	//positional parameter
    //select * from student_details where dept='' and stud_name=''
	@Query("select s from Student s where s.department=?1 and s.name=?2" )
	public List<Student> getStudentsByDepartment(String dept,String name);
	
    //named parameter
	@Query("select s from Student s where s.department=:dept" )
	public List<Student> getStudentsByDepartment(String dept);
	

	@Modifying
	@Query("delete  from Student s where s.name=?1" )
	public int deleteStudentByName(String name);

    //update student_details set dept='IT' where name='abc'
	@Modifying
	@Query("update Student s set s.department=?1 where s.name=?2" )
	public int updateStudentByName(String dept,String name);
	
	
    @Query(value="select * from student_details ",  nativeQuery=true)
 	public List<Student> fetchStudentByMail();
	

    //Derived Queries
	List<Student> findByNameStartingWith(String prefix);
	List<Student> findByNameEndingWith(String suffix);
	List<Student> findByDepartment(String dept);
    // Student      findByName(String name);

//Named query
    @Query(name = "Student.findByEmail")
    Student findStudentByEmail(String email);
	
//Projection
List<StudentView> findByName(String name);

//Class projection
    @Query("SELECT new com.training.springjpa.springjpademo.dto.StudentDTO(s.name, s.email) FROM Student s")
    List<StudentDTO> getStudents();

}
