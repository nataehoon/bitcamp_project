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
				<h4>직원 정보 보기</h4>
			</div>
			<div class="row panel-body">
				<div class="col-sm-4">
					<table>
						<tr>
							<td>
								<img src="<%=request.getContextPath()%>/images/teacher.jpg" class="img-rounded" 
									alt="${bean.name}" width="200" height="200">		
							</td>
						</tr>
					</table>
				</div>
				<div class="col-sm-8">
					<table class="table table-bordered">
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
						<tr>
							<td width="25%" align="center">출결</td>
							<td width="75%" align="left">
								${mbean.regdate}(${mbean.attendance})&nbsp;
								<a href="<%=NoForm%>empmAtt&tid=${bean.tid}">자세히 보기</a>
							</td>
						</tr>
					</table>
				</div>
			</div>
			<hr>
			<div class="col-sm-7" style="float:right;">
				<button class="btn btn-info" onclick="location.href='<%=NoForm%>empList'">
					돌아 가기
				</button>
				<button class="btn btn-info" onclick="location.href='<%=NoForm%>empmUpdate&tid=${bean.tid}'">
					직원 정보 수정
				</button>
				<button class="btn btn-danger" onclick="location.href='<%=NoForm%>empDelete&tid=${bean.tid}'">
					직원 정보 삭제
				</button>
			</div>
		</div>
	</div>
</body>
</html>
<html>
<body>
<%@ include file="./../common/footer.jsp" %>
</body>
</html>