package com.cognizant.training;

import java.util.List;

public class Department {
    private int departmentId;
    private List<Employee> employees;
    public Department (int departmentId, List<Employee> employees) {
       this.departmentId = departmentId;
       this.employees = employees;
   }
   public void display ()
   {
       employees.forEach(e->System.out.println(e));
   }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Department{");
        sb.append("departmentId=").append(departmentId);
        sb.append(", employees=").append(employees);
        sb.append('}');
        return sb.toString();
    }
}
