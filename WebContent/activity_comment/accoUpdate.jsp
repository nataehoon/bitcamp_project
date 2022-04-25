<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String contextPath = request.getContextPath() ;
String mappingName = "/Kids" ;

String YesForm = contextPath + mappingName ;
String NoForm = contextPath + mappingName + "?command=" ;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		function Update(){
			document.getElment
		}
	</script>
</head>
<body>
	 <div id="activityBoard">
        <form name="myform" action="<%=YesForm%>" method="post">	
        <input type="hidden" name="command" value="activityUpdate">
            <table width="700">
                <tr>
                    <td>작성자</td>
                    <td><input type="text" name="facktid" disabled="disabled" value="${sessionScope.loginfo.name}(${sessionScope.loginfo.pid})"></td>
                    <td><input type="text" name="actino" id="actino" value="${bean.actino}"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <textarea rows="7" cols="80" name="content"></textarea>
                        <span class="text-danger">${errcontnent}</span>
                    </td>
                </tr>
            </table>
            <br>
            	<button style="float:right;" class="btn btn-primary" type="button" onclick="Update();">수정하기</button>
          </form>
  	  </div>
</body>
</html>
