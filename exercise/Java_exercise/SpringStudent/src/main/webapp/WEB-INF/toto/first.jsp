<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	첫인사 : ${aaa}<br>
	끝인사 : ${bbb}<br>
	<%
		String second = request.getContextPath() + "/first/second.to";
	%>
	<a href="<%=second%>">여기 클릭</a>
</body>
</html>