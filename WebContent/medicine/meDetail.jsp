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
            <h5 class="m-0 font-weight-bold text-primary">${bean.name} 투약의뢰서</h5>
        </div>
	<div class="card-body">
    <div class="table-responsive">
    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
		<div class="panel panel-primary">
			<div class="row panel-body">
				<div class="col-sm-8">
					<table class="table table-bordered">
						<tr>
							<th width="40%" align="center">등록 날짜</th>
							<td width="60%" align="left">${bean.regdate}</td>
						</tr>
						<tr>
							<th width="40%" align="center">약종류</th>
							<td width="60%" align="left">${bean.category}</td>
						</tr>
						<tr>
							<th width="40%" align="center">투약량</th>
							<td width="60%" align="left">${bean.amount}</td>
						</tr>
						<tr>
							<th width="40%" align="center">투약 횟수</th>
							<td width="60%" align="left">${bean.reps}</td>
						</tr>
						<tr>
							<th width="40%" align="center">투약 시간</th>
							<td width="60%" align="left">${bean.hour}</td>
						</tr>
						<tr>
							<th width="40%" align="center">보관방법</th>
							<td width="60%" align="left">${bean.storagemethod}</td>
						</tr>
						<tr>
							<th width="40%" align="center">비고</th>
							<td width="60%" align="left">${bean.textarea}</td>
						</tr>
						<tr>
							<th width="40%" align="center">확인 여부</th>
							<td width="60%" align="left">${bean.checks}</td>
						</tr>
						<td colspan="2" align="right">
			<div class="col-sm-7" style="float:center; ">
				<button class="btn btn-info" onclick="location.href='<%=NoForm%>meList'">
					돌아 가기
				</button>
				<c:choose>
					<c:when test="${bean.checks != '안읽음' && whologin == 2 }">
						<button class="btn btn-info" onclick="alertchecks();">
						확인
						</button>
					</c:when>
					<c:when test="${bean.checks == '안읽음' && whologin == 2 }">
						<button class="btn btn-info" onclick="location.href='<%=NoForm%>meCheck&meno=${bean.meno}'">
						확인
						</button>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${bean.checks != '안읽음' }">
						<button class="btn btn-danger" onclick="alertdelete();">
						삭제
						</button>
					</c:when>
					<c:when test="${bean.checks == '안읽음' }">
						<button class="btn btn-danger" onclick="location.href='<%=NoForm%>meDelete&meno=${bean.meno}'">
						삭제
						</button>
					</c:when>
				</c:choose>
				
				<%-- <button class="btn btn-danger" onclick="location.href='<%=NoForm%>empDelete&tid=${bean.tid}'">
					직원 정보 삭제
				</button> --%>
			</div>
			</td>
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