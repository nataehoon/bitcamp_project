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
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script type="text/javascript">

		 function checkPost() {
				var width = 500; //팝업의 너비
				var height = 500; //팝업의 높이
					
			    new daum.Postcode({
					width : width, //생성자에 크기 값을 명시적으로 지정해야 합니다.
			  		height : height,
				
			        oncomplete: function(data) {
			           var addr = ''; // 주소 변수
			           var extraAddr = ''; // 참고항목 변수
			           //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
			           if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
			                addr = data.roadAddress;
			            } else { // 사용자가 지번 주소를 선택했을 경우(J)
			                addr = data.jibunAddress;
			            }
			            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
			            if(data.userSelectedType === 'R'){
			                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
			                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
			                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
			                    extraAddr += data.bname;
			                }
			                // 건물명이 있고, 공동주택일 경우 추가한다.
			                if(data.buildingName !== '' && data.apartment === 'Y'){
			                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
			                }
			        
			            // 우편번호와 주소 정보를 해당 필드에 넣는다.
			            document.getElementById('fakezipcode').value = data.zonecode;
			            document.getElementById("fakeaddress1").value = addr;
			            document.getElementById("address1").value = addr;
			            document.getElementById("zipcode").value = addr;
			            // 커서를 상세주소 필드로 이동한다.
			            document.getElementById("address2").focus();
			        	}
					}
			    }).open({
					left: (window.screen.width / 2) - (width / 2),
					top: (window.screen.height / 2) - (height / 2)
			});
		 }
	</script>
	<link href="./../bootstrap/css/ab-admin-2.min.css" rel="stylesheet">
</head>
<body>
	<div class="container col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>유치원생 가입 신청서</h4>
			</div>
			<div class="panel-body">
				<form name="myform" class="form-horizontal" action="<%=YesForm%>" method="post" enctype="multipart/form-data">
					
					<input type="hidden" name="command" value="stInsert" >
					<input type="hidden" name="isCheck" value="false" >
				    
					<div class="form-group">
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
				        	<input type="hidden" name="zipcode" id="zipcode">
				        	<p class="text-danger">${errzipcode}</p>
				      	</div>
				      	<div class="col-sm-<%=rightButton%>">
				        	<input type="button" value="우편 번호 찾기" class="btn btn-info"
				        		onclick="checkPost()">
				      	</div>
				      	</div>
				    </div>			    
					<div class="form-group">
				      	<label class="control-label col-sm-<%=formleft%>" for="address1">주소</label>
				      	<div class="row">
				      	<div class="col-sm-<%=formright%>">
				        	<input type="text" class="form-control" disabled="disabled" 
				        		id="fakeaddress1" name="fakeaddress1">
				        	<input type="hidden" name="address1" id="address1">
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
				        	원생 등록</button>
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