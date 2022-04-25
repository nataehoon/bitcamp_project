<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String contextPath = request.getContextPath() ;
	String mappingName = "/Kids" ;
	
	String YesForm = contextPath + mappingName ;
	String NoForm = contextPath + mappingName + "?command=" ;
%>
<!DOCTYPE html>
<html>
<head>   
   <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>유치원 회원가입</title>

   <link href="<%=request.getContextPath() %>/bootstrap/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath() %>/bootstrap/css/sb-admin-2.min.css" rel="stylesheet">
   <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
   <script type="text/javascript">
   
   function checktid(){
      document.getElementById("tiddiv").innerText="";
      var tid = document.writeForm.tid.value;
      var engNum = /(?=.*\d)(?=.*[a-z]).{4,15}/; //영어소문자+숫자 혼합. 4글자이상 15글자 이하
      var idtest = engNum.test(tid);
      
      if(tid==""){
         console.log('if문들어옴');
         document.getElementById("tiddiv").innerText="  먼저 아이디를 입력하세요";
         document.writeForm.tid.focus(); 
      }else if(idtest==false){
   	  	 document.getElementById("tiddiv").innerText="  아이디는 숫자+영어 혼합하고, 4글자 이상 15글자 이하이어야 합니다.";
         document.writeForm.tid.focus(); 
      }else{
         console.log('else 들어옴');
         var url = '<%=NoForm%>idCheck&tid='+tid;
         window.open(url,"checktid","width=450, height=150, left=800, top=200, menubar=no, location=no, left=400, top=200");
      }
   }
   
   function idcheckFalse(){
	   document.writeForm.idcheck.value=false;
   }
   
   function checkWrite(){
	  var submitcheck = true;
      document.getElementById("tiddiv").innerText="";
      document.getElementById("class_iddiv").innerText="";
      document.getElementById("namediv").innerText="";
      document.getElementById("join_datediv").innerText="";
      document.getElementById("imagediv").innerText="";
      document.getElementById("birthdiv").innerText="";
      document.getElementById("hpdiv").innerText="";
      document.getElementById("addressdiv").innerText="";
      document.getElementById("passworddiv").innerText="";
      document.getElementById("subject_codediv").innerText="";
      document.getElementById("genderdiv").innerText="";
      document.getElementById("emaildiv").innerText="";
      document.getElementById("zipcodediv").innerText="";
      
      var id = document.writeForm.tid.value
      var engNum = /(?=.*\d)(?=.*[a-z]).{4,15}/; //영어소문자+숫자 혼합. 4글자이상 15글자 이하
      var tidtest = engNum.test(tid);
      console.log('tidtest :'+tidtest);
      
      var pwd = document.writeForm.password.value
      var engNum = /(?=.*\d)(?=.*[a-z]).{8,15}/; //영어소문자+숫자 혼합. 8글자이상 15글자 이하
      var passwordtest = engNum.test(password);
      console.log('passwordtest :'+passwordtest);
     
      if(document.writeForm.tid.value==""){
      	document.getElementById("tiddiv").innerText="  아이디를 입력하세요";
      	document.writeForm.tid.focus();
      	submitcheck = false;
      }
      if(idtest==false){
    	document.getElementById("tiddiv").innerText="  아이디는 숫자+영어 혼합하고, 4글자 이상 15글자 이하이어야 합니다.";
        document.writeForm.tid.focus(); 
        submitcheck = false;
      }

      if(document.writeForm.password.value==""){
      	document.getElementById("passworddiv").innerText="  비밀번호를 입력하세요";
      	document.writeForm.password.focus();
      	submitcheck = false;
      }
      if(pwdtest == false){
       	document.getElementById("passworddiv").innerText=" 비밀번호는 숫자+영어 혼합하고, 8글자 이상 15글자 이하이어야 합니다";
       	document.writeForm.password.focus();
       	submitcheck = false;
      }
      if(document.writeForm.repassword.value==""){
      	document.getElementById("repassworddiv").innerText="  비밀번호 확인을 입력하세요";
      	document.writeForm.repassword.focus();
      	submitcheck = false;
      }else if(document.writeForm.password.value != document.writeForm.repassword.value){
      	document.getElementById("repassworddiv").innerText="  비밀번호가 일치하지 않습니다";
      	document.writeForm.password.focus();
      	submitcheck = false;
      }
      if(document.writeForm.idcheck.value ==""){
      	document.getElementById("tiddiv").innerText= "  중복체크 하세요";
      	submitcheck = false;
      }
      if(document.writeForm.idcheck.value == 'false'){
      	document.getElementById("tiddiv").innerText= "  중복체크 하세요";
      	submitcheck = false;
      }	
      if(document.writeForm.name.value==""){
	   	  document.getElementById("namediv").innerText=" 이름을 입력하세요";
	   	  document.writeForm.name.focus();
	   	submitcheck = false;
      }
      if(document.writeForm.birth.value == ""){
    	  document.getElementById("birthdiv").innerText=" 생년월일을 선택하세요";
    	  submitcheck = false;
      }
      
      var arrgender = document.writeForm.gender;
      var cnt = 0;
      for(var i=0; i<arrgender.length; i++){
    	  if(arrgender[i].checked){
    		  cnt +=1;
    	  }
      }
      if(cnt == 0){
    	 document.getElementById("genderdiv").innerText=" 성별을 체크하세요";
    	 submitcheck = false;
      }
      if(document.writeForm.email1.value == "" || document.writeForm.email2.value == "-"){
    	  document.getElementById("emaildiv").innerText=" 이메일을 입력하세요";
    	  document.writeForm.email1.focus();
    	  submitcheck = false;
      }
      if(document.writeForm.image.value == ""){
    	  document.getElementById("imagediv").innerText=" 사진 파일을 선택하세요";
    	  submitcheck = false;
      }
      if(document.writeForm.hp.value == ""){
    	  document.getElementById("hpdiv").innerText= " 휴대폰 번호를 입력하세요";
    	  document.writeForm.hp.focus();
    	  submitcheck = false;
      }
      if(document.writeForm.zipcode.value == ""){
    	  document.getElementById("zipcodediv").innerText=" 우편번호 검색하세요";
    	  submitcheck = false;
      }
      if(document.writeForm.address2.value == ""){
    	  document.getElementById("addressdiv").innerText=" 상세 주소를 입력하세요";
    	  document.writeForm.address2.focus();
    	  submitcheck = false;
      }
	  
      if(submitcheck == true){
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
      div#piddiv,div#pwddiv,div#repwddiv,div#imagediv,div#hpdiv,div#emaildiv,div#namediv,div#birthdiv,div#genderdiv,div#addressdiv,div#zipcodediv,div#studiv,div#relationshipdiv{
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
   <div class="card card-primary offset-sm-3 col-sm-6" id="empUpdate">
      <div class="card-body">
         <div class="card-title">
            <h1 align="center" align="center">회원가입</h1>
         </div>
          <form action="<%=YesForm %>" name="writeForm" method="post" enctype="multipart/form-data">
         	<input type="hidden" name="idcheck" value="false">
            <input type="hidden" name="command" value="empInsert">
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
               <label for="password" class="form-control-label col-sm-0">비밀번호</label>
               <div class="col-">
                  <input type="password" class="form-control" id="password" name="password">
               </div>
            <div class="form-group" id="passworddiv"></div>
            </div>
            <div class="form-group">
               <label for="password" class="form-control-label col-sm-0">비밀번호 확인</label>
               <div class="col-">
                  <input type="password" class="form-control" id="repassword" name="repassword">
               </div>
            </div>
            <div class="form-group" id="repassworddiv"></div>
            
            <div class="form-group">
               <label for="name" class="form-control-label col-sm-0">이름</label>
               <div class="col-">
                  <input type="text" class="form-control" id="name" name="name" value="${bean.name}">
               </div>
            </div>
             <div class="form-group" id="namediv"></div>
            <div class="form-group">
               <label for="birth" class="form-control-label col-sm-0">생년월일</label>
               <div class="col-6">
                  <input type="date" class="form-control" id="birth" name="birth">
               </div>
            </div>
             <div class="form-group" id="birthdiv"></div>
            <div class="form-group">
               <label for="gender" class="form-control-label col-sm-0">성별</label>
                  <div class="form-row">
                     <div class="col-1">
                        <input type="radio" class="form-control" id="gender" name="gender" value="남">
                     </div>
                     <label for="gender" class="form-control-label col-sm-0">&nbsp;남&nbsp;</label>
                     <div class="col-1">
                        <input type="radio" class="form-control" id="gender" name="gender" value="여">
                     </div>
                     <label for="gender" class="form-control-label col-sm-0">&nbsp;여&nbsp;</label>
               	</div>
            </div>
             <div class="form-group" id="genderdiv"></div>
            <div class="form-group">
               <label for="email" class="form-control-label col-sm-0">이메일</label>
               <div class="form-row">
                  <div class="col-5">
                     <input type="text" class="form-control" id="email1" name="email1" value="${bean.email}"> 
                  </div>
                  <label for="email" class="form-control-label col-sm-0">&nbsp;@&nbsp;</label>
                  <div class="col-5">
                     <select class="form-control" name="email2" id="email2">
                        <option value="-">---선택하세요
                        <option value="naver.com">naver.com
                        <option value="gmail.com">gmail.com
                        <option value="daum.net">daum.net         
                     </select>
                  </div>
               </div>
            </div>
             <div class="form-group" id="emaildiv"></div>
            <div class="form-group">
               <label for="hp" class="form-control-label col-sm-0">휴대폰</label>
               <div class="col-">
                  <input type="number" class="form-control" id="hp" name="hp" placeholder="ex)01012341234" value="${bean.hp}">
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
                     <input type="text" class="form-control" id="zipcode" name="zipcode" readonly>
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
                  <input type="text" class="form-control" id="address1" name="address1" readonly>
               </div>
            </div>
            <div class="form-group">
               <label for="address2" class="form-control-label col-sm-0">상세주소</label>
               <div class="col-">
                  <input type="text" class="form-control" id="address2" name="address2" value="${bean.address2}">
               </div>
            </div>
             <div class="form-group" id="addressdiv"></div>
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
            <div class="form-group" id="class_iddiv"></div>	
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
            <div class="form-group" id="subject_codediv"></div>	
                <div class="form-group form-row">
            	<div class = "col-6">
               		<input type="button" class="form-control btn btn-primary" onclick="javascript:checkWrite();" value="회원가입">
               </div>
               <div class = "col-6">
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