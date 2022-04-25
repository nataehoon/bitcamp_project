package kids.board.timetable.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.board.timetable.model.TimetableDao;
import kids.common.controller.SuperClass;


public class DeleteTimeTableController extends SuperClass {
		@Override
		public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			super.doGet(request, response);
			
			int time_id = Integer.parseInt(request.getParameter("time_id")) ;
			
			TimetableDao dao = new TimetableDao();
			
			int cnt = -99999 ;
			cnt = dao.DeleteData(time_id) ;
			
			new ListTimeTableController().doGet(request, response);
		}
		
		
		@Override
		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
		} 
}
