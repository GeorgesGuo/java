package com.guo;


import com.guo.UserInfo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest3 {
    private UserInfo userInfo;

    public SpringTest3() {
    }

    @Before
    public void testInitial() {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext-beans.xml"});
        this.userInfo = (UserInfo)context.getBean("userinfo");
    }

    @Test
    public void testMethod() {
        System.out.println(this.userInfo.getPerson().getpName() + ", " + this.userInfo.getPerson().getpAge());
    }
}

