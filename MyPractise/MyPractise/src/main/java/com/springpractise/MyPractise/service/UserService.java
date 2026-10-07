package com.springpractise.MyPractise.service;

import com.springpractise.MyPractise.entity.User;
import com.springpractise.MyPractise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public Optional<User> getUserByUserName(String userName){
        return userRepo.findByUserName(userName);
    }

    public void createUser(User user){
        userRepo.save(user);
    }

    public void deleteUserById(Integer id){
        userRepo.deleteById(id);
    }
}
