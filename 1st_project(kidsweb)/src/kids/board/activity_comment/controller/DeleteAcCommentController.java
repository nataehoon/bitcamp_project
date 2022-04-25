package kids.board.activity_comment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.board.activity_comment.model.Activity_commentDao;
import kids.common.controller.SuperClass;

public class DeleteAcCommentController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		int activity_cmid = Integer.parseInt(request.getParameter("actino")) ;
		
		Activity_commentDao dao = new Activity_commentDao();
		int cnt = -99999 ;
		cnt = dao.DeleteData(activity_cmid) ;
		
		new ListAcCommentController().doGet(request, response);
	}
	
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	super.doPost(request, response);
	}
}