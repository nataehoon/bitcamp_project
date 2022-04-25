<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>   
<!DOCTYPE>
<html>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

 <script type="text/javascript">
 	var mod_check = 'N';
 	
 	function openUpdate(empno, content){
 		
 		if(mod_check == 'Y')
			{
				alert('수정 중입니다.');
				return;
			}
 		 
 		document.getElementById('UpdateContent'+empno).innerHTML ="<div class='form-row'>"
 		+"<textarea rows='5' cols='120' name='updatecontent'>"+ content +"</textarea></div>"
 		+"<input type='hidden' name='empno_mod' value='" + empno +"'>"
 		+"<input style='float:right;' class='btn btn-default' type='button' onclick='location.reload()' value='취소'>"
 		+"<input style='float:right;' class='btn btn-default' type='submit' value='수정완료'>" ;
 		
 		mod_check = 'Y';
 	}	
 </script>
<head>
    <title>직원게시판</title>
    <style type="text/css">
        #wrap {
            width: 700px;
            margin: 0 auto 0 auto;
        }
        #comment{
            text-align :left;
        }
        #writeGestFrom, #listGestFrom{
            text-align :center;
        }
    </style>
</head>
<body>
 <div class="d-sm-flex align-items-center justify-content-between mb-4">
   <div class="container col-sm-offset-4 col-sm-8">
         <div class="panel panel-primary">
             <div class="row card-header py-3" style="background-color:white;">
             	<br>
               <h4>직원 게시판</h4>
               <br>
			    <!-- 글 등록 부분 시작-->
			    <div id="emploBoard">
			        <form method="post" action="<%=YesForm%>">
			        <input type="hidden" name="command" value="empbInsert">
			            <table>
			                <tr>
			                    <td>작성자&nbsp;&nbsp;&nbsp;<input type="text" name="facktid" disabled="disabled" value="${sessionScope.loginfo.name}(${sessionScope.loginfo.tid})"></td>
			                    <td><input type="hidden" name="tid" id="tid" value="${sessionScope.loginfo.tid}"></td>
			                </tr>
			                <tr>
			                    <td colspan="2">
			                        <textarea rows="5" cols="140" name="content"></textarea>
			                    </td>
			                </tr>
			            </table>
			            <br>
			            <input style="float:right;" class="btn btn-primary" type="submit" value="등록">
			        </form>
			    </div>
			    <!-- 글 등록 부분 끝-->
			 
			    <br><br>
			    <!-- 글 목록 부분 시작 -->
			    <div class="row card-body" id="emploBoardList">
			    	<form name="myform" method="post" action="<%=YesForm%>">
			    	<input type="hidden" name="command" value="empbUpdate">
			            <div id="comment">
			            	<c:forEach var="bean" items="${requestScope.lists}">
			                <hr size="1" width="1000">
			                <input type="hidden" name="empno" value="${bean.empno}">
			                 <input type="hidden" name="content" value="${bean.content}">
			                <label>아이디&nbsp;:&nbsp;${bean.tid}</label>
			                <c:if test="${sessionScope.loginfo.tid == bean.tid || sessionScope.loginfo.tid == 'admin'}">
			                <span style="float:right;">
								<!-- <a href="<%=NoForm%>empbReply&empno=${bean.empno}&tid=${sessionScope.loginfo.tid}">답글</a>&nbsp; -->
			                	<c:if test="${sessionScope.loginfo.tid == bean.tid}">
				                <a href="#" onclick="openUpdate(${bean.empno},'${bean.content}' )">수정</a>&nbsp;
				                </c:if>
				                <a href="<%=NoForm%>empbDelete&empno=${bean.empno}">삭제</a><br>
			                 </span>
			                 </c:if>
			                 <div id="UpdateContent${bean.empno}" >
			                 	 <textarea class="form-control" style="background-color:#EDFFA9" rows="3" cols="100" readonly="readonly">${bean.content}</textarea>
			                 </div>
			                 <br>
			                 </c:forEach>
			                 <hr size="1" width="1000">
			            </div>
			        </form>	
			     </div>
			      <!-- 글 목록 부분 끝 -->
			</div>
          </div>
           <div style="width: 30%; float:none; margin:0 auto" >
			<p style="width: 100%">${pageInfo.pagingHtml}</p>
		  </div>
          </div>
      </div>
</body>
</html>