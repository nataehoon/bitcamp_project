<%@page import="kids.members.parents.model.ParentsMiniView"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!-- 05.11컨텐트 지움 176 줄-->
<!-- 로그인 상태 정보 -->
<c:set var="whologin" value="0" scope="session" /> 
<c:if test="${empty sessionScope.loginfo}">
	<c:set var="whologin" value="0" scope="session"/>
</c:if>
<c:if test="${not empty sessionScope.loginfo}">
	<c:if test="${sessionScope.loginfo.responsibilities == '원장'}">
		<c:set var="whologin" value="1" scope="session"/>
	</c:if>
	<c:if test="${sessionScope.loginfo.responsibilities == '직원'}">
		<c:set var="whologin" value="2" scope="session"/>
	</c:if>
	<c:if test="${sessionScope.loginfo.responsibilities == '보호자'}">
		<c:set var="whologin" value="3" scope="session"/>
	</c:if>
	<c:if test="${sessionScope.loginfo.responsibilities == '특별'}">
		<c:set var="whologin" value="4" scope="session"/>
	</c:if>
</c:if>

<%
	String contextPath = request.getContextPath() ;
	String mappingName = "/Kids" ;
	
	String YesForm = contextPath + mappingName ;
	String NoForm = contextPath + mappingName + "?command=" ;
	
	Date nowTime = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("a hh:mm");

