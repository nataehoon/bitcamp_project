package kids.board.timetable.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.board.timetable.model.Timetable;
import kids.board.timetable.model.TimetableDao;
import kids.common.controller.SuperClass;


public class ListTimeTableController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		TimetableDao dao = new TimetableDao();
		List<Timetable> lists = dao.SelectDataList(0, 0);
		
		String gotopage = "/timetable/timeList.jsp" ;
		super.GotoPage(gotopage);
	}
	
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}
}
