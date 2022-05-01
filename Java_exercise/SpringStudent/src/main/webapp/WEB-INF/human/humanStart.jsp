<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style type="text/css">
		.err{color: red; font-size: 9px; font-weght: bold;}
	</style>
</head>
<body>
	<h2>회원 가입 하기</h2>
	
	<c:set var="apppath" value="<%=request.getContextPath()%>"/>
	
	<form:form commandName="human" action="${apppath}/mycaller.hm" method="post">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td>
					<form:input path="id"/>
					<form:errors path="id" cssClass="err"/>
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>
					<form:input path="name"/>
					<form:errors path="name" cssClass="err"/>
				</td>
				
			</tr>
			<tr>
				<td>취미</td>
				<td>
					<form:radiobuttons items="${hobbies}" path="hobby" itemLabel="korean" itemValue="english" />
					<form:errors path="hobby" cssClass="err"/>
				</td>
			</tr>
			<tr>
				<td>특기</td>
				<td>
					<form:checkboxes items="${speciallist}" path="special" />
					<form:errors path="special" cssClass="err"/>
				</td>
			</tr>
			<tr>
				<td>생일</td>
				<td>
					<form:input path="birth"/>
					<form:errors path="birth" cssClass="err"/>
				</td>
				
			</tr>
			<tr>
				<td>직업</td>
				<td>
					<form:select path="job">
						<form:options items="${joblists}" itemLabel="name" itemValue="code"></form:options>
					</form:select>
					<form:errors path="job" cssClass="err"/>
				</td>
			</tr>
			<tr>
				<td>가입일자</td>
				<td>
					<form:input path="regdate"/>
					<form:errors path="regdate" cssClass="err"/>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="가입하기"></td>
			</tr>
		</table>	
	</form:form>
</body>
</html>