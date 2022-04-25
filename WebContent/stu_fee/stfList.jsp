<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>   
<!DOCTYPE>
<html>
<head>
</head>
<body>
	       <!-- 로그인 상태 정보 -->
<c:set var="whologin" value="0" /> 
<c:if test="${empty sessionScope.loginfo}">
	<c:set var="whologin" value="0" />
</c:if>
<c:if test="${not empty sessionScope.loginfo}">
	<c:if test="${sessionScope.loginfo.responsibilities == '원장'}">
		<c:set var="whologin" value="1" />
	</c:if>
	<c:if test="${sessionScope.loginfo.responsibilities == '직원'}">
		<c:set var="whologin" value="2" />
	</c:if>
	<c:if test="${sessionScope.loginfo.responsibilities != '원장'}">
		<c:if test="${sessionScope.loginfo.responsibilities != '직원'}">
			<c:set var="whologin" value="3" />
		</c:if>
	</c:if>
</c:if>

<!DOCTYPE html>
<html lang="en">
<%
	/* position for grid system */	
	int offset = 1 ;
	int mywidth = 12 - 2 * offset ;
	int formleft = 3 ;
	int formright = 12 - formleft ;
	int rightButton = 2 ;
%>

<!DOCTYPE html>
<html>
<head>
<script>
$(document).ready(function () {
	 
    //이메일 domain선택 selectBox
    $('#state').change(function(){
  $("#state option:selected").each(function () {
  //직접입력일 경우
  if($(this).val()== '분납'){
              $("#remark").val('');                             //textBox값 초기화
              $("#remark").attr("disabled",false);    //textBox 활성화
  }
  else{
            $("#remark").attr("disabled",true); //textBox 비활성화
  }
  });
    });
});

		function search(){
			var month = $('#month').val() ;
			var paid = $('#paid').val() ;
			var class_name = $('#class_name').val() ;
			var pageSize = $('#pageSize').val();
			
location.href='<%=NoForm%>stfList'+'&month='+month+'&paid='+paid+'&class_name='+class_name+'&pageSize='+pageSize;
		}
		function searchName(){
			var name = $('#name').val() ;
			location.href='<%=NoForm%>stfList '+' &name=' + name ;
		}
		function searchAll(){
			/* alert('전체 검색'); */
			location.href='<%=NoForm%>boList';
		}
		function writeForm(){
			/* alert('글 작성'); */
			location.href='<%=NoForm%>boInsert';
		}
		// 검색한 상태가 유지되는 방법 찾아보기
		$(document).ready(function() {
            $('select[id="month"]').find('option[value="month"]').attr("selected",true);

        });

	</script>
<style type="text/css">
.badge {
	background: orange;
	color: red;
}

