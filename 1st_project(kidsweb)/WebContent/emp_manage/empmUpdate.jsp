<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>   
   <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>내 정보 수정</title>

   <link href="<%=request.getContextPath() %>/bootstrap/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath() %>/bootstrap/css/sb-admin-2.min.css" rel="stylesheet">
   <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
   <script type="text/javascript">
   
   function checkWrite(){
	  var submitcheck = true;
      document.getElementById("namediv").innerText="";
      document.getElementById("imagediv").innerText="";
      document.getElementById("hpdiv").innerText="";
      document.getElementById("addressdiv").innerText="";
      document.getElementById("zipcodediv").innerText="";
      
      if(document.writeForm.name.value==""){
    	  console.log('9');
	   	  document.getElementById("namediv").innerText=" 이름을 입력하세요";
	   	  document.writeForm.name.focus();
	   	submitcheck = false;
      }
      if(document.writeForm.image.value == ""){
    	  console.log('13');
    	  document.getElementById("imagediv").innerText=" 사진 파일을 선택하세요";
    	  submitcheck = false;
      }
      if(document.writeForm.hp.value == ""){
    	  console.log('14');
    	  document.getElementById("hpdiv").innerText= " 휴대폰 번호를 입력하세요";
    	  document.writeForm.hp.focus();
    	  submitcheck = false;
      }
      if(document.writeForm.zipcode.value == ""){
    	  console.log('15');
    	  document.getElementById("zipcodediv").innerText=" 우편번호 검색하세요";
    	  submitcheck = false;
      }
      if(document.writeForm.address2.value == ""){
    	  console.log('16');
    	  document.getElementById("addressdiv").innerText=" 상세 주소를 입력하세요";
    	  document.writeForm.address2.focus();
    	  submitcheck = false;
      }
      if(submitcheck == true){
    	  console.log('17');
    	  document.writeForm.submit();
      }
   }
   
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
               document.getElementById('zipcode').value = data.zonecode;
               document.getElementById("address1").value = addr;
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
   <style type="text/css">
      div#tiddiv,div#passworddiv,div#repassworddiv,div#imagediv,div#hpdiv,div#emaildiv,div#namediv,div#birthdiv,div#genderdiv,div#addressdiv,div#zipcodediv{
         color:red;
         font-size:10pt;
         font-weight:bold;
         padding-left:5px;
      }
   </style>
   
</head>
<body>
   <br>
   <div class="container" align="center">
      <img alt="로고" src="./../images/아이하루 로고.png" width="75" height="50">
   </div>
   <br>
   <div class="card card-primary offset-sm-3 col-sm-6" id="empmUpdate">
      <div class="card-body">
         <div class="card-title">
            <h1 align="center" align="center">직원 정보 수정</h1>
         </div>
          <form action="<%=YesForm %>" name="writeForm" method="post" enctype="multipart/form-data">
         	<input type="hidden" name="idcheck" value="false">
            <input type="hidden" name="command" value="empmUpdate">
             <div class="form-group">
               <label for="pid" class="form-control-label col-sm-0">아이디</label>
               <div class="form-row">
                  <div class="col-">
                     <input type="text" class="form-control" id="tid" name="tid" readonly="readonly" value="${bean.tid}">
                  </div>
               </div>
            </div>
		<div class="form-group" id="tiddiv"></div>
            <div class="form-group">
               <label for="name" class="form-control-label col-sm-0">이름</label>
               <div class="col-">
                  <input type="text" class="form-control" id="name" name="name" value="${bean.name}" readonly="readonly">
               </div>
            </div>
             <div class="form-group" id="namediv"></div>
            <div class="form-group">
               <label for="hp" class="form-control-label col-sm-0">휴대폰</label>
               <div class="col-">
                  <input type="number" class="form-control" id="hp" name="hp" placeholder="ex)01012341234" value="${bean.hp}" readonly="readonly">
               </div>
            </div>
             <div class="form-group" id="hpdiv"></div>
            <div class="form-group">
               <label for="image" class="form-control-label col-sm-0">사진</label>
               <div class="col-">
                  <input type="file" class="form-control-file border" id="image" name="image">
               </div>
            </div>
             <div class="form-group" id="imagediv"></div>
            <div class="form-group">
               <label for="zipcode" class="form-control-label col-sm-0">우편번호</label>
               <div class="form-row">
                  <div class="col-">
                     <input type="text" class="form-control" id="zipcode" name="zipcode" readonly value="${bean.zipcode}">
                  </div>
                  <div class="col-">
                     <input type="button" class="form-control btn btn-primary" value="우편번호검색" onclick="checkPost()">
                  </div>
               </div>
            </div>
			 <div class="form-group" id="zipcodediv"></div>
            <div class="form-group">
               <label for="address1" class="form-control-label col-sm-0">주소</label>
               <div class="col-">
                  <input type="text" class="form-control" id="address1" name="address1" readonly value="${bean.address1}">
               </div>
            </div>
            <div class="form-group">
               <label for="address2" class="form-control-label col-sm-0">상세주소</label>
               <div class="col-">
                  <input type="text" class="form-control" id="address2" name="address2" value="${bean.address2}">
               </div>
            </div>
             <div class="form-group" id="addressdiv"></div>
             <div class="form-group">
               <label for="salary" class="form-control-label col-sm-0">급여</label>
               <div class="col-">
                  <input type="number" class="form-control" id="salary" name="salary" placeholder="숫자만 입력하세요" value="${bean.salary}">
               </div>
            </div>
            <div class="form-group" id="responsibilities">
             <label for="responsibilities" class="form-control-label col-sm-0">직책 선택</label>
               <div class="form-row">                
               <label for="responsibilities" class="form-control-label col-sm-0"></label>
                  <div class="col-8">
                     <select class="form-control" name="responsibilities" id="responsibilities">
                        <option value="미정">---선택하세요
                        <option value="직원">담임</option>
                        <option value="특별">특별</option>
                     </select>
                  </div>
               </div>
            </div> 
            <div class="form-group" id="class_id">
             <label for="class_id" class="form-control-label col-sm-0">학급 선택</label>
               <div class="form-row">                
               <label for="class_id" class="form-control-label col-sm-0"></label>
                  <div class="col-8">
                     <select class="form-control" name="class_id" id="class_id">
                        <option value="0">---선택하세요
                        <c:forEach var="clists" items="${requestScope.clists}">
                        <option value="${clists.class_id}">${clists.class_name}</option>
                        </c:forEach>
                     </select>
                  </div>
               </div>
            </div> 
            <div class="form-group" id="subject_code">
             <label for="subject_code" class="form-control-label col-sm-0">과목 선택</label>
               <div class="form-row">
                  <label for="subject_code" class="form-control-label col-sm-0"></label>
                  <div class="col-8">
                     <select class="form-control" name="subject_code" id="subject_code">
                        <option value="0">---선택하세요
                       <c:forEach var="slists" items="${requestScope.slists}">
                        <option value="${slists.subject_code}">${slists.subject}</option>
                        </c:forEach>
                     </select>
                  </div>
               </div>
            </div> 
                <div class="form-group form-row">
                <div class = "col-4">
            	<button class="btn btn-info" onclick="location.href='<%=NoForm%>empList'">
					돌아 가기
				</button>
				</div>
            	<div class = "col-4">
               		<input type="button" class="form-control btn btn-primary" onclick="javascript:checkWrite();" value="수정 완료">
               </div>
               <div class = "col-4">
               		<input type="reset" class="form-control btn btn-secondary" value="초기화">
               </div>
            </div>
         </form>
      </div>   
   </div>
   <br>
   <br>
</body>
</html>