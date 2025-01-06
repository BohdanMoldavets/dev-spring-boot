package com.luv2code.springboot.thymeleafdemo.aspect;

import lombok.extern.java.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private final Logger LOGGER = Logger.getLogger(this.getClass().getName());

    @Pointcut("execution(*  com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    public void controllerPointcut() {

    }

    @Pointcut("execution(*  com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    public void servicePointcut() {

    }

    @Pointcut("execution(*  com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    public void daoPointcut() {

    }

    @Pointcut("controllerPointcut() || servicePointcut() || daoPointcut()")
    protected void pointcut() {}

    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("===> @Before" + method);
        Object[] args = joinPoint.getArgs();

        Arrays.stream(args)
                .forEach(arg -> LOGGER.info("===> argument: " + arg));
    }

    @AfterReturning(
            pointcut = "pointcut()",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String method = joinPoint.getSignature().toShortString();
        LOGGER.info("===> @AfterReturning from method: " + method);
        LOGGER.info("===> result: " + result);
    }
}
