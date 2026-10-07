package com.training.springjpa.springjpademo;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.training.springjpa.springjpademo.model.*;
import com.training.springjpa.springjpademo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringjpademoApplication {
	@Autowired
	public static PersonService personService;
    @Autowired
    public static UserService userService;
    @Autowired
    public static DepartmentService deptService;
    @Autowired
    public static EmployeeService empService;
    @Autowired
    public static SkillService skillService;
    @Autowired
    public static StudentService studentService;

    private static void addUser()
    {
        Address address=new Address();
        address.setCity("Mumbai");
        address.setStreet("2nd street");

        User u=new User();
        u.setName("Minu");
        u.setAddress(address);

       User result= userService.addUser(u);
       if (result!=null)
           System.out.println("User inserted successfully");

    }
    private static void updateUserAddress(Long userId) {
        User u=userService.updateUserAddress(1L);
        System.out.println(u);
    }

    private static void findUserAddress()
    {
        User u=userService.findUserAddress(1L);
        System.out.println("User ----> Address" + u);
        System.out.println("Address :"+u.getAddress());

        System.out.println("Address ----> User" );
        Address address=userService.findAddressUser(1L);
        System.out.println("Address "+address);
        System.out.println("User "+address.getUser());
     }
     private static void addDepartment()
     {

         Department d=new Department();
         d.setId(10);
         d.setName("IT");
         deptService.addDepartment(d);
         d=new Department();
         d.setId(20);
         d.setName("Admin");
         deptService.addDepartment(d);


     }

     private static void addEmployee()
     {
         Employee e=new Employee();
         e.setId(1003);
         e.setName("abc");
         e.setSalary(50000);
         e.setDate_of_birth(Date.valueOf("1998-06-05"));
         Department d=deptService.findDepartmentById(10);
         e.setDepartment(d);
         empService.addEmployee(e);
        /* e=new Employee();
         e.setId(1002);
         e.setName("Sri");
         e.setSalary(40000);
         e.setDate_of_birth(Date.valueOf("1998-06-05"));
         d=deptService.findDepartmentById(10);
         e.setDepartment(d);
         empService.addEmployee(e);*/

     }
     private static void fetchDeptEmployees()
     {
         System.out.println("Department -> Employee");
         Department d=deptService.findDepartmentById(10);
         Set<Employee> empList=d.getEmployeeList();
         empList.forEach(obj->System.out.println(obj));

         System.out.println("Employee -> Department");
         Employee e=empService.findEmployeeById(1001);
         System.out.println(e.getName());
         d=e.getDepartment();
         System.out.println("Department details ="+d);

     }
    public static void addSkill() {
        Skill s = new Skill();

        s.setName("Hibernate");
        skillService.addSkill(s);
        s=new Skill();
        s.setName("Spring");
        skillService.addSkill(s);
        s=new Skill();
        s.setName("Java");
        skillService.addSkill(s);

    }
    public static void addEmployeeSkill() {
       /* Employee e = empService.findEmployeeById(1001);
        Skill s = skillService.getskill(1);
        Set<Skill> skillList = new HashSet<Skill>();
        skillList.add(s);
        s = skillService.getskill(2);
        skillList.add(s);
        e.setSkillList(skillList);
        empService.addEmployee(e);*/

       Employee e1 = empService.findEmployeeById(1002);
        Skill s1 = skillService.getskill(2);
        Set<Skill> skillList1 = new HashSet<Skill>();
        skillList1.add(s1);
        e1.setSkillList(skillList1);
        empService.addEmployee(e1);
    }

    private static void addStudent()
    {
        Student s=new Student();
        s.setName("abc");
        s.setDepartment("CSC");
        s.setRegno(1234);
        studentService.saveStudent(s);
        s=new Student();
        s.setName("abc");
        s.setDepartment("CSC");
        s.setRegno(2345);
        studentService.saveStudent(s);
         s=new Student();
        s.setName("arun");
        s.setDepartment("EEE");
        s.setRegno(1001);
        studentService.saveStudent(s);
        s=new Student();
        s.setName("kavin");
        s.setDepartment("IT");
        s.setRegno(1002);
        studentService.saveStudent(s);
    }
	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringjpademoApplication.class, args);
		personService=context.getBean(PersonService.class);
        userService=context.getBean(UserService.class);
        deptService=context.getBean(DepartmentService.class);
        empService=context.getBean(EmployeeService.class);
        skillService=context.getBean(SkillService.class);
        studentService=context.getBean(StudentService.class);

      /*  Person p=new Person();
        p.setAge(24);
        p.setId(1003L);
        p.setName("Minu");

//Insert
       Person result=personService.createPerson(p);

        if(result!=null)
            System.out.println("Row inserted successfully"); */

        //Find by primary key
       /* Person person=personService.getPersonById(1001L);
        System.out.println(person);*/

        //Fetch all rows

        /*List<Person> personList=personService.getAllPersons();
        personList.forEach(obj->System.out.println(obj));*/

        //Update a arow
     /*   person=personService.getPersonById(1001L);
        System.out.println("Before update ="+person);
        person.setAge(25);
        Person updatedPerson=personService.editPerson(person);
        System.out.println("After update "+updatedPerson);*/


        //Delete by primary key
      //  personService.deletePerson(1002L);

        //addUser();
        //updateUserAddress(1L);
        //findUserAddress();
       // addDepartment();
        //addEmployee();
        //fetchDeptEmployees();
        //addSkill();
        //addEmployeeSkill();
       // addStudent();

        List<Employee> employeeList=empService.getAllEmployees();
        employeeList.forEach(obj->System.out.println(obj));

        System.out.println("Find students by department and name ");
        List<Student> studentList=studentService.getStudentsByDepartment("CSC","arun");
       studentList.forEach(obj->System.out.println(obj));

        System.out.println("Find students by department  ");
        studentList=studentService.getStudentsByDepartmentName("CSC");
        studentList.forEach(obj->System.out.println(obj));

        System.out.println("update student department  ");
        int result=studentService.updateStudentByName("CSC","arun");

        System.out.println("Student details");
        studentList= studentService.getAllStudents();
        studentList.forEach(obj->System.out.println(obj));

        Student s=studentService.findStudentByEmail("arun@gmail.com");
        System.out.println(s);


       /* System.out.println("Find students by name starting with");
        studentList=studentService.getStudentsByNamePrefix("a");
       studentList.forEach(obj->System.out.println(obj));

        System.out.println("Find students by name ending with");
        studentList=studentService.getStudentsByNameSuffix("n");
       studentList.forEach(obj->System.out.println(obj));

        List<Employee> empList=empService.getAllEmployees();
        empList.forEach(obj->System.out.println(obj));
        */

    }

}
