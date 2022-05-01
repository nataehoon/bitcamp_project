<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp" %>    
<!DOCTYPE html>
<html lang="en">
<head>
  <style>
  /* Make the image fully responsive */
  .carousel-inner img {
    width: 90%;
    height: 500px;
  }

  .cursor {
  	 cursor: pointer;
  }
  table{
  	width: 600px;
  }

  </style>
</head>
<body>
<div class="container col-sm-12">
	<div id="demo" class="carousel slide col-sm-12" data-ride="carousel" align="center">
	
	  <!-- Indicators -->
	  <ul class="carousel-indicators">
	    <li data-target="#demo" data-slide-to="0" class="active"></li>
	    <li data-target="#demo" data-slide-to="1"></li>
	    <li data-target="#demo" data-slide-to="2"></li>
	  </ul>
	  
	  <!-- The slideshow -->
	  <div class="carousel-inner">
	    <div class="carousel-item active">
	      <img src="resources/image/main1.png" alt="main1" width="300" height="100">
	    </div>
	    <div class="carousel-item">
	      <img src="resources/image/main2.png" alt="main2" width="300" height="100">
	    </div>
	    <div class="carousel-item">
	      <img src="resources/image/main3.png" alt="main3" width="300" height="100">
	    </div>
	  </div>
	  
	  <!-- Left and right controls -->
	  <a class="carousel-control-prev" href="#demo" data-slide="prev">
	    <span class="carousel-control-prev-icon"></span>
	  </a>
	  <a class="carousel-control-next" href="#demo" data-slide="next">
	    <span class="carousel-control-next-icon"></span>
	  </a>
	</div>
	<div class="row col-sm-12" style="margin-left:5%;">
		<div class="col-sm-6">
			<div class="table table-hover">
				<table>
					<tr>
						<td colspan="2"><span class="h5" style="color:red">공지사항</span>
						<span class="cursor"style="fload:left;font-size:8px;" onclick="location.href='<%=contextPath%>/nolist.bo'">+더보기</span></td>
					</tr>
					<tr style="font-weight: bold;">
						<td>제목</td>
						<td>작성일자</td>
					</tr>
					<c:forEach var="nbean" items="${requestScope.nlists}">
					<tr onclick="location.href='<%=contextPath%>/nodetail.bo?notino=${nbean.notino}'">
						<td>${nbean.title}</td>
						<td>${nbean.regdate}</td>
					</tr>
					</c:forEach>
				</table>
				
			</div>
		</div>
		<div class="col-sm-6">
			<div class="table table-hover">
				<table>
					<tr>
						<td colspan="2"><span class="h5" style="color:red">게시판 최신글</span>
						<span class="cursor"style="fload:left;font-size:8px;" onclick="location.href='<%=contextPath%>/list.bo?category=posture'">+더보기</span></td>
					</tr>
					<tr	style="font-weight: bold;">
						<td>구분</td>
						<td>제목</td>
						<td>작성자</td>
						<td>작성일자</td>
					</tr>
					<c:forEach var="bbean" items="${requestScope.blists}">
					<tr onclick="location.href='<%=contextPath%>/detail.bo?bono=${bbean.bono}'">
						<td>${bbean.category}</td>
						<td>${bbean.title}</td>
						<td>${bbean.nickname}</td>
						<td>${bbean.regdate}</td>
					</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</div>
</body>
</html>