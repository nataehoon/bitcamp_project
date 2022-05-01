<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>카드형 식단</title>
<script type="text/javascript">
	function podelete(pono, id){
		if(confirm('삭제 하시겠습니까?')){
			location.href='<%=contextPath%>/podelete.po?pono='+ pono +'&id=' + id;
			alert('삭제 완료 하였습니다.');
		}
	}
</script>
<style>
	td {
		
	}
</style>
</head>
<body>
<div class="container col-sm-offset-2 col-sm-6">
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h4 class="font-weight-bold text-danger">체형</h4>
		</div>
		<div class="panel-body">
			<div class="col-sm-12">
				<table class="w3-center col-sm-12">
					<tr>
						<td>
							<img src="./upload/${bean.image1}" class="img-rounded" 
							alt="${bean.image1}" width="220" height="500">
						</td>
						<td>
							<img src="./upload/${bean.image2}" class="img-rounded" 
								alt="${bean.image2}" width="220" height="500">		
						</td>
						<td>
							<img src="./upload/${bean.image3}" class="img-rounded" 
								alt="${bean.image3}" width="100" height="500">		
						</td>
						<td>
							<img src="./upload/${bean.image4}" class="img-rounded" 
								alt="${bean.image4}" width="100" height="500">		
						</td>
					</tr>
				</table>
				<div class="col-sm-12">
					<h5 class="font-weight-bold text-danger">코멘트</h5>
					<textarea class="form-control" rows="5" cols="100" readonly="readonly">${bean.comments}</textarea>
					<c:if test="${sessionScope.loginfo.id == bean.id}">
					<div style="float:right;">
						<button class="btn btn-danger" type="button" onclick="podelete(${bean.pono}, '${bean.id}');">
						삭제
						</button>
					</div>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>