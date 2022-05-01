<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String contextPath = request.getContextPath();
	String gotopage = contextPath + "/first/caller1.he";
	response.sendRedirect(gotopage);
%>
</body>
</html>