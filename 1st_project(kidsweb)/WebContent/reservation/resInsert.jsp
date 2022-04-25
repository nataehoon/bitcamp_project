<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br>
<br>
<div class="container fluid">
	<div class="card shadow mb-4">
		<div class="card-header py-3">
           	<h5 class="m-0 font-weight-bold text-primary">상담 예약</h5>
        </div>
		<div class="card-body">
			<form action="<%=YesForm %>" method="post">
				<input type="hidden" name="command" value="resInsert">
				<input type="hidden" name="page" value="list">
				<input class="form-control form-control-lg" name="name"type="text" placeholder="원아 이름을 입력하세요" />
				<br>
				<input class="form-control form-control-lg" type="text" name="hp" placeholder="휴대폰 번호를 입력하세요" />
				<br>
				<input class="form-control form-control-lg" type="date" name="resdate" placeholder="희망 상담일자를 입력하세요" />
				<br>
				<input class="form-control btn btn-primary" type="submit" value="상담예약" />
			</form>
		</div>
	</div>
</div>
</body>
</html>