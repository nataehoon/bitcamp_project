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
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h4 class="font-weight-bold text-primary">식단 정보</h4>
			</div>
			<div class="row panel-body">
				<div class="col-sm-4">
					<table>
						<tr>
							<td>
								<img src="./upload/${bean.files}" class="img-rounded" 
									alt="${bean.category}" width="300" height="200">		
							</td>
						</tr>
					</table>
				</div>
				<form class="card-body col-7" style="background-color:white;">
					<table class="table">
						<tr>
							<td width="25%" align="center">등록 일자</td>
							<td width="75%" align="left">${bean.regdate}&nbsp;&nbsp;${bean.category}</td>
						</tr>
						<tr>
							<td width="25%" align="center" style="padding-top:9%;">식단 내용</td>
							<td width="75%" align="left">
							<textarea class="form-control" rows="5" cols="10" readonly="readonly">${bean.content}</textarea>
							</td>
						</tr>
					</table>
					<div class="col-sm-7" style="float:right;">
						<button class="btn btn-info" type="button" onclick="location.href='<%=NoForm%>dietList'">
							돌아 가기
						</button>
						<button class="btn btn-info" type="button" onclick="location.href='<%=NoForm%>dietUpdate&dietno=${bean.dietno}'">
							수정
						</button>
						<button class="btn btn-danger" type="button" onclick="location.href='<%=NoForm%>dietDelete&dietno=${bean.dietno}'">
							삭제
						</button>
					</div>
					</form>
				</div>
			</div>
			<hr>
		</div>
</body>
</html>