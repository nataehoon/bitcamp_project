<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../common/common.jsp" %>
<%@page import="java.util.Calendar"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript">
		
		window.onload = function(){
			/* 필드 검색 상태 보존 */
			$('#year option').each(function(){
				if($(this).val() == '${year}'){
					$(this).attr('selected', 'selected') ;
				}			
			});
			
			$('#month option').each(function(){
				if($(this).val() == '${month}'){
					$(this).attr('selected', 'selected') ;
				}			
			});
			
			$('#order option').each(function(){
				if($(this).val() == '${order}'){
					$(this).attr('selected', 'selected') ;
				}			
			});
			
		} 
		
		function myformSubmit(){
			document.myform.submit();
		}
	</script>
</head>
<body>
<div class="container fluid">
	<div class="card shadow mb-4">
		<div class="card-header py-3">
           	<h5 class="m-0 font-weight-bold text-primary">상담 예약 목록</h5>
            <input type="button" onclick="location.href='./reservation/resInsert.jsp'" value="상담예약" class="btn btn-primary" style="float:right;">
        </div>
		<div class="card-body">
		  <form name="myform" action="<%=YesForm %>" method="post">
		  	<input type="hidden" name="command" value="resList">
			<div class="form-inline" id="box">
				<div class="form-inline">
					<select name="year" id="year" class="form-control" onchange="myformSubmit();">
						<%
						    Calendar cal = Calendar.getInstance();
						  
						    int year = cal.get(Calendar.YEAR);
						    int month = cal.get(Calendar.MONTH) + 1;
						    
						    for(int i = year - 5; i < year + 5; i++) { 
						        if(i == year) {
						            out.println("<option selected=\"selected\" value=\""+i+"\">" + i + "</option>");
						        } else {
						            out.println("<option value=\""+i+"\">" + i + "</option>");
						        }
						    }
						%>
					</select>
		
					<label for="year">년</label>  
					<select name="month" id="month" class="form-control" onchange="myformSubmit();">
						<%
						    for(int i = 1; i <= 12; i++) {
						        if(i == month) {
						            out.println("<option selected=\"selected\" value=\""+i+"\">" + i + "</option>");
						        } else {
						            out.println("<option value=\""+i+"\">" + i + "</option>");
						        }
						    }
						%>
					</select>
					<label for="month">월</label> 
					<select class="form-control" id="order" name="order" onchange="myformSubmit();">
						<option value="desc">최신일자 순
						<option value="asc">과거일자 순
					</select>
					</div>
					<div class="form-inline">
						${pageInfo.pagingStatus}
						<input type="text" class="form-control" name="keyword" id="keyword" placeholder="이름/휴대폰">
						<input type="submit" class="form-control" value="검색">
					</div>
				</div>
			</form>
			
			<br>
				 <table class="table table-hover">
				    <thead>
				      <tr align="center">
				      	<th>예약일자<th>
				        <th>이름</th>
				        <th>휴대폰</th>
				        <th>등록일자</th>
				        <th>  </th>
				        <th>  </th>
				      </tr>
				    </thead>
				    <tbody align="center">
				    	<c:forEach var="bean" items="${requestScope.lists }">
					      <tr>
					      	<td>${bean.res_date }</td>
					      	<td></td>
					      	<td>${bean.name }</td>
					      	<td>${bean.hp }</td>
					      	<td>${bean.reg_date}</td>
					      	<td>
					      		<button class="form-control" onclick="location.href='<%=NoForm%>resUpdate&rid=${bean.rid}'">일지작성</button>
					      	</td>
					      	<td>
					      		<button class="form-control" onclick="location.href='<%=NoForm%>resDelete&rid=${bean.rid}&${requestScope.parameters}'">예약취소</button>
					      	</td>
					      </tr>
					    </c:forEach>
				    </tbody>
				  </table>
			  <div style="width: 30%; float:none; margin:0 auto" >
			      <p style="width: 100%">${pageInfo.pagingHtml}</p>
			  </div>
		</div><!-- 카드 바디 -->
	</div><!-- 그림자 div -->
</div><!-- container div -->	
 
</body>
</html>