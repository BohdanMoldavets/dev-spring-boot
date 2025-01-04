package com.moldavets.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopExpressions {

    @Pointcut("execution(* com.moldavets.aopdemo.dao.*.* (..))")
    public void forDaoPackage() {}

    @Pointcut("execution(* com.moldavets.aopdemo.dao.*.get* (..))")
    public void getter(){}

    @Pointcut("execution(* com.moldavets.aopdemo.dao.*.set* (..))")
    public void setter(){}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter(){}

}
