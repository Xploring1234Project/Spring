package com.cognizant.training;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveEmp {

	
	public static void main(String[] args) {
	
	//	Session session = HibernateUtil.getSession();
		Session session=null;
		try
		{
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		System.out.println("factory="+sessionFactory);
		session = sessionFactory.openSession();
		System.out.println("session =" + session);
			Transaction tx = session.beginTransaction();
            Emp emp = new Emp();
		emp.setEmpId(10002);
		emp.setEmpName("Sai");
		emp.setDept("HR");
		emp.setEmpSal(35000.00);

		Emp emp1 = new Emp();
		emp1.setEmpId(113);
		emp1.setEmpName("basheer");
		emp1.setDept("HR");
		emp1.setEmpSal(25000.00);

		Emp emp2 = new Emp();
		emp2.setEmpId(116);
		emp2.setEmpName("jack");
		emp2.setDept("CEO");
		emp2.setEmpSal(45000.00);

		session.save(emp);
		session.save(emp1);
		session.save(emp2);

		tx.commit();
	}
	catch(Exception ex)
	{
		System.out.println("Exception block" +ex.getMessage());

	}
	finally
	{
		if(session!=null)
		session.close();
	}
	}

}
