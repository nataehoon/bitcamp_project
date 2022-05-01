<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>
<!DOCTYPE html><html>
<head>
</head>
<body>
	<div class="container col-sm-offset-2 col-sm-8">
		<div class="card shadow mb-4">
			<div class="card-header">
				<h4 class="font-weight-bold text-primary">${category}게시물 수정</h4>
			</div>
			<div class="card-body">
			<c:set var="appath" value="<%=request.getContextPath()%>"/>
			<form:form modelAttribute="board" id="myform" name="myform" class="form-horizontal" 
				role="form" action="${appath}/update.bo" method="post" enctype="multipart/form-data">
					<div class="form-group">
				      	<label class="control-label col-sm-3" for="id">작성자</label>
				      	<div class="col-sm-12">
				        	<input type="text" class="form-control" disabled="disabled" 
				        		id="faketid" name="faketid"
				        		value="${sessionScope.loginfo.id}" >				        		
				        	<form:input path="id" type="hidden" name="id" value="${sessionScope.loginfo.id}"/>
				      	</div>
				    </div>
				    <input type="hidden" name="bono" value="${bean.bono}">
				    <div class="form-group">
						<label class="control-label col-sm-3" for="title">글 제목</label>
				      	<div class="col-sm-12">
				        	<form:input path="title" type="text" class="form-control" id="title" 
				        	name="title" value="${bean.title}"/>
				        	<form:errors cssClass="err" path="title"/>
				      	</div>
				    </div>	
					<div class="form-group">
				      	<label class="control-label col-sm-3" for="content">글 내용</label>
				      	<div class="col-sm-12">
				        	<textarea rows="13" cols="400" class="form-control" id="content" 
				        	name="content">${bean.content}</textarea>
				      	</div>
				    </div>
				    <div class="form-group">
				    	<label class="control-label col-sm-3" for="category">게시판 구분</label>
				      	<div class="col-sm-12">
				        	<input type="text" class="form-control" readonly="readonly"
				        		id="category" name="category"
				        		value="${bean.category}" >			        		
				      	</div>
               	    </div>
				<div class="form-group">
				      	<label class="control-label col-sm-3" for="asdf">첨부 자료</label>
				      	<div class="col-sm-9">
							<input type="file" class="form-control" name="asdf"
								id="asdf" placeholder="첨부파일" value="default">
						</div>
				    </div>
				    <div class="form-group" style="float:right;">        
				      	<span class="col-sm-offset-2 col-sm-8">
				        	<button type="submit" class="btn btn-primary">게시물 작성</button>
				        	&nbsp;&nbsp;&nbsp;
				        	<button type="reset" class="btn btn-primary">초기화</button>
				      	</span>
				    </div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>