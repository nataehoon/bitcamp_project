<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>
<!DOCTYPE html><html>
<head>
	 <script type="text/javascript">
	 
	 function onsubmit(){
		 var from = document.all;

		 var radio_num = document.all.radio.length;
		 var chk_i = 0;

		 for(var i=0; i<radio_num; i++){
			 if(from.radio[i].checked == true){
			 chk_i ++;
			 break;
			 }
		 }
		 
		 if(chk_i <= 0){
			 alert(“선택해 주세요.”);
			 return;
		 }
	 }
	 
	 function ondo(){
		 alert('실험');
	 }
		
	</script>
</head>
<body>

	<div class="container fluid">
	<div class="card shadow mb-4">
		<div class="card-header py-3">
            <h5 class="m-0 font-weight-bold text-primary">
            <c:choose>
            <c:when test="${whlogin == 3 }"><!-- 학부모 -->
				${loginfo.stname}&nbps;
			</c:when>
			</c:choose>
            알림장
            </h5>
        </div>
	<div class="card-body">
    <div class="table-responsive">
    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
	<form class="form-horizontal" action="<%=YesForm%>" method="post" >
		<input type="hidden" name="command" value="sthwInsert">
		<!--<input type="hidden" name="isCheck" value="fals">-->
		<tr>
			<th>아동명</th>
			<c:choose>
			<c:when test="${ whologin == 1 || whologin == 2 }"><!--원장,직원  -->
				<td>
				<select>
				<c:forEach var="bean" items="${sbean}">
						<option id="sid" name="sid" value="${bean.sid}">${bean.name}</option> <!-- 이름 고르면 sid 들어오 -->
				</c:forEach>
				</select>
				</td>
			</c:when>
			<c:when test="${whlogin == 3 }"><!-- 학부모 -->
				<td>${loginfo.stname}</td>
			</c:when>
			</c:choose>
			<td></td>
			<th>투약의뢰서</th>
			<td></td>
		</tr>
		<tr>
			<th>출석</th>
			<td></td>
			<th>건강</th>
			<td>
				<select>
					<option id="healty" name="healty" value="좋음">좋음</option>
					<option id="healty" name="healty" value="보통">보통</option>
					<option id="healty" name="healty" value="나쁨">나쁨</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>잠</th>
			<td><input type="text" id="sleep" name="sleep">시간</td>
			<th>기분</th>
			<td>
				<select>
					<option id="condition" name="condition" value="좋음">좋음</option>
					<option id="condition" name="condition" value="보통">보통</option>
					<option id="condition" name="condition" value="나쁨">나쁨</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>식사</th>
			<td>
				<select>
					<option id="meal" name="meal" value="정량">정량</option>
					<option id="meal" name="meal" value="미달">미달</option>
					<option id="meal" name="meal" value="초과">초과</option>
				</select>
			</td>
			<th>배변</th>
			<td>
				<input type="text" id="poop" name="poop">회
			</td>
		</tr>
		<tr>
			<th>키</th>
			<td>
				<input type="text" id="height" name="height">cm
			</td>
			<th>몸무게</th>
			<td>
				<input type="text" id="weight" name="weight">kg
			</td>
		</tr>
		<tr>
		<td colspan="4">
		<button type="submit">제출</button>
		</td>
		</tr>
	</form>	
	</table>
	</div>
	</div>
	</div>	
	</div>
</body>
</html>