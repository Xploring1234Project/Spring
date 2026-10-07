package org.example.service;

import org.example.beans.User;
import org.example.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public int insertUser(User user){
        return userDao.insertUser(user);
    }

    public List<User> fetchAllUsers(){
        List<User> userList=userDao.getAllUsers();
        return userList;
    }

    public int updateUser(User u)
    {
        return userDao.updateUser(u);
    }
}
