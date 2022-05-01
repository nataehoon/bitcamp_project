<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String myContext = request.getContextPath();

	String myurl = request.getRequestURL().toString();
	String uri = request.getRequestURI();
	int idx = myurl.indexOf(uri);

	//웹 서버의 이미지를 올릴 경로
	String uploadPath = "/WEB-INF/upload/";
	String uploadedFolder = myurl.substring(0, idx) + myContext
			+ uploadPath;	
	
	String realPath1 =  application.getRealPath( uploadPath ) ;
	out.print(realPath1) ;
%>