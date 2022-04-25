<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>   
<!DOCTYPE><html><head>
<meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>아이하루 어린이집</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/bootstrap2/assets/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.15.3/js/all.js"></script>
        <!-- Simple line icons-->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.5.5/css/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="<%=request.getContextPath()%>/bootstrap2/css/styles.css?after" rel="stylesheet" />
       
        <!-- w3school 예제에서 가져옴 -->
       	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body> 	
<%
	String imsi = request.getContextPath() + "/Kids?command=" ; 	
	//response.sendRedirect( imsi ) ;
%>
	<a href="<%=imsi%>hello">헬로우</a>
	<br><br><br>
	<a href="<%=imsi%>world">월드</a>
	안녕하세요 0514 aa
	0517 시영 내용 추가 시영내용추가 
	<div onclick="location.href">
	테스트 테스트
	</div>
</body>
</html>