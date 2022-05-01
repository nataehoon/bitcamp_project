<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="./../common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>앨범 목록</title>
	<script type="text/javascript">
		function alldata() {
			location.href='<%=myContext %>/album/alldata' ;	
		}
		function partial() {
			location.href='<%=myContext %>/album/partial' ;	
		}
	</script>
</head>
<body>
<h3 align="center">앨범 목록 보여 주기 페이지</h3>
<table border="1" width="80%" align="center">
	<tr>
		<td colspan="12" align="right">
          	<input type="button" value="전부" onclick="alldata();"/>	
          	<input type="button" value="부분" onclick="partial();"/>
			<a href="<%=myContext %>/insert.al">등록</a>
		</td>
	</tr>
	<tr>
		<td colspan="9" align="center">
			<form action="<%=myContext %>/list.al" method="post">
				<select name="what">
					<option value="all">전체 검색
					<option value="albumname">앨범 제목
					<option value="song">노래
				</select>
				<input type="text" name="keyword" value="스무살">
				<input type="submit" value="검색">
			</form>
		</td>
		<td colspan="3" align="center">
			${pageInfo.pagingStatus}
		</td>		
	</tr>	
	<tr>
		<td align="center">번호</td>
		<td align="center">앨범명</td>
		<td align="center">노래</td>
		<td align="center">작사</td>
		<td align="center">작곡</td>
		<td align="center">편곡</td>
		<td align="center">날짜</td>
		<td align="center">장르</td>
		<td align="center">미디어 유형</td>
		<td align="center">이메일 수신 여부</td>
		<td align="center">삭제</td>
		<td align="center">수정</td>
	</tr>
	<c:forEach var="album" items="${albumLists}">
		<tr>
			<td align="center">${album.id}</td>
			<td align="center">${album.albumname}</td>
			<td>
				<a href="<%=myContext %>/detail.al?id=${album.id}">${album.song}</a>				
			</td>
			<td align="center">${album.lyricist}</td>
			<td align="center">${album.songwriter}</td>
			<td align="center">${album.transcription}</td>
			<td align="center">${album.writerdate}</td>
			<td align="center">${album.genre}</td>
			<td align="left">${album.mediatype}</td>
			<td align="center">${album.emailagree}</td>			
			<td align="center"><a href="<%=myContext %>/delete.al?id=${album.id}">삭제</a></td>
			<td align="center"><a href="<%=myContext %>/update.al?id=${album.id}">수정</a></td>
		</tr>
	</c:forEach>
</table>
<hr>
	<center>${pageInfo.pagingHtml}</center>	
<hr>
인터셉터를 이용하여 로그인하지 않았다면 다른 페이지로 이동하게 설정해 보세요.
</body>
</html>