package com.imagecheck.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.imagecheck.util.RenameUtil;

@Controller
public class LoadController {
	 @RequestMapping("download")
	    public String downloadFile(@RequestParam("path") String path,@RequestParam("fileName") String fileName,
	            HttpServletRequest request, HttpServletResponse response) {
		 	String realPath=request.getServletContext().getRealPath(path);
		 	
		 	String[] temp=path.split("/");
		 	
		 	String name=temp[temp.length-1];
		 	String type="";
		 	if(name.contains(".")){
		 		 temp=path.split("\\.");
			 	
			 	type=temp[temp.length-1];
			 	
		 	}
		 	try {
				fileName = new String((fileName+"."+type).getBytes(), "ISO-8859-1");
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
	        if (path != null) {
	            
	            File file = new File(realPath);
	            if (file.exists()) {
	                response.setContentType("application/force-download");// 设置强制下载不打开
	                response.addHeader("Content-Disposition",
	                        "attachment;filename=" + fileName);// 设置文件名
	                byte[] buffer = new byte[1024];
	                FileInputStream fis = null;
	                BufferedInputStream bis = null;
	                try {
	                    fis = new FileInputStream(file);
	                    bis = new BufferedInputStream(fis);
	                    OutputStream os = response.getOutputStream();
	                    int i = bis.read(buffer);
	                    while (i != -1) {
	                        os.write(buffer, 0, i);
	                        i = bis.read(buffer);
	                    }
	                } catch (Exception e) {
	                    // TODO: handle exception
	                    e.printStackTrace();
	                } finally {
	                    if (bis != null) {
	                        try {
	                            bis.close();
	                        } catch (IOException e) {
	                            // TODO Auto-generated catch block
	                            e.printStackTrace();
	                        }
	                    }
	                    if (fis != null) {
	                        try {
	                            fis.close();
	                        } catch (IOException e) {
	                            // TODO Auto-generated catch block
	                            e.printStackTrace();
	                        }
	                    }
	                }
	            }
	        }
	        return null;
	    }
	
	 @RequestMapping(value="upload")
	 @ResponseBody
	 public String upload(@RequestParam(value = "file", required = false) MultipartFile file,HttpServletRequest request){
		 String path=request.getParameter("path");
	
		 String realPath = request.getSession().getServletContext().getRealPath(path);
		 File newFile=null;
	    	if(file!=null){
	        	newFile=new File(realPath,file.getOriginalFilename());
	        	newFile=RenameUtil.getRandomFile(newFile);
	        	try {
	    			file.transferTo(newFile);
	    		} catch (IllegalStateException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    			return "IllegalStateException";
	    		} catch (IOException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    			return "IOException";
	    		}
	        	
	        	return path+"/"+newFile.getName();
	    	}
		 return "NoFileException";
	 }
	 
		@RequestMapping(value = "description")
		public ModelAndView getDescription(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			request.getRequestDispatcher(request.getParameter("path")).forward(request, response);

			return null;
		}
}
