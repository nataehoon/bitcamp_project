<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="./../common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>insert.jsp</title>
	<style type="text/css">
		.err{
			font-weight: bolder;
			font-size: 9pt;
			color: red;
		}
	</style>
</head>
<body>
	<h1><spring:message code="album.register"/></h1>
	<c:set var="xx" value="<%=myContext %>"/>
	<form:form modelAttribute="album" method="post" action="${xx}/insert.al" enctype="multipart/form-data" >
	<table>
		<tr>
			<td align="center">
				<spring:message code="album.albumname"/> 
			</td>
			<td align="left">
				<form:input path="albumname" value="푸른 하늘" />
				<form:errors path="albumname" cssClass="err" />
			</td>
		</tr>
		<tr>
			<td align="center">
				<spring:message code="album.image"/>
			</td>
			<td align="left">
				<input type="file" name="abcd">
				<form:errors path="abcd" cssClass="err" />
			</td>
		</tr>
		<tr>
			<td align="center">
				<spring:message code="album.song"/>
			</td>
			<td align="left">
				<form:input path="song" value="겨울 바다" />
				<form:errors cssClass="err" path="song" />				
			</td>
		</tr>		
		<tr>
			<td align="center">
				<spring:message code="album.lyricist"/>
			</td>
			<td align="left">
				<form:input path="lyricist" value="김건모" />
				<form:errors cssClass="err" path="lyricist" />				
			</td>
		</tr>
		<tr>
			<td align="center">
				<spring:message code="album.songwriter"/>
			</td>
			<td align="left">
				<form:input path="songwriter" value="윤이상" />
				<form:errors cssClass="err" path="songwriter" />				
			</td>
		</tr>
		<tr>
			<td align="center">
				<spring:message code="album.transcription"/>
			</td>
			<td align="left">
				<form:input path="transcription" value="윤종신" />
				<form:errors cssClass="err" path="transcription" />				
			</td>
		</tr>
		<tr>
			<td align="center">
				<spring:message code="album.writerdate"/>
			</td>
			<td align="left">
				<form:input path="writerdate" value="2014/08/15" />
				<form:errors cssClass="err" path="writerdate" />				
			</td>
		</tr>
		<tr>
			<td align="center">
				<spring:message code="album.genre"/>
			</td>
			<td align="left">
				<form:select path="genre">
					<form:options items="${genrelist}" itemLabel="mykey" itemValue="mykey"/>
				</form:select>				
				<form:errors cssClass="err" path="genre" />				
			</td>
		</tr>
		<tr>
			<td align="center">
				<spring:message code="album.mediatype"/>
			</td>
			<td align="left">
				<form:checkboxes items="${mediatypelist}" path="mediatype"
					itemLabel="mykey" itemValue="mykey" />
				<form:errors cssClass="err" path="mediatype" />				
			</td>
		</tr>
		<tr>
			<td align="center">
				<spring:message code="album.emailagree"/>
			</td>
			<td align="left">
				<form:radiobuttons items="${emailagreelist}" path="emailagree" 
						itemLabel="mykey" itemValue="mykey" />
				<form:errors cssClass="err" path="emailagree" />				
			</td>
		</tr>		
		<tr>
			<td colspan="2" align="center">
				<input type="submit" 
					value="<spring:message code="album.insert"/>"/>	
			</td>
		</tr>		
	</table>
	</form:form>	
</body>
</html>