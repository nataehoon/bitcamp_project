package kids.members.employees.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.common.controller.SuperClass;

public class EmpJoinController extends SuperClass {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
			
		String gotopage = "/employees/empJoinForm.jsp" ;
		super.GotoPage(gotopage);
	}	
}
