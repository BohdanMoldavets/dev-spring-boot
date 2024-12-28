package com.moldavets.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Before("execution(* add*(..,com.moldavets.aopdemo.entity.Account))")
    public void beforeAddAccountAdvice() {
        System.out.println("=====>before add*");
    }

}
