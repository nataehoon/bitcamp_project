package kids.board.diet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.board.diet.model.Diet;
import kids.board.diet.model.DietDao;
import kids.common.controller.SuperClass;

public class DetailDietController extends SuperClass{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		int dietno = Integer.parseInt(request.getParameter("dietno"));
		
		DietDao dao = new DietDao();
		Diet bean = dao.DetailDate(dietno);
		
		System.out.println(bean);
		request.setAttribute("bean", bean);
		
		String gotopage = "/diet/dietDetail.jsp";
		super.GotoPage(gotopage);
	}
} 
