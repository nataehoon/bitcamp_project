<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html>
<style type="text/css">
	.form-group{
		margin-bottom: 3px;
	}
	.err{
		font-color: red;
	}
</style>
<body>
	<div class="container col-sm-offset-2 col-sm-8">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>운동일지 등록</h4>
			</div>
			<div class="card-body">
				<c:set var="appath" value="<%=request.getContextPath()%>"/>
				<form:form modelAttribute="log" class="form-horizontal" role="form" action="${appath}/insert.lo"
					method="post">
					<input type="hidden" id="id" name="id" value="${sessionScope.loginfo.id}">
					<div class="form-group">
				      	<label class="control-label col-sm-3" for="regdate">운동 날짜</label>
				      	<div class="col-sm-9">
				      		<form:input path="regdate" type="date" class="form-control" id="regdate" name="regdate" />
				      	</div>
				    </div>
				    <div class="form-group">
				      	<label class="control-label col-sm-3" for="loglist">글 내용</label>
				      	<div class="col-sm-9">
				      	<form:textarea path="loglist" rows="5" cols="60" class="form-control" name="loglist" id="loglist"/>
						<form:errors cssClass="err" path="loglist"/>
				      	</div>
				    </div>
				    <div class="form-group">        
				      	<div class="col-sm-offset-2 col-sm-8">
				        	<button type="submit" class="btn btn-info">작성 완료</button>
				        	&nbsp;&nbsp;&nbsp;
				        	<button type="reset" class="btn btn-danger">초기화</button>
				      	</div>
				    </div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>