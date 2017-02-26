package com.imagecheck.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.imagecheck.pojo.Homework_Task;
import com.imagecheck.pojo.User;
import com.imagecheck.service.TeacherService;
import com.imagecheck.service.UserService;
import com.imagecheck.util.Page;
import com.imagecheck.util.PageUtil;
import com.imagecheck.util.RenameUtil;

import net.sf.json.JSONObject;

@Controller
public class TaskController {

	@Resource(name = "userServiceBean")
	private UserService userService;

	@Resource(name = "teacherServiceBean")
	private TeacherService teacherService;

	@RequestMapping(value = "")
	public ModelAndView showTaskList(HttpServletRequest request) {

		int currentPage = 1;
		String pageStr = request.getParameter("page");
		if (pageStr != null) {

			currentPage = Integer.parseInt(pageStr);
		}

		Page page = PageUtil.createPage(5, userService.findTaskCount(), currentPage);

		List<Homework_Task> tasks = userService.readTasks(page);

		ModelAndView view = new ModelAndView("index");
		view.addObject("tasks", tasks);
		view.addObject("page", page);

		return view;
	}

	@RequestMapping(value = "task")
	public ModelAndView readTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int taskId = Integer.parseInt(request.getParameter("taskId"));
		request.getSession().setAttribute("task", userService.readTask(taskId));
		System.out.println(request);
		request.getRequestDispatcher("task.html").forward(request, response);
		return null;

	}

	@RequestMapping(value = "taskInit")
	@ResponseBody
	public String taskInit(HttpServletRequest request) {
		String taskId = request.getParameter("taskId");
		Map map = new HashMap();
		Homework_Task task = (Homework_Task) request.getSession().getAttribute("task");
		
		if (task == null && taskId != null && (!taskId.equals(""))) {
			task = userService.readTask(Integer.parseInt(taskId));
		}
		
		String description = task.getDescription();

		if (description != null) {
			map.put("description", task.getDescription());
		}
		if (task.getSrcPath() != null)
			map.put("srcPath", task.getSrcPath());
		map.put("title", task.getTitle());
		map.put("taskId", task.getTaskId());
		request.getSession().removeAttribute("task");

		return (JSONObject.fromObject(map)).toString();

	}



	@RequestMapping(value = "addTask")
	@ResponseBody
	public String addTask(HttpServletRequest request) {

		if (((User) request.getSession().getAttribute("user")).getIdentity() == 1) {
			String path = request.getSession().getServletContext().getRealPath("WEB-INF/task");

			String description = request.getParameter("description");
			Homework_Task task = null;
			String taskId=request.getParameter("taskId");
			boolean existFlag=false;
			if(taskId!=null&&!taskId.equals("")){
				task=userService.readTask(Integer.parseInt(taskId));
			}
			if(task==null){
				task=new Homework_Task();
				
				task.setTaskId(0);
			}
			else
				existFlag=true;
			File descriptionFile = null;
			if (description!=null&&!description.equals("")) {
				if(existFlag&&task.getDescription()!=null){
					String[] s=task.getDescription().split("/");
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
					task.setDescription("WEB-INF/task/" + descriptionFile.getName());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "False";
				}

			}
			
			String srcPath=request.getParameter("srcPath");
			if(srcPath!=null){
				if(existFlag){
				File fileToDelete =new File(task.getSrcPath());
				if(fileToDelete.exists()){
					try {
						fileToDelete.delete();
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				}	
				task.setSrcPath(srcPath);
			}
			
			
			task.setTitle(request.getParameter("title"));
			
			task.setFunctionName(request.getParameter("functionName"));
			if(existFlag){
				return teacherService.updateTask(task)?"success":"False";
				
			}else
			if (teacherService.publishTask(task)) {
				return "success";
			} else
				return "False";
		} else {
			return "IdentifyWrong";
		}
	}
	@RequestMapping(value="deleteTask")
	@ResponseBody
	public String deleteTask(HttpServletRequest request){
		User user =(User) request.getSession().getAttribute("user");
		int taskId;
		try {
			taskId=Integer.parseInt(request.getParameter("taskId"));
		} catch (Exception e) {
			return "NoTaskId";
		}
		
		
		if(user!=null&&user.getIdentity()==1){
			return teacherService.deleteTask(taskId)?"success":"False";
		}else{
			return "IdentifyWrong";
		}
		
	}
}