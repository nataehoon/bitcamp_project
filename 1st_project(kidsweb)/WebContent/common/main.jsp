<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>   
<!DOCTYPE html>
<html lang="en">
<head>
	<script type="text/javascript">
		function alert1() {
			 window.open("<%=NoForm%>empmOn&tid=${sessionScope.loginfo.tid}&attendance=출석", "new", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=700, height=700, left=0, top=0" );		
		}
		function alert2() {
			 window.open("<%=NoForm%>empmOff&tid=${sessionScope.loginfo.tid}&attendance=퇴근", "new", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=700, height=700, left=0, top=0" );		
		}
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
                      <div class="text-xs font-weight-bold text-primary text-uppercase mb-1" >
                          <!--선생님  --></div>
                     	 <div class="h5 mb-0 font-weight-bold text-gray-800">
                     		 <div class="btn btn-primary btn-icon-split " onclick="alert1();">
                  				<span class="icon text-white-50">
		                 			 <i class="fas fa-flag"></i>
		               			</span>
              					<span class="text" >출근</span>
              				</div>
                  		<div class="my-2"></div>
                   			<div class="btn btn-warning btn-icon-split " onclick="alert2();">
		                      	<span class="icon text-white-50">
		                      		<i class="fas fa-flag"></i>
		                      	</span>
                       			<span class="text">퇴근</span>
                  			</div>
                        	</div>
                  		  </div>
                       	<div class="col-xl-6">
                  		     <div class="h5 mb-0 font-weight-bold text-gray-800 ">현재시간<br><%= sf.format(nowTime)%></div>
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
	                                <div class="h5 mb-0 font-weight-bold text-primary">
	                              		  귀가동의서 <br>확인하기</div>
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
                             <div class="card-body">
                                 <div class="row no-gutters align-items-center">
                                     <div class="col mr-2">
                                         <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                             </div>
		                                         <a href="<%=NoForm%>stmOn" class="btn btn-success btn-icon-split btn-lg">
		                                     		<span class="icon text-white-50">
		                                         <i class="fas fa-calendar"></i>
                                    			 	</span>
                                   			  	<span class="text">원생출석</span>
                               				</a>
                          			  </div>
                                 </div>
                             </div>
                         </div>
                     </div>
                     <div class="col-xl-6 col-md-6 mb-3">
                         <div class="card border-left-primary shadow h-100 py-2">
                             <div class="card-body" onclick="location.href='<%=NoForm%>meList';">
                                 <div class="row no-gutters align-items-center">
                                     <div class="col mr-2">
                                         <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                            </div>
                                         <div class="h5 mb-0 font-weight-bold text-primary">투약의뢰서 <br>확인하기</div>
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
                                         <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                             </div>
                                         <a class="btn btn-danger btn-icon-split btn-lg" onclick="location.href='<%=NoForm%>stInsert';">
                                     		<span class="icon text-white-50">
                                         <i class="fas fa-plus"></i>
                                    		 	</span>
                                     	<span class="text">원생등록</span>
                                 		</a>
                                 		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                 		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                 		<a href="<%=NoForm%>resList" class="btn btn-primary btn-icon-split btn-lg">
                                     		<span class="icon text-white-50">
                                         <i class="fas fa-plus"></i>
                                    		 	</span>
                                     	<span class="text">예약목록</span>
                                 		</a>
                                     </div>
                                 </div>
                             </div>
                         </div>
                     </div>
                      <div class="col-xl-6 col-md-6 mb-3">
                         <div class="card border-left-primary shadow h-100 py-2">
                             <div class="card-body" onclick="location.href='<%=NoForm%>timeInsert';">
                                 <div class="row no-gutters align-items-center">
                                     <div class="col mr-2">
                                         <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                            </div>
                                         <div class="h5 mb-0 font-weight-bold text-primary">시간표 <br>입력하기</div>
                                     </div>
                                     <div class="col-auto">
                                         <i class="far fa-plus-square fa-2x text-gray-300"></i>
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
                             <div class="h5 text-md font-weight-bold text-primary text-uppercase mb-1">
                                  Today Issue</div>
                                  <hr>
                                  	<h5 class="font-weight-bold text-primary">투약의뢰서</h5>
                               		<c:if test="${sessionScope.mbean.tid == sessionScope.loginfo.tid}">
                               		<div onclick="location.href='<%=NoForm%>meDetail&meno=${sessionScope.mbean.meno}'" style="cursor:pointer;">-${sessionScope.mbean.name}님 의 투약의뢰서</div><br>
                               		</c:if>
                               		<c:if test="${sessionScope.mbean.tid != sessionScope.loginfo.tid}">
                               			등록된 투약의뢰서가 없습니다.<br>
                               		</c:if>
                               		<br>
                               		<h5 class="font-weight-bold text-primary">귀가동의서</h5>
                               		<c:if test="${sessionScope.hbean.tid == sessionScope.loginfo.tid}">
                               		<div onclick="location.href='<%=NoForm%>hoDetail&hono=${sessionScope.hbean.hono}'" style="cursor:pointer;">-${sessionScope.hbean.name}님 의 귀가동의서</div><br>
                               		</c:if>
                               		<c:if test="${sessionScope.hbean.tid != sessionScope.loginfo.tid}">
                               			등록된 귀가동의서가 없습니다.<br>
                               		</c:if>
                               		<br>
                               		<h5 class="font-weight-bold text-primary">금일 상담 일정</h5>
                               		<c:forEach var="rbean" items="${sessionScope.rbean}">
                               		<c:if test="${rbean.res_date == sessionScope.today && rbean.status == '상담대기'}">
                               		<div onclick="location.href='<%=NoForm%>resUpdate&rid=${rbean.rid}'" style="cursor:pointer;margin-bottom:-25px;">-${rbean.name}님의 상담이 예정되어 있습니다.</div><br>
                               		</c:if>
                               		</c:forEach>
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