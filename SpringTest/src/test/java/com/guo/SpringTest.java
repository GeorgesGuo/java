package com.guo;

import com.guo.Person;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    private Person person = null;

    public SpringTest() {
    }

    @Before
    public void testInitial() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        this.person = (Person)context.getBean("person");
    }

    @Test
    public void testMethod() {
        this.person.sayHello();
        System.out.println("pName = " + this.person.getpName() + ", pAge = " + this.person.getpAge());
    }
}