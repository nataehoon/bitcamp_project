<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath() ;
	String mappingName = "/Kids" ;
	
	String YesForm = contextPath + mappingName ;
	String NoForm = contextPath + mappingName + "?command=" ;
%>
<!DOCTYPE html>
<html>
<head>	
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>유치원 비밀번호 찾기</title>

	<link href="<%=contextPath %>/bootstrap/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=contextPath %>/bootstrap/css/sb-admin-2.min.css" rel="stylesheet">
    <script type="text/javascript">
		function codeCheck(tid){
			
			var mailcode = '${requestScope.code}';
			var inputcode = document.getElementById('code').value;
			var result = document.getElementById('result');
			if( mailcode == inputcode){
				window.location.href="./employees/empUpdatePassword.jsp?tid="+tid; //opener 기준으로 상대경로 작성해야 되는듯...
			}else{
				result.innerHTML="";
				result.innerHTML='인증코드가 일치하지 않습니다';
			}
		}
		function preCheck(){
			result.innerHTML="";
			result.innerHTML ='메일 전송 완료';
		}
		
		function meClose(){
			var win = window.open("","_self");
			win.close();
		}
    </script>
</head>
<body>
<div class="container">
		<div class="card card-primary offset-sm-3 col-sm-6">
			<div class="card-header" align="center">
				<h4>비밀번호 찾기(직원)</h4>
			</div>
			<div class="card-body">
				<form action="<%=YesForm %>" method="post">
					<input type="hidden" name="command" value="empPaSearch">
					<div class="form-group">
						<input class="form-control" type="text" name="tid" id="tid" placeholder="아이디" value="${requestScope.tid }${requestScope.bean.tid}" required> 
					</div>
					<div class="form-group">
						<input class="form-control" type="email" name="email" id="email" placeholder="이메일" value="${requestScope.email }${requestScope.bean.email}" required> 
					</div>
					<button class="form-control btn btn-primary" onclick='preCheck();'>인증코드 이메일 전송</button>
				</form>
				<hr>
				<div class="form-group">
					<input class="form-control" type="text" name="code" id="code" placeholder="인증코드 입력" required> 
				</div>
				<input type="submit" class="form-control btn btn-primary" value="인증코드 확인" onclick="codeCheck('${requestScope.bean.tid}');">
				<br>
				<br>
				<div class="form-group" id="result" align="center">
				</div>
			</div>
	
			<div class="card-footer" align="center">
				<input type="button" class="btn btn-danger" value="닫기" onclick="meClose();">
			</div>
		</div>
	</div>
</body>
</html>