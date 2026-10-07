package com.springpractise.MyPractise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MyPractiseApplication {

	public static void main(String[] args) {

		ApplicationContext context= SpringApplication.run(MyPractiseApplication.class, args);

		//Devop obj = context.getBean(Devop.class);
		//obj.build();
	}

}
