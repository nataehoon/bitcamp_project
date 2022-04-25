<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>   
   <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>유치원 회원정보 수정</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
   <script type="text/javascript">
   
   function checkWrite(){
	  	  var submitcheck = true;
	  	  
	      document.getElementById("pwddiv").innerText="";
	      document.getElementById("repwddiv").innerText="";
	      document.getElementById("namediv").innerText="";
	      document.getElementById("birthdiv").innerText="";
	      document.getElementById("genderdiv").innerText="";
	      document.getElementById("emaildiv").innerText="";
	      document.getElementById("hpdiv").innerText="";
	      document.getElementById("imagediv").innerText="";
	      document.getElementById("zipcodediv").innerText="";
	      document.getElementById("addressdiv").innerText="";
	      document.getElementById("studiv").innerText="";
	      document.getElementById("relationshipdiv").innerText="";
	      
	      var pwd = document.writeForm.password.value
	      var engNum = /(?=.*\d)(?=.*[a-z]).{8,15}/; //영어소문자+숫자 혼합. 8글자이상 15글자 이하
	      var pwdtest = engNum.test(pwd);
	      console.log('pwdtest :'+pwdtest);
	     

	      if(document.writeForm.password.value==""){
	      	document.getElementById("pwddiv").innerText="  비밀번호를 입력하세요";
	      	document.writeForm.password.focus();
	      	submitcheck=false;
	      }
	      if(pwdtest == false){
	       	document.getElementById("pwddiv").innerText=" 비밀번호는 숫자+영어 혼합하고, 8글자 이상 15글자 이하이어야 합니다";
	       	document.writeForm.password.focus();
	       	submitcheck=false;
	      }
	      if(document.writeForm.repassword.value==""){
	      	document.getElementById("repwddiv").innerText="  비밀번호 확인을 입력하세요";
	      	document.writeForm.repassword.focus();
	      	submitcheck=false;
	      }else if(document.writeForm.password.value != document.writeForm.repassword.value){
	      	document.getElementById("repwddiv").innerText="  비밀번호가 일치하지 않습니다";
	      	document.writeForm.password.focus();
	      	submitcheck=false;
	      }
	      
	      if(document.writeForm.name.value==""){
		   	  document.getElementById("namediv").innerText=" 이름을 입력하세요";
		   	  document.writeForm.name.focus();
		   	  submitcheck=false;
	      }
	      if(document.writeForm.birth.value == ""){
	    	  document.getElementById("birthdiv").innerText=" 생년월일을 선택하세요";
	    	  submitcheck=false;
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
	    	 submitcheck=false;
	      }
	      if(document.writeForm.email1.value == "" || document.writeForm.email2.value == "-"){
	    	  document.getElementById("emaildiv").innerText=" 이메일을 입력하세요";
	    	  document.writeForm.email1.focus();
	    	  submitcheck=false;
	      }
	      
	      if(document.writeForm.hp.value == ""){
	    	  document.getElementById("hpdiv").innerText= " 휴대폰 번호를 입력하세요";
	    	  document.writeForm.hp.focus();
	    	  submitcheck=false;
	      }
	      if(document.writeForm.zipcode.value == ""){
	    	  document.getElementById("zipcodediv").innerText=" 우편번호 검색하세요";
	    	  submitcheck=false;
	      }
	      if(document.writeForm.address2.value == ""){
	    	  document.getElementById("addressdiv").innerText=" 상세 주소를 입력하세요";
	    	  document.writeForm.address2.focus();
	    	  submitcheck=false;
	      }
		  if(document.writeForm.sid.value ==""){
			 document.getElementById("studiv").innerText=" 원생 등록(원생찾기 버튼 클릭) 해주세요"
		     submitcheck=false;
		  }
		  
		  var arrrel = document.writeForm.relationship;
		  var cnt2 = 0;
		  for(var i=0; i<arrrel.length; i++){
			  if(arrrel[i].checked){
				  cnt2 +=1;
			  }
		  }
	      if(cnt2 ==0){
	    	  document.getElementById("relationshipdiv").innerText=" 원생과의 관계를 체크하세요";
	    	  submitcheck=false;
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

	    function add_input(){
			document.getElementById('second').value='second';
			document.getElementById('btnfirst').onclick = null;
			document.getElementById('searchfirst').onclick = null;
		
	     	 document.getElementById('childsecond').innerHTML ="<div class='form-row' id='deleteid'><div class='col-'>"
	      	+"<input type='text' name='childid' class='form-control' value='${requestScope.bean.childid}' readonly></div><div class='col-'>"
	         +"<input type='button' class='form-control btn btn-primary' id=searchsecond value='원생 찾기' onclick='stSearch();'>"
	         +"</div><div class='col-'>"
	         +"<input type='button' class='btn btn-secondary' onclick='add_input2();' id='btnsecondadd' value='추가'> </div> <div class='col-'>"
	         +"<input type='button' class='btn btn-danger' onclick='delete_input();' id='btnsecond' value='삭제'> </div> </div>";
	   }
	   
	   function add_input2(){
		  	 document.getElementById('third').value='third';
		 	 document.getElementById('btnsecond').onclick = null;
		 	 document.getElementById('btnsecondadd').onclick = null;
		 	 document.getElementById('searchsecond').onclick = null;
		 	 
	     	 document.getElementById('childthird').innerHTML ="<div class='form-row' id='deleteid2'><div class='col-'>"
	         +"<input type='text' name='childid2' class='form-control' value='${requestScope.bean.childid2}' readonly></div><div class='col-'>"
	         +"<input type='button' class='form-control btn btn-primary' value='원생 찾기' onclick='stSearch();'>"
	         +"</div><div class='col-'>"
	         +"<input type='button' class='btn btn-danger' onclick='delete_input2();' value='삭제'></div> </div>";
	   }
	   
	   function delete_input(){
		   	document.getElementById('second').value="";
	      	document.getElementById('deleteid').outerHTML = "";
	      	document.getElementById('btnfirst').onclick = add_input;
	      	document.getElementById('searchfirst').onclick = stSearch;
	   }
	   
	   function delete_input2(){
		   	document.getElementById('third').value="";
	      	document.getElementById('deleteid2').outerHTML = "";
	      	document.getElementById('btnsecond').onclick = delete_input;
	      	document.getElementById('btnsecondadd').onclick = add_input2;
	      	document.getElementById('searchsecond').onclick = stSearch;
	   }
	   
	   function stSearch(){
	      var url = '<%=NoForm%>paStSearch';
	      window.open(url, 'stsearch', 'height=200, width=330, menubar=no, location=no, left=400, top=200');
		}
	   
	   window.onload=function(){
		   document.writeForm.gender['${requestScope.genderCheck}'].checked = true;
		   document.wrteForm.relationship['${requestScope.relCheck}'].checked = true;
		  
		   //select box가 문제로구나........
		   //var value ="${requestScope.email2}"; 
		   //$(#email2).val('value').attr("selected", "selected");
		   //s.options[s.selectedIndex].value;
		   
		  //$("#email2").val("${requestScope.email2}").prop("selected", true);
		  //document.writeForm.email2.value = '${requestScope.email2}';
		  // $("#email2 option:eq(2)").prop("selected", true);

		//   var s = document.writeForm.getElementById('email2');
		//	s.options[s.selectedIndex].value = '${requestScope.email2}';
		  // $("#email2 option:eq(2)").attr("selected", "selected");

	   }
  
//골칫거리	   
//    window.onload=function(){
//	   	alert('gender '+${requestScope.bean.gender == '여'});
//    	alert('gender 남 :'+${requestScope.bean.gender == '남'} );
    	
//    	document.writeForm.relationship[3].checked = true;
    	
//	 	if("${requestScope.bean.gender == '남'}"){
// 			document.writeForm.gender[0].checked = true;
//  		}else if("${requestScope.bean.gender == '여'}"){
// 			document.writeForm.gender[1].checked = true;
//  		} // 도대체 왜 선태되는거지??????? if가 false일때도....
    	
//    	alert('relationship '+${requestScope.bean.relationship == '아버지'});


//참고 

 		// 조건문이 안먹음...지금보니...
 		// 업데이트 할때 파일 유효성 검사에서 제거하자. 새로 업로드 추가했을 때만 되도록.
// 		var state1 = '${not empty requestScope.childid2}';
// 		var state2 = '${not empty requestScope.childid}';
 //		alert('state1 : '+state1);
// 		alert('state2 : '+state2);
//   		if(state1){ //false인데 왜 실행되는거야ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠ
//   			add_input();
//   			alert('실행1');
//   			add_input2();
//   			alert('실행2');
//   		}else if(state2){
//   			add_input();
//   			alert('실행3');
//   		}
//    }
    
   </script>
   <style type="text/css">
      div#pwddiv,div#repwddiv,div#hpdiv,div#emaildiv,div#namediv,div#birthdiv,div#genderdiv,div#addressdiv,div#zipcodediv,div#studiv,div#relationshipdiv{
         color:red;
         font-size:10pt;
         font-weight:bold;
         padding-left:5px;
      }
      div#imagediv{
        color:green;
         font-size:10pt;
         font-weight:bold;
         padding-left:5px;
      }
   </style>
   
