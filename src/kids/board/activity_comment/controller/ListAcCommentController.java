package kids.board.activity_comment.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.board.activity_comment.model.Activity_comment;
import kids.board.activity_comment.model.Activity_commentDao;
import kids.common.controller.SuperClass;

public class ListAcCommentController extends SuperClass{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		Activity_commentDao dao = new Activity_commentDao();
		List<Activity_comment> lists = dao.SelectDataList(0, 0);
		
		String gotopage = "/activity/accoList.jsp" ;
		super.GotoPage(gotopage);
	}
	
	
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
	}
}

