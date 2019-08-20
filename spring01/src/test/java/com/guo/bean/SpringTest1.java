package com.guo.bean;

import com.guo.bean2.Bean1;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest1 {

    private Bean1 bean1 = null;
    @Before
    public void testInitial(){
        //获取person、
        ApplicationContext context = new ClassPathXmlApplicationContext
                (new String[]{"applicationContext-beans.xml"});
        bean1 = (Bean1) context.getBean("bean1");

    }
    @Test
    public void testMethod(){
        System.out.println("bean1 strV = "+bean1.getStrValue());
        System.out.println("bean1 listV= "+bean1.getListValue());
        System.out.println("bean1 setV = "+bean1.getSetValue());
        System.out.println("bean1 mapV = "+bean1.getMapValue());
        System.out.println("bean1 intV = "+bean1.getIntValue());
        System.out.println("bean1 arrayV = "+bean1.getArrayValue());
        System.out.println("bean1 dataValue = "+bean1.getDateValue());


    }

}
