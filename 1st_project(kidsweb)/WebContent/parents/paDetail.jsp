<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부모 상세 페이지</title>
</head>
<body>
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
						<td width="75%" align="left">${bean.pid}</td>
					</tr>
					<tr>
						<td width="25%" align="center">생년월일</td>
						<td width="75%" align="left">${bean.birth}</td>
					</tr>
					<tr>
						<td width="25%" align="center">성별</td>
						<td width="75%" align="left">${bean.gender}</td>
					</tr>
					<tr>
						<td width="25%" align="center">이메일</td>
						<td width="75%" align="left">${bean.email}</td>
					</tr>
					<tr>
						<td width="25%" align="center">휴대폰</td>
						<td width="75%" align="left">${bean.hp}</td>
					</tr>
					<tr>
						<td width="25%" align="center">우편번호</td>
						<td width="75%" align="left">${bean.zipcode}</td>
					</tr>
					<tr>
						<td width="25%" align="center">주소</td>
						<td width="75%" align="left">${bean.address1}</td>
					</tr>
					<tr>
						<td width="25%" align="center">주소</td>
						<td width="75%" align="left">${bean.address2}</td>
					</tr>
					<tr>
						<td width="25%" align="center">승인상태</td>
						<td width="75%" align="left">${bean.submit}</td>
					</tr>
				</table>
				<div class="col-sm-12" style="float:right;">
				<button class="btn btn-info" onclick="location.href='<%=NoForm%>paUpdate&pid=${requestScope.bean.pid }'">
					정보 수정
				</button>
				<button class="btn btn-danger" onclick="location.href='<%=NoForm%>paDelete&pid=${requestScope.bean.pid }'">
					정보 삭제
				</button>
				<button class="btn btn-info" onclick="location.href='<%=NoForm%>paList'">
					돌아 가기
				</button>
				</div>
			</div>
		</div>
	</div>
</div>	
	
	
</body>
</html>