package com.cognizant.training.config;


import com.cognizant.training.Book;
import com.cognizant.training.Department;
import com.cognizant.training.Employee;
import org.springframework.context.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages="com.cognizant.training")
@PropertySource("classpath:data.properties")

public class ApplicationConfig {

   /* @Bean
    @Scope("prototype")
    public Book getBook()
    {
        return new Book();
    }*/

   /* @Bean

    public Person getPerson()
    {
        return new Person();
    }*/
   /* @Bean
       public Employee getEmployee() {

        	    return new Employee(1,"Ragul","IT");
             }

@Bean
        public Department department() {
                  List<Employee> empList = new ArrayList<>();
                 empList.add(getEmployee());

         	    return new Department(123,empList);
             }*/



}

