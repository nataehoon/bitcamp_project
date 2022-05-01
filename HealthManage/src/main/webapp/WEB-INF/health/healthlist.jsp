<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set var="perfat" value="${fat-weight}"/>
<script type="text/javascript">
	function healthdelete(healthno, id){
		if(confirm('정말로 삭제 하시겠습니까?')){
			alert('건강 기록이 삭제 되었습니다.')
			location.href='<%=contextPath%>/hedelete.he?healthno=' + healthno + '&id=' + id;
		}
}
</script>
</head>
<body>
<div class="container col-sm-12">
	<div class="card card-danger">
		<div class="card-heading" align="center">
		 <br><br><h2 class="font-weight-bold text-danger">건강 기록</h2>
			<c:if test="${sessionScope.loginfo.id == id}">
			<span style="float:right;margin-right:10%">
				<a href="<%=contextPath%>/insert.he?id=${sessionScope.loginfo.id}" class="btn btn-info" type="buttoen">건강기록 등록&nbsp;</a>
			</span>
			</c:if>
		</div>
		<div class="row card-body col-offset-2">
			<c:if test="${bean1.healthno != null}">
			<c:if test="${bean2.healthno != null}">
			<div class="col-sm-4" style="float:left;margin-left:0%">
				<span class="" style="float:right;margin-right:20%">등록 날짜 : ${bean2.regdate}</span>
				<table class="table table-bordered">
					<tr>
						<td>
							<span style="color:black;border:thick;margin-left:5%">신장(키)</span>
							<span style="float:right;margin-right:20%">${bean2.height}cm</span>
						</td>
					</tr>
					<tr>
						<td>
							<span style="color:black;border:thick;margin-left:5%">몸무게</span>
							<span style="float:right;margin-right:20%">${bean2.weight}kg</span>
						</td>
					</tr>
					<tr>
						<td>
							<span style="color:black;border:thick;margin-left:5%">지방량</span>
							<span style="float:right;margin-right:20%">${bean2.fat}kg</span>
						</td>
					</tr>
					<tr>
						<td>
							<span style="color:black;border:thick;margin-left:5%">근육량</span>
							<span style="float:right;margin-right:20%">${bean2.muscle}kg</span>
						</td>
					</tr>
					<tr>
						<td>
							<span style="color:black;border:thick;margin-left:5%">체지방률</span>
							<span style="float:right;margin-right:20%">${perfat2}%</span>
						</td>
					</tr>
					<tr>
						<td>
							<span style="color:black;border:thick;margin-left:5%">HDL</span>
							<span style="float:right;margin-right:20%">${bean2.hdl}mg/dl</span>
						</td>
					</tr>
					<tr>
						<td>
							<span style="color:black;border:thick;margin-left:5%">LDL</span>
							<span style="float:right;margin-right:20%">${bean2.ldl}mg/dl</span>
						</td>
					</tr>
					<tr>
						<td>
							<span style="color:black;border:thick;margin-left:5%">총 콜레스테롤</span>
							<span style="float:right;margin-right:20%">${bean2.totalco}mg/dl</span>
						</td>
					</tr>
					<tr>
						<td>
							<span style="color:black;border:thick;margin-left:5%">AST</span>
							<span style="float:right;margin-right:20%">${bean2.ast}IU/L</span>
						</td>
					</tr>
					<tr>
						<td>
							<span style="color:black;border:thick;margin-left:5%">ALT</span>
							<span style="float:right;margin-right:20%">${bean2.alt}IU/L</span>
						</td>
					</tr>
					<tr>
						<td>
							<span style="color:black;border:thick;margin-left:5%">GGT</span>
							<span style="float:right;margin-right:20%">${bean2.ggt}IU/L</span>
						</td>
					</tr>
					<tr>
						<td>
							<span style="color:black;border:thick;margin-left:5%">BUN</span>
							<span style="float:right;margin-right:20%">${bean2.bun}mg/dl</span>
						</td>
					</tr>
					<tr>
						<td>
							<span style="color:black;border:thick;margin-left:5%">CREATININE</span>
							<span style="float:right;margin-right:20%">${bean2.creatin}mg/dl</span>
						</td>
					</tr>
					<tr>
						<td>
							<span style="color:black;border:thick;margin-left:5%">Glucose Fasting</span>
							<span style="float:right;margin-right:20%">${bean2.fbs}mg/dl</span>
						</td>
					</tr>
					<tr>
						<td>
							<span style="color:black;border:thick;margin-left:5%">수축기 혈압</span>
							<span style="float:right;margin-right:20%">${bean2.systolic}mmHg</span>
						</td>
					</tr>
					<tr>
						<td>
							<span style="color:black;border:thick;margin-left:5%">이완기 혈압</span>
							<span style="float:right;margin-right:20%">${bean2.diastolic}mmHg</span>
						</td>
					</tr>
				</table>
			</div>
			</c:if>
			<div class="col-sm-4" style="margin-left:0%">
				<span class="" style="float:right;margin-right:20%">등록 날짜 : ${bean1.regdate}</span>
				<table class="table table-bordered">
					<tr>
						<td width="75%">
							<span style="color:black;border:thick;margin-left:5%;border:thick;margin-left:5%">신장(키)</span>
							<span style="float:right;margin-right:14%">${bean1.height}cm</span>
						</td>
						<td width="25%">
						</td>
					</tr>
					<tr>
						<td width="75%">
							<span style="color:black;border:thick;margin-left:5%">몸무게</span>
							<span style="float:right;margin-right:14%">${bean1.weight}kg</span>
						</td>
						<td width="25%">
						</td>
					</tr>
					<tr>
						<td width="75%">
							<span style="color:black;border:thick;margin-left:5%">지방량</span>
							<span style="float:right;margin-right:14%">${bean1.fat}kg</span>
						</td>
						<td width="25%">
						</td>
					</tr>
					<tr>
						<td width="75%">
							<span style="color:black;border:thick;margin-left:5%">근육량</span>
							<span style="float:right;margin-right:14%">${bean1.muscle}kg</span>
						</td>
						<td width="25%">
						</td>
					</tr>
					<tr>
						<td width="75%">
							<span style="color:black;border:thick;margin-left:5%">체지방률</span>
							<span style="float:right;margin-right:14%">${perfat1}%</span>
						</td>
						<td width="25%">
							<c:if test="${bean1.totalco < 201}">
							<span style="float:right;color:blue">정상</span>
							</c:if>
							<c:if test="${bean1.totalco > 200}">
							<span style="float:right;color:red">위험</span>
							</c:if>
						</td>
					</tr>
					<tr>
						<td width="75%">
							<span style="color:black;border:thick;margin-left:5%">HDL</span>
							<span style="float:right;margin-right:14%">${bean1.hdl}mg/dl</span>
						</td>
						<td width="25%">
							<c:if test="${bean1.hdl > 39}">
							<span style="float:right;color:blue">정상</span>
							</c:if>
							<c:if test="${bean1.hdl < 40}">
							<span style="float:right;color:red">위험</span>
							</c:if>
						</td>
					</tr>
					<tr>
						<td width="75%">
							<span style="color:black;border:thick;margin-left:5%">LDL</span>
							<span style="float:right;margin-right:14%">${bean1.ldl}mg/dl</span>
						</td>
						<td width="25%">
							<c:if test="${bean1.ldl < 141}">
							<span style="float:right;color:blue">정상</span>
							</c:if>
							<c:if test="${bean1.ldl > 140}">
							<span style="float:right;color:red">위험</span>
							</c:if>
						</td>
					</tr>
					<tr>
						<td width="75%">
							<span style="color:black;border:thick;margin-left:5%">총 콜레스테롤</span>
							<span style="float:right;margin-right:14%">${bean1.totalco}mg/dl</span>
						</td>
						<td width="25%">
							<c:if test="${bean1.totalco < 201}">
							<span style="float:right;color:blue">정상</span>
							</c:if>
							<c:if test="${bean1.totalco > 200}">
							<span style="float:right;color:red">위험</span>
							</c:if>
						</td>
					</tr>
					<tr>
						<td width="75%">
							<span style="color:black;border:thick;margin-left:5%">AST</span>
							<span style="float:right;margin-right:14%">${bean1.ast}IU/L</span>
						</td>
						<td width="25%">
							<c:if test="${bean1.ast < 41}">
							<span style="float:right;color:blue">정상</span>
							</c:if>
							<c:if test="${bean1.ast > 40}">
							<span style="float:right;color:red">위험</span>
							</c:if>
						</td>
					</tr>
					<tr>
						<td width="75%">
							<span style="color:black;border:thick;margin-left:5%">ALT</span>
							<span style="float:right;margin-right:14%">${bean1.alt}IU/L</span>
						</td>
						<td width="25%">
							<c:if test="${bean1.alt < 41}">
							<span style="float:right;color:blue">정상</span>
							</c:if>
							<c:if test="${bean1.alt > 40}">
							<span style="float:right;color:red">위험</span>
							</c:if>
						</td>
					</tr>
					<tr>
						<td>
							<span style="color:black;border:thick;margin-left:5%">GGT</span>
							<span style="float:right;margin-right:14%">${bean1.ggt}IU/L</span>
						</td>
						<td width="25%">
							<c:if test="${bean1.ggt > 40}">
							<span style="float:right;color:blue">정상</span>
							</c:if>
							<c:if test="${bean1.ggt < 40}">
							<span style="float:right;color:red">위험</span>
							</c:if>
						</td>
					</tr>
					<tr>
						<td width="75%">
							<span style="color:black;border:thick;margin-left:5%">BUN</span>
							<span style="float:right;margin-right:14%">${bean1.bun}mg/dl</span>
						</td>
						<td width="25%">
							<c:if test="${bean1.bun > 5.0 || bean1.bun < 21.0}">
							<span style="float:right;color:blue">정상</span>
							</c:if>
							<c:if test="${bean1.bun > 20.0 || bean1.bun < 6.0}">
							<span style="float:right;color:red">위험</span>
							</c:if>
						</td>
					</tr>
					<tr>
						<td>
							<span style="color:black;border:thick;margin-left:5%">CREATININE</span>
							<span style="float:right;margin-right:14%">${bean1.creatin}mg/dl</span>
						</td>
						<td width="25%">
							<c:if test="${bean1.creatin > 0.80 || bean1.creatin < 1.45}">
							<span style="float:right;color:blue">정상</span>
							</c:if>
							<c:if test="${bean1.creatin < 0.81 || bean1.creatin > 1.44}">
							<span style="float:right;color:red">위험</span>
							</c:if>
						</td>
					</tr>
					<tr>
						<td width="75%">
							<span style="color:black;border:thick;margin-left:5%">Glucose Fasting</span>
							<span style="float:right;margin-right:14%">${bean1.fbs}mg/dl</span>
						</td>
						<td width="25%">
							<c:if test="${bean1.fbs < 100}">
							<span style="float:right;color:blue">정상</span>
							</c:if>
							<c:if test="${bean1.fbs < 125 && bean1.fbs > 99}">
							<span style="float:right;color:red">공복혈당장애</span>
							</c:if>
							<c:if test="${bean1.fbs > 125}">
							<span style="float:right;color:red">당뇨</span>
							</c:if>
						</td>
					</tr>
					<tr>
						<td width="75%">
							<span style="color:black;border:thick;margin-left:5%">수축기 혈압</span>
							<span style="float:right;margin-right:14%">${bean1.systolic}mmHg</span>
						</td>
						<td width="25%">
							<c:if test="${bean1.systolic < 121}">
							<span style="float:right;color:blue">정상</span>
							</c:if>
							<c:if test="${bean1.systolic > 120 && bean1.systolic < 130}">
							<span style="float:right;color:blue">주의혈압</span>
							</c:if>
							<c:if test="${bean1.systolic > 130 && bean1.systolic < 140}">
							<span style="float:right;color:blue">고혈압 전단계</span>
							</c:if>
							<c:if test="${bean1.systolic > 139}">
							<span style="float:right;color:red">고혈압</span>
							</c:if>
						</td>
					</tr>
					<tr>
						<td width="75%">
							<span style="color:black;border:thick;margin-left:5%">이완기 혈압</span>
							<span style="float:right;margin-right:14%">${bean1.diastolic}mmHg</span>
						</td>
						<td width="25%">
							<c:if test="${bean1.diastolic < 81}">
							<span style="float:right;color:blue">정상</span>
							</c:if>
							<c:if test="${bean1.diastolic < 90 && bean1.diastolic > 80}">
							<span style="float:right;color:blue">고혈압 전단계</span>
							</c:if>
							<c:if test="${bean1.diastolic > 89}">
							<span style="float:right;color:red">고혈압</span>
							</c:if>
						</td>
					</tr>
				</table>
				<c:if test="${sessionScope.loginfo.id == id}">
				<div style="float:right;">
					<button class="btn btn-info" type="button" onclick="location.href='<%=contextPath%>/update.he?healthno=${bean1.healthno}'">
						수정
					</button>
					<button class="btn btn-danger" type="button" onclick="healthdelete(${bean1.healthno}, '${bean1.id}');">
						삭제
					</button>
				</div>
				</c:if>
			</div>
			</c:if>
			<div class="col-sm-4" style="margin-left:0%">
			<br><br><br><br><br><br>
				<table class="table table-bordered">
					<tr>
						<td colspan="3" align="center">정상 기준치 정보</td>
					</tr>
					<tr>
						<td>구분</td>
						<td>단위</td>
						<td>기준치</td>
					</tr>
					<c:if test="${sessionScope.loginfo.gender == '남자'}">
					<tr>
						<td>체지방률(남)</td>
						<td>%</td>
						<td></td>
					</tr>
					</c:if>
					<c:if test="${sessionScope.loginfo.gender == '여자'}">
					<tr>
						<td>체지방률(여)</td>
						<td>%</td>
						<td></td>
					</tr>
					</c:if>
					<tr>
						<td>HDL</td>
						<td>mg/dl</td>
						<td></td>
					</tr>
					<tr>
						<td>LDL</td>
						<td>mg/dl</td>
						<td></td>
					</tr>
					<tr>
						<td>총 콜레스테롤</td>
						<td>mg/dl</td>
						<td></td>
					</tr>
					<tr>
						<td>AST</td>
						<td>IU/L</td>
						<td></td>
					</tr>
					<tr>
						<td>ALT</td>
						<td>IU/L</td>
						<td></td>
					</tr>
					<tr>
						<td>GGT</td>
						<td>IU/L</td>
						<td></td>
					</tr>
					<tr>
						<td>BUN</td>
						<td>mg/dl</td>
						<td></td>
					</tr>
					<tr>
						<td>CREATININE</td>
						<td>mg/dl</td>
						<td></td>
					</tr>
					<tr>
						<td>Glucose Fasting</td>
						<td>mg/dl</td>
						<td></td>
					</tr>
					<tr>
						<td>수축기 혈압</td>
						<td>mmHg</td>
						<td></td>
					</tr>
					<tr>
						<td>이완기 혈압</td>
						<td>mmHg</td>
						<td></td>
					</tr>
				</table>
			</div>
		</div>
		<hr>
		<div class="col-sm-4" style="margin-left:10%">
			<table class="table table-bordered">
				<tr>
					<td colspan="3" align="center">건강 기록지 리스트</td>
				</tr>
				<tr>
					<td>순번</td>
					<td>측정 날짜</td>
				</tr>
				<c:forEach var="bean" items="${requestScope.lists}">
				<tr onclick="location.href='<%=contextPath%>/detail.he?healthno=${bean.healthno}'">
					<td>${bean.healthno}</td>
					<td>${bean.regdate}</td>
				</tr>
				</c:forEach>
			</table>
			<div align="center">
				<p class="form-control-static">${requestScope.pagingStatus}</p>
				<footer>${requestScope.pagingHtml}</footer>			
			</div>
		</div>
	</div>
</div>		
</body>
</html>