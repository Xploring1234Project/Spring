package com.cognizant.training;

import com.cognizant.training.config.ApplicationConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
        //ApplicationContext context=new AnnotationConfigApplicationContext(ApplicationConfig.class);


        Player p1=(Player)context.getBean("player1");
         System.out.println("Name :"+p1.getPlayerName());
         System.out.println("Skill :"+p1.getSkill());
         System.out.println("Country :"+p1.getCountry());

        Player p2=(Player)context.getBean("player1");
        System.out.println("Name :"+p2.getPlayerName());
        System.out.println("Skill :"+p2.getSkill());
        System.out.println("Country :"+p2.getCountry());

        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());

        Player p3=(Player)context.getBean("player3");
        System.out.println("Name :"+p3.getPlayerName());
        System.out.println("Skill :"+p3.getSkill());
        System.out.println("Country :"+p3.getCountry());


        Person p4=(Person)context.getBean("person1");
        System.out.println(p4);

        Person p5=(Person)context.getBean("person2");
        System.out.println(p5);

        //Book book=context.getBean(Book.class);
        //System.out.println(book.getBookCode() + " "+book.getBookName());

        /*Author author=context.getBean(Author.class);
        System.out.println("Author Name:"+author.getAuthorName());
        System.out.println("Book Name :"+author.getBook().getBookName());*/

        /*Student student=context.getBean(Student.class);
        student.display();
        StudentReport report=context.getBean(StudentReport.class);
        System.out.println(report.calculateTotal());*/


    }
}
