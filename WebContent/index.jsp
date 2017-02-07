<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@page import="com.imagecheck.pojo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>作业提交系统</title>
</head>
<body>
	<%
		User user=(User)request.getAttribute("user");
	%>
	<div id="title">
		<c:choose>
			<c:when test="${empty user}">
				<div id="username">
					未登录,请登录
				</div>
				
				<button id="login">登陆</button>
				
			</c:when>
		</c:choose>
			
		
		
	</div>
</body>
</html>