package com.imagecheck.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.imagecheck.pojo.User;
import com.imagecheck.service.UserService;
import com.imagecheck.util.Page;
import com.imagecheck.util.PageUtil;



@Controller
public class TaskController {
 
	
	
    @Resource(name="userServiceBean")
    private UserService service;
    
   
    
    
    @RequestMapping(value="/")
    public ModelAndView showTaskList(HttpServletRequest request){
    	request.getParameter("page");
    	Page page=PageUtil¡£
        service.readTasks(page);
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
    }
}