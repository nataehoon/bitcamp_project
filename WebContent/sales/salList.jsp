<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="./../common/common.jsp"%>
<%
	int offset = 1; //오프 셋 
	int content = 12 - 2 * offset; //12 - 2 * 오프셋
%>
<html>
<head>
</head>
<body>
	       <!-- 로그인 상태 정보 -->

	<div class="container col-md-offset-<%=offset%> col-md-<%=content%>">
	<div class="card shadow mb-4">
		<div class="card-header py-3">
               <h4 class="m-0 font-weight-bold text-primary">아이하루 어린이집 매출 내역</h4>
        </div>
        <div class="card-body">
		<p>아이하루 어린이집 &nbsp; <strong>5월</strong>&nbsp;매출 내역입니다.
		</p>
		<hr>

		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4 class="panel-title">5월</h4>
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-condensed">
						<thead>
							<tr>
								<th class="text-center">입금날짜</th>
								<th class="text-center">반</th>								
								<th class="text-center">이름</th>
								<th class="text-center">수입</th>
								<th class="text-center">환불</th>
								<th class="text-center">비고</th>
							</tr>
						</thead>
						<tbody>
							<c:set var="totalAmount" value="0"/>
							<c:forEach var="salesinfo" items="${requestScope.lists}">
								<tr>
									<td class="text-center">${salesinfo.inputdate}</td>
									<td class="text-center">${salesinfo.class_name}</td>
									<td class="text-center">${salesinfo.name}</td>
									<td class="text-center">
										<fmt:formatNumber value="${salesinfo.sales}" pattern="###,###"/> 원
									</td>
									<td class="text-center">
										<fmt:formatNumber value="${salesinfo.returns}" pattern="###,###"/> 원
									</td>
									<td class="text-center">
										<c:set var="amount" value="${salesinfo.sales}"/>
										<c:set var="totalAmount" value="${totalAmount + amount}"/>
										${salesinfo.remark}
										<%-- <fmt:formatNumber value="${amount}" pattern="###,###"/> 원 --%>
									</td>
								</tr>
							</c:forEach>
							<tr>
								<td class="thick-line"></td>
								<td class="thick-line"></td>
								<td class="thick-line"></td>
								<td class="thick-line"></td>
								<td class="thick-line text-center">
									<strong>합계</strong>
								</td>
								<td class="thick-line text-right">
									<fmt:formatNumber value="${totalAmount}" pattern="###,###"/> 원
								</td>
							</tr>
						</tbody>
					</table>
					<%-- <div align="center">
						<footer>${pageInfo.pagingHtml}</footer>
					</div> --%>
				</div>
			</div>
		</div>

		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">현황</h3>
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-bordered">
						<tbody>
							<tr>
								<td class="text-center gr">원래 받아야 하는 돈</td>
								<td>${salesinfo.inputdate}</td>
							</tr>
							<tr>
								<td class="text-center gr">받은 돈</td>
								<td>${salesinfo.inputdate}</td>
							</tr>
							<tr>
								<td class="text-center gr">합계</td>
								<td>
									<fmt:formatNumber value="${finalAmount}" pattern="###,###"/> 원
								</td>
								
						</tbody>
					</table>
				</div>
			</div>
			</div>
			</div>
		</div>
<!--  
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">배송 정보</h3>
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-bordered">
						<tbody>
							<tr>
								<td class="text-center gr"><strong>받으시는 분</strong></td>
								<td>${sessionScope.loginfo.name}(${sessionScope.loginfo.id})님</td>
							</tr>	
							<tr>
								<td class="text-center gr"><strong>우편 번호</strong></td>
								<td>${sessionScope.loginfo.zipcode}</td>
							</tr>	
							<tr>
								<td class="text-center gr"><strong>주소</strong></td>
								<td>
									${sessionScope.loginfo.address1}
									&nbsp;
									${sessionScope.loginfo.address2}
								</td>
							</tr>	
							<tr>
								<td class="text-center gr"><strong>적립 포인트</strong></td>
								<td>
									<fmt:formatNumber value="${sessionScope.loginfo.mpoint}" pattern="###,###"/>
								</td>
							</tr>	
							<tr>
								<td class="text-center gr"><strong>배송 방법</strong></td>
								<td>택배</td>
							</tr>							
						</tbody>
					</table>
				</div>
			</div>
		</div> // 배송 정보 끝
		-->
	</div>
</body>
</html>