package com.spring.aop.springaop;

import com.spring.aop.springaop.service.AccountService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringaopApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringaopApplication.class, args);
		AccountService acc =  context.getBean(AccountService.class);

		acc.deposit(1000);
		acc.getBalance();
		acc.withdraw(5000);

	}

}
