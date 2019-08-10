package com.guo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
@Aspect
public class SecurityHandler {
    @Pointcut("execution(* com.guo.UserManagerImpl.*(..))")
    private void allMethod(){

    }
    @Before("allMethod()")
    public void checkSecurity(){
        System.out.println("====checkSecurity()====");
    }

}
