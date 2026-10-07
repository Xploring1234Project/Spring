package com.training.springjpa.springjpademo.service;

import java.util.List;

import com.training.springjpa.springjpademo.model.Person;
 
public interface PersonService {
 
    Person createPerson(Person person);
    Person getPerson(Long id);
    Person editPerson(Person person);
    void deletePerson(Person person);
    void deletePerson(Long id);
    public Person getPersonById(long id) ;//throws InvalidIdException;
    List<Person> getAllPersons();

    

}
