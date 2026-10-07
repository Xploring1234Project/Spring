package com.springjpa.SpringDataJpa.service;

import com.springjpa.SpringDataJpa.entity.Course;
import com.springjpa.SpringDataJpa.entity.Department;
import com.springjpa.SpringDataJpa.repository.CourseRepository;
import com.springjpa.SpringDataJpa.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepo;

    public List<Department> findAllDepartments(){
        return departmentRepo.findAll();
    }

    public Department findDepartmentById(Long id){
        return departmentRepo.findById(id).get();
    }

    public Department createDepartment(Department department){
        return departmentRepo.save(department);
    }

    public Department updateDepartment(Department department){
        return departmentRepo.save(department);
    }

    public void deleteDepartmentById(Long id){
        departmentRepo.deleteById(id);
    }
}
