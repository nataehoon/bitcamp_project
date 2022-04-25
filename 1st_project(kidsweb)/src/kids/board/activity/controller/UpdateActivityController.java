package kids.board.activity.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.board.activity.model.Activity;
import kids.board.activity.model.ActivityDao;
import kids.common.controller.SuperClass;

public class UpdateActivityController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		Activity bean = null ;
		ActivityDao dao = new ActivityDao() ;
		String data = dao.toString() ;
		
		List<Activity> lists = new ArrayList<Activity>() ;
		
		request.setAttribute("bean", bean);
		
		String gotopage = "/activity/acUpdate.jsp" ;
		super.GotoPage(gotopage);
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}
}

