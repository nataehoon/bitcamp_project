<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>아이디</td>
			<td>${human.id}</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${human.name}</td>
		</tr>
		<tr>
			<td>취미</td>
			<td>${human.hobby}</td>
		</tr>
		<tr>
			<td>특기</td>
			<td>${human.special}</td>
		</tr>
		<tr>
			<td>생일</td>
			<td>${human.birth}</td>
		</tr>
		<tr>
			<td>직업</td>
			<td>${human.job}</td>
		</tr>
		<tr>
			<td>가입 날짜</td>
			<td>${human.regdate}</td>
		</tr>
	</table>
</body>
</html>