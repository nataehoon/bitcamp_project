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
		margin-bottom: 20px;
	}
	.err{
		font-color: red;
	}
</style>
</head>
<body>
<div class="container col-sm-12">
	<div class="card">
		<div class="card-heading" align="center">
			<h2 class="font-weight-bold text-danger">건강 데이터 등록</h2>
		</div>	
		<div class="card-body col-offset-3">
			<c:set var="appath" value="<%=request.getContextPath()%>"/>
			<form:form modelAttribute="inserthealth" class="form-horizontal" role="form" action="${appath}/insert.he" method="post">
			<input type="hidden" name="id" value="${mbean.id}">
			<div class="row form-group" align="right">
				<label class="control-label col-sm-1" for="regdate">측정날짜</label>
				<div class="col-sm-4">
					<form:input path="regdate" type="date" name="regdate" class="form-control" placeholder="측정날짜" value="${bean.regdate}"/>
				</div>
			</div>
			<div class="row form-group">
				<label class="control-label col-sm-2" for="height">키(신장)</label>
				<div class="col-sm-2">
					<form:input path="height" type="text" name="height" class="form-control" placeholder="키(신장)" value="${mbean.height}${bean.height}"/>
					<form:errors cssClass="err" path="height"/>
				</div>
				<label class="control-label col-sm-2" for="weight">몸무게</label>
				<div class="col-sm-2">
					<form:input path="weight" type="text" name="weight" class="form-control" placeholder="몸무게" value="${mbean.weight}${bean.weight}"/>
					<form:errors cssClass="err" path="weight"/>
				</div>
				<label class="control-label col-sm-2" for="fat">지방량</label>
				<div class="col-sm-2">
					<form:input path="fat" type="text" name="fat" class="form-control" placeholder="지방량" value="${bean.height}"/>
				</div>
			</div>
			<div class="row form-group">
				<label class="control-label col-sm-2" for="muscle">근육량</label>
				<div class="col-sm-2">
					<form:input path="muscle" type="text" name="muscle" class="form-control" placeholder="근육량" value="${bean.muscle}"/>
				</div>
				<label class="control-label col-sm-2" for="ldl">LDL</label>
				<div class="col-sm-2">
					<form:input path="ldl" type="text" name="ldl" class="form-control" placeholder="LDL" value="${bean.ldl}"/>
				</div>
				<label class="control-label col-sm-2" for="hdl">HDL</label>
				<div class="col-sm-2">
					<form:input path="hdl" type="text" name="hdl" class="form-control" placeholder="HDL" value="${bean.hdl}"/>
				</div>
			</div>
			<div class="row form-group">
				<label class="control-label col-sm-2" for="totalco">총 콜레스테롤</label>
				<div class="col-sm-2">
					<form:input path="totalco" type="text" name="totalco" class="form-control" placeholder="총 콜레스테롤" value="${bean.totalco}"/>
				</div>
				<label class="control-label col-sm-2" for="ast">AST</label>
				<div class="col-sm-2">
					<form:input path="ast" type="text" name="ast" class="form-control" placeholder="AST" value="${bean.ast}"/>
				</div>
				<label class="control-label col-sm-2" for="alt">ALT</label>
				<div class="col-sm-2">
					<form:input path="alt" type="text" name="alt" class="form-control" placeholder="ALT" value="${bean.alt}"/>
				</div>
			</div>
			<div class="row form-group">
				<label class="control-label col-sm-2" for="ggt">GGT</label>
				<div class="col-sm-2">
					<form:input path="ggt" type="text" name="ggt" class="form-control" placeholder="GGT" value="${bean.ggt}"/>
				</div>
				<label class="control-label col-sm-2" for="bun">BUN</label>
				<div class="col-sm-2">
					<form:input path="bun" type="text" name="bun" class="form-control" placeholder="BUN" value="${bean.bun}"/>
				</div>
				<label class="control-label col-sm-2" for="creatin">크레아티닌(CREATININE)</label>
				<div class="col-sm-2">
					<form:input path="creatin" type="text" name="creatin" class="form-control" placeholder="크레아티닌(CREATININE)" value="${bean.creatin}"/>
				</div>
			</div>
			<div class="row form-group">
				<label class="control-label col-sm-2" for="fbs">공복시혈당(Glucose Fasting)</label>
				<div class="col-sm-2">
					<form:input path="fbs" type="text" name="fbs" class="form-control" placeholder="공복시혈당" value="${bean.fbs}"/>
				</div>
				<label class="control-label col-sm-2" for="systolic">수축기 혈압</label>
				<div class="col-sm-2">
					<form:input path="systolic" type="text" name="systolic" class="form-control" placeholder="수축기 혈압" value="${bean.systolic}"/>
				</div>
				<label class="control-label col-sm-2" for="diastolic">이완기 혈압</label>
				<div class="col-sm-2">
					<form:input path="diastolic" type="text" name="diastolic" class="form-control" placeholder="이완기 혈압" value="${bean.diastolic}"/>
				</div>
			</div>
			<div class="col-sm-12" align="right">
				<button class="btn btn-info" type="submit">등록</button>
			</div>
			</form:form>
		</div>
	</div>
</div>
</body>
</html>