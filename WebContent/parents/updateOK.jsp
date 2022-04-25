<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	window.onload=function(){
		alert("${requestScope.message}");
	 	location.href="<%=NoForm%>paDetail&pid=${requestScope.pid}";
	}
</script>
	 
</head>
<body>

</body>
</html>