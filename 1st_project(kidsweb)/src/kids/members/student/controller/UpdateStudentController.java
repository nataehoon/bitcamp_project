package kids.members.student.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.common.controller.SuperClass;
import kids.members.student.model.Student;
import kids.members.student.model.StudentDao;

public class UpdateStudentController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		Student bean = null ;
		StudentDao dao = new StudentDao() ;
		String data = dao.toString() ;
		
		int sid = Integer.parseInt(request.getParameter("sid")) ;
		
		List<Student> lists = new ArrayList<Student>() ;
		
		request.setAttribute("bean", bean);
		
		String gotopage = "/kids/main.jsp" ;
		super.GotoPage(gotopage);
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}
}
