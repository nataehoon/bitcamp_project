<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function alertchecks(){
		alert("이미 확인하였습니다.");
	}
	function alertdelete(){
		alert("이미 선생님이 확인하여 삭제할 수 없습니다.");
	}
</script>
<body>
<div class="container fluid">
	<div class="card shadow mb-4">
		<div class="card-header py-3">
            <h5 class="m-0 font-weight-bold text-primary">${bean.name} 알림장 목록</h5>
        </div>
	<div class="card-body">
    <div class="table-responsive">
    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
		<div class="panel panel-primary">
			<div class="row panel-body">
				<div class="col-sm-8">
					<table class="table table-bordered">
						<tr>
							<th>날짜</th>
							<th>반 이름</th>
							<th>이름</th>
						</tr>
						<tr>
						<c:forEach var="bean" items="beans">
							<td>${bean.regdate}</td>
							<td>${sessionScope.loginfo.classname}</td>
							<td>${bean.sid}</td>
						</c:forEach>
						</tr>
						<tr>
							<button type="button" class="form-control" onclick="location.href='<%=NoForm%>noInsert&tid=${sessionScope.loginfo.tid}&${requestScope.parameters}'">글쓰기</button>
						</tr>
						<tr>
							<td>dddd</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</table>
	</div>
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