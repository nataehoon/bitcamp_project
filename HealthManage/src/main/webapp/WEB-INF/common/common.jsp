<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%	
	// 파일 업로드 관련
	String contextPath = request.getContextPath() ;
	String myurl = request.getRequestURL().toString() ;
	String uri = request.getRequestURI() ;
	int idx = myurl.indexOf( uri ) ;	
	//웹서버에 올릴 이미지의 저장 경로 
	String uploadPath = "/upload" ;//개발자가 임의 지정 가능
	String uploadedFolder 
		= myurl.substring(0, idx) + contextPath + uploadPath ;	
	String realPath = application.getRealPath( uploadPath ) ;
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

    <!-- Custom fonts for this template-->
    <link href="resources/bootstrap/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <!-- <link href="./../bootstrap/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css"> -->
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="resources/bootstrap/css/sb-admin-2.min.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	
	<script type="text/javascript">
		function pologinCheck(loginstatus){
			if(loginstatus != 0){
				location.href='polist.po?id='+ '${sessionScope.loginfo.id}';
			}else{
				location.href='/com/login.me';
				alert('로그인 후 이용해 주세요');
			}
		}
		function dietloginCheck(loginstatus){
			if(loginstatus != 0){
				location.href='dietlist.di?id='+ '${sessionScope.loginfo.id}';
			}else{
				location.href='/com/login.me';
				alert('로그인 후 이용해 주세요');
			}
		}
		function logloginCheck(loginstatus){
			if(loginstatus != 0){
				location.href='loglist.lo?id='+ '${sessionScope.loginfo.id}';
			}else{
				location.href='/com/login.me';
				alert('로그인 후 이용해 주세요');
			}
		}
		function healthloginCheck(loginstatus){
			if(loginstatus != 0){
				location.href='healthlist.he?id='+ '${sessionScope.loginfo.id}';
			}else{
				location.href='/com/login.me';
				alert('로그인 후 이용해 주세요');
			}
		}
		function chat(id){
			var url='<%=contextPath%>/advice.ad?id=' + id;
			window.open(url, 'mywin', 'height=750, width=600');
		}
	</script>
	
	<c:set var="loginstatus" value="fales"/>
	<c:if test="${empty sessionScope.loginfo}">
		<c:set var="loginstatus" value="0"/>
	</c:if>
	<c:if test="${not empty sessionScope.loginfo}">
		<c:set var="loginstatus" value="1"/>
	</c:if>
	<c:if test="${sessionScope.loginfo.id == 'any'}">
		<c:set var="loginstatus" value="2"/>
	</c:if>
</head>

