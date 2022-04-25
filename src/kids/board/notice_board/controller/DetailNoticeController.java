package kids.board.notice_board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.board.notice_board.model.Notice_board;
import kids.board.notice_board.model.Notice_boardDao;
import kids.common.controller.SuperClass;
import kids.members.employees.model.Employees;
import kids.members.parents.model.Parents;

public class DetailNoticeController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		int notino = Integer.parseInt(request.getParameter("notino"));
		Notice_boardDao dao = new Notice_boardDao();
		Notice_board bean = dao.DetailGoData(notino);
		
//		Employees loginfo = (Employees)super.session.getAttribute("loginfo");
//		
//		if(loginfo.getTid().equals(bean.getTid()) == false) {
//			dao.UpdateReadhit(notino);
//			bean.setReadhit(bean.getReadhit() + 1);
//		}
		
		request.setAttribute("bean", bean);
		
		String gotopage = "/notice_board/goDetail.jsp";
		super.GotoPage(gotopage);
	}
}  
