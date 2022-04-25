package kids.management.subject.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.common.controller.SuperClass;
import kids.management.subject.model.Subject;
import kids.management.subject.model.SubjectDao;

public class UpdateSubjectController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
	
		Subject bean = null ;
		SubjectDao dao = new SubjectDao() ;
		String data = dao.toString() ;
		
		int subject_code = Integer.parseInt(request.getParameter("subject_code")) ;
		
		List<Subject> lists = new ArrayList<Subject>() ;
		
		request.setAttribute("bean", bean);
		
		String gotopage = "/subject/UpdateSubject.jsp" ;
		super.GotoPage(gotopage);
	
	}
	
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
	}
} 
