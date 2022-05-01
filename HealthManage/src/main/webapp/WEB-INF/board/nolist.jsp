<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style type="text/css">
		.xxx {
			margin-left: 0px;
		}
		.re{font-size: 11px;}
	</style>
	<script type="text/javascript">
		function writeForm(){
				location.href='<%=contextPath%>/noinsert.bo';
		}
		function search(){
			if( $('#mode').val() == 'all' ){
				alert('검색 목록을 선택해주세요') ;
			}
		}
		function searchAll(){
			location.href='<%=contextPath%>/nolist.bo';
		}
	</script>	
</head>
<body>
	<div class="container col-sm-12">
		<div class="card">
			<div class="card-heading">
				<form class="form-inline" role="form">
					<h2 style="color:red"><br>공지 사항</h2>
				</form>
			</div>
			<div style="float:right;">
				<form class="form-inline" role="form" name="myform" action="<%=contextPath%>/nolist.bo" method="get">
					<div class="form-group">
						<br><br>&nbsp;&nbsp;&nbsp;&nbsp;
						<select class="form-control" name="mode" id="mode">
							<option value="all" selected="selected">-- 선택하세요---------
							<option value="title" >제목									
							<option value="content" >글 내용									
						</select>
					</div>
					
					<div class="form-group">
						<input type="text" class="form-control btn-xs" name="keyword"
							id="keyword" placeholder="검색 키워드">
					</div>
					&nbsp;&nbsp;
					<button class="btn btn-default btn-danger" type="submit" onclick="search();">검색</button>&nbsp;&nbsp;
					<button class="btn btn-default btn-danger" type="button" onclick="searchAll();">전체 검색</button>&nbsp;&nbsp;
					<c:if test="${loginstatus == 2}">
					<button class="btn btn-default btn-danger" type="button" onclick="writeForm();">글 쓰기</button>
					</c:if>
					&nbsp;&nbsp;<p class="form-control-static">${requestScope.pagingStatus}</p>
				</form>
			</div>
			<div class="card-body" style="background-color:white;">
				<table class="table table-striped table-hover">
					<tr>
						<th>글 번호</th>
						<th>글 제목</th>
						<th>글쓴이</th>
						<th>작성 일자</th>
					</tr>
					<c:forEach var="bean" items="${requestScope.lists}">
						<tr onclick="location.href='<%=contextPath%>/nodetail.bo?notino=${bean.notino}&${requestScope.parameters}'">
							<td>
								${bean.notino}
							</td>
							<td>
								${bean.title}
							</td>
							<td>
								관리자
							</td>
							<td>
								${bean.regdate}							
							</td>						
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div align="center">
			<footer>${requestScope.pagingHtml}</footer>			
		</div>		
	</div>
	<br><br><br><br>
	<script type="text/javascript">
	   /* 방금 전 선택한 콤보 박스를 그대로 보여 주기 */ 
		$('#mode option').each(function (index){
			if( $(this).val() == '${requestScope.mode}' ){
				$(this).attr('selected', 'selected') ;
			}
		});	
		/* 이전에 넣었던 값 그대로 보존 */
		$('#keyword').val( '${requestScope.keyword}' ) ;		
	</script>	
</body>
</html>