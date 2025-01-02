package com.moldavets.aopdemo.aspect;

import com.moldavets.aopdemo.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("com.moldavets.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("=====>before add*");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        Object[] args = joinPoint.getArgs();

        Arrays.stream(args)
                .filter(arg -> arg instanceof Account)
                .map(arg -> (Account) arg)
                .forEach((n) -> System.out.println("\nName: " + n.getName() + "\nEmail:" + n.getEmail() +"\n"));

    }
}
