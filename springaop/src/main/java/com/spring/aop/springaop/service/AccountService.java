package com.spring.aop.springaop.service;

import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private  double balance = 1000.0;

    public void deposit(double balance) {
        System.out.println("Executing Deposit >> "+balance);
        this.balance += balance;
    }

    public void withdraw(double amount) {
        System.out.println("Executing Withdraw >> "+amount);
        if(amount > balance) {
            throw new RuntimeException("Insufficient Balance");
        }
        this.balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}
