<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.content{
		border: 1px dotted #CECECE;
	}
	.content img{
		max-width: 100%;
	}
	.comments ul{
		padding: 0;
		margin: 0;
		list-style-type: none;
	}
	.comments ul li{
		border-top: 1px solid #888;
	}
	.comments dt{
		margin-top: 5px;
	}
	.comments dd{
		margin-left: 26px;
	}
	comments form textarea{
		width: 85%;
		height: 100ox;
	}
	.comment form{
		display: none;
	}
	.comment{
		position: relative;
	}
	.comment .reply_icon{
		width: 8px;
		height: 8px;
		positiob: absolute;
		top: 10px;
		left: 30px;
	}
	.comments .user-img{
		width: 20px;
		height: 20px;
		border-radius: 50%;
	}
	.err{
		color: red;
	}
</style>
<script type="text/javascript">
	function deletalert(cono){
		if(confirm("댓글을 삭제 하시겠습니까?")){
			alert('댓글이 삭제 되었습니다.');
			location.href='<%=contextPath%>/codelete.bo?cono=' + cono;
		}
	}
	var mod_check = 'N';
	
	function update(cono, content){
		if(mod_check == 'Y'){
			alert('수정 중입니다.');
			return;
		}
		
		document.getElementById('updatecontent'+cono).innerHTML = "<textarea rows='3' cols='110' name='content'>" + content + "</textarea>"
			+"<input type='hidden' name='cono' value='" + cono + "'>"
			+"<input class='btn btn-danger' type='submit' value='수정 완료'>"
			+"<input class='btn btn-danger' onclick='' value='취소'>";
			
			mod_check = 'Y';
	}
	
	$(document).on("click","button[name='reply']", function(){
		
		$("#").remove();
		
	});
	function recommendBtn(bono){
		if(confirm("해당 글을 추천하시겠습니까?")){
			location.href='<%=contextPath%>/borecommend.bo?bono=' + bono;
		}
		
	};
</script>
</head>
<c:set var="appath" value="<%=contextPath%>"/>
<body>
<div class="container-fluid col-sm-offset-2 col-sm-8">
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h4 class="font-weight-bold text-primary">${bean.category} 게시판</h4>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered">
					<tr>
						<td width="10%" align="center">제목</td>
						<td width="90%" align="left">
							${bean.title}<p style="float:right;">글 번호 : ${bean.bono} &nbsp;&nbsp; 작성자 : ${bean.nickname} &nbsp;&nbsp; 조회수 : ${bean.readhit} &nbsp;&nbsp; 추천수 : ${bean.recommend}</p>
						</td>
					</tr>
					<tr>
						<td width="25%" align="center">등록일자</td>
						<td width="75%" align="left">${bean.regdate}</td>
					</tr>
					<tr>
						<td width="25%" align="center" colspan="2">
						<c:if test="${bean.image != null}">
						<img src="./upload/${bean.image}" class="img-rounded" width="100%" height="500">
						</c:if>
						<textarea class="form-control" readonly="readonly"style="float:left;width:100%;height:600px">${bean.content}</textarea></td>
					</tr>
				</table>
				<div align="center">
					<button class="btn btn-danger" onclick="recommendBtn(${bean.bono});">
						 <i class="fas fa-fw fa-thumbs-up" style="color:blue"></i>
                    	<span>추천</span>
					</button>
				</div>
			</div>
		</div>
		<c:if test="${sessionScope.loginfo.id == bean.id}">
		<div class="col-sm-12" align="right">
			<button class="btn btn-info" onclick="location.href='<%=contextPath%>/update.bo?bono=${bean.bono}'">
				글 수정
			</button>
			<button class="btn btn-danger" onclick="location.href='<%=contextPath%>/delete.bo?bono=${bean.bono}'">
				글 삭제
			</button>
		</div>
		</c:if>
		<hr>
		<div class="comments">
			<div class="comment-form" align="center" style="">
				<form:form modelAttribute="comment" role="form" action="${appath}/coinsert.bo" method="post">
					<input type="hidden" name="bono" value="${bean.bono}">
					<input type="hidden" name="id" value="${sessionScope.loginfo.id}">
					<c:if test="${empty sessionScope.loginfo.id}">
					<a href="<%=contextPath%>/login.me">
					<textarea rows="5" cols="140" class="content" name="content" id="content">로그인이 필요합니다.</textarea>
					</a>
					</c:if>
					<c:if test="${loginstatus != 0}">
					<textarea rows="5" cols="140" class="content" name="content" id="content"></textarea>
					</c:if>
					<div style="float:right;margin-right:5%;">
					<button class="btn btn-danger" type="submit">댓글 등록</button>
					</div>
				</form:form>
			</div>
		</div>
		<div class="comment-list ml-4 mr-4 col-sm-11">
			<form:form modelAttribute="comment" role="form" action="${appath}/coupdate.bo" method="post">
			<c:forEach var="cbean" items="${requestScope.clists}">
			<input type="hidden" name="bono" value="${cbean.bono}">
			<hr>
			<div class="row">
				<div class="col-sm-2"><p style="margin-right:10px;margin-top:25px;">${cbean.id}</p></div>
				<div class="col-sm-10" id="updatecontent${cbean.cono}"><textarea rows="3" cols="110" class="content" readonly="readonly" id="content">${cbean.content}</textarea></div>
			</div>
			<div class="row" style="float:right;margin-right:3%;">
				<c:if test="${sessionScope.loginfo.id == cbean.id}">
				<button class="btn btn-danger" type="button" onclick="update(${cbean.cono}, '${cbean.content}');">수정</button>&nbsp;
				<button class="btn btn-danger" onclick="deletalert(${cbean.cono});">삭제</button>&nbsp;
				</c:if>
				<!-- <button class="btn btn-danger" id="reply" name="reply">답글</button> -->
			</div>
			<br>
			</c:forEach>
			<hr>
			</form:form>
		</div>
	</div>
</div>
</body>
</html>