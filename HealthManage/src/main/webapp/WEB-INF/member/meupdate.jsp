<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.form-group{
		margin-bottom: 3px;
	}
	.err{
		font-color: red;
	}
</style>
<script type="text/javascript">
	function findZipcode(){
		var url = '<%=contextPath%>/zipcheck.me';
		window.open(url, 'mywin', 'height=600, width=720, status=yes, scrollbars=yes, resizable=no');
	}
	}
</script>
</head>
<body>
<div class="container col-sm-12">
	<div class="card card-danger">
		<div class="card-heading" align="center">
		 	<br><br><h2 class="font-weight-bold text-danger">회원정보 수정</h2>
		</div>
		<br><br>
		<div class="row card-body col-offset-3">
			<div class="col-sm-6" style="float:left;margin-left:18%">
				<c:set var="appath" value="<%=request.getContextPath()%>"/>
				<form:form modelAttribute="member" id="myform" name="myform" class="form-horizontal" 
					role="form" action="${appath}/update.me" method="post">
					<div class="row form-group">
						<label class="control-label col-sm-3" for="id">아이디</label>
						<div class="col-sm-9">
							<input type="text" name="id" class="form-control" placeholder="아이디" readonly="readonly" value="${requestScope.bean.id}"/>
						</div>
					</div>
					<br>
					<div class="row form-group">
						<label class="control-label col-sm-3" for="password">비밀번호</label>
						<div class="col-sm-9">
							<form:input path="password" type="password" name="password" class="form-control" placeholder="비밀번호"/>
							<form:errors cssClass="err" path="password"/>
						</div>
					</div>
					<br>
					<div class="row form-group">
						<label class="controll-label col-sm-3" for="name">이름</label>
						<div class="col-sm-9">
							<form:input path="name" type="text" name="name" id="name" class="form-control" placeholder="이름" value="${requestScope.bean.name}"/>
							<form:errors cssClass="err" path="name"/>
						</div>
					</div>
					<br>
					<div class="row form-group">
						<label class="controll-label col-sm-3" for="age">나이</label>
						<div class="col-sm-9">
							<form:input path="age" type="number" id="age" name="age" class="form-control" placeholder="나이" value="${requestScope.bean.age}"/>
							<form:errors cssClass="err" path="age"/>
						</div>
					</div>
					<br>
					<div class="row form-group">
						<label class="controll-label col-sm-3" for="gender">성별</label>
						<div class="row col-sm-9">
							<div class="col-1">
		                        <input type="radio" class="form-control" name="gender" value="남자">
		                     </div>
		                     <label for="gender" class="form-control-label col-sm-0">&nbsp;남&nbsp;</label>
		                     <div class="col-1">
		                        <input type="radio" class="form-control" name="gender" value="여자">
		                     </div>
		                     <label for="gender" class="form-control-label col-sm-0">&nbsp;여&nbsp;</label>
						</div>
					</div>					
					<br>
					<div class="row form-group">
						<label class="controll-label col-sm-3" for="hp">핸드폰번호</label>
						<div class="col-sm-9">
							<form:input path="hp" type="text" id="hp" name="hp" class="form-control" placeholder="핸드폰번호" value="${requestScope.bean.hp}"/>
							<form:errors cssClass="err" path="hp"/>
						</div>
					</div>
					<br>
					<div class="row form-group">
						<label class="controll-label col-sm-3" for="nickname">닉네임</label>
						<div class="col-sm-9">
							<input type="text" id="nickname" name="nickname" class="form-control" placeholder="닉네임" readonly="readonly" value="${requestScope.bean.nickname}"/>
						</div>
					</div>
					<br>
					<div class="row form-group">
						<label class="controll-label col-sm-3" for="email">이메일</label>
						<div class="col-sm-9">
							<form:input path="email" type="text" id="email" name="email" class="form-control" placeholder="이메일" value="${requestScope.bean.email}"/>
							<form:errors cssClass="err" path="email"/>
						</div>
					</div>
					<br>
					<div class="row form-group">
						<label class="controll-label col-sm-3" for="zipcode">우편번호</label>
						<div class="col-sm-6">
							<input type="text" name="zipcode" id="zipcode" readonly="readonly" class="form-control"
								placeholder="우편번호" value="${requestScope.bean.zipcode}">
							<form:errors cssClass="err" path="zipcode"/>
						</div>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<div class="col-sm-2">
							<input type="button" class="btn btn-danger" value="우편번호 찾기" onclick="findZidpcode();">
						</div>
					</div>
					<br>
					<div class="row form-group">
						<label class="controll-label col-sm-3" for="address">주소</label>
						<div class="col-sm-9">
							<input type="text" name="address" id="address" readonly="readonly" class="form-control"
								placeholder="주소" value="${requestScope.bean.address}">
							<form:errors cssClass="err" path="address"/>
						</div>
					</div>	
					<br>
					<div class="row form-group">
						<label class="controll-label col-sm-3" for="address2">세부주소</label>
						<div class="col-sm-9">
							<form:input path="address2" type="text" id="address2" name="address2" class="form-control" placeholder="세부주소" value="${requestScope.bean.address2}"/>
						</div>
					</div>
					<hr>
					<div class="row form-group">
						<label class="controll-label col-sm-3" for="mehi">병력</label>
						<div class="col-sm-9">
							<form:input path="mehi" type="text" id="mehi" name="mehi" class="form-control" placeholder="병력 (ex.없음, 당뇨, 고지혈, 고혈압, 뇌졸중 등)" value="${requestScope.bean.mehi}"/>
						</div>
					</div>
					<br>
					<div class="row form-group">
						<label class="controll-label col-sm-3" for="workpattern">생활패턴</label>
						<div class="col-sm-9">
							<form:input path="workpattern" type="text" id="workpattern" name="workpattern" class="form-control" placeholder="생활패턴 또는 직업 (ex.좌식생활, 현장직, 사무직, 주부 등)" value="${requestScope.bean.workpattern}"/>
						</div>
					</div>
					<br>
					<div class="row form-group">
						<label class="controll-label col-sm-3" for="weight">몸무게</label>
						<div class="col-sm-9">
							<form:input path="weight" type="text" id="weight" name="weight" class="form-control" placeholder="몸무게" value="${requestScope.bean.weight}"/>
							<form:errors cssClass="err" path="weight"/>
						</div>
					</div>
					<br>
					<div class="row form-group">
						<label class="controll-label col-sm-3" for="height">키(신장)</label>
						<div class="col-sm-9">
							<form:input path="height" type="text" id="height" name="height" class="form-control" placeholder="신장" value="${requestScope.bean.height}"/>
							<form:errors cssClass="err" path="height"/>
						</div>
					</div>
					<hr>
					<div class="row form-group">
						<label class="controll-label col-sm-3" for="postop">수술 여부 및 부위</label>
						<div class="col-sm-9">
							<form:input path="postop" type="text" id="postop" name="postop" class="form-control" placeholder="수술 경험이 없다면 없음, 있다면 수술 부위와 진단명을 입력해 주세요." value="${requestScope.bean.postop}"/>
						</div>
					</div>
					<br>
					<div class="row form-group">
						<label class="controll-label col-sm-3" for="memo">수술 내용</label>
						<div class="col-sm-9">
							<form:input path="memo" type="text" id="memo" name="memo" class="form-control" placeholder="수술 경험이 있다면 수술 부위와 대략적인 날짜(ex, 1년전)를 입력해 주세요" value="${requestScope.bean.memo}"/>
						</div>
					</div>
					<hr>
					<div style="float:right;">
						<button type="submit" class="btn btn-danger">정보 수정</button>
						<button type="reset" class="btn btn-danger">초기화</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>
	<script type="text/javascript">
		$(document).ready(function() {
			//alert('dd') ;
			$(".datepicker").datepicker();
			$("#spanid").addClass('good-result');
		});
	</script>
</body>
</html>