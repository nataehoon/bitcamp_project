<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../common/common.jsp" %>
<%@page import="java.util.Calendar"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
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
	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container fluid">
	<div class="card shadow mb-4">
		<div class="card-header py-3">
            <h5 class="m-0 font-weight-bold text-primary">입소 대기 확인</h5>
        </div>
		<div class="card-body">
			<form action="<%=YesForm %>" method="post" name="myform">
			  	<input type="hidden" name="command" value="resAfterList">
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
					&nbsp;
					 ${pageInfo.pagingStatus}
						<input type="text" class="form-control" name="keyword" id="keyword" placeholder="이름/휴대폰">
						<input type="submit" class="form-control" value="검색">
				</div>
			</form>
			<br>
		
				  <div id="accordion">
				  	<c:forEach var="bean" items="${requestScope.lists }">
				    	<div class="card">
				      
					      <div class="card-header">
					        <a class="collapsed card-link" data-toggle="collapse" data-target="#b${bean.rid }">
					          상담일자 : ${bean.res_date}/ 아이이름: ${bean.name }
					        </a>
					      </div>
					      
					      <div id="b${bean.rid }" class="collapse" data-parent="#accordion">
					        <div class="card-body">
					        	<table class="table">
					        		<tr>
					        			<td width="20%">휴대폰 번호</td>
					        			<td width="20%">${bean.hp }</td>
					        			<td width="60%"></td>
					        		</tr>
					        		<tr>
					        			<td width="20%">상담 선생님</td>
					        			<td width="20%">${bean.tname}(${bean.tid})</td>
					        			<td width="60%"></td>
					        		</tr>
					        		<tr>
					        			<td colspan="3">상담 내용</td>
					        		</tr>
					        		<tr>
					        			<td colspan="3">
					        				${bean.textarea}
					        			</td>
					        		</tr>
					        		<tr align="center">
					        			<td colspan="3">
					        				<input class="btn btn-primary" type="button" value="원생등록" onclick="location.href='<%=NoForm%>stInsert&rid=${bean.rid }'">
					        				<input class="btn btn-primary" type="button" value="내용수정" onclick="location.href='<%=NoForm%>resUpdate&rid=${bean.rid}'">
					        				<input class="btn btn-primary" type="button" value="등록 취소" onclick="location.href='<%=NoForm%>resDelete&rid=${bean.rid}&page=after&${requestScope.parameters}'">
					        			</td>
					        		</tr>
					        	</table>
					         </div>
					       </div>
					       
				    	</div>
				   </c:forEach>
				</div>	<!-- 리스트 데이터 끝 -->
			</div><!-- 전체 card body 끝 -->
			<br>
			<br>	
		<div style="width: 30%; float:none; margin:0 auto" >
      		<p style="width: 100%">${pageInfo.pagingHtml}</p>
  		</div>
  </div><!-- 카드 그림자 끝 -->
</div><!-- 카드 컨테이너 끝 -->

</body>
</html>