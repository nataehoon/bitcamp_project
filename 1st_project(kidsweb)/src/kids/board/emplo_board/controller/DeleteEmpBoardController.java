package kids.board.emplo_board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.board.emplo_board.model.Emplo_boardDao;
import kids.common.controller.SuperClass;

public class DeleteEmpBoardController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		int empno = Integer.parseInt(request.getParameter("empno"));
		
		Emplo_boardDao dao = new Emplo_boardDao();
		int cnt = -99999;
		cnt = dao.DeleteEmpbData(empno);
		
		new ListEmpBoardController().doGet(request, response);
		
	}
} 
