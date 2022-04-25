<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>
<%
	/* position for grid system */	
	int offset = 4 ;
	int mywidth = 12 - 4 * offset ;
	int formleft = 3 ;
	int formright = 12 - formleft ;
	int rightButton = 4 ;
%>
<!DOCTYPE html><html>
<head>
	<script>
		$(document).ready(function(){
		});
	</script>
</head>
<body>
	<div class="d-sm-flex align-items-center justify-content-between mb-4">
		<div class="container col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>특별활동 게시물 등록</h4>
			</div>
			<div class="panel-body">
				<form class="form-horizontal" action="<%=YesForm%>" method="post" enctype="multipart/form-data">
					<input type="hidden" name="command" value="acInsert">
					<div class="form-group">
				      	<label class="control-label col-sm-3" for="tid">작성자</label>
				      	<div class="col-sm-9">
				        	<input type="text" class="form-control" disabled="disabled" 
				        		id="fakewriter" name="fakewriter"
				        		value="${sessionScope.loginfo.name}(${sessionScope.loginfo.tid})" >				        		
				        	<input type="hidden" name="tid" value="${sessionScope.loginfo.tid}">
				        	<input type="hidden" name="subject_code" value="${sessionScope.loginfo.subject_code}">
				      	</div>
				    </div>
				    <div class="form-group">
                      	
                            <div class="col-sm-9">
								<select class="form-control" name="class_id" id="class_id">
				                        <option value="0">---선택하세요
				                        <c:forEach var="clists" items="${requestScope.clists}">
				                        <option value="${clists.class_id}">${clists.class_name}</option>
				                        </c:forEach>
							  	</select>
								<span class="text-danger">${errclass_id}</span>
							</div>
						
               	    </div>
				    <div class="form-group">
						<label class="control-label col-sm-3" for="title">글 제목</label>
				      	<div class="col-sm-9">
				        	<input type="text" class="form-control" id="title" 
				        	name="title" value="${bean.title}">
				        	<span class="err">${errtitle}</span>
				      	</div>
				    </div>	
               	    <div class="form-group">
				      	<label class="control-label col-sm-3" for="content">글 내용</label>
				      	<div class="col-sm-9">
				        	<input type="text" class="form-control" id="content" 
				        		name="content" value="${bean.content}">
				      	</div>
				    </div>
					<div class="form-group">
				      	<label class="control-label col-sm-9" for="image">첨부 자료</label>
				      	<div class="col-sm-9">
				        	<input type="file" class="form-control" id="image" 
				        		name="image" value="${bean.files}">
				      	</div>
				    </div>
				    <div class="form-group">        
				      	<div class="col-sm-offset-2 col-sm-8">
				        	<button type="submit" class="btn btn-primary">게시물 등록</button>
				        	&nbsp;&nbsp;&nbsp;
				        	<button type="reset" class="btn btn-default">초기화</button>
				      	</div>
				    </div>
				</form>
			</div>
		</div>
		</div>
	</div>
</body>
</html>