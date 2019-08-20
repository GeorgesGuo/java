package com.guo.bean;

import com.guo.bean2.Bean1;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest2 {
    private UserInfo userInfo;

    @Before
    public void testInitial(){
        //获取person、
        ApplicationContext context = new ClassPathXmlApplicationContext
                (new String[]{"applicationContext-beans.xml"});
        userInfo = (UserInfo) context.getBean("userinfo");


    }
    @Test
    public void testMethod(){
        System.out.println(userInfo.getPerson().getpName() + ", " );
        System.out.println(userInfo.getUsername());

    }

}
