package kids.members.common.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.common.controller.SuperClass;
import kids.members.employees.model.EmployeesDao;

public class SubmitUpdateController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		String tid = request.getParameter("tid") ;
		
		System.out.println(tid);
		
		EmployeesDao dao = new EmployeesDao();
		int cnt = - 999999 ;
		cnt = dao.SubmitUpdate(tid);
		
		new SubmitController().doGet(request, response);
		
	}	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}
}
