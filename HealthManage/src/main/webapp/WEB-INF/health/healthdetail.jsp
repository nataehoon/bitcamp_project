<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container col-sm-12">
	<div class="card card-danger">
		<div class="card-heading" align="center">
		 <br><br><h2 class="font-weight-bold text-danger">건강 기록</h2>
		</div>
		<div class="row card-body col-offset-2">
			<div class="col-sm-4" style="margin-left:0%">
				<span class="" style="float:right;margin-right:20%">등록 날짜 : ${bean.regdate}</span>
				<table class="table table-bordered">
					<tr>
						<td width="75%">
							<span style="color:black;border:thick;margin-left:5%;border:thick;margin-left:5%">신장(키)</span>
							<span style="float:right;margin-right:14%">${bean.height}cm</span>
						</td>
						<td width="25%">
						</td>
					</tr>
					<tr>
						<td width="75%">
							<span style="color:black;border:thick;margin-left:5%">몸무게</span>
							<span style="float:right;margin-right:14%">${bean.weight}kg</span>
						</td>
						<td width="25%">
						</td>
					</tr>
					<tr>
						<td width="75%">
							<span style="color:black;border:thick;margin-left:5%">지방량</span>
							<span style="float:right;margin-right:14%">${bean.fat}kg</span>
						</td>
						<td width="25%">
						</td>
					</tr>
					<tr>
						<td width="75%">
							<span style="color:black;border:thick;margin-left:5%">근육량</span>
							<span style="float:right;margin-right:14%">${bean.muscle}kg</span>
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
							<c:if test="${bean.totalco < 201}">
							<span style="float:right;color:blue">정상</span>
							</c:if>
							<c:if test="${bean.totalco > 200}">
							<span style="float:right;color:red">위험</span>
							</c:if>
						</td>
					</tr>
					<tr>
						<td width="75%">
							<span style="color:black;border:thick;margin-left:5%">HDL</span>
							<span style="float:right;margin-right:14%">${bean.hdl}mg/dl</span>
						</td>
						<td width="25%">
							<c:if test="${bean.hdl > 39}">
							<span style="float:right;color:blue">정상</span>
							</c:if>
							<c:if test="${bean.hdl < 40}">
							<span style="float:right;color:red">위험</span>
							</c:if>
						</td>
					</tr>
					<tr>
						<td width="75%">
							<span style="color:black;border:thick;margin-left:5%">LDL</span>
							<span style="float:right;margin-right:14%">${bean.ldl}mg/dl</span>
						</td>
						<td width="25%">
							<c:if test="${bean.ldl < 141}">
							<span style="float:right;color:blue">정상</span>
							</c:if>
							<c:if test="${bean.ldl > 140}">
							<span style="float:right;color:red">위험</span>
							</c:if>
						</td>
					</tr>
					<tr>
						<td width="75%">
							<span style="color:black;border:thick;margin-left:5%">총 콜레스테롤</span>
							<span style="float:right;margin-right:14%">${bean.totalco}mg/dl</span>
						</td>
						<td width="25%">
							<c:if test="${bean.totalco < 201}">
							<span style="float:right;color:blue">정상</span>
							</c:if>
							<c:if test="${bean.totalco > 200}">
							<span style="float:right;color:red">위험</span>
							</c:if>
						</td>
					</tr>
					<tr>
						<td width="75%">
							<span style="color:black;border:thick;margin-left:5%">AST</span>
							<span style="float:right;margin-right:14%">${bean.ast}IU/L</span>
						</td>
						<td width="25%">
							<c:if test="${bean.ast < 41}">
							<span style="float:right;color:blue">정상</span>
							</c:if>
							<c:if test="${bean.ast > 40}">
							<span style="float:right;color:red">위험</span>
							</c:if>
						</td>
					</tr>
					<tr>
						<td width="75%">
							<span style="color:black;border:thick;margin-left:5%">ALT</span>
							<span style="float:right;margin-right:14%">${bean.alt}IU/L</span>
						</td>
						<td width="25%">
							<c:if test="${bean.alt < 41}">
							<span style="float:right;color:blue">정상</span>
							</c:if>
							<c:if test="${bean.alt > 40}">
							<span style="float:right;color:red">위험</span>
							</c:if>
						</td>
					</tr>
					<tr>
						<td>
							<span style="color:black;border:thick;margin-left:5%">GGT</span>
							<span style="float:right;margin-right:14%">${bean.ggt}IU/L</span>
						</td>
						<td width="25%">
							<c:if test="${bean.ggt > 40}">
							<span style="float:right;color:blue">정상</span>
							</c:if>
							<c:if test="${bean.ggt < 40}">
							<span style="float:right;color:red">위험</span>
							</c:if>
						</td>
					</tr>
					<tr>
						<td width="75%">
							<span style="color:black;border:thick;margin-left:5%">BUN</span>
							<span style="float:right;margin-right:14%">${bean.bun}mg/dl</span>
						</td>
						<td width="25%">
							<c:if test="${bean.bun > 5 || bean.bun < 21}">
							<span style="float:right;color:blue">정상</span>
							</c:if>
							<c:if test="${bean.bun > 20 || bean.bun < 6}">
							<span style="float:right;color:red">위험</span>
							</c:if>
						</td>
					</tr>
					<tr>
						<td>
							<span style="color:black;border:thick;margin-left:5%">CREATININE</span>
							<span style="float:right;margin-right:14%">${bean.creatin}mg/dl</span>
						</td>
						<td width="25%">
							<c:if test="${bean.creatin > 0.80 || bean.creatin < 1.45}">
							<span style="float:right;color:blue">정상</span>
							</c:if>
							<c:if test="${bean.creatin < 0.81 || bean.creatin > 1.44}">
							<span style="float:right;color:red">위험</span>
							</c:if>
						</td>
					</tr>
					<tr>
						<td width="75%">
							<span style="color:black;border:thick;margin-left:5%">Glucose Fasting</span>
							<span style="float:right;margin-right:14%">${bean.fbs}mg/dl</span>
						</td>
						<td width="25%">
							<c:if test="${bean.fbs < 100}">
							<span style="float:right;color:blue">정상</span>
							</c:if>
							<c:if test="${bean.fbs < 125 && bean.fbs > 99}">
							<span style="float:right;color:red">공복혈당장애</span>
							</c:if>
							<c:if test="${bean.fbs > 125}">
							<span style="float:right;color:red">당뇨</span>
							</c:if>
						</td>
					</tr>
					<tr>
						<td width="75%">
							<span style="color:black;border:thick;margin-left:5%">수축기 혈압</span>
							<span style="float:right;margin-right:14%">${bean.systolic}mmHg</span>
						</td>
						<td width="25%">
							<c:if test="${bean.systolic < 121}">
							<span style="float:right;color:blue">정상</span>
							</c:if>
							<c:if test="${bean.systolic > 120 && bean.systolic < 130}">
							<span style="float:right;color:blue">주의혈압</span>
							</c:if>
							<c:if test="${bean.systolic > 130 && bean.systolic < 140}">
							<span style="float:right;color:blue">고혈압 전단계</span>
							</c:if>
							<c:if test="${bean.systolic > 139}">
							<span style="float:right;color:red">고혈압</span>
							</c:if>
						</td>
					</tr>
					<tr>
						<td width="75%">
							<span style="color:black;border:thick;margin-left:5%">이완기 혈압</span>
							<span style="float:right;margin-right:14%">${bean.diastolic}mmHg</span>
						</td>
						<td width="25%">
							<c:if test="${bean.diastolic < 81}">
							<span style="float:right;color:blue">정상</span>
							</c:if>
							<c:if test="${bean.diastolic < 90 && bean.diastolic > 80}">
							<span style="float:right;color:blue">고혈압 전단계</span>
							</c:if>
							<c:if test="${bean.diastolic > 89}">
							<span style="float:right;color:red">고혈압</span>
							</c:if>
						</td>
					</tr>
				</table>
				<c:if test="${sessionScope.loginfo.id == bean.id}">
				<div style="float:right;">
					<button class="btn btn-info" type="button" onclick="location.href='<%=contextPath%>/update.he?healthno=${bean.healthno}'">
						수정
					</button>
					<button class="btn btn-danger" type="button" onclick="location.href='<%=contextPath%>/delete.he?healthno=${bean.healthno}'">
						삭제
					</button>
				</div>
				</c:if>
			</div>
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
	</div>
</div>		
</body>
</html>