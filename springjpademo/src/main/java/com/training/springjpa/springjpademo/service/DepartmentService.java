package com.training.springjpa.springjpademo.service;

import com.training.springjpa.springjpademo.dao.DepartmentRepository;
import com.training.springjpa.springjpademo.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepo;
    public Department addDepartment(Department dept)
    {
        return departmentRepo.save(dept);
    }
    public Department findDepartmentById(int deptid)
    {
        return departmentRepo.findById(deptid).get();
    }

}
