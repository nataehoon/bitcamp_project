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

    <title>비밀번호 변경하기</title>

	<link href="<%=contextPath %>/bootstrap/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=contextPath %>/bootstrap/css/sb-admin-2.min.css" rel="stylesheet">
    <script type="text/javascript">
    	function checkForm(){
    	      document.getElementById("pwddiv").innerText="";
    	      document.getElementById("repwddiv").innerText="";
    	      
    	      var pwd = document.papaupdate.password.value;
    	      var engNum = /(?=.*\d)(?=.*[a-z]).{8,15}/; //영어소문자+숫자 혼합. 8글자이상 15글자 이하
    	      var pwdtest = engNum.test(pwd);
    		
    		 if(document.papaupdate.password.value==""){
    			 document.getElementById("pwddiv").innerText="  비밀번호를 입력하세요";
    		 }else if(document.papaupdate.repassword.value==""){
    			 document.getElementById("repwddiv").innerText="  비밀번호 확인을 입력하세요";
    		 }else if(document.papaupdate.password.value != document.papaupdate.repassword.value){
    			 document.getElementById("repwddiv").innerText="  비밀번호가 일치하지 않습니다";
    		 }else{
    			 document.papaupdate.submit();
    		 }
    	}
    </script>
</head>
<body>
<div class="container">
	<br>
	<br>
	<div class="card card-primary offset-sm-3 col-sm-6">
		<div class="card-header" align="center">
			<h4>비밀번호 변경하기(보호자)</h4>
		</div>
		<div class="card-body">
			<form action="<%=YesForm %>" method="post" name="papaupdate">
				<input type="hidden" name="command" value="empUpPassword">
				<input type="hidden" name="tid" value="<%=request.getParameter("tid")%>">
				<div class="form-group">
					<input class="form-control" type="password" name="password" id="password" placeholder="비밀번호"> 
				</div>
				<div class="form-group" id="pwddiv" style="color:red;"></div>
				<div class="form-group">
					<input class="form-control" type="password" name="repassword" id="repassword" placeholder="비밀번호 확인"> 
				</div>
				<div class="form-group" id="repwddiv" style="color:red;"></div>
				<br>
				<input type="button" class="form-control btn btn-primary" value="적용" onclick="checkForm();">
				</form>
		</div>
	</div>
</div>
</body>
</html>