package com.training.springjpa.springjpademo.service;

import com.training.springjpa.springjpademo.dao.DepartmentRepository;
import com.training.springjpa.springjpademo.dao.EmployeeRepository;
import com.training.springjpa.springjpademo.model.Department;
import com.training.springjpa.springjpademo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepo;
    public Employee addEmployee(Employee emp)
    {
        return employeeRepo.save(emp);
    }
    public Employee findEmployeeById(int empid)
    {
        return employeeRepo.findById(empid).get();
    }
    public List<Employee> getAllEmployees()
    {
        return employeeRepo.getAllEmployees();
    }
}
