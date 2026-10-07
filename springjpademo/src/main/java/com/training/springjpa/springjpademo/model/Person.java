package com.training.springjpa.springjpademo.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
 
@Entity
@Table(name="person_info")
public class Person {
 
    @Id
    //@GeneratedValue
    //@Column(name="id")
    private Long id;
    @Column(name="name",length = 40, unique=true,nullable = false)
    private String name;

    @Column(name="age",nullable = false)
    private int age;
 
    public Person() {
    }
 
    
 
    public Person(Long id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
    public String toString() {
        return String.format("Person{id=%d, name='%s', age=%d}", id, name, age);
    }
}

