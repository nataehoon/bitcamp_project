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
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		function search(){
			var mode = $('#mode').val();
			var keyword = $('#keyword').val();
			location.href='<%=NoForm%>goList'+'&mode='+mode+'&keyword='+keyword;
		}
		function searchAll(){
			locatoin.gref='<%=NoForm%>goList';
		}
	</script>
   <style type="text/css">
      .badge{background:orange; color:red;}
      .form-inline{
         justify-content: flex-end;
      }
   </style>
</head>
<body>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
		<div class="container col-sm-offset-<%=offset%> col-sm-<%=mywidth%>">         
			<div class="panel panel-primary">
             <div class="panel-heading">
               <h4>학급 리스트</h4>
               <div class="search">
                  <tr>
                     <td align="center" colspan="11">
                        <form action="" class="form-inline" role="form" name="myform" method="get"> 
                           <div class="form-group">
                              <select id="mode" name="mode" class="form-control">
                                 <option value="all" selected="selected">-- 선택하세요.
                                 <option value="tid">선생님
                                 <option value="class_id">학급
                              </select>
                           </div>                           
                           <div class="form-group">
                              <input type="text" class="form-control" name="keyword" id="keyword"> 
                           </div>                           
                           &nbsp;&nbsp;
                           <button class="btn btn-primary" type="button" onclick="search();">검색</button>
                           &nbsp;&nbsp;
                           <button class="btn btn-primary" type="button" onclick="searchAll();">전체 검색</button>
                           &nbsp;&nbsp;
                           ${pageInfo.pagingStatus}                        
                        </form>
                     </td>
                  </tr>
               </div>
            <br>
               <table class="table table-hover">
					<thead>
						<tr>
							<th>학급 번호</th>
							<th>학급</th>
							<th>비고</th>
						</tr>
					</thead>
			  	 <tbody>
						<c:forEach var="bean" items="${requestScope.lists}">
							<tr onclick="location.href='<%=NoForm%>myclUpdate&myclass_id=${bean.class_id}';">
								<td>${bean.class_id}</td>
								<td>${bean.class_name}</td>
								<td>${bean.remark}</td>
							</tr>	
					</c:forEach>
				</tbody>
			</table>
						   &nbsp;&nbsp;
                           <button class="btn btn-primary" type="button" onclick="location.href='<%=NoForm%>myclInsert';">학급 추가하기</button>
                          
        </div> 
      </div>
    </div>

</div>
</body>
</html>