.form-inline {
	justify-content: flex-end;
}
</style>
</head>
<body>
	<div class="d-sm-flex align-items-center justify-content-between mb-4">
		<div class="container col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">
		<div class="card shadow mb-4">
			<div class="card-header py-3">
               <h4 class="m-0 font-weight-bold text-primary">원비 납부 관리</h4>
            </div>
               <div class="card-body">
						<tr>
							<td align="center" colspan="11">
								<form action="<%=YesForm%>" class="form-inline" role="form" name="myform"
									method="get">
									<input type="hidden" id="command" name="command" value="stfInsert">
									<!-- <div class="form-group"> -->
										<!-- <select id="mode" name="mode" class="form-control">
											<option value="all" selected="selected">-- 선택하세요.
											<option value="name">이름
											<option value="gender">성별
										</select>
									</div>
									년 &nbsp; -->
									<div class="form-group">
										<select id="month" name="month" class="form-control" onchange="select();">
											<option value="all" selected="selected">전체검색
											<option value="01">1
											<option value="02">2
											<option value="03">3
											<option value="04">4
											<option value="05">5
											<option value="06">6
											<option value="07">7
											<option value="08">8
											<option value="09">9
											<option value="10">10
											<option value="11">11
											<option value="12">12
										</select>
									</div>
									월 &nbsp; 납부
									<div class="form-group">
										<select id="paid" name="paid" class="form-control">
											<option value="all" selected="selected">전체검색
											<option value="완납">완납
											<option value="분납">분납
											<option value="미납부">미납부
										</select>
									</div>
									&nbsp;반 
									<div class="form-group">
										<select id="class_name" name="class_name" class="form-control">
											<option value="all" selected="selected">전체검색
											<c:forEach var="bean" items="${requestScope.lists}">
												<option value="${bean.class_name}">${bean.class_name}
											</c:forEach>
										</select>
									</div>
									&nbsp;한 페이지에 표시할 갯수 
									<div class="form-group">
										<select id="pageSize" name="pageSize" class="form-control">
											<option value="10" selected="selected">10
											<option value="30">30
										</select>
									</div>
									<button class="btn btn-primary" type="button"
											onclick="search();">검색</button>
								</form>
							</td>
						</tr>
					<div class="panel-body">
						<form action="<%=YesForm%>" class="form-inline"  method="post">
						<input type="hidden" id="command" name="command" value="stfUpdate">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>선택</th>
									<th>날짜</th>
									<th>이름</th>
									<th>반</th>
									<th>납부</th>
									<th>미납금</th>
									<th>비고</th>
								</tr>
							</thead>
							<tbody>
							 	<c:forEach var="bean" items="${requestScope.lists}">		
							<tr>
								<c:choose>
								<c:when test="${bean.paid == '완납'}">
									<td><input type="checkbox" name="payno" id="payno" value="${bean.payno}" disabled></td>
								</c:when>
								<c:when test="${bean.paid == '분납' || bean.paid == '미납부' }">
									<td><input type="checkbox" name="payno" id="payno" value="${bean.payno}"></td>
								</c:when>
								</c:choose>
								<td>${bean.month}</td>
								<td>${bean.name}</td>
								<td>${bean.class_name}</td>
								<td>${bean.paid}</td>
								<td>
								<fmt:formatNumber value="${bean.unpaid}" pattern="###,###"/> 원
								</td>
								<td>
								<fmt:formatNumber value="${bean.remark}" pattern="###,###"/> 
								<c:if test="${not empty bean.remark}">
									<c:out value="원"/>
								</c:if>
								</td>
							</tr>
								</c:forEach> 
							</tbody>
							<tfoot>
							<tr>
								<td colspan="7">
								<select id="state" name="state" class="form-control">
									<option value="완납" selected="selected">완납
									<option value="분납">분납
								</select>
								<input type="text" name="remark" id="remark" disabled>
								<button class="btn btn-primary" type="submit">납부 내역 추가</button>
								<span class="text-danger">${errremark}</span>
								</td>
							</tr>
							</tfoot>
							</table>
							</form>
								<form action="" class="form-inline" role="form" name="myform" method="get">
									<div class="form-group">
										<input type="text" class="form-control" name="keyword"
												id="keyword">
									</div>
										&nbsp;&nbsp;
										<button class="btn btn-primary" type="button"
											onclick="searchName();">이름검색</button>
										&nbsp;&nbsp; ${pageInfo.pagingStatus}
								</form>
						</div>
					</div>
					<div align="center">
						<footer>${pageInfo.pagingHtml}</footer>
					</div>
				</div>
			</div>
		</div>
		<br>
		<br>
		<br>
		<br>
		<script type="text/javascript">
			/* 필드 검색 상태 보존 */
			$('#mode option').each(function() {
				if ($(this).val() == '${pageInfo.mode}') {
					$(this).attr('selected', 'selected');
				}
			});

			$('#keyword').val('${pageInfo.keyword}');
		</script>
    <!-- Bootstrap core JavaScript-->
    <script src="<%=request.getContextPath()%>/bootstrap/vendor/jquery/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/bootstrap/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="<%=request.getContextPath()%>/bootstrap/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="<%=request.getContextPath()%>/bootstrap/js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="<%=request.getContextPath()%>/bootstrap/vendor/chart.js/Chart.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="<%=request.getContextPath()%>/bootstrap/js/demo/chart-area-demo.js"></script>
    <script src="<%=request.getContextPath()%>/bootstrap/js/demo/chart-pie-demo.js"></script>


<%@ include file="./../common/footer.jsp" %>

</body>
</html>