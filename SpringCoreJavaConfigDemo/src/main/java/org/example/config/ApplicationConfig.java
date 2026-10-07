package org.example.config;

import org.example.Address;
import org.example.Person;
import org.example.Player;
import org.example.Student;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("org.example")
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

    //setter injection for primitive types
    @Bean
    @Primary
    public Player player1(){
        Player p = new Player();
        p.setPlayerName("Harsha1");
        p.setSkill("Coding1");
        p.setCountry("India1");
        return p;
    }

    //Constructor injection for primitive types
    @Bean
    public Player player2(){
        return new Player("Harsha2","Coding2","India2");
    }

    //Setter injection for obj type
    @Bean
    public Address address1(){
        Address a = new Address();
        a.setCity("Coimbatore1");
        a.setStreet("Street1");
        return a;
    }

    @Bean
    public Person person1(){
        Person p = new Person();
        p.setName("Teja1");
        p.setAddress(address1());
        return p;
    }

    //Constructor injection for object types

    @Bean
    public Address address2(){
        return new Address("Street2","Coimbatore2");
    }

    @Bean
    public Person person2(){
        return  new Person("Teja2",address2());
    }

    // instead of calling from bean
    // use @Component for student class  so that it will be scanned automatically
    // and values are assigned
    /*@Bean
    public Student student(){
        return  new Student();
    }*/

}