</head>
<body>
   <br>
   <br>
   <div class="card card-primary offset-sm-3 col-sm-6" id="paUpdateTwo">
      <div class="card-body">
         <div class="card-title">
            <h1 align="center" align="center">회원 정보 수정</h1>
         </div>
         <form action="<%=YesForm %>" name="writeForm" method="post" enctype="multipart/form-data">
            <input type="hidden" name="command" value="paUpdateTwo">
            <input type="hidden" name="page" value="update">
                <div class="form-group">
               <label for="pid" class="form-control-label col-sm-0">아이디</label>
               <div class="form-group">
                    <input type="text" class="form-control" id="pid" name="pid" value="${requestScope.bean.pid }" readonly>
                    <input type="hidden" name="idcheck" value="">
               </div>
            </div>
            <div class="form-group">
               <label for="password" class="form-control-label col-sm-0">비밀번호</label>
               <div class="col-">
                  <input type="password" class="form-control" id="password" name="password">
               </div>
            <div class="form-group" id="pwddiv"></div>
            </div>
            <div class="form-group">
               <label for="password" class="form-control-label col-sm-0">비밀번호 확인</label>
               <div class="col-">
                  <input type="password" class="form-control" id="repassword" name="repassword">
               </div>
            </div>
            <div class="form-group" id="repwddiv"></div>
            <div class="form-group">
               <label for="name" class="form-control-label col-sm-0">이름</label>
               <div class="col-">
                  <input type="text" class="form-control" id="name" name="name" value="${requestScope.bean.name }">
               </div>
            </div>
            <div class="form-group" id="namediv"></div>
            <div class="form-group">
               <label for="birth" class="form-control-label col-sm-0">생년월일</label>
               <div class="col-">
                  <input type="date" class="form-control" id="birth" name="birth" value="${requestScope.bean.birth }">
               </div>
            </div>
            <div class="form-group" id="birthdiv"></div>
            <div class="form-group">
               <label for="gender" class="form-control-label col-sm-0">성별</label>
                  <div class="form-row">
                     <div class="col-">
                        <input type="radio" class="form-control" name="gender" value="남">
                        <label for="gender" class="form-control-label col-sm-0">&nbsp;남&nbsp;</label>
                     </div>
                     <div class="col-">
                        <input type="radio" class="form-control" name="gender" value="여">
                        <label for="gender" class="form-control-label col-sm-0">&nbsp;여&nbsp;</label>
                     </div>
               </div>
            </div>
            <div class="form-group" id="genderdiv"></div>
            <div class="form-group">
               <label for="email" class="form-control-label col-sm-0">이메일</label>
               <div class="form-row">
                  <div class="col-5">
                     <input type="text" class="form-control" id="email1" name="email1" value="${requestScope.email1 }"> 
                  </div>
                  <label for="email" class="form-control-label col-sm-0">&nbsp;@&nbsp;</label>
                  <div class="col-5">
                     <select class="form-control" name="email2" id="email2" >
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
                  <input type="number" class="form-control" id="hp" name="hp" value="${requestScope.bean.hp }">
               </div>
            </div>
            <div class="form-group" id="hpdiv"></div>
            <input type="hidden" name="image" value="${requestScope.bean.image }">
            
            <div class="form-group">
               <label for="image" class="form-control-label col-sm-0">사진</label>
               <div class="col-">
                  <input type="file" class="form-control-file border" id="fakeimage" name="fakeimage">
               </div>
            </div>
            <div class="form-group" id="imagediv">현재 사진 파일 : ${requestScope.bean.image}</div>
            <div class="form-group">
               <label for="zipcode" class="form-control-label col-sm-0" >우편번호</label>
               <div class="form-row">
                  <div class="col-">
                     <input type="text" class="form-control" id="zipcode" name="zipcode" readonly value="${requestScope.bean.zipcode }">
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
                  <input type="text" class="form-control" id="address1" name="address1" readonly value="${requestScope.bean.address1 }">
               </div>
            </div>
            <div class="form-group">
               <label for="address2" class="form-control-label col-sm-0">상세주소</label>
               <div class="col-">
                  <input type="text" class="form-control" id="address2" name="address2" value="${requestScope.bean.address2 }">
               </div>
            </div>
            <div class="form-group" id="addressdiv"></div>
            <div class="form-group" id="childadd">
               <label for="sid" class="form-control-label col-sm-0">자녀등록</label>
               <div class="form-row">
                  <div class="col-">
                     <input type="text" class="form-control" id="sid" name="sid" readonly value="${requestScope.bean.sid }">
                  </div>
                  <div class="col-">
                     <input type="button" class="form-control btn btn-primary" id="searchfirst" value="원생 찾기" onclick="stSearch();">
                     <input type="hidden" name="first" value="first" id="first">
                  	 <input type="hidden" name="second" id="second">
                     <input type="hidden" name="third" id="third">
                  </div>
                  <div class="col-">
                     <button class="btn btn-secondary" id ="btnfirst" onclick="add_input();">추가</button>
                  </div>
               </div>
            </div>
             <div id="childsecond" class="form-group">
             </div>
             <div id="childthird" class="form-group">
             </div>
            <div class="form-group" id="studiv"></div>
            <div class="form-group">
               <label for="relationship" class="form-control-label col-sm-0">원생과의 관계</label>
               <div class="form-row">
                  <div class="col-1">
                     <input type="radio" class="form-control" name="relationship" value="아버지">
                  </div>
                  <label for="relationship" class="form-control-label col-sm-0">&nbsp;아버지&nbsp;</label>
                  <div class="col-1">
                     <input type="radio" class="form-control" name="relationship" value="어머니">
                  </div>
                  <label for="relationship" class="form-control-label col-sm-0">&nbsp;어머니&nbsp;</label>
                  <div class="col-1">
                     <input type="radio" class="form-control" name="relationship" value="조부모님">
                  </div>
                  <label for="relationship" class="form-control-label col-sm-0">&nbsp;조부모&nbsp;</label>
                  <div class="col-1">
                     <input type="radio" class="form-control" name="relationship" value="보호자님">
                  </div>
                  <label for="relationship" class="form-control-label col-sm-0">&nbsp;기타&nbsp;</label>   
               </div>
            </div>
             <div class="form-group" id="relationshipdiv"></div>
            <br>
            <div class="form-group">
           		<input type="button" class="form-control btn btn-primary" onclick="javascript:checkWrite();" value="회원정보 수정">
            </div>
         </form>
      </div>   
   </div>
   <br>
   <br>
</body>
</html>