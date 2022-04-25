<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>   
<!DOCTYPE>
<html>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<head>
    <title>직원게시판</title>
    <script type="text/javascript">
    	function openUpdate(empno){
    		document.getElementById('UpdateContent'+empno).innerHTML ="<br><div class='form-row'>"
    		+"<textarea rows='7' cols='80' name='updatecontent'></textarea></div>"
    		+"<input style='float:right;' class='btn btn-default' type='button' onclick='history.back();' value='취소'>"
    		+"<input style='float:right;' class='btn btn-default' type='submit' value='수정완료'>"
    	}
    </script>
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
    <br>
    <b><font size="6" color="gray">특별활동 게시판</font></b>
    <hr size="1" width="700">
    <br>
<div id="wrap">    
 
    <!-- 글 등록 부분 시작-->
    <div id="activityBoard">
        <form method="post" action="<%=YesForm%>">
        <input type="hidden" name="command" value="accoInsert">
            <table width="700">
                <tr>
                    <td>작성자</td>
                    <td><input type="text" name="facktid" disabled="disabled" value="${sessionScope.loginfo.name}(${sessionScope.loginfo.pid})"></td>
                    <td><input type="hidden" name="pid" id="pid" value="${sessionScope.loginfo.pid}"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <textarea rows="7" cols="80" name="content"></textarea>
                    </td>
                </tr>
            </table>
            <br>
            <input style="float:right;" type="submit" value="등록">
        </form>
    </div>
    <!-- 글 등록 부분 끝-->
 
    <br><br>
    <!-- 글 목록 부분 시작 -->
    <div id="accoList">
    	<form name="myform" method="post" action="<%=YesForm%>">
    	<input type="hidden" name="command" value="accoUpdate">
            <div id="comment">
            	<c:forEach var="bean" items="${requestScope.lists}">
                <hr size="1" width="700">
                <input type="hidden" name="actino" value="${bean.actino}">
                <label>이름&nbsp;:&nbsp;${bean.tpd}</label>
                <c:if test="${sessionScope.loginfo.pid == bean.tid || sessionScope.loginfo.pid == 'admin'}">
                <span style="float:right;">
					<!-- <a href="<%=NoForm%>empbReply&empno=${bean.empno}&tid=${sessionScope.loginfo.tid}">답글</a>&nbsp; -->
                	<c:if test="${sessionScope.loginfo.pid == bean.pid}">
	                <a href="#" onclick="openUpdate(${bean.actino});">수정</a>&nbsp;
	                </c:if>
	                <a href="<%=NoForm%>accoDelete&actino=${bean.actino}">삭제</a><br>
                 </span>
                 </c:if>
                 <div id="UpdateContent${bean.actino}" >
                 	내용&nbsp;:&nbsp;${bean.content}
                 </div>
                 <br>
                 </c:forEach>
                 <hr size="1" width="700">
            </div>
        </form>	
     </div>
      <!-- 글 목록 부분 끝 -->
</div>
     
</body>
</html>
<html>
<body>
<%@ include file="./../common/footer.jsp" %>
</body>
</html>