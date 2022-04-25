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
				<h4>식단 등록</h4>
			</div>
			<div class="panel-body">
				<form class="form-horizontal" action="<%=YesForm%>" method="post" enctype="multipart/form-data">
					<input type="hidden" name="command" value="dietInsert">
					<input type="hidden" name="isCheck" value="false">
					<div class="form-group">
				      	<label class="control-label col-sm-3" for="category">글 내용</label>
				      	<div class="col-sm-9">
				      		<select class="form-controll" name="category" id="category">
				      			<option value="-">-- 선택하세요.</option>
				      			<option value="1아침">아침</option>
				      			<option value="2점심">점심</option>
				      			<option value="3저녁">저녁</option>
				      			<option value="4간식">간식</option>
				      		</select>
				      	<span class="text-danger">${errtcategory}</span>
				      	</div>
				    </div>
				    <div class="form-group">
				      	<label class="control-label col-sm-3" for="content">글 내용</label>
				      	<div class="col-sm-9">
				      	<textarea rows="5" cols="60" class="form-control" name="content" id="content"></textarea>
				        	<!-- <input type="text" class="form-control" id="content" 
				        		name="content"> -->
				      	</div>
				    </div>
					<div class="form-group">
				      	<label class="control-label col-sm-3" for="files" >첨부 자료</label>
				      	<div class="col-sm-3">
				        	<input type="file" class="form" id="files" 
				        		name="files" multiple>
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