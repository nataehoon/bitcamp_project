<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html>
<title>카드형 운동일지</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<c:set var="i" value="0"/>
<c:set var="j" value="4"/>
<c:set var="day" value="${today}"/>
<body>
<div class="form-group" align="center">
	 <h2 class="font-weight-bold text-danger">식단</h2>
	 	<c:if test="${sessionScope.loginfo.id == id}">
		<span style="float:right;margin-right:20%">
			<a href="<%=contextPath%>/insert.di?id=${sessionScope.loginfo.id}" class="btn btn-info" type="buttoen">식단 등록&nbsp;</a>
		</span>
		</c:if>
		</div>
		<br><br>
	  <div class="form-group w3-center" style="background-color:white">
	  <br>
	  <table>
	  	<c:forEach var="bean" items="${requestScope.lists}">
	  	<c:if test="${i%j == 0}"> 
	  		<tr> 
	  	</c:if> 
		  	<td>
		  	<a href="<%=contextPath%>/detail.di?dietno=${bean.dietno}">
		  		<div align="center" class="w3-card-4" style="margin-right:10px;margin-left:25px;width:380px;height:400px">
				    <img src="./upload/${bean.image}" alt="food" style="width:100%;height:200px">
				    <div class="w3-container w3-center">
				    <p style="float:left;padding-top:5px;margin-bottom:5px">${bean.regdate}</p><br>
				      <textarea class="form-control" readonly="readonly" style="float:left;width:100%;height:130px">${bean.dietlist}</textarea>
				    </div>
				  </div>
				</a>
			 <hr>
		  	</td> 
	  	<c:if test="${i%j == j-1 }"> 
	  		</tr> 
	  	</c:if> <c:set var="i" value="${i+1 }" /> 
	  	</c:forEach>
  </table>
</div>
</body>
</html>