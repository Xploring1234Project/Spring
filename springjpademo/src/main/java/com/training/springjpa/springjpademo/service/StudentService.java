package com.training.springjpa.springjpademo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.springjpa.springjpademo.dao.StudentRepository;
import com.training.springjpa.springjpademo.model.Student;

import jakarta.transaction.Transactional;


@Service
public class StudentService {
@Autowired
StudentRepository studRepo;

	public Student saveStudent(Student s) {
		System.out.println("Repository "+studRepo);
		Student obj=studRepo.save(s);
		System.out.println(obj);
	return obj;

		//return studRepo.save(s);
	}

	public List<Student> getAllStudents()
	{
		
		return studRepo.findAll();
	}
	
	public  Student getStudentById(int rno)
	{
		
		return studRepo.findById(rno).get();
	}


	public List<Student> getStudentsByDepartment(String dept)
	{
		return studRepo.findByDepartment(dept);
	}

    public List<Student> getStudentsByNamePrefix(String prefix)
    {
        return studRepo.findByNameStartingWith(prefix);
    }
    public List<Student> getStudentsByNameSuffix(String suffix)
    {
        return studRepo.findByNameEndingWith(suffix);
    }

    public List<Student> getStudentsByDepartment(String dept,String name)
    {
        return studRepo.getStudentsByDepartment(dept,name);
    }
    public List<Student> getStudentsByDepartmentName(String dept)
    {
        return studRepo.getStudentsByDepartment(dept);
    }
    @Transactional
    public int updateStudentByName(String dept,String name)
    {
        return studRepo.updateStudentByName(dept,name);
    }
    public List<Student> fetchStudentByMail()
    {
        return studRepo.fetchStudentByMail();
    }
    public Student findStudentByEmail(String email)
    {
        return studRepo.findStudentByEmail(email);
    }

}
