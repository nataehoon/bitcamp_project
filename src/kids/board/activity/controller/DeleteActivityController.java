package kids.board.activity.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.board.activity.model.ActivityDao;
import kids.common.controller.SuperClass;

public class DeleteActivityController extends SuperClass{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		int actino = Integer.parseInt(request.getParameter("actino")) ;
		System.out.println("actino :" + actino);
		ActivityDao dao = new ActivityDao();
		int cnt = -99999 ;
		cnt = dao.DeleteData(actino) ;
		
		new ListActivityController().doGet(request, response);
	}
	
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	super.doPost(request, response);
	}
}
