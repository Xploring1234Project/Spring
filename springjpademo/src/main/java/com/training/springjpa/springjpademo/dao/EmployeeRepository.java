package com.training.springjpa.springjpademo.dao;

import com.training.springjpa.springjpademo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    //select d.dp_name,e.emp_name,e.salary  from department d join employee e on d.dp_id=e.em_dp_id join
    //@Query(value="SELECT e FROM Employee e left join e.department d left join  e.skillList ")
    @Query(value="SELECT e FROM Employee e left join fetch e.department d left join fetch e.skillList")
    List<Employee> getAllEmployees();


}
