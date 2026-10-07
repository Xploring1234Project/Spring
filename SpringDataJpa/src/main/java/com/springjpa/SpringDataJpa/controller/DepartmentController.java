package com.springjpa.SpringDataJpa.controller;

import com.springjpa.SpringDataJpa.entity.Course;
import com.springjpa.SpringDataJpa.entity.Department;
import com.springjpa.SpringDataJpa.service.CourseService;
import com.springjpa.SpringDataJpa.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> findAllDepartments(){
        return departmentService.findAllDepartments();
    }

    @GetMapping("/{departmentId}")
    public Department findDepartmentById(@PathVariable Long departmentId){
        return  departmentService.findDepartmentById(departmentId);
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department){
        return departmentService.createDepartment(department);
    }

    @PutMapping("/{deptId}")
    public Department updateDepartment(@RequestBody Department department, @PathVariable Long deptId){
        Department oldDept = departmentService.findDepartmentById(deptId);
        if(oldDept != null){
            oldDept.setName(department.getName()!=null && !department.getName().equals("")?department.getName():oldDept.getName());
            return  departmentService.updateDepartment(oldDept);
        }
        return null;
    }

    @DeleteMapping("/{departmentId}")
    public void deleteDepartment(@PathVariable Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
    }
}
