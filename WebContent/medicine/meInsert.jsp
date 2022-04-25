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
            <h5 class="m-0 font-weight-bold text-primary">투약의뢰서 작성</h5>
        </div>
	<div class="card-body">
    <div class="table-responsive">
    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
	<form class="form-horizontal" action="<%=YesForm%>" method="post" >
		<input type="hidden" name="command" value="meInsert">
		<input type="hidden" name="isCheck" value="fals">
		<tr>
			<th>아동명</th>
			<td>${loginfo.stname}</td>
			<th rowspan="4">투약 시간</th>
			<td>
				<select id="hour_1" name="hour_1">
					<option value="매끼">매끼</option>
					<option value="점심">점심</option>
					<option value="저녁">저녁</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>반명</th>
			<td>${loginfo.classname}</td>
			<td>
				<select id="hour_2" name="hour_2">
					<option value="식전">식전</option>
					<option value="식후">식후</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>증상</th>
			<td><input type="text" id="textarea" name="textarea"></td>
			<td><input type="text" id="hour_3" name="hour_3">시<br>
			<span class="text-danger">${errhour_3}</span>
			</td>
		</tr>
		<tr>
			<th rowspan="4">약의 종류</th>
			<td><input type="radio" id="category" name="category" value="물약" checked="checked">물약</td>
			<td><input type="text" id="hour_4" name="hour_4" >분<br>
			<span class="text-danger">${errhour_4}</span>
			</td>
		</tr>
		<tr>
			<td><input type="radio" id="category" name="category" value="가루약">가루약</td>
			<th>보관방법</th>
			<td>
				<input type="radio" id="storagemethod" name="storagemethod" value="실온" checked="checked">실온
				<input type="radio" id="storagemethod" name="storagemethod" value="냉장">냉장
				<input type="radio" id="storagemethod" name="storagemethod" value="냉동">냉동
			</td>
		</tr>
		<tr>
			<td><input type="radio" id="category" name="category" value="연고">연고</td>
			<th>투약용량</th>
			<td>
				<input type="text" id="amount_1" name="amount_1">
				<select id="amount_2" name="amount_2">
					<option value="cc">cc</option>
					<option value="봉">봉</option>
					<option value="정">정</option>
				</select>
				<br>
				<span class="text-danger">${erramount_1}</span>
			</td>
		</tr>
		<tr>
			<td><input type="radio" id="category" name="category" value="기타">기타</td>
			<th>투약횟수</th>
			<td><input type="text" id="reps" name="reps">회<br>
			<span class="text-danger">${errreps}</span>
			</td>
		</tr>
		<tr>
			<th>의뢰자</th>
			<td>${loginfo.name}</td>
			<th>관계</th>
			<td>${loginfo.relationship}</td>
		</tr>
		<tr>
			<td colspan="4">
				<div class="row" style="float : right; padding: 10px">			
				<strong >의뢰일</strong>&nbsp;${time}&nbsp;
					<button type="submit" class="btn btn-default" onclick="onsubmit();">제출</button>
				</div>
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