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
				<h4>학생 정보 상세 보기</h4>
			</div>
			<div class="row panel-body">
				<div class="col-sm-4">
					<table>
						<tr>
							<td>
								<img src="<%=request.getContextPath()%>/images/student.png" class="img-rounded" 
									alt="${bean.name}" width="200" height="200">		
							</td>
						</tr>
					</table>
				</div>
				<div class="col-sm-8">
					<table class="table table-bordered">
						<tr>
							<td width="25%" align="center">이름</td>
							<td width="75%" align="left">${bean.sname}</td>
						</tr>
						<tr>
							<td width="25%" align="center">학급</td>
							<td width="75%" align="left">${bean.class_name}</td>
						</tr>
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
							<td width="25%" align="center">주소</td>
							<td width="75%" align="left">${bean.address1}${bean.address2}</td>
						</tr>
						<tr>
							<td width="25%" align="center">등록 날짜</td>
							<td width="75%" align="left">${bean.join_date}</td>
						</tr>
						<tr>
							<td width="25%" align="center">특기 사항</td>
							<td width="75%" align="left">${bean.regdate}</td>
						</tr>
						<tr>
							<td width="25%" align="center">부모님 성함</td>
							<td width="75%" align="left">${bean.pname}</td>
						</tr>
						<tr>
							<td width="25%" align="center">부모 핸드폰 번호</td>
							<td width="75%" align="left">${bean.p_hp}</td>
						</tr>
					</table>
				</div>
			</div>
			<hr>
			<div class="col-sm-7" style="float:right;">
				<button class="btn btn-info" onclick="location.href='<%=NoForm%>stList'">
					돌아 가기
				</button>
				<button class="btn btn-info" onclick="location.href='<%=NoForm%>stUpdate&tid=${bean.sid}'">
					학생 정보 수정
				</button>
				<button class="btn btn-danger" onclick="location.href='<%=NoForm%>stDelete&tid=${bean.sid}'">
					학생 정보 삭제
				</button>
			</div>
		</div>
	</div>
</body>
</html>
