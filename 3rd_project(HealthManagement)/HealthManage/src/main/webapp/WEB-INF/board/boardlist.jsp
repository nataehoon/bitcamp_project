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
		function writeForm(loginstatus){
			if(loginstatus != 0){
				location.href='<%=contextPath%>/insert.bo?id=' + '${sessionScope.loginfo.id}' + '&category=' + '${category}';
			}else{
				location.href='/com/login.me';
				alert('로그인 후 이용해 주세요');
			}
		}
		function search(){
			if( $('#mode').val() == 'all' ){
				alert('검색 목록을 선택해주세요') ;
			}
		}
		function searchAll(category){
			//$('#mode').val('-');
			//$('#keyword').val('');
			location.href='<%=contextPath%>/list.bo?category=' + category;
		}
	</script>	
</head>
<body>
	<div class="container col-sm-12">
		<div class="card">
			<div class="card-heading" align="center">
				<form class="form-inline" role="form">
					<h2 style="color:red"><br>${mocategory} 게시판<br></h2>
				</form>
			</div>
			<div style="float:right;">
				<form class="form-inline" role="form" name="myform" action="<%=contextPath%>/list.bo" method="get">
				<input type="hidden" name="category" value="${category}">
					<div class="form-group">
						<br><br>&nbsp;&nbsp;&nbsp;&nbsp;
						<select class="form-control" name="mode" id="mode">
							<option value="all" selected="selected">-- 선택하세요---------
							<option value="id" >작성자
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
					<button class="btn btn-default btn-danger" type="button" onclick="searchAll('${category}');">전체 검색</button>&nbsp;&nbsp;
					<button class="btn btn-default btn-danger" type="button"
						onclick="writeForm(${loginstatus});">글 쓰기</button>
					&nbsp;&nbsp;<p class="form-control-static">${requestScope.pagingStatus}</p>
				</form>
			</div>
			<div class="card-body" style="background-color:white">
				<table class="table table-striped table-hover">
					<tr>
						<th>글 번호</th>
						<th>작성자</th>
						<th>글 제목</th>
						<th>조회수</th>
						<th>추천수</th>
						<th>게시판 구분</th>
						<th>작성 일자</th>
					</tr>
					<c:forEach var="bean" items="${requestScope.lists}">
						<tr onclick="location.href='<%=contextPath%>/detail.bo?bono=${bean.bono}&${requestScope.parameters}'">
							<td>
								${bean.num}
							</td>
							<td>
								${bean.nickname}
							</td>
							<td>
								${bean.title}
							</td>
							<td>
								${bean.readhit}
							</td>
							<td>
								${bean.recommend}
							</td>
							<td>
								${bean.category}
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