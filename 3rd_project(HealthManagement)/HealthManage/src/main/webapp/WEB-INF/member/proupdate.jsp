<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.form-group{
		margin-bottom: 3px;
	}
	.err{
		font-color: red;
	}
</style>
</head>
<body>
<div class="container col-sm-12">
	<div class="card card-danger">
		<div class="card-heading" align="center">
		 	<br><br><h2 class="font-weight-bold text-danger">프로필 사진</h2>
		</div>
		<br><br>
		<div class="row card-body col-offset-3">
			<div class="col-sm-6" style="float:left;margin-left:18%">
				<c:set var="appath" value="<%=request.getContextPath()%>"/>
				<form:form modelAttribute="pro" id="myform" name="myform" class="form-horizontal" 
					role="form" action="${appath}/proupdate.me" method="post" enctype="multipart/form-data">
					<div class="row form-group">
						<label class="control-label col-sm-3" for="id">아이디</label>
						<div class="col-sm-9">
							<input path="id" type="text" name="id" class="form-control" placeholder="아이디" readonly="readonly" value="${requestScope.bean.id}"/>
						</div>
					</div>
						<div class="row form-group">
						<label class="control-label col-sm-3" for="asdf">사진</label>
						<div class="col-sm-9">
							<input type="file" name="asdf" class="form-control" value="${requestScope.bean.image}"/>
						</div>
					</div>
					<hr>
					<div style="float:right;">
						<button type="submit" class="btn btn-danger">사진 등록</button>
						<button type="reset" class="btn btn-danger">초기화</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>
	<script type="text/javascript">
		$(document).ready(function() {
			//alert('dd') ;
			$(".datepicker").datepicker();
			$("#spanid").addClass('good-result');
		});
	</script>
</body>
</html>