<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE><html><head></head>
<body> 	
<%
	String imsi = request.getContextPath() + "/Kids?command=" ; 	
	//response.sendRedirect( imsi ) ;
%>
	<a href="<%=imsi%>hello">헬로우</a>
	<br><br><br>
	<a href="<%=imsi%>world">월드</a>
	안녕하세요 0514 aa
	0517 시영 내용 추가 시영내용추가 
</body>
</html>