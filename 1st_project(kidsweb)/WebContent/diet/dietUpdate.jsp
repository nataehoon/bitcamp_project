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
				<h4>식단 수정</h4>
			</div>
			<div class="panel-body">
				<form class="form-horizontal" action="<%=YesForm%>" method="post">
					<input type="hidden" name="command" value="dietUpdate">
					<input type="hidden" name="isCheck" value="false">
					<input type="hidden" name="dietno" value="${bean.dietno}">
					<div class="form-group">
				      	<label class="control-label col-sm-3" for="category">글 내용</label>
				      	<div class="col-sm-9">
				      		<select class="form-controll" name="category" id="category">
				      			<option value="-">-- 선택하세요.</option>
				      			<option value="아침">아침</option>
				      			<option value="점심">점심</option>
				      			<option value="저녁">저녁</option>
				      			<option value="간식">간식</option>
				      		</select>
				      	<span class="text-danger">${errtcategory}</span>
				      	</div>
				    </div>
				    <div class="form-group">
				      	<label class="control-label col-sm-3" for="content">글 내용</label>
				      	<div class="col-sm-9">
				      	<textarea rows="5" cols="60" class="form-control" name="content" id="content"></textarea>
				      	</div>
				    </div>
					<div class="form-group">
				      	<label class="control-label col-sm-3" for="files">첨부 자료</label>
				      	<div class="col-sm-9">
				        	<input type="file" class="form-control" id="files" 
				        		name="files">
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