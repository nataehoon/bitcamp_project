package kids.members.common.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.common.controller.SuperClass;

public class LogoutController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		super.session.invalidate();
		
		String gotopage = "/start.jsp" ;
		super.GotoPage(gotopage);
	}
} 
