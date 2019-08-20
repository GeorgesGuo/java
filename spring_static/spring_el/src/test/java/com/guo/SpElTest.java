package com.guo;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpElTest {
    private ApplicationContext context = null;

    @Before
    public void testInit(){
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    @Test
    public void SpEL(){
        Address address = (Address)context.getBean("address");
        System.out.println(address);
        Car car = (Car)context.getBean("car");
        System.out.println(car);
        Person person = (Person)context.getBean("person");
        System.out.println(person);
    }
}
