<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>
<!DOCTYPE html><html>
<head>
	<script>
		$(document).ready(function(){
		});
	</script>
</head>
<body>
	<div class="container col-sm-offset-2 col-sm-8">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>과목등록</h4>
			</div>
			<div class="panel-body">
				<form class="form-horizontal" action="<%=YesForm%>" method="post">
					<input type="hidden" name="command" value="suInsert">
					<input type="hidden" name="isCheck" value="fals">
					<div class="form-group">
				      	<label class="control-label col-sm-3" for="subject">과목이름</label>
				      	<div class="col-sm-9">
				        	<input type="text" class="form-control" id="subject" 
				        		name="bf" value="${bean.content}">
				      	</div>
				    </div>
				    <input type="hidden" name="command" value="suInsert">
					<input type="hidden" name="isCheck" value="fals">
					<div class="form-group">
				      	<label class="control-label col-sm-3" for="subject">담당 선생님</label>
				      	<div class="col-sm-9">
				        	<input type="text" class="form-control" id="subject" 
				        		name="bf" value="${bean.content}">
				      	</div>
				    </div>
					
				    <div class="form-group">        
				      	<div class="col-sm-offset-2 col-sm-8">
				        	<button type="submit" class="btn btn-default">작성 완료</button>
				        	&nbsp;&nbsp;&nbsp;
				        	<button type="reset" class="btn btn-default">초기화</button>
				      	</div>
				    </div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
<html>
<body>
<%@ include file="./../common/footer.jsp" %>
</body>
</html>