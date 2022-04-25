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
		<form action="<%=YesForm %>" method="post" >
        <input type="hidden" name="idcheck" value="false">
        <input type="hidden" name="command" value="myclInsert">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>과목 등록</h4>
			</div>
			
				    <div class="form-group">
						<label class="control-label col-sm-3" for="title">과목명</label>
				      	<div class="col-sm-9">
				        	<input type="text" class="form-control" id="class_name" 
				        	name="class_name">
				        	<span class="err">${errclass_name}</span>
				      	</div>
				    </div>	
               	    <div class="form-group">
				      	<label class="control-label col-sm-3" for="content">비고</label>
				      	<div class="col-sm-9">
				        	<input type="text" class="form-control" id="remark" 
				        		name="remark">
				      	</div>
				    </div>
					<div class="form-group">        
				      	<div class="col-sm-offset-2 col-sm-8">
				        	<button type="submit" class="btn btn-primary">과목 등록</button>
				        	&nbsp;&nbsp;&nbsp;
				        	<button type="reset" class="btn btn-danger">초기화</button>
				      	</div>
				    </div>
			</div>
		  </form>
		</div>
	</div>
	
</body>
</html>