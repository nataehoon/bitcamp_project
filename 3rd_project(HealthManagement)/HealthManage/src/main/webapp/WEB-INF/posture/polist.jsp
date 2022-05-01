<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<script type="text/javascript">
	function podelete(pono, id){
		if(confirm('삭제 하시겠습니까?')){
			location.href='<%=contextPath%>/podelete.po?pono='+ pono +'&id=' + id;
			alert('삭제 완료 하였습니다.');
		}
		
	}
</script>
</head>
<body>
<div class="container col-sm-12">
	<div class="card card-danger">
		<div class="card-heading" align="center">
			<c:if test="${sessionScope.loginfo.id == id}">
			<br><h2 class="font-weight-bold text-danger">체형 리스트</h2>
			<span style="float:right;margin-right:10%">
				<a href="<%=contextPath%>/insert.po?id=${id}" class="btn btn-info" type="buttoen">체형 등록&nbsp;</a>
			</span>
			</c:if>
		</div>
		<c:if test="${bean1.pono != null}">
		<div class="card-body">
			<c:if test="${bean2.pono != null}">
			<div class="w3-center col-sm-9" style="float:left;margin-left:11%">
				<span class="" style="float:right;margin-right:20%">등록 날짜 : ${bean2.regdate}</span>
				<table class="table"> 
					<thead onclick="location.href='<%=contextPath%>/detail.po?pono=${bean2.pono}'">
						<tr>
							<td>
								<img src="./upload/${bean2.image1}" class="img-rounded" 
												alt="전면" width="220" height="500">		
							</td>
							<td>
								<img src="./upload/${bean2.image2}" class="img-rounded" 
												alt="후면" width="220" height="500">		
							</td>
							<td>
								<img src="./upload/${bean2.image3}" class="img-rounded" 
												alt="측면(좌)" width="100" height="500">	
							</td>
							<td>
								<img src="./upload/${bean2.image4}" class="img-rounded" 
												alt="측면(우)" width="100" height="500">		
							</td>
						</tr>
					</thead>
				</table>
			</div>
			</c:if>
			<div class="w3-center col-sm-9" style="margin-left:10%">
				<span class="" style="float:right;margin-right:20%">측정 날짜 : ${bean1.regdate}</span>
				<table class="table">
					<thead onclick="location.href='<%=contextPath%>/detail.po?pono=${bean1.pono}'">
						<tr>
							<td>
								<img src="./upload/${bean1.image1}" class="img-rounded" 
												alt="전면" width="220" height="500">		
							</td>
							<td>
								<img src="./upload/${bean1.image2}" class="img-rounded" 
												alt="후면" width="220" height="500">		
							</td>
							<td>
								<img src="./upload/${bean1.image3}" class="img-rounded" 
												alt="측면(좌)" width="100" height="500">	
							</td>
							<td>
								<img src="./upload/${bean1.image4}" class="img-rounded" 
												alt="측면(우)" width="100" height="500">		
							</td>
						</tr>
					</thead>
				</table>
				<c:if test="${sessionScope.loginfo.id == id}">
				<div style="float:right;">
					<button class="btn btn-danger" type="button" onclick="podelete(${bean1.pono}, '${bean1.id}');">
						삭제
					</button>
				</div>
				</c:if>
			</div>
		</div>
		<hr>
		</c:if>
		<div class="row card-body col-offset-2">
			<div class="w3-center col-sm-4" style="float:left;margin-left:12%">
				<table class="table table-bordered">
					<tr>
						<td colspan="3" align="center">이상적인 바른자세</td>
					</tr>
					<tr>
						<td>
							<img src="./upload/후면.png" class="img-rounded" 
											alt="전면" width="220" height="500">		
						</td>
						<td>
							<img src="./upload/후면.png" class="img-rounded" 
											alt="후면" width="220" height="500">		
						</td>
					</tr>
					<tr>
						<td>
							<img src="./upload/측면.png" class="img-rounded" 
											alt="측면(좌)" width="100" height="500">	
						</td>
						<td>
							<img src="./upload/측면.png" class="img-rounded" 
											alt="측면(우)" width="100" height="500">		
						</td>
					</tr>
				</table>
			</div>
			<div class="col-sm-4" style="margin-left:10%">
				<table class="table table-bordered">
					<tr>
						<td colspan="3" align="center">체형 리스트</td>
					</tr>
					<tr>
						<td>순번</td>
						<td>측정 날짜</td>
					</tr>
					<c:forEach var="bean" items="${requestScope.lists}">
					<tr onclick="location.href='<%=contextPath%>/detail.po?pono=${bean.pono}'">
						<td>${bean.num}</td>
						<td>${bean.regdate}</td>
					</tr>
					</c:forEach>
				</table>
				<div align="center">
					<p class="form-control-static">${requestScope.pagingStatus}</p>
					<footer>${requestScope.pagingHtml}</footer>			
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>