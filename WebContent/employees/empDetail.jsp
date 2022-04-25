<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4 style="margin-left:17%;">내 정보 보기</h4>
<div class="row container" style="margin-left:15%;">
	<div class="wrap col-sm-3">
		<div class="card shadow mb-4">
			<div class="card-header">
				<h5 class="font-weight-bold text-primary">${bean.name}(${bean.tid})</h5>
			</div>
			<div class="card-body" style="background-color:white">
				<img src="./upload/${bean.image}" class="img-rounded" 
									alt="${bean.name}" width="200" height="200">
			</div>
		<!-- <br>
			<div class="card-header" style="background-color:#EEEEEE;">
				<h5>${bean.name}(${bean.tid})</h5>
			</div>
			<div class="card-body" style="background-color:white">
				<img src="./upload/${bean.image}" class="img-rounded" 
									alt="${bean.name}" width="200" height="200">
			</div> -->	
		</div>
	</div>
	<div class="wrap col-sm-9">
		<div class="card shadow mb-4">
			<div class="card-header">
				<h5 class="font-weight-bold text-primary">인적사항</h5>
			</div>
			<div class="card-body" style="background-color:white">
				<table class="table">
					<tr>
						<td width="25%" align="center">이름</td>
						<td width="75%" align="left">${bean.name}</td>
					</tr>
					<tr>
						<td width="25%" align="center">아이디</td>
						<td width="75%" align="left">${bean.tid}</td>
					</tr>
					<c:if test="${bean.responsibilities == '직원'}">
					<tr>
						<td width="25%" align="center">담당 학급</td>
						<td width="75%" align="left">${bean.class_name}</td>
					</tr>
					</c:if>
					<c:if test="${bean.responsibilities == '특별'}">
					<tr>
						<td width="25%" align="center">담당 과목</td>
						<td width="75%" align="left">${bean.subject}</td>
					</tr>
					</c:if>
					<tr>
						<td width="25%" align="center">성별</td>
						<td width="75%" align="left">${bean.gender}</td>
					</tr>
					<tr>
						<td width="25%" align="center">생년월일</td>
						<td width="75%" align="left">${bean.birth}</td>
					</tr>
					<tr>
						<td width="25%" align="center">핸드폰 번호</td>
						<td width="75%" align="left">${bean.hp}</td>
					</tr>
					<tr>
						<td width="25%" align="center">이메일</td>
						<td width="75%" align="left">${bean.email}</td>
					</tr>
					<tr>
						<td width="25%" align="center">직급</td>
						<td width="75%" align="left">${bean.responsibilities}</td>
					</tr>
					<tr>
						<td width="25%" align="center">주소</td>
						<td width="75%" align="left">${bean.address1}(${bean.address2})</td>
					</tr>
					<tr>
						<td width="25%" align="center">급여</td>
						<td width="75%" align="left">${bean.salary}</td>
					</tr>
					<tr>
						<td width="25%" align="center">등록 날짜</td>
						<td width="75%" align="left">${bean.join_date}</td>
					</tr>
				</table>
				<div class="col-sm-12" style="float:right;">
					<button class="btn btn-info" onclick="location.href='<%=contextPath %>/common/main.jsp'">
						돌아 가기
					</button>
					<button class="btn btn-info" onclick="location.href='<%=NoForm%>empUpdate&tid=${bean.tid}'">
						내 정보 수정
					</button>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>
