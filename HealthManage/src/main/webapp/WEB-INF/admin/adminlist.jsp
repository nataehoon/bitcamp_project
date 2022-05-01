<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
   /* 방금 전 선택한 콤보 박스를 그대로 보여 주기 */ 
	$('#mode option').each(function (index){
		if( $(this).val() == '${requestScope.mode}' ){
			$(this).attr('selected', 'selected') ;
		}
	});	
	/* 이전에 넣었던 값 그대로 보존 */
	$('#keyword').val( '${requestScope.keyword}' ) ;	
	
	function search(){
		if( $('#mode').val() == '-' ){
			alert('검색 목록을 선택해주세요') ;
		}
		
	}
	function searchAll(part){
		location.href='<%=contextPath%>/adminlist.am?part=' + part;
	}
</script>
</head>
<body>
<div class="container col-sm-offset-2 col-sm-10">
	<div class="card">
		<div class="card-heading">
			<h2 style="color:red"><br>${requestScope.partname} 목록</h2>
		</div>
		<div class="card-body col-sm-12" align="right" style="float:right;">
			<form class="form-inline" role="form" name="myform" action="<%=contextPath%>/adminlist.am" method="get">
			<input type="hidden" name="part" value="${requestScope.part}">
			<div class="form-group">
				<br><br>&nbsp;&nbsp;
				<select class="form-control" name="mode" id="mode">
					<option value="-" selected="selected">----선택하세요-----
					<option value="id">아이디
					<option value="name">이름
					<option value="nickname">닉네임
				</select>
			</div>
			<div class="form-group">
				<input type="text" class="form-control btn-xs" name="keyword" id="keyword" placeholder="검색 키워드">
			</div>
			<button class="btn btn-danger" type="submit" onclick="search();">검색</button>&nbsp;&nbsp;
			<button class="btn btn-danger" type="button" onclick="searchAll('${requestScope.part}');">전체 검색</button>&nbsp;&nbsp;
			&nbsp;&nbsp;<p class="form-control-static">${requestScope.pagingStatus}</p>
			</form>
		</div>
	</div>
	<div class="card-body" style="background-color:white">
		<table class="table table-hober">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>닉네임</th>
				<th>등록수</th>
			</tr>
			<c:forEach var="bean" items="${requestScope.lists}">
			<c:if test="${requestScope.part == 'po'}">
			<tr onclick="location.href='<%=contextPath%>/polist.po?id=${bean.id}'">
			</c:if>
			<c:if test="${requestScope.part == 'health'}">
			<tr onclick="location.href='<%=contextPath%>/healthlist.he?id=${bean.id}'">
			</c:if>
			<c:if test="${requestScope.part == 'diet'}">
			<tr onclick="location.href='<%=contextPath%>/dietlist.di?id=${bean.id}'">
			</c:if>
			<c:if test="${requestScope.part == 'log'}">
			<tr onclick="location.href='<%=contextPath%>/loglist.lo?id=${bean.id}'">
			</c:if>
				<td>${bean.id}</td>
				<td>${bean.name}</td>
				<td>${bean.nickname}</td>
				<td>${bean.totalcount}</td>
			</tr>
			</c:forEach>
		</table>
		<div align="center">
			<footer>${requestScope.pagingHtml}</footer>
		</div>
	</div>
</div>
</body>
</html>