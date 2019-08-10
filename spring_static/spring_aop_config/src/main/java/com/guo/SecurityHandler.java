package com.guo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


public class SecurityHandler {
    public void checkSecurity(){
        System.out.println("====checkSecurity()====");
    }

}
