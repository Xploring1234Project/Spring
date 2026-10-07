package org.example.client;

import org.example.ApplicationConfig;
import org.example.beans.User;
import org.example.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class JdbcMain
{
    public static void main(String[] args)
    {
        ApplicationContext context=new AnnotationConfigApplicationContext(ApplicationConfig.class);
        UserService service=context.getBean(UserService.class);

        /*User user=new User("U1","Harsha","harsha@gmail.com");

        int result=service.insertUser(user);

        if(result>0)
        System.out.println("User created successfully");*/



      /*  List<User> userList=service.fetchAllUsers();
        userList.forEach(u->System.out.println(u));*/

        User u=new User();
        u.setUserid("U0003");
        u.setUsername("Teja");
        u.setEmail("teja@gmail.com");

        int result=service.updateUser(u);

        if(result>0)
            System.out.println("User updated successfully");


    }
}
