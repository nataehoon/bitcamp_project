package kids.board.diet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.board.diet.model.Diet;
import kids.board.diet.model.DietDao;
import kids.common.controller.SuperClass;

public class UpdateDietController extends SuperClass {
	Diet bean = null;
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		System.out.println(request.getParameter("dietno"));
		
		int dietno = Integer.parseInt(request.getParameter("dietno"));
		
		DietDao dao = new DietDao();
		bean = dao.DetailDate(dietno);
		
		request.setAttribute("bean", bean);
		
		String gotopage = "/diet/dietUpdate.jsp";
		super.GotoPage(gotopage);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		bean = new Diet();
		
		System.out.println(request.getParameter("dietno"));
		bean.setDietno(Integer.parseInt(request.getParameter("dietno")));
		bean.setCategory(request.getParameter("category"));
		bean.setContent(request.getParameter("content"));
		bean.setFiles(request.getParameter("files"));
		
		if(this.validate(request) == true) {
			System.out.println("수정 성공");
			System.out.println(bean);
			DietDao dao = new DietDao();
			int cnt = -99999;
			cnt = dao.UpdateDietDate(bean);
			
			new DetailDietController().doGet(request, response);
			
		}else {
			System.out.println("수정 실패");
			
			request.setAttribute("bean", bean);
			
			String gotopage = "/diet/dietUpdate.jsp";
			super.GotoPage(gotopage);
		}
	}
	
	@Override
	public boolean validate(HttpServletRequest request) {
		boolean isCheck = true;
		
		if(bean.getCategory() == null || bean.getCategory().equals("-")) {
			request.setAttribute(super.PREFIX + "category", "시간을 선택해 주세요");
			isCheck = false;
		}
		return isCheck;
	}
} 
