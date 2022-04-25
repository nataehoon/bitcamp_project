package kids.board.activity.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.board.activity.model.Activity;
import kids.board.activity.model.ActivityDao;
import kids.common.controller.SuperClass;

public class ListActivityController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		Date date = new Date();
		SimpleDateFormat form = new SimpleDateFormat("yyyy/MM/dd");
		String today = form.format(date);
		
		 ActivityDao dao = new ActivityDao(); 
		 List<Activity> lists = dao.SelectDataList();
		 
		 request.setAttribute("today", today);
		 request.setAttribute("lists", lists);
		 
		 System.out.println("lists sizs : " + lists.size());
		
		String gotopage = "/activity/acList.jsp" ;
		super.GotoPage(gotopage);
	}
	
	
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
	}
}
