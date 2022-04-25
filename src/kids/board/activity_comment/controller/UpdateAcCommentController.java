package kids.board.activity_comment.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.board.activity_comment.model.Activity_comment;
import kids.board.activity_comment.model.Activity_commentDao;
import kids.common.controller.SuperClass;

public class UpdateAcCommentController extends SuperClass{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		Activity_comment bean = null ;
		Activity_commentDao dao = new Activity_commentDao() ;
		String data = dao.toString() ;
		
		int activity_cmid = Integer.parseInt(request.getParameter("activity_cmid")) ;
		
		List<Activity_comment> lists = new ArrayList<Activity_comment>() ;
		
		request.setAttribute("bean", bean);
		
		String gotopage = "/activity/accoUpdate.jsp" ;
		super.GotoPage(gotopage);
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}
}
