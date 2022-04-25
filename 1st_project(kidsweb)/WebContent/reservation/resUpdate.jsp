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
		function cccheck(){
			var tid = document.myform.tid.value;
			if(tid == "-"){
				alert('상담 진행자를 선택하세요');
				return false;
			}
		}
		
		window.onload = function(){
			/* 필드 검색 상태 보존 */
			$('#tid option').each(function(){
				if($(this).val() == '${bean.tid}'){
					$(this).attr('selected', 'selected') ;
				}			
			});
		} 
		
	</script>
</head>
<body>
<div class="container fluid">
	<div class="card shadow mb-4">
		<div class="card-header py-3">
            <h5 class="m-0 font-weight-bold text-primary">상담 일지</h5>
        </div>
		<div class="card-body">
			<form action="<%=YesForm %>" method="post" name="myform">
				<input type="hidden" name="command" value="resUpdate">
				<input type="hidden" name="rid" value="${bean.rid}">
				<input type="hidden" name="regdate" value="${bean.reg_date }">
				<table class="table table-bordered">
		         <tr>
		            <td width="10%" style="vertical-align:middle;" align="center">원생이름</td>
		   			<td width="40%">
		   				<input type="text" name="name" class="form-control" value="${bean.name }">
		   			</td>
		   		</tr>
		   		 <tr>
		   			<td width="10%" style="vertical-align:middle;" align="center">휴대폰번호</td>
		   			<td width="40%">
		   				<div class="form-inline">
	    					<input type="text" name="hp" class="form-control" value="${bean.hp }">
    					</div>
		   			</td>
		   		</tr>
		   		 <tr>
		   			<td width="10%" style="vertical-align:middle;" align="center">상담예약일자</td>
		   			<td width="40%">
		  					<input type="date" name="date" class="form-control" value="${bean.res_date }">
		   			</td>
		   		</tr>
		   		<tr>
		   			<td width="10%" style="vertical-align:middle;" align="center">상담 진행자</td>
		   			<td width="40%">
		   				<select name="tid" id="tid" class="form-control" required="required">
		   					<option value="-">-선택하세요
			   				<c:forEach var="item" items="${requestScope.elists}">
			  					<option value="${item.tid}">${item.name}&nbsp;(${item.responsibilities })
			  				</c:forEach>
		  				</select>
		   			</td>
		   		</tr>
		   		 <tr>
		   			<td width="10%" style="vertical-align:middle;" align="center">상담 내용</td>
		   			<td width="40%">
		   				<textarea style="resize: none;" class="form-control" name="textarea" cols="100%" rows="10" id="textarea" >${bean.textarea }</textarea>
		   			</td>
		   		</tr>
		   		<tr>
		   			<td colspan="2">
		   				<input type="submit" class="form-control btn btn-primary" onclick="return cccheck();" value="상담 일지 등록">
		   			</td>
		   			
		   		</tr>
		   	</table>
		   </form>
		</div><!-- card body 끝 -->
	</div><!-- card 그림자 끝 -->
</div><!-- container 끝 -->
</body>
</html>