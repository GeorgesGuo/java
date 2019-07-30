package com.guo.controll;

import com.guo.UserInfo;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DemoHander implements Controller {
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) throws Exception {

        List<UserInfo> itemsList = new ArrayList<UserInfo>();
        UserInfo items1 = new UserInfo();
        items1.setName("arvin");
        items1.setPrice(100d);
        items1.setCreatetime(new Date());
        items1.setDetail("good");

        UserInfo items2 = new UserInfo();
        items2.setName("jerry");
        items2.setPrice(100d);
        items2.setCreatetime(new Date());
        items2.setDetail("good");

        itemsList.add(items1);
        itemsList.add(items2);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsListKey",itemsList);
        modelAndView.setViewName("itemslist");
        return modelAndView;
    }
}
