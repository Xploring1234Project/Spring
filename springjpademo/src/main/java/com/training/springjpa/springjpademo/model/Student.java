package com.training.springjpa.springjpademo.model;

import jakarta.persistence.*;


@Entity
@Table(name="student_details")
@NamedQuery(
        name = "Student.findByEmail",
        query = "SELECT s FROM Student s WHERE s.email = :email"
)

/*@NamedQueries({
        @NamedQuery(
                name = "Student.findByEmail",
                query = "SELECT s FROM Student s WHERE s.email = :email"
        ),
        @NamedQuery(
                name = "Student.findByName",
                query = "SELECT s FROM Student s WHERE s.name = :name"
        )
})*/
public class Student {
	@Id
	@Column(name="rollno")

	private int regno;
	
	@Column(name="stud_name",length=30,nullable=false)

	private String name;
	
	@Column(name="dept")
	private String department;
	
  @Column(name="email")
	private String email;
	
	public Student()
	{}
	public int getRegno() {
		return regno;
	}
	public void setRegno(int regno) {
		this.regno = regno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return String.format("Student [regno=%s, name=%s, department=%s]", regno, name, department);
	}
	
	
	

}
