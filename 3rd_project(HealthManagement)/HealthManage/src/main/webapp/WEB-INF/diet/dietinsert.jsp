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
				<h4>식단 등록</h4>
			</div>
			<div class="panel-body">
				<c:set var="appath" value="<%=request.getContextPath()%>"/>
				<form:form modelAttribute="diet" class="form-horizontal" role="form" action="${appath}/insert.di" 
					method="post" enctype="multipart/form-data">
					<input type="hidden" id="id" name="id" value="${sessionScope.loginfo.id}">
					<div class="form-group">
				      	<label class="control-label col-sm-3" for="regdate">식사 날짜</label>
				      	<div class="col-sm-9">
				      		<input type="date" class="form-control" id="regdate" name="regdate" >
				      	</div>
				    </div>
				    <div class="form-group">
				      	<label class="control-label col-sm-3" for="dietlist">글 내용</label>
				      	<div class="col-sm-9">
				      	<textarea rows="5" cols="60" class="form-control" name="dietlist" id="dietlist"></textarea>
						<form:errors cssClass="err" path="dietlist"/>
				      	</div>
				    </div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="asdf">이미지</label>
						<div class="col-sm-9">
							<input type="file" class="form-control" name="asdf"
								id="asdf" placeholder="첨부파일">
						</div>
					</div>
				    <div class="form-group">        
				      	<div class="col-sm-offset-2 col-sm-8">
				        	<button type="submit" class="btn btn-default">작성 완료</button>
				        	&nbsp;&nbsp;&nbsp;
				        	<button type="reset" class="btn btn-default">초기화</button>
				      	</div>
				    </div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>