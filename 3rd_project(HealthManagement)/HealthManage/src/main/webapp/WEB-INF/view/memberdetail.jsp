<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div class="container col-sm-12">
	<div class="card card-danger">
		<div class="card-heading" align="center">
			<br><h2 class="font-weight-bold text-danger">회원 건강정보</h2>
		</div>
		<div class="row card-body">
			<c:if test="${pbean.pono != null}">
			<div class="w3-center col-sm-4" style="float:left;margin-left:11%;background-color:white">
				<span class="" style="float:right;margin-right:20%">등록 날짜 : ${pbean.regdate}</span>
				<table class="table table-bordered"> 
					<thead onclick="location.href='<%=contextPath%>/detail.po?pono=${pbean.pono}'">
						<tr>
							<th colspan="2" style="color:red;">체형 정보</th>
						</tr>
						<tr>
							<td>
								<img src="./upload/${pbean.image1}" class="img-rounded" 
												alt="전면" width="220" height="500">		
							</td>
							<td>
								<img src="./upload/${pbean.image2}" class="img-rounded" 
												alt="후면" width="220" height="500">		
							</td>
						</tr>
						<tr>
							<td>
								<img src="./upload/${pbean.image3}" class="img-rounded" 
												alt="측면(좌)" width="100" height="500">	
							</td>
							<td>
								<img src="./upload/${pbean.image4}" class="img-rounded" 
												alt="측면(우)" width="100" height="500">		
							</td>
						</tr>
					</thead>
				</table>
				<div style="float:right;">
					<button class="btn btn-danger" type="button" onclick="location.href='<%=contextPath%>/polist.po?id=${sessionScope.loginfo.id}'">
						리스트 상세보기
					</button>
				</div>
			</div>
			</c:if>
			<c:if test="${pbean.pono == null}">
				동록된 체형정보가 없습니다.
			</c:if>
			<br>
			<div class="row col-sm-4">
				<c:if test="${hbean.healthno != null}">
				<div class="card-body" style="margin-left:10%;background:white">
					<span class="" style="float:right;margin-right:20%">등록 날짜 : ${hbean.regdate}</span>
					<table class="table table-bordered">
						<tr>
							<th class="w3-center" colspan="2" style="color:red;">건강 기록지</th>
						</tr>
						<tr>
							<td width="75%">
								<span style="color:black;border:thick;margin-left:5%;border:thick;margin-left:5%">신장(키)</span>
								<span style="float:right;margin-right:14%">${hbean.height}cm</span>
							</td>
							<td width="25%">
							</td>
						</tr>
						<tr>
							<td width="75%">
								<span style="color:black;border:thick;margin-left:5%">몸무게</span>
								<span style="float:right;margin-right:14%">${hbean.weight}kg</span>
							</td>
							<td width="25%">
							</td>
						</tr>
						<tr>
							<td width="75%">
								<span style="color:black;border:thick;margin-left:5%">지방량</span>
								<span style="float:right;margin-right:14%">${hbean.fat}kg</span>
							</td>
							<td width="25%">
							</td>
						</tr>
						<tr>
							<td width="75%">
								<span style="color:black;border:thick;margin-left:5%">근육량</span>
								<span style="float:right;margin-right:14%">${hbean.muscle}kg</span>
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
								<c:if test="${hbean.totalco < 201}">
								<span style="float:right;color:blue">정상</span>
								</c:if>
								<c:if test="${hbean.totalco > 200}">
								<span style="float:right;color:red">위험</span>
								</c:if>
							</td>
						</tr>
						<tr>
							<td width="75%">
								<span style="color:black;border:thick;margin-left:5%">HDL</span>
								<span style="float:right;margin-right:14%">${hbean.hdl}mg/dl</span>
							</td>
							<td width="25%">
								<c:if test="${hbean.hdl > 39}">
								<span style="float:right;color:blue">정상</span>
								</c:if>
								<c:if test="${hbean.hdl < 40}">
								<span style="float:right;color:red">위험</span>
								</c:if>
							</td>
						</tr>
						<tr>
							<td width="75%">
								<span style="color:black;border:thick;margin-left:5%">LDL</span>
								<span style="float:right;margin-right:14%">${hbean.ldl}mg/dl</span>
							</td>
							<td width="25%">
								<c:if test="${hbean.ldl < 141}">
								<span style="float:right;color:blue">정상</span>
								</c:if>
								<c:if test="${hbean.ldl > 140}">
								<span style="float:right;color:red">위험</span>
								</c:if>
							</td>
						</tr>
						<tr>
							<td width="75%">
								<span style="color:black;border:thick;margin-left:5%">총 콜레스테롤</span>
								<span style="float:right;margin-right:14%">${hbean.totalco}mg/dl</span>
							</td>
							<td width="25%">
								<c:if test="${hbean.totalco < 201}">
								<span style="float:right;color:blue">정상</span>
								</c:if>
								<c:if test="${hbean.totalco > 200}">
								<span style="float:right;color:red">위험</span>
								</c:if>
							</td>
						</tr>
						<tr>
							<td width="75%">
								<span style="color:black;border:thick;margin-left:5%">AST</span>
								<span style="float:right;margin-right:14%">${hbean.ast}IU/L</span>
							</td>
							<td width="25%">
								<c:if test="${hbean.ast < 41}">
								<span style="float:right;color:blue">정상</span>
								</c:if>
								<c:if test="${hbean.ast > 40}">
								<span style="float:right;color:red">위험</span>
								</c:if>
							</td>
						</tr>
						<tr>
							<td width="75%">
								<span style="color:black;border:thick;margin-left:5%">ALT</span>
								<span style="float:right;margin-right:14%">${hbean.alt}IU/L</span>
							</td>
							<td width="25%">
								<c:if test="${hbean.alt < 41}">
								<span style="float:right;color:blue">정상</span>
								</c:if>
								<c:if test="${hbean.alt > 40}">
								<span style="float:right;color:red">위험</span>
								</c:if>
							</td>
						</tr>
						<tr>
							<td>
								<span style="color:black;border:thick;margin-left:5%">GGT</span>
								<span style="float:right;margin-right:14%">${hbean.ggt}IU/L</span>
							</td>
							<td width="25%">
								<c:if test="${hbean.ggt > 40}">
								<span style="float:right;color:blue">정상</span>
								</c:if>
								<c:if test="${hbean.ggt < 40}">
								<span style="float:right;color:red">위험</span>
								</c:if>
							</td>
						</tr>
						<tr>
							<td width="75%">
								<span style="color:black;border:thick;margin-left:5%">BUN</span>
								<span style="float:right;margin-right:14%">${hbean.bun}mg/dl</span>
							</td>
							<td width="25%">
								<c:if test="${hbean.bun > 5 || hbean.bun < 21}">
								<span style="float:right;color:blue">정상</span>
								</c:if>
								<c:if test="${hbean.bun > 20 || hbean.bun < 6}">
								<span style="float:right;color:red">위험</span>
								</c:if>
							</td>
						</tr>
						<tr>
							<td>
								<span style="color:black;border:thick;margin-left:5%">CREATININE</span>
								<span style="float:right;margin-right:14%">${hbean.creatin}mg/dl</span>
							</td>
							<td width="25%">
								<c:if test="${hbean.creatin > 0.80 || hbean.creatin < 1.45}">
								<span style="float:right;color:blue">정상</span>
								</c:if>
								<c:if test="${hbean.creatin < 0.81 || hbean.creatin > 1.44}">
								<span style="float:right;color:red">위험</span>
								</c:if>
							</td>
						</tr>
						<tr>
							<td width="75%">
								<span style="color:black;border:thick;margin-left:5%">Glucose Fasting</span>
								<span style="float:right;margin-right:14%">${hbean.fbs}mg/dl</span>
							</td>
							<td width="25%">
								<c:if test="${hbean.fbs < 100}">
								<span style="float:right;color:blue">정상</span>
								</c:if>
								<c:if test="${hbean.fbs < 125 && hbean.fbs > 99}">
								<span style="float:right;color:red">공복혈당장애</span>
								</c:if>
								<c:if test="${hbean.fbs > 125}">
								<span style="float:right;color:red">당뇨</span>
								</c:if>
							</td>
						</tr>
						<tr>
							<td width="75%">
								<span style="color:black;border:thick;margin-left:5%">수축기 혈압</span>
								<span style="float:right;margin-right:14%">${hbean.systolic}mmHg</span>
							</td>
							<td width="25%">
								<c:if test="${hbean.systolic < 121}">
								<span style="float:right;color:blue">정상</span>
								</c:if>
								<c:if test="${hbean.systolic > 120 && hbean.systolic < 130}">
								<span style="float:right;color:blue">주의혈압</span>
								</c:if>
								<c:if test="${hbean.systolic > 130 && hbean.systolic < 140}">
								<span style="float:right;color:blue">고혈압 전단계</span>
								</c:if>
								<c:if test="${hbean.systolic > 139}">
								<span style="float:right;color:red">고혈압</span>
								</c:if>
							</td>
						</tr>
						<tr>
							<td width="75%">
								<span style="color:black;border:thick;margin-left:5%">이완기 혈압</span>
								<span style="float:right;margin-right:14%">${hbean.diastolic}mmHg</span>
							</td>
							<td width="25%">
								<c:if test="${hbean.diastolic < 81}">
								<span style="float:right;color:blue">정상</span>
								</c:if>
								<c:if test="${hbean.diastolic < 90 && hbean.diastolic > 80}">
								<span style="float:right;color:blue">고혈압 전단계</span>
								</c:if>
								<c:if test="${hbean.diastolic > 89}">
								<span style="float:right;color:red">고혈압</span>
								</c:if>
							</td>
						</tr>
					</table>
					<div style="float:right;">
					<button class="btn btn-danger" type="button" onclick="location.href='<%=contextPath%>/healthlist.he?id=${sessionScope.loginfo.id}'">
						리스트 상세보기
					</button>
					</div>
				</div>
				</c:if>
				<div class="card-body" style="margin-left:10%;">
					<table class="table table-bordered">
						<tr>
							<th colspan="2" style="color:red" class="w3-center">추가 정보</th>
						</tr>
						<tr>
							<td width="20%">병력</td>
							<td width="80%">${mbean.mehi}</td>
						</tr>
						<tr>
							<td>생활패턴</td>
							<td>${mbean.workpattern}</td>
						</tr>
						<tr>
							<td>수술여부</td>
							<td>${mbean.postop}</td>
						</tr>
						<tr>
							<td>수술메모</td>
							<td>${mbean.memo}</td>
						</tr>
					</table>
				</div>
			</div>
			<c:if test="${hbean.healthno == null}">
				동록된 건강기록지가 없습니다.
			</c:if>
		</div>
		<hr>
		<c:set var="i" value="0"/>
		<c:set var="j" value="5"/>
		<div class="form-group w3-center" style="background-color:white">
			<table>
		  	<c:forEach var="bean" items="${requestScope.llists}">
			  	<c:if test="${i%j == 0}"> 
			  		<tr> 
			  	</c:if> 
				  	<td>
				  	<a href="<%=contextPath%>/detail.lo?logno=${bean.logno}">
				  		<div align="center" class="w3-card-4" style="margin-right:10px;margin-left:25px;width:290px;height:400px">
						    <div class="w3-container w3-center">
						    	<p style="float:left;padding-top:5px;margin-bottom:5px">${bean.regdate}</p><br>
						    	<textarea class="form-control" readonly="readonly" style="float:left;width:100%;height:340px">${bean.loglist}</textarea>
						    </div>
						</div>
					</a>
				  	</td> 
			  	<c:if test="${i%j == j-1 }"> 
			  		</tr> 
			  	</c:if> <c:set var="i" value="${i+1 }" /> 
		  	</c:forEach>
			</table>
			<br>
			<div style="float:right;margin-right:3%">
				<button class="btn btn-danger" type="button" onclick="location.href='<%=contextPath%>/loglist.lo?id=${sessionScope.loginfo.id}'">
					리스트 상세보기
				</button>
			</div>
		</div>
		<hr>
		<c:set var="i" value="0"/>
		<c:set var="j" value="4"/>
		<div class="form-group w3-center" style="background-color:white">
			<table>
		  	<c:forEach var="bean" items="${requestScope.dlists}">
			  	<c:if test="${i%j == 0}"> 
			  		<tr> 
			  	</c:if> 
				  	<td>
					  	<a href="<%=contextPath%>/detail.di?dietno=${bean.dietno}">
					  		<div align="center" class="w3-card-4" style="margin-right:10px;margin-left:25px;width:370px;height:400px">
							    <img src="./upload/${bean.image}" alt="food" style="width:100%;height:200px">
							    <div class="w3-container w3-center">
							    <p style="float:left;padding-top:5px;margin-bottom:5px">${bean.regdate}</p><br>
							      <textarea class="form-control" readonly="readonly" style="float:left;width:100%;height:130px">${bean.dietlist}</textarea>
							    </div>
							</div>
						</a>
				  	</td> 
			  	<c:if test="${i%j == j-1 }"> 
			  		</tr> 
			  	</c:if> <c:set var="i" value="${i+1}" /> 
		  	</c:forEach>
			</table>
			<br>
			<div style="float:right;margin-right:3%">
				<button class="btn btn-danger" type="button" onclick="location.href='<%=contextPath%>/dietlist.di?id=${sessionScope.loginfo.id}'">
					리스트 상세보기
				</button>
			</div>
		</div>
	</div>
</div>
</body>
</html>