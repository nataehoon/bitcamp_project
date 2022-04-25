<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		function period(){
			var datefr = $('#datefr').val();
			var dateto = $('#dateto').val();
			var tid = $('#tid').val();
			location.href='<%=NoForm%>empmAtt'+'&datefr='+datefr+'&dateto='+dateto+'&tid='+tid;
		}
	</script>
<c:set var="i" value="0" />
<c:set var="j" value="0" />
</head>
<body>
 <div class="d-sm-flex align-items-center justify-content-between mb-4">
   <div class="container col-sm-offset-2 col-sm-10">
         <div class="panel panel-primary">
            <div class="card-header">
               <h4>${ebean.name}님의 출결</h4>
               <table class="table table-hover">
					<thead>
						<tr>
							<th>아이디</th>
							<th>이름</th>
							<th>담당 학급</th>
							<th>담당 과목</th>
							<th>핸드폰 번호</th>
							<th>이메일</th>
							<th>직급</th>
							<th>주소</th>
							<th>등록 날짜</th>
						</tr>
					</thead>
			  	 <tbody>
					<tr>
						<td>${ebean.tid}</td>
						<td>${ebean.name}</td>
						<td>${ebean.class_id}</td>
						<td>${ebean.subject_code}</td>
						<td>${ebean.hp}</td>
						<td>${ebean.email}</td>
						<td>${ebean.responsibilities}</td>
						<td>${ebean.address1}(${ebean.address2})</td>
						<td>${ebean.join_date}</td>
					</tr>
				</tbody>	
			</table>
			<div class="card-body">
				<div>
					<input type="date" id="datefr" value="2021-05-01" />
					<input type="date" id="dateto" value="2021-05-31" />
					<input type="hidden" id="tid" value="${ebean.tid}" />
					<button class="btn btn-info" type="button" onclick="period();">찾기</button>
				</div>
			<table class="table table-hover">
				<tr>
					<td>월</td>
					<td>화</td>
					<td>수</td>
					<td>목</td>
					<td>금</td>
				</tr>
				<tr>
					<c:forEach var="lists" items="${requestScope.lists}">
						<c:if test="${j == 0}">
							<c:forEach var="j" begin="1" end="${lists.regday}">
								<c:if test="${lists.regday > 1}">
								<td/>
								</c:if>
								<c:if test="${j == lists.regday}">
									<td>
									<c:set var="i" value="${lists.regday}" />
									<c:set var="j" value="${lists.regday}" />
								</c:if>
							</c:forEach>
						</c:if>
						<c:if test="${i != lists.regday}">
							</td>
							<td>
							<c:set var="i" value="${lists.regday}" />
						</c:if>
						<div>${lists.regdate}${lists.attendance}</div>
						<br>
						<c:if test="${i%5 == 0}">
							</tr>
							<tr>
						</c:if>
					</c:forEach>
					</td>
					</tr>
				</table>
	        </div> 
	      </div>
	    </div>	
	</div>    
</div>
</body>
</html>