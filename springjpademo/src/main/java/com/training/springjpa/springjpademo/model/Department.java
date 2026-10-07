package com.training.springjpa.springjpademo.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "department")
public class Department {
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "dp_id")
	private int id;
	@Column(name = "dp_name")
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	@Override
	public String toString() {
		return String.format("Department [id=%s, name=%s]", id, name);
	}


	@OneToMany(mappedBy = "department",fetch=FetchType.EAGER)
	private Set<Employee> employeeList;

	public Set<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(Set<Employee> employeeList) {
		this.employeeList = employeeList;
	}

}



