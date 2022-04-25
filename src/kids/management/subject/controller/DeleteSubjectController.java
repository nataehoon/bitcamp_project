package kids.management.subject.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.common.controller.SuperClass;
import kids.management.subject.model.SubjectDao;

public class DeleteSubjectController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		int subject_code = Integer.parseInt(request.getParameter("subject_code")) ;
		SubjectDao dao = new SubjectDao() ;
		
		int cnt = -999999 ;  
		cnt = dao.DeleteData(subject_code) ;
		
		super.session.invalidate(); 
		
		new DeleteSubjectController().doGet(request, response);
		
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
	}
}
