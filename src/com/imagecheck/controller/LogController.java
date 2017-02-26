package com.imagecheck.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.imagecheck.pojo.LogMsg;
import com.imagecheck.pojo.User;
import com.imagecheck.service.UserService;

import net.sf.json.JSONObject;

@Controller
public class LogController {
	@Resource(name="userServiceBean")
    private UserService service;
	
	@RequestMapping(value="log")
	@ResponseBody
	public String log(HttpServletRequest request){
		
		String userId=(String) request.getParameter("userId");
		String password=(String) request.getParameter("password");
		String method=(String) request.getParameter("method");
		if(method.equals("getUser")){
			
			User user=(User) request.getSession().getAttribute("user");
			
			Map map = new HashMap();
			if(user==null){
				map.put("msg", "NotLogin");
			}else{
				
				map.put("msg", "Login");
				map.put("username", user.getUserName());
				map.put("identify", user.getIdentity());
			}
			
			return (JSONObject.fromObject(map)).toString();
		}else if(method.equals("login")){
			LogMsg logMsg=service.login(userId, password);
			

			request.getSession().setAttribute("user", logMsg.getUser());
			return logMsg.getLogMsg();
		}else if(method.equals("logout")){
			request.getSession().removeAttribute("user");
			return "index";
		}
		return "Error";
		
		
	}
    

}
