<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>


<div class="container fluid">
	<div class="card shadow mb-4">
		<div class="card-header py-3">
            <h5 class="m-0 font-weight-bold text-primary">귀가동의서 작성</h5>
        </div>
		<div class="card-body">
				
   			<form action="" method="post">
   				<input type="hidden" name="command" value="hoInsert">
   				
   				<label for="regdate">귀가시간</label><!-- regdate지만 의미는 귀가예정시간으로 쓴다.-->
				<input class="form-control" type="datetime-local" id="regdate"
				       name="regdate">
				     
   			</form>
		</div>
	</div>
</div>



</body>
</html>