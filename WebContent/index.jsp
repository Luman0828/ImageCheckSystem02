<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@page import="com.imagecheck.pojo.*" %>
  <%@page import="com.imagecheck.util.Page" %>
  <%
String ctx = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>作业提交系统</title>
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>

<script type="text/javascript" src="js/head-title.js"></script>

<link rel="stylesheet" type="text/css"  href="css/style.css"/>

</head>
<body>
	
	<div id="head-title">
		
	</div>
	<div id="taskList">
		<c:forEach items="${tasks }" var="task">
			<div id="task">
				<div id="taskTitle">
					<a href="task?taskId=${task.taskId}"><c:out value="${task.title }"></c:out></a>
				</div>
			</div>
			
		</c:forEach>
	</div>
	<div id="pageController">
		
		<c:if test="${page.hasPrePage}">
		<a id="firstPage" href="<%=ctx%>?page=1" >首页</a>
		<a id="backPage" href="<%=ctx%>?page=${page.currentPage-1}">上一页</a>
		</c:if>
		<c:if test="${page.hasNextPage }">
		<a id="nextPage" href="<%=ctx%>?page=${page.currentPage+1}">下一页</a>
		<a id="endPage" href="<%=ctx%>?page=${page.totalPage}">尾页</a>
		</c:if>
	</div>

</body>
</html>