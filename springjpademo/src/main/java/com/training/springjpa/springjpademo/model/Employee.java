package com.training.springjpa.springjpademo.model;

import java.sql.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "em_id")
	private int id;
	@Column(name = "em_name")
	private String name;
	@Column(name = "em_salary")
	private double salary;
	@Column(name = "em_permanent")
	private boolean permanent;
	@Column(name = "em_date_of_birth")
	private Date date_of_birth;

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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public boolean isPermanent() {
		return permanent;
	}

	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	

	//unidirectional
	//bidirectional


    @ManyToOne
	@JoinColumn(name = "em_dp_id")
	private Department department;

    @ManyToMany(fetch=FetchType.EAGER)

    @JoinTable(name = "emp_skill", joinColumns =
    @JoinColumn(name = "es_em_id"),
            inverseJoinColumns = @JoinColumn(name = "es_sk_id"))

    private Set<Skill> skillList;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

    public Set<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(Set<Skill> skillList) {
        this.skillList = skillList;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Employee{");
        sb.append("date_of_birth=").append(date_of_birth);
        sb.append(", department=").append(department);
        sb.append(", id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", permanent=").append(permanent);
        sb.append(", salary=").append(salary);
        sb.append(", skillList=").append(skillList);
        sb.append('}');
        return sb.toString();
    }
}
