package org.example;

import org.example.config.ApplicationConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        // java based injection for primitive types
        Player p1 = context.getBean("player1",Player.class);
        System.out.println("Name :" + p1.getPlayerName());
        System.out.println("Skill :" + p1.getSkill());
        System.out.println("Country :" + p1.getCountry());

        Player p2 = context.getBean("player2", Player.class);
        System.out.println("Name :" + p2.getPlayerName());
        System.out.println("Skill :" + p2.getSkill());
        System.out.println("Country :" + p2.getCountry());

        // java based injection for obj types
        Person person1 = context.getBean("person1", Person.class);
        System.out.println(person1);

        Person person2 = context.getBean("person2", Person.class);
        System.out.println(person2);

        // accessing values from properties file using constructor, setters and directly,
        Student s1 = context.getBean("student",Student.class);
        System.out.println(s1.toString());


       /* //Constructor Injection java based
        CarEngine e1 = new CarEngine("Type1");
        Car c1 = new Car("BMW","model1",e1);
        System.out.println(c1);

        //setter Injection java based
        CarEngine e2 = new CarEngine();
        e2.setType("Type2");

        Car c2 = new Car();
        c2.setName("BMW");
        c2.setModel("model2");
        c2.setEngine(e2);

        System.out.println(c2);
*/

        //Annotation based Injection
        // For constructor injection we should use parameterized constructor
        // for Setter injection we should use default constructor
        // all injections used in car class injected car engine class

        Car c3 = context.getBean(Car.class);
        System.out.println(c3);





    }
}