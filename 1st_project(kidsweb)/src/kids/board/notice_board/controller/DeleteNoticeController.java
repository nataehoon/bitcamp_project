package kids.board.notice_board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.board.notice_board.model.Notice_boardDao;
import kids.common.controller.SuperClass;
import kids.common.utility.FlowParameters;

public class DeleteNoticeController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		int notino = Integer.parseInt(request.getParameter("notino"));
		
		FlowParameters parameters = new FlowParameters(request.getParameter("pageNumber"), request.getParameter("mode"), request.getParameter("keyword"));
		System.out.println(parameters.toString());
		
		Notice_boardDao dao = new Notice_boardDao();
		
		int cnt = -99999;
		cnt = dao.DeleteNotiData(notino);
		
		new ListNoticeController().doGet(request, response);
		
	}
}  
 