package com.training.springjpa.springjpademo.dao;

import com.training.springjpa.springjpademo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {

}
