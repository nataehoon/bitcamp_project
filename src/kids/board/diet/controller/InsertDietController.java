package kids.board.diet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kids.board.diet.model.Diet;
import kids.board.diet.model.DietDao;
import kids.common.controller.SuperClass;

public class InsertDietController extends SuperClass{
	Diet bean = null;
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		String gotopage = "/diet/dietInsert.jsp";
		super.GotoPage(gotopage);
		
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		MultipartRequest multi = (MultipartRequest)request.getAttribute("multi");
		
		bean = new Diet();
		
		bean.setCategory(multi.getParameter("category"));
		bean.setContent(multi.getParameter("content"));
		bean.setFiles(multi.getFilesystemName("files"));
		
		if(this.validate(request) == true) {
		DietDao dao = new DietDao();
		int cnt = -99999;
		cnt = dao.InsertDietDate(bean);
		
		new ListDietController().doGet(request, response);
		
		}else {
			System.out.println("수정 실패");
			
			request.setAttribute("bean", bean);
			
			String gotopage = "/diet/dietInsert.jsp";
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
