<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
	<div class="container col-sm-offset-3 col-sm-6">
		<div class="panel panel-default panel-primary">
			<div class="panel-heading">로그인 하기</div>
			<div class="panel-body">
				<form class="form-horizontal" role="form" action="<%=contextPath%>/login.me" method="post">
					<div class="form-group">
						<label class="control-label col-sm-3" for="id">아이디</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="id" id="id"
								data-toggle="tooltip" data-placement="top" 
								placeholder="아이디를 넣어 주셔용^^" value="any">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="password">비밀 번호</label>
						<div class="col-sm-9">
							<input type="password" class="form-control" name="password"
								id="password" placeholder="비밀 번호를 넣어 주셔용^^" value="11">
						</div>
						<span class="err">${errmasg}</span>
					</div>
					<div class="form-group">
						<div align="center" class="col-sm-offset-3 col-sm-6">
							<button class="btn btn-danger" type="submit">로그인</button>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<button class="btn btn-danger" type="reset">취소</button>
							&nbsp;&nbsp;&nbsp;
							<a href="<%=contextPath%>/insert.me">회원 가입</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<script>
		$(document).ready(function(){
    		$('[data-toggle="tooltip"]').tooltip();    		
		});
	</script>
	
</body>
</html>