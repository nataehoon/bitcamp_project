<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>   
<!DOCTYPE html>
<html lang="en">
<head>
  	<meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>아이하루 어린이집</title>
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.15.3/js/all.js"></script>
        <!-- Simple line icons-->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.5.5/css/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
       
        <!-- w3school 예제에서 가져옴 -->
       	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script type="text/javascript">
	
	</script>
		       <!-- 로그인 상태 정보 -->
<c:set var="whologin" value="0" /> 
<c:if test="${empty sessionScope.loginfo}">
	<c:set var="whologin" value="0" />
</c:if>
<c:if test="${not empty sessionScope.loginfo}">
	<c:if test="${sessionScope.loginfo.responsibilities == '원장'}">
		<c:set var="whologin" value="1" />
	</c:if>
	<c:if test="${sessionScope.loginfo.responsibilities == '직원'}">
		<c:set var="whologin" value="2" />
	</c:if>
	<c:if test="${sessionScope.loginfo.responsibilities != '원장'}">
		<c:if test="${sessionScope.loginfo.responsibilities != '직원'}">
			<c:set var="whologin" value="3" />
		</c:if>
	</c:if>
</c:if>
</head>
<body>
  <!-- Begin Page Content -->
  <div class="container-fluid">
   <!-- 메인 네가지 박스 -->
	<div class="row">
	<div class="col-xl-8 col-md-6 mb-3">
	<div class="row">
	<div class="col-xl-6 col-md-6 mb-3">
      <div class="card border-left-primary shadow h-100 py-2 px-2">
          <div class="card-body">
              <div class="row no-gutters align-items-center">
                  <div class="col mr-2">
                  	<div class="h5 mb-0 font-weight-bold text-primary ">내아이<br>상세보기
                  	</div>
                  </div>
                  	<div class="col-auto">
                    	<i class="far fa-smile fa-2x text-gray-300"></i> <!-- fa-2x --> 
                    </div>	     
                      </div>
               		</div>
                  </div>
               </div>
                 <div class="col-xl-6 col-md-6 mb-3">
                    <div class="card border-left-primary shadow h-100 py-2">
                       <div class="card-body" onclick="location.href='<%=NoForm%>hoCheck';">
                          <div class="row no-gutters align-items-center">
                              <div class="col mr-2" >
                                 <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                 </div>
	                                <div class="h5 mb-0 font-weight-bold text-gray-800">
	                              		  현재시간 <br><%= sf.format(nowTime)%></div>
                                   	 </div>
                                     <div class="col-auto">
                                         <i class="fas fa-home fa-2x text-gray-300"></i>
                                     </div>
                                 </div>
                             </div>
                         </div>
                     </div>
                  </div>
                   <div class="row">
                     <div class="col-xl-6 col-md-6 mb-3">
                         <div class="card border-left-primary shadow h-100 py-2">
                             <div class="card-body onclick="location.href='<%=NoForm%>hoInsert';">
                                 <div class="row no-gutters align-items-center">
                                     <div class="col mr-2">
                                     	<div class="h5 mb-0 font-weight-bold text-primary">귀가동의서 <br>작성하기</div>
                                   	 </div>
                              			 <div class="col-auto">
                                         <i class="fas fa-calendar fa-2x text-gray-300"></i>
                                     </div>
                                 </div>
                             </div>
                         </div>
                     </div>
                     <div class="col-xl-6 col-md-6 mb-3">
                         <div class="card border-left-primary shadow h-100 py-2">
                             <div class="card-body" onclick="location.href='<%=NoForm%>meInsert';">
                                 <div class="row no-gutters align-items-center">
                                     <div class="col mr-2">
                                         <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                            </div>
                                         <div class="h5 mb-0 font-weight-bold text-primary">투약의뢰서 <br>작성하기</div>
                                     </div>
                                     <div class="col-auto">
                                         <i class="far fa-plus-square fa-2x text-gray-300"></i>
                                     </div>
                                 </div>
                             </div>
                         </div>
                     </div>
                     <div class="col-xl-6 col-md-6 mb-3">
                         <div class="card border-left-primary shadow h-100 py-2">
                             <div class="card-body">
                                 <div class="row no-gutters align-items-center">
                                     <div class="col mr-2">
                                        <div class="h5 mb-0 font-weight-bold text-primary">
                                        <c:if test="${sessionScope.loginfo.responsibilities == '보호자'}">
                        				${sessionScope.loginfo.stname}(${sessionScope.loginfo.classname}) ${sessionScope.loginfo.relationship }
							 			<div class="dropdown">
                                        <button type="button" class="btn btn-warning dropdown-toggle mb-0" data-toggle="dropdown" style="">
							    		아이 선택
							  			</button>
							  			<div class="dropdown-menu">
							  			<c:forEach var="item" items="${sessionScope.plists}">
							    		<a class="dropdown-item" href="<%=NoForm%>changePloginfo&sid=${item.sid}&pid=${item.pid}">${item.stname}</a>
							    		</c:forEach>	
							 			</div>
                                        </div>
                                        </c:if>
										</div>
                                     </div>
                                     <div class="col-auto">
                                         <i class="far fa-smile fa-2x text-gray-300"></i>
                                     </div>
                                 </div>
                             </div>
                         </div>
                     </div>
                   </div>
                </div>
                  <div class="col-xl-4 col-md-6 mb-3">
				  <div class="card border-left-primary shadow h-100 py-2">
                  <div class="card-body">
                         <div class="row no-gutters align-items-center">
                           <div class="col mr-2">
                           <div class="container">
                           <ul class="nav nav-fill" role="tablist">
						  <li class="nav-item rounded-lg">
						  <a class="navbar-toggler btn btn-light btn-icon-split btn-sm active mx-auto" data-toggle="pill" href="#nobean" >
						  <span class="text-md font-weight-bold text-primary">공지사항</span></a></li>
						  
					   	  <li class="nav-item rounded-lg ">
					   	  <a class="navbar-toggler btn btn-light btn-icon-split btn-sm" data-toggle="pill" href="#notice" >
						  <span class="text-md font-weight-bold text-primary">알림장</span></a></li>
						  
					      <li>
					      <a class="navbar-toggler btn btn-light btn-icon-split btn-sm" data-toggle="pill" href="#noactive">
						  <span class="text-md font-weight-bold text-primary">특별활동</span></a></li>
						  </ul>
						  <div class="text-md font-weight-bold text-primary text-uppercase mb-1">
                                  Today Issue</div>
						  <div class="h6  font-weight-bold text-gray-800">
						  <div class="tab-content"><!-- tab -->
				
                               <div id="nobean" class="container tab-pane active">
								<c:forEach var="bean" items="${sessionScope.nobean}">
								<div onclick="location.href='<%=NoForm%>goDetail&notino=${bean.notino}'" style="cursor:pointer;">
									<fmt:parseDate value="${bean.regdate}" pattern ="yyyy-MM-dd" var="date"> </fmt:parseDate>
									<fmt:formatDate value="${date}" pattern="yyyy년 MM월 dd일"></fmt:formatDate>
									${bean.class_name}<br>
									${bean.title}<br>
									${bean.content}<br>
								</div>
								</c:forEach>
                               </div>
                               <div id="notice" class="container tab-pane fade">
                               <c:forEach var="bean" items="${sessionScope.notice}">
									<fmt:parseDate value="${bean.regdate}" pattern ="yyyy-MM-dd" var="date"> </fmt:parseDate>
									<fmt:formatDate value="${date}" pattern="yyyy년 MM월 dd일"></fmt:formatDate>
									${bean.class_name}<br>
									${bean.title}<br>
									${bean.content}<br>
								</c:forEach>
                               </div>
                               <div id="noactive" class="container tab-pane fade">
                               <c:forEach var="bean" items="${requestScope.noactive}">
									<fmt:parseDate value="${bean.regdate}" pattern ="yyyy-MM-dd" var="date"> </fmt:parseDate>
									<fmt:formatDate value="${date}" pattern="yyyy년 MM월 dd일"></fmt:formatDate>
									${bean.title}
									${bean.content}
							   </c:forEach>
                               </div>
                               </div><!-- tab-->
                               </div><!--container 끝  -->
                               </div>
                             </div>
                               <div class="col-auto">
                                  <i class="fas fa-calendar fa-2x text-gray-300"></i>
                               </div>
                           </div>
                        </div>
                      </div>
                  </div>     
  			  </div>
  			  </div>
 
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


<%@ include file="./../common/footer.jsp" %>

</body>
</html>