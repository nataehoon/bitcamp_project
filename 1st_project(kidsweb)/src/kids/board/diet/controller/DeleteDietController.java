package kids.board.diet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.board.diet.model.DietDao;
import kids.common.controller.SuperClass;

public class DeleteDietController extends SuperClass{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		int dietno = Integer.parseInt(request.getParameter("dietno"));
		
		DietDao dao = new DietDao();
		int cnt = -99999;
		cnt = dao.DeleteDietData(dietno);
		
		new ListDietController().doGet(request, response);
		
	}
}
