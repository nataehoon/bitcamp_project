package kids.members.employees.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.common.controller.SuperClass;
import kids.common.utility.FlowParameters;
import kids.members.employees.model.Employees;
import kids.members.employees.model.EmployeesDao;

public class DeleteEmployerController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		String tid = request.getParameter("tid");
		
		FlowParameters parameters = new FlowParameters(request.getParameter("pageNumber"), request.getParameter("mode"), request.getParameter("keyword"));
		System.out.println(parameters.toString());
		
		EmployeesDao dao = new EmployeesDao();
		
		int cnt = -99999;
		cnt = dao.DeleteData(tid);
		
		new ListEmployerIdController().doGet(request, response);
		
	}
} 
