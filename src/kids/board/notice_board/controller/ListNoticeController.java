package kids.board.notice_board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.board.notice_board.model.Notice_board;
import kids.board.notice_board.model.Notice_boardDao;
import kids.common.controller.SuperClass;
import kids.common.utility.FlowParameters;
import kids.common.utility.Paging;
import kids.management.myclass.model.Myclass;
import kids.management.myclass.model.MyclassDao;

public class ListNoticeController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		FlowParameters parameters = new FlowParameters(
				request.getParameter("pageNumber"),
				request.getParameter("mode"),
				request.getParameter("keyword"));
		System.out.println("parameters list : " + parameters.toString());
		
		String url = request.getContextPath() + "/Kids?command=goList";
		
		Notice_boardDao dao = new Notice_boardDao();
		int totalCount = dao.selectNoticeCount(
					parameters.getMode(),
					parameters.getKeyword());
		
		Paging pageInfo = new Paging(
				parameters.getPageNumber(),
				totalCount,
				url,
				parameters.getMode(),
				parameters.getKeyword());
				
		List<Notice_board> lists = dao.SelectList(
				pageInfo.getBeginRow(),
				pageInfo.getEndRow(),
				parameters.getMode(),
				parameters.getKeyword());
		
		System.out.println("notice_board size : " + lists.size());
		
		request.setAttribute("lists", lists);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("parameters", parameters);
		
		String gotopage = "/notice_board/goList.jsp" ;
		super.GotoPage(gotopage);
		 
	}	
	
}