%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Dashboard</title>

    <!-- Custom fonts for this template-->
    <link href="<%=request.getContextPath()%>/bootstrap/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <!-- <link href="./../bootstrap/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css"> -->
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="<%=request.getContextPath()%>/bootstrap/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
      
            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="<%=contextPath %>/common/main.jsp">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">아이하루<br>&nbsp;&nbsp;&nbsp;&nbsp;어린이집 </div>
            </a>
            <hr class="sidebar-divider my-0">


            <!-- Heading -->
            <div class="sidebar-heading">
                <!--Addons-->
            </div>
            <!-- Nav Item - Pages Collapse Menu -->
     		    <li class="nav-item">
                <a class="nav-link" href="<%=NoForm%>goList">
                    <i class="fas fa-fw fa-table"></i>
                    <span>공지사항</span></a>
            </li>
            <hr class="sidebar-divider my-0">
             <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseCommunity"
                    aria-expanded="true" aria-controls="collapsePages">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>커뮤니티</span>
                </a>
                <div id="collapseCommunity" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">소분류필요하면 쓰기</h6>
             			  	<a class="collapse-item" href="<%=NoForm%>sthwList">알림장</a>
             			  	<a class="collapse-item" href="<%=NoForm%>acList">특별활동 게시판</a>
             			  	<c:if test="${whologin != 0 || whologin != 3}">
                    		<a class="collapse-item" href="<%=NoForm%>empbList">
                    		직원 게시판</a>
                    		</c:if>
                    </div>
                </div>
				<hr class="sidebar-divider my-0">
              <li class="nav-item">
                <a class="nav-link" href="<%=NoForm%>dietList">
                    <i class="fas fa-fw fa-table"></i>
                    <span>식단표</span></a>
            </li>
            <hr class="sidebar-divider my-0">
            <li class="nav-item">
                <a class="nav-link" href="<%=NoForm%>timeList">
                    <i class="fas fa-fw fa-table"></i>
                    <span>시간표</span></a>
            </li>
            <hr class="sidebar-divider my-0">
             <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseManagement"
                    aria-expanded="true" aria-controls="collapsePages">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>관리</span>
                </a>
                <div id="collapseManagement" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Login Screens:</h6>
                        <a class="collapse-item" href="<%=NoForm%>meList">
                    		투약의뢰서</a>
                   		<a class="collapse-item" href="<%=NoForm%>hoList">
                   			귀가동의서</a>
                   		<c:if test="${whologin != 0 || whologin != 3}">
                    	<a class="collapse-item" href="<%=NoForm%>resList">
                    		상담예약확인</a>	
                    	<a class="collapse-item" href="<%=NoForm%>resAfterList">
                    		입소대기확인</a>	
                    	</c:if>
                    </div>
                </div>
            </li>
            
           

            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

            <!-- Sidebar Message -->

        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <!-- <div id="content"> -->

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

                    <!-- Topbar Search -->
                    <form
                        class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100">
                       	<div class="input-group-append">
                        	<!-- 테스트중 - 정희 -->
						</div>
						
                        	<!-- 테스트중 - 정희 -->
                        	
                        	
                     <!-- 
                        <div class="input-group">
                            <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
                                aria-label="Search" aria-describedby="basic-addon2">
                            <div class="input-group-append">
                                <button class="btn btn-primary" type="button">
                                    <i class="fas fa-search fa-sm"></i>
                                </button>
                            </div>
                        </div>
                      -->  
                    </form>

                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">

                        <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                        <li class="nav-item dropdown no-arrow d-sm-none">
                            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-search fa-fw"></i>
                            </a>
                            <!-- Dropdown - Messages -->
                            <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                                aria-labelledby="searchDropdown">
                                <form class="form-inline mr-auto w-100 navbar-search">
                                    <div class="input-group">
                                        <input type="text" class="form-control bg-light border-0 small"
                                            placeholder="Search for..." aria-label="Search"
                                            aria-describedby="basic-addon2">
                                        <div class="input-group-append">
                                            <button class="btn btn-primary" type="button">
                                                <i class="fas fa-search fa-sm"></i>
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </li>
                    <!-- 원장님전용 관리 -->
                    <c:if test="${whologin == 1}">
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                               <img class="img-profile rounded-circle"
                                    src="./upload/menu.jpg">
                            </a>
                             <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                  <a class="dropdown-item" href="<%=NoForm%>submit">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    가입 승인
                                 	 </a>
                                  <div class="dropdown-divider"></div>
                                  <a class="dropdown-item" href="<%=NoForm%>empList">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    직원 관리
                                	  </a>
                                    <a class="dropdown-item" href="<%=NoForm%>paList">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    보호자 관리
                                	  </a>  
                                  	<a class="dropdown-item" href="<%=NoForm%>stList">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    학생 관리
                                  	</a>
                                  	 <div class="dropdown-divider"></div>
                                  	<a class="dropdown-item" href="<%=NoForm%>myclList">
                                    <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                    학급 관리
                                  	</a>
                                  	<a class="dropdown-item" href="<%=NoForm%>suList">
                                    <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                    과목 관리
                                  	</a>
                                  	 <div class="dropdown-divider"></div>
                                  	 <a class="dropdown-item" href="<%=NoForm%>stfList">
                                    <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                    원비 관리
                                 	 </a>
                                   <a class="dropdown-item" href="<%=NoForm%>salList">
                                    <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                    매출
                                  	</a>
                             </div>
                             </c:if>
					<!-- 로그인 아이콘 -->		
					 <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <c:if test="${whologin != 0}">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">
                               		 ${sessionScope.loginfo.name} 님
                                </span>
                                </c:if>
                                <img class="img-profile rounded-circle"
                                    src="./upload/user.png">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <c:if test="${whologin == 0}">
                                  <a class="dropdown-item" href="<%=contextPath %>/start.jsp">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Login
                                  </a>
                                </c:if>
                                 <c:if test="${whologin != 0}">
                                <c:if test="${whologin != 0 && whologin == 2 || whologin == 1 || whologin == 4}">
                                <a class="dropdown-item" href="<%=NoForm%>empDetail&tid=${sessionScope.loginfo.tid}">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Profile
                                </a>
                                </c:if>
                                 <c:if test="${whologin != 0 && whologin == 3}">
                                <a class="dropdown-item" href="<%=NoForm%>paDetail&pid=${sessionScope.loginfo.pid}">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Profile
                                </a>
                                </c:if>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="<%=NoForm %>logout">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Logout
                                </a>
                                </c:if>
                            </div>
                        </li>

                    </ul> 
                </nav>
    <!-- Bootstrap core JavaScript-->
    <script src="<%=request.getContextPath()%>/bootstrap/vendor/jquery/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/bootstrap/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="<%=request.getContextPath()%>/bootstrap/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="<%=request.getContextPath()%>/bootstrap/js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="<%=request.getContextPath()%>/bootstrap/vendor/chart.js/Chart.min.js"></script>

     <!-- Page level custom scripts -->
    <script src="<%=request.getContextPath()%>/bootstrap/js/demo/chart-area-demo.js"></script>
    <script src="<%=request.getContextPath()%>/bootstrap/js/demo/chart-pie-demo.js"></script>

</body>
</html>