<body id="page-top">
    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-light sidebar sidebar-red accordion" id="accordionSidebar">
      
		<!-- style="background-color:#CDF0EA"  -->
            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="<%=contextPath %>/main.co">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-ambulance" style="color:red"></i>
                </div>
                <div class="sidebar-brand-text mx-3" style="color:red">건강 관리</div>
            </a>
            <hr class="sidebar-divider my-0">


            <!-- Heading -->
            <!-- Nav Item - Pages Collapse Menu -->
     		    <li class="nav-item">
                <a class="nav-link" href="<%=contextPath%>/nolist.bo">
                    <i class="fas fa-fw fa-chalkboard-teacher" style="color:red"></i>
                    <span style="color:red">공지사항</span></a>
            	</li>
            	<hr class="sidebar-divider my-0">
             	<li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseCommunity"
                    aria-expanded="true" aria-controls="collapsePages" style="color:red">
                    <i class="fas fa-fw fa-chalkboard" style="color:red"></i>
                    <span style="color:red">공유 게시판</span>
                </a>
                <div id="collapseCommunity" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">게시판</h6>
             			  	<a class="collapse-item" href="<%=contextPath%>/list.bo?category=posture">체형 게시판</a>
             			  	<a class="collapse-item" href="<%=contextPath%>/list.bo?category=diet">다이어트 게시판</a>
                    		<a class="collapse-item" href="<%=contextPath%>/list.bo?category=ms">대사증후군 게시판</a>
                    		<a class="collapse-item" href="<%=contextPath%>/list.bo?category=log">운동일지 게시판</a>
                    </div>
                </div>
                </li>
				<hr class="sidebar-divider my-0">
				<c:if test="${loginstatus != 2}">
            	<li class="nav-item">
                	<a class="nav-link" href="#" onclick="pologinCheck(${loginstatus});">
                    	<i class="fas fa-fw fa-child" style="color:red"></i>
	                    <span style="color:red">체형관리</span></a>
	            </li>
	            <li class="nav-item">
	                <a class="nav-link" href="#" onclick="healthloginCheck(${loginstatus});">
	                    <i class="fas fa-fw fa-diagnoses" style="color:red"></i>
	                    <span style="color:red">건강기록지</span></a>
	            </li>
	            <li class="nav-item">
	                <a class="nav-link" href="#" onclick="logloginCheck(${loginstatus});">
	                    <i class="fas fa-fw fa-dumbbell" style="color:red"></i>
	                    <span style="color:red">운동일지</span></a>
	            </li>
	            <li class="nav-item">
	                <a class="nav-link" href="#" onclick="dietloginCheck(${loginstatus});">
	                    <i class="fas fa-fw fa-drumstick-bite" style="color:red"></i>
	                    <span style="color:red">식단관리</span></a>
	            </li>
	            </c:if>
	            <c:if test="${loginstatus == 2}">
            	<li class="nav-item">
                	<a class="nav-link" href="<%=contextPath%>/adminlist.am?part=po">
                    	<i class="fas fa-fw fa-child" style="color:red"></i>
	                    <span style="color:red">체형관리</span></a>
	            </li>
	            <li class="nav-item">
	                <a class="nav-link" href="<%=contextPath%>/adminlist.am?part=health">
	                    <i class="fas fa-fw fa-diagnoses" style="color:red"></i>
	                    <span style="color:red">건강기록지</span></a>
	            </li>
	            <li class="nav-item">
	                <a class="nav-link" href="<%=contextPath%>/adminlist.am?part=log">
	                    <i class="fas fa-fw fa-dumbbell" style="color:red"></i>
	                    <span style="color:red">운동일지</span></a>
	            </li>
	            <li class="nav-item">
	                <a class="nav-link" href="<%=contextPath%>/adminlist.am?part=diet">
	                    <i class="fas fa-fw fa-drumstick-bite" style="color:red"></i>
	                    <span style="color:red">식단관리</span></a>
	            </li>
	            </c:if>
	            <li class="nav-item">
	                <a class="nav-link" href="<%=contextPath%>/holist.pl?gu=강서구">
	                    <i class="fas fa-fw fa-hospital-alt" style="color:red"></i>
	                    <span style="color:red">병원정보</span></a>
	            </li>
	            <li class="nav-item">
	                <a class="nav-link" href="<%=contextPath%>/fitlist.pl?gu=강서구">
	                    <i class="fas fa-fw fa-building" style="color:red"></i>
	                    <span style="color:red">헬스장 정보</span></a>
	            </li>
	            
	           

            <!-- Divider -->
            	<hr class="sidebar-divider d-none d-md-block">
				
				<li class="nav-item">
	                <a class="nav-link" >
	                <span class="btn btn-primary" style="color:white" onclick="chat('${sessionScope.loginfo.id}');">1:1 채팅 상담</span></a>
	            </li>

            <!-- Sidebar Toggler (Sidebar) -->
	            <div class="text-center d-none d-md-inline">
	                <button class="rounded-circle border-0" id="sidebarToggle"></button>
	            </div>

            <!-- Sidebar Message -->

        </ul>

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-white	 bg-black topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

                    <!-- Topbar Navbar -->
				<ul class="navbar-nav ml-auto">

					<!-- 로그인 아이콘 -->		
					 <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <c:if test="${loginstatus != 0}">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">${sessionScope.loginfo.id}(${sessionScope.loginfo.name})</span>
                                <c:if test="${sessionScope.loginfo.image != null}">
                                <img class="img-profile rounded-circle" src="./upload/${sessionScope.loginfo.image}">
                                </c:if>
                                <c:if test="${sessionScope.loginfo.image == null}">
                                <img class="img-profile rounded-circle" src="./upload/user.png">
                                </c:if>
                                 </c:if>
                                 <c:if test="${loginstatus == 0}">
                                 <img class="img-profile rounded-circle" src="./upload/user.png">
                                 </c:if>
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <c:if test="${loginstatus == 0}">
                                  <a class="dropdown-item" href="<%=contextPath %>/login.me">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Login
                                  </a>
                                </c:if>
                                <c:if test="${loginstatus != 0}">
                                   <a class="dropdown-item" href="<%=contextPath %>/totalhealth.vw?id=${sessionScope.loginfo.id}">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    MyTotalHealth
                                  </a>
	                                <a class="dropdown-item" href="<%=contextPath%>/detail.me?id=${sessionScope.loginfo.id}">
	                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
	                                    Profile
	                                </a>
                                  	<c:if test="${loginstatus == 2}">
	                                <div class="dropdown-divider"></div>
	                                 <a class="dropdown-item" href="<%=contextPath %>/members.vw">
                                   	 <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                  		회원 정보
                                 	 </a>
                                  	</c:if>
	                                <div class="dropdown-divider"></div>
	                                <a class="dropdown-item" href="<%=contextPath%>/logout.me">
	                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
	                                    Logout
	                                </a>
	                            </c:if>
                            </div>
                        </li>
                    </ul> 
                </nav>
    <!-- Bootstrap core JavaScript-->
    <script src="resources/bootstrap/vendor/jquery/jquery.min.js"></script>
    <script src="resources/bootstrap/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="resources/bootstrap/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="resources/bootstrap/js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="resources/bootstrap/vendor/chart.js/Chart.min.js"></script>

     <!-- Page level custom scripts -->
    <script src="resources/bootstrap/js/demo/chart-area-demo.js"></script>
    <script src="resources/bootstrap/js/demo/chart-pie-demo.js"></script>

</body>
</html>