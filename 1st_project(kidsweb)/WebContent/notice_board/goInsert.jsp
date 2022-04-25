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
		<div class="card shadow mb-4">
			<div class="card-header">
				<h4 class="font-weight-bold text-primary">게시물 등록</h4>
			</div>
			<div class="card-body">
				<form class="form-horizontal" action="<%=YesForm%>" method="post" enctype="multipart/form-data">
					<input type="hidden" name="command" value="goInsert">
					<input type="hidden" name="isCheck" value="fals">
					<div class="form-group">
				      	<label class="control-label col-sm-3" for="tid">작성자</label>
				      	<div class="col-sm-12">
				        	<input type="text" class="form-control" disabled="disabled" 
				        		id="faketid" name="faketid"
				        		value="${sessionScope.loginfo.name}(${sessionScope.loginfo.tid})" >				        		
				        	<input type="hidden" name="tid" value="${sessionScope.loginfo.tid}">
				      	</div>
				    </div>
				    <div class="form-group">
						<label class="control-label col-sm-3" for="title">글 제목</label>
				      	<div class="col-sm-12">
				        	<input type="text" class="form-control" id="title" 
				        	name="title" value="${bean.title}">
				        	<span class="err">${errtitle}</span>
				      	</div>
				    </div>	
					<div class="form-group">
				      	<label class="control-label col-sm-3" for="content">글 내용</label>
				      	<div class="col-sm-12">
				        	<textarea rows="13" cols="400" class="form-control" id="content" 
				        	name="content"></textarea>
				      	</div>
				    </div>
				    <div class="form-group">
                        <div class="col-sm-12">
							<select class="form-control" id="class_id" name="class_id">
				        		<option value="0" selected="selected">--- 학급명을 선택해 주세요.</option>
							    <c:forEach var="mlists" items="${requestScope.mlists}">
							    <option value="${mlists.class_id}">${mlists.class_name}</option>
							    </c:forEach>
							  	</select>
							<span class="text-danger">${errclass_id}</span>
						</div>
               	    </div>
				<div class="form-group">
				      	<label class="control-label col-sm-3" for="files">첨부 자료</label>
				      	<div class="col-sm-3">
				        	<input type="file" class="form" id="files" 
				        		name="files" multiple>
				      	</div>
				    </div>
				    <div class="form-group" style="float:right;">        
				      	<span class="col-sm-offset-2 col-sm-8">
				        	<button type="submit" class="btn btn-primary">게시물 작성</button>
				        	&nbsp;&nbsp;&nbsp;
				        	<button type="reset" class="btn btn-primary">초기화</button>
				      	</span>
				    </div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>