package com.guo;

import com.guo.bean2.Bean2;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest4 {
    private Bean2 bean2;
    private Bean2 bean2_1;
    ApplicationContext context;

    public SpringTest4() {
    }

    @Before
    public void testInitial() {
        this.context = new ClassPathXmlApplicationContext(new String[]{"applicationContext-beans2.xml"});
    }

    @Test
    public void testMethod() {
    }

    @Test
    public void testMethod2() {
        this.bean2 = (Bean2)this.context.getBean("bean2");
        this.bean2_1 = (Bean2)this.context.getBean("bean2");
        if (this.bean2 == this.bean2_1) {
            System.out.println("bean2 is singleton");
        } else {
            System.out.println("bean2 is multible");
        }

    }
}

