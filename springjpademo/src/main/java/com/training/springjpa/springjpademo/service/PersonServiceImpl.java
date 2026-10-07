package com.training.springjpa.springjpademo.service;

import java.util.List;
import java.util.Optional;

import com.training.springjpa.springjpademo.dao.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.springjpa.springjpademo.model.Person;

import jakarta.transaction.Transactional;

 
@Service
public class PersonServiceImpl implements PersonService 
{
 
    @Autowired
    private PersonRepository personRepository;

   // @Override
    @Transactional
    public Person createPerson(Person person) {
        Person result=personRepository.save(person);
        return result;
    }
 
   // @Override
    @Transactional
    public Person getPerson(Long id) {
        return personRepository.getOne(id);
    }
 
    //@Override
    @Transactional
    public Person editPerson(Person person) {
        return personRepository.save(person);
      
    }
 
   // @Override
    @Transactional
    public void deletePerson(Person person) {
        personRepository.delete(person);
    }
 
   // @Override
    @Transactional
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
 
  
 
    //@Override
    @Transactional
    public List<Person> getAllPersons() {

        return personRepository.findAll();
    }
 
  // @Override
    public long countPersons() {
        return personRepository.count();
    }
    @Transactional
    public Person getPersonById(long id) //throws InvalidIdException
    {

    	Person p=null;
        Optional<Person> person = personRepository.findById(id);
        if(person.isPresent())
        p=person.get();
        return p;
     //   return person.orElseThrow(() -> new InvalidIdException("Invalid Id: " + id));
    }

    

	
}
