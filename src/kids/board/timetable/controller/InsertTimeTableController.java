package kids.board.timetable.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kids.board.timetable.model.Timetable;
import kids.board.timetable.model.TimetableDao;
import kids.common.controller.SuperClass;


public class InsertTimeTableController extends SuperClass {
	private Timetable bean = null ;
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		String gotopage = "/timetable/timeInsert.jsp" ;
		super.GotoPage(gotopage);
	}


	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
		MultipartRequest multi = (MultipartRequest)request.getAttribute("multi") ;
		
		bean = new Timetable();
		bean.setTime(multi.getParameter("time"));
		bean.setDay(multi.getParameter("day"));
		bean.setRemark(multi.getParameter("remark"));
		
		if (multi.getParameter("time_id") != null && multi.getParameter("time_id").equals("") == false) {
			bean.setTime_id(Integer.parseInt(multi.getParameter("time_id")));	
		}
		
		if (multi.getParameter("subject_code") != null && multi.getParameter("subject_code").equals("") == false) {
			bean.setSubject_code(Integer.parseInt(multi.getParameter("subject_code")));	
		}
		
		if (multi.getParameter("class_id") != null && multi.getParameter("class_id").equals("") == false) {
			bean.setClass_id(Integer.parseInt(multi.getParameter("class_id")));	
		}		 
		if (this.validate(request) == true) {
			System.out.println("product insert validation check success");
			TimetableDao dao = new TimetableDao() ;
			
			int cnt = -99999 ;
			cnt = dao.InsertData(bean) ;
			
			new ListTimeTableController().doGet(request, response);
			
		} else {
			System.out.println("timetable insert validation check failure");			
			request.setAttribute("bean", bean); 			
			super.doPost(request, response);			
			String gotopage = "/timetable/InsertTimeTable.jsp" ;
			super.GotoPage(gotopage);
		}
	}
}