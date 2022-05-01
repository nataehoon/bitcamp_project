<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html>
<body>
	<div class="container col-sm-offset-2 col-sm-8">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>식단 수정</h4>
			</div>
			<div class="panel-body">
				<c:set var="appath" value="<%=request.getContextPath()%>"/>
				<form:form modelAttribute="log" class="form-horizontal" role="form" action="${appath}/update.lo" 
					method="post" enctype="multipart/form-data">
					<input type="hidden" id="id" name="id" value="${sessionScope.loginfo.id}">
					<div class="form-group">
				      	<label class="control-label col-sm-3" for="regdate">운동 날짜</label>
				      	<div class="col-sm-9">
				      		<input type="date" class="form-control" id="regdate" name="regdate" value="${bean.regdate}">
				      	</div>
				    </div>
				    <div class="form-group">
				      	<label class="control-label col-sm-3" for="dietlist">글 내용</label>
				      	<div class="col-sm-9">
				      	<textarea rows="5" cols="60" class="form-control" name="dietlist" id="dietlist" >${bean.dietlist}</textarea>
						<form:errors cssClass="err" path="content"/>
				      	</div>
				    </div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="image">이미지</label>
						<div class="col-sm-9">
							<input type="file" class="form-control" name="image"
								id="image" placeholder="첨부파일" value="${bean.image}">
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