package com.imagecheck.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.imagecheck.pojo.User;
import com.imagecheck.service.UserService;



@Controller
public class HelloController {

    @Resource(name="userServiceBean")
    private UserService service;

 /*   @RequestMapping("/hello")
    public ModelAndView sayHello(){
        User user=null;
        System.out.println("²âÊÔ·ûºÏ»»¸ö·¿¼ä");
        try {
            user = service.getUserById(1);
            System.out.println(user.getId()+"´÷·Æ·Æ£¡£¡£¡");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ModelAndView view=new ModelAndView("index");
        view.addObject("user", user);
        return view;
    }*/
}