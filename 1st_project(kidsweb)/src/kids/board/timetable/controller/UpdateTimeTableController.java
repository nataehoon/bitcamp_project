package kids.board.timetable.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.board.timetable.model.Timetable;
import kids.board.timetable.model.TimetableDao;
import kids.common.controller.SuperClass;


public class UpdateTimeTableController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		Timetable bean = null ;
		TimetableDao dao = new TimetableDao() ;
		String data = dao.toString() ;
		
		int sid = Integer.parseInt(request.getParameter("sid")) ;
		
		List<Timetable> lists = new ArrayList<Timetable>() ;
		
		request.setAttribute("bean", bean);
		
		String gotopage = "/timetable/timeupdate.jsp" ;
		super.GotoPage(gotopage);
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}
}
