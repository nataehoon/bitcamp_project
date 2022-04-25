package kids.board.emplo_board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.board.emplo_board.model.Emplo_board;
import kids.board.emplo_board.model.Emplo_boardDao;
import kids.common.controller.SuperClass;

public class InsertEmpBoardController extends SuperClass {
	Emplo_board bean = null;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
		bean = new Emplo_board();
		
		bean.setTid(request.getParameter("tid"));
		bean.setContent(request.getParameter("content"));
		bean.setFiles(request.getParameter("files"));
		
		Emplo_boardDao dao = new Emplo_boardDao();
		int cnt = -99999;
		cnt = dao.InsertEmpbData(bean);
		
		request.setAttribute("bean", bean);
		
		new ListEmpBoardController().doGet(request, response);		
		
	}
}
