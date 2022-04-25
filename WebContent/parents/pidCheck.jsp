<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>아이디 중복체크</title>

	<link href="<%=request.getContextPath() %>/bootstrap/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath() %>/bootstrap/css/sb-admin-2.min.css" rel="stylesheet">
	
	<script type="text/javascript">
		function meclose() {
			opener.writeForm.idcheck.value='${requestScope.isCheck}';
			var win = window.open("","_self");
			win.close();
			
		}
	</script>
</head>
<body>
	<div class="container mx-auto bg-light">
		<br>
		<br>
		<br>
		<p align="center">${requestScope.message}</p>
		<br>
		<div align="center">
			<button onclick="meclose();">
				닫&nbsp;&nbsp;기
			</button>
		</div>
	</div>
</body>
</html>