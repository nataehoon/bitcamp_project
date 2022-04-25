<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<%
	/* position for grid system */	
	int offset = 4 ;
	int mywidth = 12 - 4 * offset ;
	int formleft = 3 ;
	int formright = 12 - formleft ;
	int rightButton = 4 ;
%>

<!DOCTYPE html>
<html>
<head>
<script>	
		function search(){
			/* alert('검색');  */	
			var mode = $('#mode').val() ;
			var keyword = $('#keyword').val() ;
			location.href='<%=NoForm%>stList' + '&mode=' + mode + '&keyword=' + keyword ;
		}
		function searchAll(){
			/* alert('전체 검색'); */
			location.href='<%=NoForm%>stList';
		}
		function writeForm(){
			/* alert('글 작성'); */
			location.href='<%=NoForm%>stInsert';
		}
		
		$(document).ready(function(){
			
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
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>아이들 목록 보기</h4>
					<table>
						<tr>
							<td align="center" colspan="11">
								<form action="" class="form-inline" role="form" name="myform"
									method="get">
									<div class="form-group">
										<select id="mode" name="mode" class="form-control">
											<option value="all" selected="selected">-- 선택하세요.
											<option value="name">이름
											<option value="gender">성별
										</select>
									</div>
									<div class="form-group">
										<input type="text" class="form-control" name="keyword"
											id="keyword">
									</div>
									&nbsp;&nbsp;
									<button class="btn btn-primary" type="button"
										onclick="search();">검색</button>
									&nbsp;&nbsp;
									<button class="btn btn-primary" type="button"
										onclick="searchAll();">전체 검색</button>
									&nbsp;&nbsp; ${pageInfo.pagingStatus}
								</form>
							</td>
						</tr>
						</table>
						<br>
					<div class="panel-body">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>이름</th>
									<th>성별</th>
									<th>생일</th>
									<th>학급</th>
								</tr>
							</thead>
							
							</table>	
							 	<c:forEach var="bean" items="${requestScope.lists}">		
							<tr>
								<td>${bean.name}</td>
								<td>${bean.gender}</td>
								<td>${bean.birth}</td>
								<td>${bean.textarea}</td>
								<td>
									<a href="<%=NoForm%>&no=${bean.no}&${requestScope.parameters}">
											삭제
									</a>
								</td>
							</tr>
						</c:forEach> 
						
					</div>
					
					
					
					<div align="center">
						<footer>${pageInfo.pagingHtml}</footer>
					</div>
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
</body>
</html>
