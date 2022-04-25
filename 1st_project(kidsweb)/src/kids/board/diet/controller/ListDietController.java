package kids.board.diet.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.board.diet.model.Diet;
import kids.board.diet.model.DietDao;
import kids.common.controller.SuperClass;

public class ListDietController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);

		Date date = new Date();
		SimpleDateFormat form = new SimpleDateFormat("yyyy/MM/dd");
		String today = form.format(date);
		
		DietDao dao = new DietDao();
		List<Diet> lists = dao.SelectDietData();
		
		request.setAttribute("today", today);
		request.setAttribute("lists", lists);
		
		System.out.println("lists sizs : " + lists.size());
		
		String gotopage = "/diet/dietList.jsp";
		super.GotoPage(gotopage);
		
	}
}
