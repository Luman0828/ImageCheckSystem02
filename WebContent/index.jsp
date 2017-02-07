<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@page import="com.imagecheck.pojo.*" %>
  <%@page import="com.imagecheck.util.Page" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>作业提交系统</title>
</head>
<body>
	
	<div id="title">
		<c:choose>
			<c:when test="${empty user}">
				<div id="hint">
					未登录,请
				</div>
				
				<button id="login">登陆</button>
				
			</c:when>
			<c:otherwise>
				<div id=username>
					${user.userName}
				</div>
				<button id="logout">注销</button>
			</c:otherwise>
		</c:choose>
	</div>
	<div id="taskList">
		<c:forEach items="${tasks }" var="task">
			<div id="task">
				<div id="taskName">
					<c:out value="${task.name }"></c:out>
				</div>
			</div>
			
		</c:forEach>
	</div>
	<div id="pageController">
		<c:if test="${page.hasPreviousPage}">
		<a id="firstPage" href="">首页</a>
		<a id="backPage" href="">上一页</a>
		</c:if>
		<c:if test="${page.hasNextPage }">
		<a id="nextPage" href="">下一页</a>
		<a id="endPage" href="">尾页</a>
		</c:if>
	</div>
</body>
</html>