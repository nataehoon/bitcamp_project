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
	<div class="container-fluid col-sm-offset-2 col-sm-8">
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h4 class="font-weight-bold text-primary">공지 사항</h4>
				</div>
					<div class="card-body">
						<div class="table-responsive">
						<table class="table table-bordered">
							<tr>
								<td width="10%" align="center">제목</td>
								<td width="90%" align="left">
									${bean.title}<p style="float:right;">글 번호 : ${bean.notino} &nbsp;&nbsp; 작성자 : ${bean.tid} &nbsp;&nbsp; 조회수 : ${bean.readhit}</p>
								</td>
							</tr>
							<tr>
								<td width="25%" align="center" colspan="2">
								<c:if test="${bean.files != null}">
								<img src="./upload/${bean.files}" class="img-rounded" width="100%" height="500">
								</c:if>
								<textarea class="form-control" readonly="readonly"style="float:left;width:100%;height:600px">${bean.content}</textarea></td>
							</tr>
							<tr>
								<td width="25%" align="center">등록일자</td>
								<td width="75%" align="left">${bean.regdate}</td>
							</tr>
						</table>
					</div>
				</div>
			<hr>
			<div class="col-sm-7" style="float:right;">
				<button class="btn btn-info" onclick="location.href='<%=NoForm%>goUpdate&notino=${bean.notino}'">
					글 수정
				</button>
				<button class="btn btn-danger" onclick="location.href='<%=NoForm%>goDelete&notino=${bean.notino}'">
					글 삭제
				</button>
			</div>
		</div>
	</div>
</body>
</html>