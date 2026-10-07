package com.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class AccountAspect {

    @Before("execution(* com.spring.aop.springaop.service.AccountService.deposit(..))")
    public void logBeforeDeposit(JoinPoint joinpoint){
        System.out.println("BEFORE: Security Check - Validating user");
    }

    @AfterReturning(pointcut = "execution(* com.spring.aop.springaop.service.AccountService.getBalance(..))", returning = "returnValue")
    public void logBalanceEnquiry(Object returnValue){
        System.out.println("AFTER RETURNING: Balance Check " + returnValue);
    }

    @AfterThrowing(pointcut = "execution(* com.spring.aop.springaop.service.AccountService.withdraw(..))", throwing = "exception")
    public void logWithdrawalError(RuntimeException exception){
        System.out.println("AFTER THROWING: Withdraw Failed " + exception.getMessage());
    }

    @After("execution(* com.spring.aop.springaop.service.AccountService.*(..))")
    public void logTransactionEndPoint(JoinPoint joinpoint){
        System.out.println("AFTER TRANSACTION END POINT: " + joinpoint.getSignature().getName());
    }

    /*@Around("execution(* com.spring.aop.springaop.service.AccountService.withdraw(..))")
    public Object logWithdrawal(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        try {
            System.out.println("AROUND Starting");
            return proceedingJoinPoint.proceed();
        } finally {
            // This will now execute even if an exception was thrown!
            System.out.println("AROUND Ending");
        }
    }*/

    @Around("execution(* com.spring.aop.springaop.service.AccountService.withdraw(..))")
    public Object logWithdrawal(ProceedingJoinPoint pjp) {
        try {
            System.out.println("AROUND Starting");
            return pjp.proceed();
        } catch (Throwable e) {
            System.out.println("Handled in Aspect: " + e.getMessage());
            return null; // Return null so the app doesn't crash
        } finally {
            System.out.println("AROUND Ending");
        }
    }
}
