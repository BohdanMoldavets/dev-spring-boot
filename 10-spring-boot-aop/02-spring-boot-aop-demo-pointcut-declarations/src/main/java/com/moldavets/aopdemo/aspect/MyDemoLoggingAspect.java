package com.moldavets.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.moldavets.aopdemo.dao.*.* (..))")
    private void forDaoPackage() {}

    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice() {
        System.out.println("=====>before add*");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics() {
        System.out.println("=====>apiAnalysis");
    }

}
