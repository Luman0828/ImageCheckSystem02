package com.imagecheck.util;

import java.io.File;
import java.util.Date;
import java.util.Random;

public class RenameUtil {
	public static File getRandomFile(File file){
	      String body="";  
	      String ext="";  
	      Date date = new Date();  
	      int pot=file.getName().lastIndexOf(".");  
	      if(pot!=-1){  
	          body= date.getTime() +"";  
	          ext=file.getName().substring(pot);  
	      }else{  
	          body=(new Date()).getTime()+"";  
	          ext="";  
	      }  
	      String newName=body+ext;  
	      file=new File(file.getParent(),newName);  
	      return file; 
	}
	public static String getRandomFileName(String suffix){
	      
	      Date date = new Date();  
	      int randomNum=new Random().nextInt(9999);
  
	      String randomName=date.getTime()+randomNum+"."+suffix;  
	      
	      return randomName; 
	}
}
