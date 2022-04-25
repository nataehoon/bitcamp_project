<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		function search(){
			var mode = $('#mode').val();
			var keyword = $('#keyword').val();
			location.href='<%=NoForm%>empList'+'&mode='+mode+'&keyword='+keyword;
		}
		function searchAll(){
			locatoin.gref='<%=NoForm%>empList';
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
   <div class="container col-sm-offset-2 col-sm-10">
        <div class="card shadow mb-4">
            <div class="card-header">
               <h4 class="font-weight-bold text-primary">직원 목록</h4>
               <div class="card-body">
                <table class="table">
                <thead>
                  <tr>
                  	 <td align="center" colspan="11">
                        <form action="" class="form-inline" role="form" name="myform" method="post"> 
                           <div>${pageInfo.pagingStatus}</div>
                          &nbsp;&nbsp;
                           <div class="form-group">
                             <select class="form-control" id="mode" name="mode">
				        		<option value="-">--- 선택하세요.</option>
			        			<option value="tid">아이디</option>
			        			<option value="name">이름</option>
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
                        </form>
                     </td>
                  </tr>   
	             </thead> 
					 <tbody>
						<tr>
							<th>아이디</th>
							<th>이름</th>
							<th>성별</th>
							<th>핸드폰 번호</th>
							<th>이메일</th>
							<th>학급</th>
							<th>직급</th>
						</tr>
					</tbody>
			  		<tfoot>
						<c:forEach var="bean" items="${requestScope.lists}">
							<tr onclick="location.href='<%=NoForm%>empmDetail&tid=${bean.tid}&${requestScope.parameters}'">
								<td>${bean.tid}</td>
								<td>${bean.name}</td>
								<td>${bean.gender}</td>
								<td>${bean.hp}</td>
								<td>${bean.email}</td>
								<td>${bean.class_name}</td>
								<td>${bean.responsibilities}</td>
							</tr>	
						</c:forEach>
					</tfoot>	
			 	</table>
       		 </div> 
    	  </div>
    	</div>
    	 <div style="width: 30%; float:none; margin:0 auto" >
		<p style="width: 100%">${pageInfo.pagingHtml}</p>
	  </div>
	 </div>
</div>
</body>
</html>