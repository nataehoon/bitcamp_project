<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		function zipfind(){
			/* alert('우편 번호 찾기') ; */
			var url = '<%=NoForm%>meZipcheck'  ; 
			window.open(url, 'mywin', 'height=600,width=720,scrollbars=yes') ;
		}
		
		function isCheckFalse(){
			document.myform.isCheck.value = false ;
		}
		
		function checkForm(){
			var isCheck = document.myform.isCheck.value  ;
			if(isCheck == 'false'){
				alert('아이디 중복 체크를 해주세요.') ;
				return false ; 
			}
		}
	
		$(document).ready(function(){
			$('[data-toggle="tooltip"]').tooltip();	
		});
	</script>
	<link href="./../bootstrap/css/ab-admin-2.min.css" rel="stylesheet">
</head>
<body>
	<div class="container col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>유치원생 수정</h4>
			</div>
			<div class="panel-body">
				<form name="myform" class="form-horizontal" action="<%=YesForm%>" method="post" enctype="multipart/form-data">
					<div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="id">글 번호</label>
				      	<div class="col-sm-<%=formright%>">
				        	<input type="number" class="form-control" id="fakeno" 
				        		name="fakeno" disabled="disabled" value="${bean.no}">
				        		
				        	<input type="number" id="no" name="no" value="${bean.no}" >
				      	</div>
				      	</div>
				     <div class="panel-body"> 	
				      	<label class="control-label col-sm-<%=formleft%>" for="name">이름</label>
				      	<div class="row">
				      	<div class="col-sm-<%=formright%>">
				        	<input type="text" class="form-control" id="name" 
				        		name="name"  value="${bean.name}">
				        	<p class="text-danger">${errname}</p>
				      	</div>
				    </div>
				    </div>				    
				    <div class="form-group">
				      	<label class="control-label col-sm-<%=formleft%>" for="gender">성별</label>
				      	<div class="row">
				      	<div class="col-sm-<%=formright%> ml-2">				        	
				        	<label class="radio-inline">
				        		<input type="radio" name="gender" value="남">남자
				        	</label>
				        	&nbsp;&nbsp;&nbsp;
							<label class="radio-inline">
								<input type="radio" name="gender" value="여">여자
							</label>
				      	</div>
				      	<p class="text-danger ml-2">${errgender}</p>
				    </div>
				    </div>
				    <div class="form-group">
				      	<label class="control-label col-sm-<%=formleft%>" for="hp">핸드폰</label>
				      	<div class="row">
				      	<div class="col-sm-<%=formright%>">
				        	<input type="number" class="form-control" id="hp" 
				        		name="hp" value="${bean.hp}">
				        	<p class="text-danger">${errhp}</p>
				      	</div>
				    </div>
				    </div>
					<div class="form-group">
				      	<label class="control-label col-sm-<%=formleft%>" for="birth">생일</label>
				      	<div class="row">
				      	<div class="col-sm-<%=formright%>">
				        	<input type="date" class="form-control" id="birth" 
				        		name="birth" value="${bean.birth}">
				        	<p class="text-danger">${errbirth}</p>
				      	</div>
				    </div>
				    </div>
				   	
				   	<div class="form-group">
				      	<label class="control-label col-sm-<%=formleft%>" for="zipcode">우편 번호</label>
				      	<div class="row">
				      	<div class="col-sm-<%=formright-rightButton%>">
				        	<input type="text" class="form-control" disabled="disabled" 
				        		id="fakezipcode" name="fakezipcode">
				        	<input type="hidden" name="zipcode">
				        	<p class="text-danger">${errzipcode}</p>
				      	</div>
				      	<div class="col-sm-<%=rightButton%>">
				        	<input type="button" value="우편 번호 찾기" class="btn btn-info"
				        		onclick="zipfind();">
				      	</div>
				      	</div>
				    </div>			    
					<div class="form-group">
				      	<label class="control-label col-sm-<%=formleft%>" for="address1">주소</label>
				      	<div class="row">
				      	<div class="col-sm-<%=formright%>">
				        	<input type="text" class="form-control" disabled="disabled" 
				        		id="fakeaddress1" name="fakeaddress1">
				        	<input type="hidden" name="address1">
				        	<p class="text-danger">${erraddress1}</p>
				      	</div>
				    </div>
				    </div>
				    <div class="form-group">
				      	<label class="control-label col-sm-<%=formleft%>" for="address2">세부 주소</label>
				      	<div class="row">
				      	<div class="col-sm-<%=formright%>">
				        	<input type="text" class="form-control" id="address2" name="address2">
				        	<p class="text-danger">${erraddress2}</p>				        	
				      	</div>
				    </div>
				    </div>
				    <div class="form-group">
				      	<label class="control-label col-sm-<%=formleft%>" for="image">아이 사진</label>
				      	<div class="row">
				      	<div class="col-sm-<%=formright%>">
				        	<input type="file" class="form-control" 
				        		id="image" name="image" value="${bean.image}">			        		
				        	<span class="err form-control-static">${errimage}</span>
				      	</div>
				    </div>
				    </div>
						<div class="form-group">
							<label for="content" class="col-xs-3 col-lg-3 control-label">특이사항</label>
							<div class="row">
							<div class="col-xs-9 col-lg-9">
								<textarea name="content" class="form-control" rows="3" cols="50" id="content" ></textarea> 
							</div>
						</div>
						</div>
				    <div class="form-group">        
				      	<div class="col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">
				        	<button type="submit" class="btn btn-primary">
				        	아이 수정</button>
				        	&nbsp;&nbsp;&nbsp;
				        	<button type="reset" class="btn btn-primary">초기화</button>				        	
				      	</div>
				    </div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>