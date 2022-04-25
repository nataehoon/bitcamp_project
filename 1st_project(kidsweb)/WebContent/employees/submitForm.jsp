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
			location.href='<%=NoForm%>submit'+'&mode='+mode+'&keyword='+keyword;
		}
		function searchAll(){
			locatoin.gref='<%=NoForm%>submit';
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
   <div class="container col-sm-offset-4 col-sm-8">
         <div class="panel panel-primary">
            <div class="panel-heading">
               <h4>가입 대기 목록</h4>
               <tbody class="search">
                  <tr>
                     <td align="center" colspan="11">
                        <form action="" class="form-inline" role="form" name="myform" method="get"> 
                           <div class="form-group">
                              <select id="mode" name="mode" class="form-control">
                                 <option value="all" selected="selected">-- 선택하세요.
                                 <option value="name">이름
                                 <option value="tid">아이디
                                  <option value="email">이메일
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
            </tbody>
            <br>
               <table class="table table-hover">
					<thead>
						<tr>
							<th>아이디</th>
							<th>이름</th>
							<th>성별</th>
							<th>핸드폰 번호</th>
							<th>이메일</th>
							<th>가입 상태</th>
							<th>가입 승인</th>
						</tr>
					</thead>
					<c:forEach var="bean" items="${requestScope.lists}">
						<tr>
							<td>${bean.tid}</td>
							<td>${bean.name}</td>
							<td>${bean.gender}</td>
							<td>${bean.hp}</td>
							<td>${bean.email}</td>
							<td>${bean.submit}</td>
							<td>
								<a href="<%=NoForm%>submitUpdate&tid=${bean.tid}&${requestScope.parameters}">가입 승인</a>
							</td>							
						</tr>							
					</c:forEach>		
				 </table>
             </div> 
          </div>
       </div>

</div>
</body>
</html>
<html>
<body>
<%@ include file="./../common/footer.jsp" %>
</body>
</html>