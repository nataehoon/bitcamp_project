package kids.board.emplo_board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.board.emplo_board.model.Emplo_board;
import kids.board.emplo_board.model.Emplo_boardDao;
import kids.common.controller.SuperClass;
import kids.common.utility.FlowParameters;
import kids.common.utility.Paging;
import kids.members.employees.model.Employees;

public class ListEmpBoardController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		FlowParameters parameters = new FlowParameters(
				request.getParameter("pageNumber"),
				request.getParameter("mode"),
				request.getParameter("keyword"));
		System.out.println("parameters list : " + parameters.toString());
		
		String url = request.getContextPath() + "/Kids?command=empbList";
		
		Emplo_boardDao dao = new Emplo_boardDao();
		String tid = request.getParameter("tid");
		int totalCount = dao.selectEmbCount(
					parameters.getMode(),
					parameters.getKeyword());
		
		Paging pageInfo = new Paging(
				parameters.getPageNumber(),
				totalCount,
				url,
				parameters.getMode(),
				parameters.getKeyword());
				
		List<Emplo_board> lists = dao.SelectList(
				pageInfo.getBeginRow(),
				pageInfo.getEndRow(),
				parameters.getMode(),
				parameters.getKeyword());
		
		System.out.println("emplo_board size : " + lists.size());
		
		request.setAttribute("lists", lists);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("parameters", parameters);
		
		String gotopage = "/emplo_board/empbList.jsp" ;
		super.GotoPage(gotopage);
		 
	}	
}
