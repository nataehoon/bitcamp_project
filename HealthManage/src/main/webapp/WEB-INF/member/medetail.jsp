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
	<div class="container col-sm-offset-2 col-sm-8">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4 class="font-weight-bold text-danger">내 정보 보기</h4>
			</div>
			<div class="row panel-body">
				<div class="col-sm-4">
					<table>
						<tr>
							<td>
								<a href="<%=contextPath%>/proupdate.me?id=${bean.id}">
									<img src="./upload/${bean.image}" class="img-rounded" 
										alt="${bean.id}" width="200" height="200">		
								</a>
							</td>
						</tr>
					</table>
				</div>
				<div class="card-body col-sm-8" style="background-color:white">
					<table class="table table-bordered">
						<tr>
							<td width="25%" align="center">이름</td>
							<td width="75%" align="left">${bean.name}</td>
						</tr>
						<tr>
							<td width="25%" align="center">아이디</td>
							<td width="75%" align="left">${bean.id}</td>
						</tr>
						<tr>
							<td width="25%" align="center">성별</td>
							<td width="75%" align="left">${bean.gender}</td>
						</tr>
						<tr>
							<td width="25%" align="center">나이</td>
							<td width="75%" align="left">${bean.age}</td>
						</tr>
						<tr>
							<td width="25%" align="center">핸드폰번호</td>
							<td width="75%" align="left">${bean.hp}</td>
						</tr>
						<tr>
							<td width="25%" align="center">닉네임</td>
							<td width="75%" align="left">${bean.nickname}</td>
						</tr>
						<tr>
							<td width="25%" align="center">이메일</td>
							<td width="75%" align="left">${bean.email}</td>
						</tr>
						<tr>
							<td width="25%" align="center">우편번호</td>
							<td width="75%" align="left">${bean.zipcode}</td>
						</tr>
						<tr>
							<td width="25%" align="center">주소</td>
							<td width="75%" align="left">${bean.address}</td>
						</tr>
						<tr>
							<td width="25%" align="center">세부주소</td>
							<td width="75%" align="left">${bean.address2}</td>
						</tr>
						<tr>
							<td width="25%" align="center">병력</td>
							<td width="75%" align="left">${bean.mehi}</td>
						</tr>
						<tr>
							<td width="25%" align="center">생활 패턴</td>
							<td width="75%" align="left">${bean.workpattern}</td>
						</tr>
						<tr>
							<td width="25%" align="center">수술 여부</td>
							<td width="75%" align="left">${bean.postop}</td>
						</tr>
						<tr>
							<td width="25%" align="center">수술 기록</td>
							<td width="75%" align="left">${bean.memo}</td>
						</tr>
					</table>
				</div>
			</div>
			<div style="float:right;">
				<button class="btn btn-danger" onclick="location.href='<%=contextPath%>/update.me?id=${bean.id}'">
					정보 수정
				</button>
			</div>
		</div>
	</div>
</body>
</html>