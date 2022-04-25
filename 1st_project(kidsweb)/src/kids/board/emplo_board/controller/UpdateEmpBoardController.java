package kids.board.emplo_board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.board.emplo_board.model.Emplo_board;
import kids.board.emplo_board.model.Emplo_boardDao;
import kids.common.controller.SuperClass;

public class UpdateEmpBoardController extends SuperClass {
		Emplo_board bean = null;
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		int empno = Integer.parseInt(request.getParameter("empno"));
		String content = request.getParameter("content");
		
		Emplo_boardDao dao = new Emplo_boardDao();
		bean = dao.SelectByPk(empno);
		
		request.setAttribute("bean", bean);
		request.setAttribute("content", content);
		
		String gotopage = "/emplo_board/empbUpdate.jsp";
		super.GotoPage(gotopage);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
		bean = new Emplo_board();

		System.out.println(request.getParameter("empno"));
//		bean.setEmpno(Integer.parseInt(request.getParameter("empno")));
		bean.setEmpno(Integer.parseInt(request.getParameter("empno_mod")));
		bean.setContent(request.getParameter("updatecontent"));
		
		
		if(this.validate(request) == true) {
		Emplo_boardDao dao = new Emplo_boardDao();
		int cnt = -99999;
		cnt = dao.UpdateEmpbData(bean);
		System.out.println("수정이 완료되었습니다.");
		
		new ListEmpBoardController().doGet(request, response);
		}else {
			System.out.println("수정에 실패하였습니다.");
			
			String gotopage = "/emplo_board/empbUpdate.jsp";
			super.GotoPage(gotopage);
		}
	}
	@Override
	public boolean validate(HttpServletRequest request) {
		boolean isCheck = true;
		
		if(bean.getContent().length() <= 0) {
			request.setAttribute(super.PREFIX + "content", "수정할 내용을 입력해 주세요");
			isCheck = false;
		}
		
		return isCheck;
		
		
	}
}
