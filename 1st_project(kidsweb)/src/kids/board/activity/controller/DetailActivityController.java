package kids.board.activity.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.board.activity.model.Activity;
import kids.board.activity.model.ActivityDao;
import kids.common.controller.SuperClass;


public class DetailActivityController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		int actino = Integer.parseInt(request.getParameter("actino")) ;
		
		ActivityDao dao = new ActivityDao();
		Activity bean = dao.SelectDataByPk(actino) ;

		request.setAttribute("bean", bean);
		
		String gotopage = "/activity/acDetail.jsp" ;
		super.GotoPage(gotopage);
	}	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}
}