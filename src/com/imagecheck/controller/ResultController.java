package com.imagecheck.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.apache.tools.ant.taskdefs.condition.Http;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.imagecheck.pojo.Homework_Result;
import com.imagecheck.pojo.Homework_Task;
import com.imagecheck.pojo.User;
import com.imagecheck.service.UserService;
import com.imagecheck.util.RenameUtil;

import net.sf.json.JSONObject;

@Controller
public class ResultController {
	@Resource(name = "userServiceBean")
	private UserService userService;

	@RequestMapping(value = "addResult")
	@ResponseBody
	public String addTask(HttpServletRequest request) {
		
		String taskIdStr=request.getParameter("taskId");
		int taskId;
		if(taskIdStr!=null&&taskIdStr.equals("")){
			return "未指定对应的作业";
		}
		else{
			taskId=Integer.parseInt(taskIdStr);
		}
		boolean existFlag=true;
		Homework_Result result = null;
		String userId=null;
		try {
			userId=((User)request.getSession().getAttribute("user")).getUserId();
		} catch (Exception e) {
			// TODO: handle exception
			return "用户未登录";
		}
		
		result=userService.readOwnResult(userId, taskId);
		if(result==null){
			result=new Homework_Result();
			result.setTaskId(taskId);
			result.setUserId(userId);
			result.setResultId(0);
			existFlag=false;
		}
		String path = request.getSession().getServletContext().getRealPath("WEB-INF/result");
		
		String description = request.getParameter("description");

		File descriptionFile = null;
		if (description!=null&&!description.equals("")) {
			if(existFlag){
				String[] s=result.getDescription().split("/");
				descriptionFile=new File(path,s[s.length-1]);
			}
			else
				descriptionFile = new File(path, RenameUtil.getRandomFileName("html"));
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream(descriptionFile);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "False";
			}

			BufferedOutputStream bos = new BufferedOutputStream(fos);

			try {
				bos.write(description.getBytes());
				bos.flush();
				fos.close();
				bos.close();
				result.setDescription("WEB-INF/result/" + descriptionFile.getName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "False";
			}
		}
		
		String srcPath=request.getParameter("srcPath");
		if(srcPath!=null){
			if(existFlag){
			File fileToDelete =new File(result.getResultPath());
			if(fileToDelete.exists()){
				try {
					fileToDelete.delete();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			}	
			result.setResultPath(srcPath);
		}
		
		
		if(existFlag){
			return userService.updateResult(result)?"success":"False";
			
		}else
		
		if (userService.uploadResult(result)) {
			return "success";
		} else
			return "False";

	}
	@RequestMapping(value="getMyResult")
	@ResponseBody
	public String getMyResult(@RequestParam(value = "taskId", required = true)String taskId,@SessionAttribute(value="user", required=true)User user){
		Homework_Result result=userService.readOwnResult(user.getUserId(),Integer.parseInt(taskId));
		if(result==null){
			result=new Homework_Result();
		}
		return (JSONObject.fromObject(result)).toString();
	}
}
