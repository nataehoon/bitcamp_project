<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html>
<style>
  .cursor {
  	 cursor: pointer;
  }
</style>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script type="text/javascript">
	function period(){
		var gu = $('#gu').val();
		location.href='<%=contextPath%>/fitlist.pl?gu='+gu;
	}
</script>
</head>
<body>
<div class="container col-sm-12">
	<div class="form-group">
		<select id="gu" name="gu">
			<option value="-">----선택하세요----</option>
			<option value="강서구">강서구</option>
			<option value="송파구">송파구</option>
			<option value="종로구">종로구</option>
			<option value="중랑구">중랑구</option>
			<option value="강동구">강동구</option>
			<option value="영등포구">영등포구</option>
			<option value="용산구">용산구</option>
			<option value="관악구">관악구</option>
			<option value="양천구">양천구</option>
			<option value="성동구">성동구</option>
			<option value="도봉구">도봉구</option>
			<option value="금천구">금천구</option>
			<option value="동작구">동작구</option>
			<option value="중구">중구</option>
			<option value="구로구">구로구</option>
			<option value="노원구">노원구</option>
			<option value="서초구">서초구</option>
			<option value="은평구">은평구</option>
			<option value="마포구">마포구</option>
			<option value="광진구">광진구</option>
			<option value="서대문구">서대문구</option>
			<option value="성북구">성북구</option>
			<option value="동대문구">동대문구</option>
			<option value="강남구">강남구</option>
			<option value="강북구">강북구</option>
		</select>
		<button class="btn btn-danger" type="button" onclick="period();">지역 선택</button>
	</div>
	<div class="row form-groups" style="background-color:white">
		<c:forEach var="fbean" items="${requestScope.lists}">
		<div class="w3-card col-offset-1 col-sm-3">
			<div class="row cursor" onclick="location.href='<%=contextPath%>/fitdetail.pl?fitno=${fbean.fitno}'">
				<div class="col-sm-3">
					<br>
					<img src="./upload/로고.png" class="img-profile rounded-circle" width="90" height="90">
				</div>
				<div class="col-sm-3">
					<br>
					이름<br>
					주소
				</div>
				<div class="col-sm-6">
					<br>
					${fbean.name}<br>
					${fbean.address}
				</div>
			</div>
		</div>
		</c:forEach>
	</div>
</div>
</body>
</html>
