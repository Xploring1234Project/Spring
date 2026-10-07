package com.cognizant.training;

public class Employee {
    private int employeeId;
    	private String employeeName;
     	private String department;

    public Employee(int employeeId, String employeeName,String department) {

        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("department='").append(department).append('\'');
        sb.append(", employeeId=").append(employeeId);
        sb.append(", employeeName='").append(employeeName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
