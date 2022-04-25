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
			location.href='<%=NoForm%>meList'+'&mode='+mode+'&keyword='+keyword;
		}
		function searchAll(){
			locatoin.gref='<%=NoForm%>meList';
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
<div class="container col-sm-offset-2 col-sm-10">
 <div class="card shadow mb-4">
            <div class="card-header py-3">
               <h4 class="m-0 font-weight-bold text-primary">투약의뢰서 목록</h4>
            </div>
               <div class="card-body">
               <c:forEach var="bean" items="${requestScope.cn_lists}">
               		<c:if test="${whologin == 2}">
               			<c:if test="${loginfo.class_id == bean.class_id }">
               				<h2>${bean.class_name}반</h2>
               			</c:if>
               		</c:if>
               </c:forEach>
               <c:if test="${whologin == 3}">
               <h2>${sessionScope.loginfo.classname}반</h2>
               </c:if>
               <div class="search">
                  <tr>
                     <td align="center" colspan="11">
                        <form action="" class="form-inline" role="form" name="myform" method="get"> 
                           <div class="form-group">
                              <select id="mode" name="mode" class="form-control">
                                 <option value="all" selected="selected">-- 선택하세요.
                                 <option value="a.regdate">등록날짜
                                 <option value="b.name">이름
                                  <option value="a.checks">확인여부
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
							<th>번호</th>
							<th>등록날짜</th>
							<th>이름</th>
							<th>확인 여부</th>
						</tr>
					</thead>
			  	 <tbody>
						<c:choose>
							<c:when test="${whologin == 2 }">
							<c:forEach var="bean" items="${requestScope.lists}">
							<c:if test="${sessionScope.loginfo.tid == bean.tid}">
							<tr onclick="location.href='<%=NoForm%>meDetail&meno=${bean.meno}'">
								<td>${bean.meno}</td>
								<td>${bean.regdate}</td>
								<td>${bean.name}</td>
								<td>${bean.checks}</td>
							</tr>
							</c:if>	
							</c:forEach>
							</c:when>
							<c:when test="${whologin == 3 }">
							<c:forEach var="bean" items="${requestScope.lists}">
							<c:if test="${sessionScope.loginfo.pid == bean.pid}">
							<tr onclick="location.href='<%=NoForm%>meDetail&meno=${bean.meno}'">
								<td>${bean.meno}</td>
								<td>${bean.regdate}</td>
								<td>${bean.name}</td>
								<td>${bean.checks}</td>
							</tr>
							</c:if>	
							</c:forEach>
							</c:when>
						</c:choose>
				</tbody>
		 	</table>
		 	<div style="float:right">
							<c:choose>
								<c:when test="${whologin == 3}"> <!--학부모-->
									<button class="btn btn-primary" onclick="location.href='<%=NoForm%>meInsert'">
									글쓰기
									</button>
								</c:when>
							</c:choose>
						<!-- <c:if test="${whologin == 3 }"> 구현 완성하고 풀기 --> 
						<!-- </c:if> -->
				</div>		
        </div> 
    </div>
</div>
<%@ include file="./../common/footer.jsp" %>
</body>
</html>