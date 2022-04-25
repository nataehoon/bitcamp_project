package kids.members.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.common.controller.SuperClass;
import kids.members.student.model.StudentDao;


public class DeleteStudentController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		int sid = Integer.parseInt(request.getParameter("sid")) ;
		
		StudentDao dao = new StudentDao();
		int cnt = -99999 ;
		cnt = dao.DeleteData(sid) ;
		
		new ListStudentController().doGet(request, response);
		
	}	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}
}

