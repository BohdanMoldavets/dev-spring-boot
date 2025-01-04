package com.moldavets.aopdemo.aspect;

import com.moldavets.aopdemo.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Around("execution(* com.moldavets.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(
                    ProceedingJoinPoint joinPoint) throws Throwable {

        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n===>Executing @Around on method: " + method);

        long begin = System.currentTimeMillis();

        Object result = null;

        try {
            result = joinPoint.proceed();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            result = "No fortune today, cos AOP is working good";
        }

        long end = System.currentTimeMillis();

        long duration = end - begin;

        System.out.println("\n===>Duration: " + duration / 1000.0 + " seconds");

        return result;
    }

    @AfterReturning(
            pointcut = "execution(* com.moldavets.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();

        System.out.println("\n==> Executing @AfterReturning on method: " + method);
        System.out.println("\n==> Result: " + result);

        convertAccountNamesToUpperCase(result);

        System.out.println("\n==> Result: " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        result.forEach(account -> account.setName(account.getName().toUpperCase()));
    }

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
