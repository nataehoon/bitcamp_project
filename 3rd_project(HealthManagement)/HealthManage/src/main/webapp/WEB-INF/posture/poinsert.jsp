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
				<h4>체형 등록</h4>
			</div>
			<div class="panel-body">
				<c:set var="appath" value="<%=request.getContextPath()%>"/>
				<form:form modelAttribute="po" class="form-horizontal" role="form" action="${appath}/insert.po" 
					method="post" enctype="multipart/form-data">
					<input type="hidden" id="id" name="id" value="${id}">
					<div class="form-group">
				      	<label class="control-label col-sm-3" for="regdate">측정 날짜</label>
				      	<div class="col-sm-9">
				      		<input type="date" class="form-control" id="regdate" name="regdate" >
				      	</div>
				    </div>
				    <div class="form-group">
				      	<label class="control-label col-sm-3" for="comments">코멘트</label>
				      	<div class="col-sm-9">
				      	<textarea rows="5" cols="60" class="form-control" name="comments" id="comments"></textarea>
						<form:errors cssClass="err" path="comments"/>
				      	</div>
				    </div>
				    <div class="form-group">
						<label class="control-label col-sm-3" for="front">전면</label>
						<div class="col-sm-9">
							<input type="file" class="form-control" name="front"
								id="front" placeholder="첨부파일">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="back">후면</label>
						<div class="col-sm-9">
							<input type="file" class="form-control" name="back"
								id="back" placeholder="첨부파일">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="left">측면(좌)</label>
						<div class="col-sm-9">
							<input type="file" class="form-control" name="left"
								id="left" placeholder="첨부파일">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="right">측면(우)</label>
						<div class="col-sm-9">
							<input type="file" class="form-control" name="right"
								id="right" placeholder="첨부파일">
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