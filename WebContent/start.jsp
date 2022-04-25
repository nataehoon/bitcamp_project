<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String contextPath = request.getContextPath() ;
	String mappingName = "/Kids" ;
	
	String YesForm = contextPath + mappingName ;
	String NoForm = contextPath + mappingName + "?command=" ;
%>
<!DOCTYPE html>
<html lang="en">
    <head>
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
   		<style>
			    html, body {width:100%;height:100%;margin:0;padding:0;} 
			    .map_wrap {position:relative;overflow:hidden;width:100%;height:350px;}
			    .radius_border{border:1px solid #919191;border-radius:5px;}     
			    #navtest .container tab-pane active{
			    	border-bottom: 6px outset red;
			  		border-style: outset;border-width: medium;}
			    }     
			       
			    </style>
	    </head>
  
    <body data-spy="scroll" data-target=".navbar" data-offset="50">

  
 		<!-- Navigation-->
		<nav class="navbar navbar-expand-sm navbar-dark fixed-top clear-fix d-flex justify-content-between" style="background:white; position:flex; justify-content:space-between;">  
			<div class="form-inline">
				<img alt="로고" src="./images/logo.png" width="50" height="50">
				&nbsp;
				<h6 style="margin-top: 0.3rem; margin-bottom: 0.5rem; font-weight: 700; line-height: 1.2;">아이하루 어린이집</h6>
			</div>
		</nav>
  
        <!-- Masthead-->
        <header class="masthead text-white text-center">
            <div class="overlay"></div>
            <div class="container">
                <div class="row">
                    <div class="col-xl-9 mx-auto"> <!-- 1차 범위 좁힘 -->
                   		<img alt="로고" src="./images/logo.png" width="100" height="100">
						 <h1 class="mb-5">아이하루 어린이집</h1>
                    </div>
                    	
                    	
                    <div class="col-md-10 col-lg-8 col-xl-7 mx-auto"> <!-- 하위 요소들 가운데 정렬. 2차 범위 좁힘 -->
                            <div class="row text-center" style="width:100%">
                                <div class="col-12 col-md-8 mb-2 mb-md-0 mx-auto" align="center" style="width:100%;float:none; margin:0 auto">
									
									<!-- 탭 만들기 보호자/직원용 -->
									<div class="container">
									  <!-- Nav pills -->
									  <ul class="nav nav-fill" role="tablist">
									    <li class="nav-item rounded-lg " style="width:25%; background:white; height:50px; padding:0.5rem; border: 1px solid #ffd700; background:#ffd700;">
									      <a class="navbar-toggler active mx-auto" data-toggle="pill" href="#home" style="color:white; font-weight:bolder; ">보호자</a>
									    </li>
									    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									    <li class="nav-item rounded-lg " style="width:25%; background:white; height:50px; padding:0.5rem; border: 1px solid #ffd700; background:#ffd700;">
									      <a class="navbar-toggler" data-toggle="pill" href="#menuemp" style="color:white;">직원</a>
									    </li>
									  </ul>
									
										 <!-- Tab panes -->
										 <div class="tab-content" id="navtest">
										    <!-- 홈 : 보호자 -->
										    
										    <div id="home" class="container tab-pane active"><br>
										    	<form action="<%=YesForm%>" method="post">
										    		<div>
												     	<h3>보호자 로그인</h3>
												    </div>
			       	
			       									<input type="hidden" name="command" value="paLogin">
				                                	<input class="form-control form-control-lg" type="text" id="pid" name="pid" placeholder="아이디를 입력하세요."/>
				                                	<br>
				                                	<input class="form-control form-control-lg" type="password" id="password" name="password" placeholder="비밀번호를 입력하세요." />
				                                	<br>
				                                	<button class="btn btn-block btn-lg btn-default" style="background:#ffd700;"type="submit">로그인</button>
				                                </form>	
			                                	<a style="color:#ffd700; "href="/kids/parents/paInsert.jsp">회원가입</a>
			                                	&nbsp;
				                                <a style="color:#ffd700;" class="text-white" onclick="window.open('./parents/paIdSearch.jsp','paidsearch','height=400, width=400, menubar=no, location=no, left=400, top=200');">아이디/</a>
				                                <a style="color:#ffd700;" class="text-white" onclick="window.open('./parents/paPaSearch.jsp','papasearch','height=400, width=400, menubar=no, location=no, left=400, top=200');">비밀번호 찾기</a>
				                                <br><span class="form-control-static err" style="color:#d61d4e;">${pErrmsg}</span>
										    </div>
										    
										    <!-- 직원 -->
										  
										    <div id="menuemp" class="container tab-pane fade"><br>
										    	<form action="<%=YesForm%>" method="post">
												    <div>
												    	<h3>직원 로그인</h3>
												    </div>
												     
												     <input type="hidden" name="command" value="empLogin">  	
				                                	<input class="form-control form-control-lg" type="text" id="id" name="id" placeholder="아이디를 입력하세요." value="${id}"/>
				                                	<br>
				                                	<input class="form-control form-control-lg" type="password" id="password" name="password" placeholder="비밀번호를 입력하세요." />
				                                	<br>
				                                	<button  style="background:#ffd700;" class="btn btn-block btn-lg btn-default" type="submit">로그인</button>
				                                </form>	
				                                
			                                	<a style="color:#ffd700;" href="<%=NoForm%>empInsert">회원가입</a>
			                                	&nbsp;
				                                <a class="text-white" onclick="window.open('./employees/empIdSearch.jsp','empidsearch','height=400, width=400, menubar=no, location=no, left=400, top=200');">아이디/</a>
				                                <a class="text-white" onclick="window.open('./employees/empPaSearch.jsp','emppasearch','height=400, width=400, menubar=no, location=no, left=400, top=200');">비밀번호 찾기</a>
				                                <br><span class="form-control-static err" >${errmsg}</span>
										    </div>
										    
										</div><!-- tab Pane 끝 -->
	                                </div><!-- 탭 만들기 container 끝 -->
                          	 </div>
                    	</div>
                	</div><!-- 하위요소들 가운데 정렬 끝 -->
                </div><!-- row 끝 -->
              </div><!-- header container 끝 -->
        </header>

        <section class="testimonials text-center bg-light">
            <div class="container">
                <h2 class="mb-1">행복이 모이는</h2>
                <h2 class="mb-5"><font color="#ffd700">아이하루 어린이집</font>에 오신것을 환영합니다</h2>
                
           		 <p class="font-weight-light mb-0">유아기는 자아가 형성되며 지적, 정서적, 사회적 등</p>
           		 <p class="font-weight-light mb-0">전인간적인 기초가 이루어지는 매우 중요한 시기입니다.</p>
           		 <br>
           		 <p class="font-weight-light mb-0">더욱이 세계화, 지식산업화 시대의 주역으로 살아갈 우리 어린아이들에게</p>
           		 <p class="font-weight-light mb-0">수준이 갖추어진 교육환경의 제공은 학부모, 교사를 비롯한 우리 어른들의 의무이며 책임입니다.</p>
           		 <br>
             	 <p class="font-weight-light mb-0">교사가 무엇을(what) 가르치려 하기 보다 아이들이 <span style="color:#d61d4e; font-weight:bold;">스스로 호기심을 갖고 문제를 인식(why)</span>하게 도와주며</p>
           		 <p class="font-weight-light mb-0"><span style="color:#d61d4e; font-weight:bold;">지혜롭고 창의롭게 해결하는 방법(how)</span>을 습득하는 아이들로 교육하고자 합니다.</p>
           		 <br>
           		 <br>
           		 <img alt="유치원메인" class="rounded-lg" src="<%=request.getContextPath()%>/bootstrap2/assets/img/kindergardenmain.jpg">
              		
             </div>
           </section>
           
         <section class="text-center bg-light">
            <div class="container">
                <h2 class="mb-5">유치원 시설 소개</h2>
                <div class="row">
                    <div class="col-lg-6">
                        <div class="testimonial-item mx-auto mb-5 mb-lg-0">
                            <img class="img-fluid mb-3 rounded" style="width:400px; height:300px;" src="<%=request.getContextPath()%>/bootstrap2/assets/img/kindergarden.jpg" alt="..." />
                            <h5>특별활동실(미술)</h5>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="testimonial-item mx-auto mb-5 mb-lg-0">
                            <img class="img-fluid mb-3 rounded" style="width:400px; height:300px;" src="<%=request.getContextPath()%>/bootstrap2/assets/img/kindergarden2.jpg" alt="..." />
                            <h5>식당</h5>
                        </div>
                    </div>
                </div>
                 <div class="row">
                    <div class="col-lg-6">
                        <div class="testimonial-item mx-auto mb-5 mb-lg-0">
                            <img class="img-fluid mb-3 rounded" style="width:400px; height:300px;" src="<%=request.getContextPath()%>/bootstrap2/assets/img/kindergarden1.jpg" alt="..." />
                            <h5>놀이방</h5>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="testimonial-item mx-auto mb-5 mb-lg-0">
                            <img class="img-fluid mb-3 rounded" style="width:400px; height:300px;" src="<%=request.getContextPath()%>/bootstrap2/assets/img/kindergarden10.jpg" alt="..." />
                            <h5>놀이방2</h5>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        
        <section class="testimonials text-center bg-light">
            <div class="container">
              		  <h2 class="mb-5">선생님 소개</h2>
              		 <div class="row">
                    <div class="col-lg-4">
                        <div class="testimonial-item mx-auto mb-5 mb-lg-0">
                            <img class="img-fluid rounded-circle mb-3" src="<%=request.getContextPath()%>/bootstrap2/assets/img/teacherqueen.jpg" alt="..." />
                            <h5>이사장님</h5>
                            <p class="font-weight-light mb-0">서울시 교육위원회 북부교육구청장상</p>
                            <p class="font-weight-light mb-0">아이하루 어린이집 설립, 원장역임</p>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="testimonial-item mx-auto mb-5 mb-lg-0">
                            <img class="img-fluid rounded-circle mb-3" src="<%=request.getContextPath()%>/bootstrap2/assets/img/teacherman.jpg" alt="..." />
                            <h5>원장님</h5>
                            <p class="font-weight-light mb-0">서울시 교육감 표창장 1992</p>
                            <p class="font-weight-light mb-0">대한민국 교육인적자원부 장관상 2005</p>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="testimonial-item mx-auto mb-5 mb-lg-0">
                            <img class="img-fluid rounded-circle mb-3" src="<%=request.getContextPath()%>/bootstrap2/assets/img/teacher4.jpg" alt="..." />
                            <h5>교사</h5>
                            <p class="font-weight-light mb-0">덕성여대 유아교육과 졸업</p>
                            <p class="font-weight-light mb-0">이화여대 교육대학원 유아교육과 석사</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        
        
        
        
        
           <!-- Testimonials--><!--
        <section class="testimonials text-center bg-light">
            <div class="container">
                <h2 class="mb-5">유치원 식구들을 소개합니다</h2>
                <div class="row">
                    <div class="col-lg-4">
                        <div class="testimonial-item mx-auto mb-5 mb-lg-0">
                            <img class="img-fluid rounded-circle mb-3" src="<%=request.getContextPath()%>/bootstrap2/assets/img/teacherqueen.jpg" alt="..." />
                            <h5>이사장님</h5>
                            <p class="font-weight-light mb-0">"This is fantastic! Thanks so much guys!"</p>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="testimonial-item mx-auto mb-5 mb-lg-0">
                            <img class="img-fluid rounded-circle mb-3" src="<%=request.getContextPath()%>/bootstrap2/assets/img/teacherman.jpg" alt="..." />
                            <h5>원장님</h5>
                            <p class="font-weight-light mb-0">"Bootstrap is amazing. I've been using it to create lots of super nice landing pages."</p>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="testimonial-item mx-auto mb-5 mb-lg-0">
                            <img class="img-fluid rounded-circle mb-3" src="<%=request.getContextPath()%>/bootstrap2/assets/img/teacher4.jpg" alt="..." />
                            <h5>원장님</h5>
                            <p class="font-weight-light mb-0">"Thanks so much for making these free resources available to us!"</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        -->  
        <!-- 
           <section class="features-icons bg-light text-center">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4">
                        <div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
                            <div class="features-icons-icon d-flex"><i class="icon-screen-desktop m-auto text-primary"></i></div>
                            <h3>Fully Responsive</h3>
                            <p class="lead mb-0">This theme will look great on any device, no matter the size!</p>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
                            <div class="features-icons-icon d-flex"><i class="icon-layers m-auto text-primary"></i></div>
                            <h3>Bootstrap 4 Ready</h3>
                            <p class="lead mb-0">Featuring the latest build of the new Bootstrap 4 framework!</p>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="features-icons-item mx-auto mb-0 mb-lg-3">
                            <div class="features-icons-icon d-flex"><i class="icon-check m-auto text-primary"></i></div>
                            <h3>Easy to Use</h3>
                            <p class="lead mb-0">Ready to use with your own content, or customize the source files!</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
  		 -->
        
        
        <!-- Image Showcases-->
        <section class="showcase">
            <div class="container-fluid p-0">
                <div class="row no-gutters">
                    <div class="col-lg-6 order-lg-2 text-white showcase-img" style="background-image: url('<%=request.getContextPath()%>/bootstrap2/assets/img/child.jpg')"></div>
                    <div class="col-lg-6 order-lg-1 my-auto showcase-text">
                        <h2>연령에 따라 발달에 적합한 프로그램 운영</h2>
                        <br>
                        <p class="lead mb-0">
                        따뜻한 마음으로 신체적 접촉을 많이 하는 기본 교사상을 바탕으로
                        아이의 자신감을 증진시킬 수 있는 다양한 프로그램을 계획되어 운영되며 
                        영아들에게 최적의 경험과 환경을 제공하기 위해 아이에게 일어나는 일상생활과 
                        환경변화, 흥미를 중심으로 연간보육을 운영합니다.</p>
                    </div>
                </div>
                <div class="row no-gutters">
                    <div class="col-lg-6 text-white showcase-img" style="background-image: url('<%=request.getContextPath()%>/bootstrap2/assets/img/kindergarden4.jpg')"></div>
                    <div class="col-lg-6 my-auto showcase-text">
                        <h2>사회관계 · 의사소통 중점 프로그램 운영</h2>
                        <br>
                        <p class="lead mb-0">아이들이 스스로 할 수 있게 하여 자신감을 향상시키고,
                         다양한 경험을 통해 새로운 사실을 배우게 합니다.</p>
                         <p class="lead mb-0">집단 규칙을 따르는 기본 생활 습관과 창의 · 인성 지도를 강조하는
                         지식 구성, 토의 협동 학습 프로그램을 운영합니다.</p>
                    </div>
                </div>
                <div class="row no-gutters">
                    <div class="col-lg-6 order-lg-2 text-white showcase-img" style="background-image: url('<%=request.getContextPath()%>/bootstrap2/assets/img/child2.jpg')"></div>
                    <div class="col-lg-6 order-lg-1 my-auto showcase-text">
                        <h2>예술경험 · 자연탐구 중점 프로그램 운영</h2>
                        <br>
                        <p class="lead mb-0">주변 환경에서 아름다움을 찾고 창의적으로 표현하며 감상할 줄 알며, 일상생활에 호기심을 갖고 스스로 탐구하는 경험을 주는 프로그램을 운영합니다.</p>
                        <p class="lead mb-0"></p>
                    </div>
                </div>
            </div>
        </section>
     
        <section class="testimonials text-center bg-light">
            <div class="container">
            	<h2 class="mb-3">오시는 길</h2>
            	<div class="offset-3">
	            	 <p class="font-weight-light mb-0 float-left"><font class="font-weight-bold" style="font-size:20px">주소 : </font> &nbsp;서울특별시 서초구 서초4동 강남대로 459&nbsp;&nbsp;&nbsp;&nbsp; </p> 
	           		 <p class="font-weight-light mb-3 float-left"><font class="font-weight-bold " style="font-size:20px">TEL : </font> &nbsp; 02-2298-2277</p>
           		  </div>
    			<div class="mx-auto col-lg-12" id="map" style="width:800px;height:600px;"></div>
		    </div>
        </section>
        <!-- Call to Action-->
        <section class="call-to-action text-white text-center">
            <div class="overlay"></div>
            <div class="container">
                <div class="row">
                    <div class="col-xl-9 mx-auto"><h2 class="mb-4">상담문의</h2></div>
                    <div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
                       	<form action="<%=YesForm %>" method="post">
                       		<input type="hidden" name="command" value="resInsert">
                        	<input class="form-control form-control-lg" name="name"type="text" placeholder="원아 이름을 입력하세요" />
                        	<br>
                        	<input class="form-control form-control-lg" type="text" name="hp" placeholder="휴대폰 번호를 입력하세요" />
                        	<br>
                        	<input class="form-control form-control-lg" type="date" name="resdate" placeholder="희망 상담일자를 입력하세요" />
                        	<br>
                        	<input class="form-control btn btn-default" type="submit" value="상담예약" style="background:#ffd700;"/>
                       	</form>
                    </div>
                </div>
            </div>
        </section>
        <!-- Footer-->
        <footer class="footer bg-light">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 h-100 text-center my-auto ">
                        <ul class="list-inline mb-2">
                            <li class="list-inline-item"><a class="text-warning" href="#!">개인정보처리방침</a></li>
                            <li class="list-inline-item">⋅</li>
                            <li class="list-inline-item"><a class="text-warning" href="#!">이메일 무단수집 거부</a></li>
                            <li class="list-inline-item">⋅</li>
                            <li class="list-inline-item"><a class="text-warning" href="#!">저작권 보호 정책</a></li>
                        </ul>
                        <p class="text-muted small mb-4 mb-lg-0">Copyright(c) 아이하루 어린이집. All Rights Reserved.</p>
                    </div>
                </div>
            </div>
        </footer>
 
         <!-- Bootstrap core JS-->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="<%=request.getContextPath()%>/bootstrap2/js/scripts.js"></script>
        <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6b95ec568d65d02e07d199c7f320337d"></script>
        <script>
            var container = document.getElementById('map');
            var options = {
               center: new kakao.maps.LatLng(37.50296156302804, 127.02428579999999),
               level: 3
            };
      
            var map = new kakao.maps.Map(container, options);
            
            // 마커가 표시될 위치입니다 
            var markerPosition  = new kakao.maps.LatLng(37.50296156302804, 127.02428579999999); 

            // 마커를 생성합니다
            var marker = new kakao.maps.Marker({
                position: markerPosition
            });

            // 마커가 지도 위에 표시되도록 설정합니다
            marker.setMap(map);

            var iwContent = '<div style="padding:5px;">아이하루 어린이집<br><a href="https://map.kakao.com/link/map/Hello World!,33.450701,126.570667" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/Hello World!,37.50296156302804, 127.02428579999999" style="color:blue" target="_blank">길찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
                iwPosition = new kakao.maps.LatLng(33.450701, 126.570667); //인포윈도우 표시 위치입니다

            // 인포윈도우를 생성합니다
            var infowindow = new kakao.maps.InfoWindow({
                position : iwPosition, 
                content : iwContent 
            });
              
            // 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
            infowindow.open(map, marker); 
		</script>
    </body>
</html>