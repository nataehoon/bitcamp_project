package kids.members.parents.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.common.controller.SuperClass;
import kids.members.parents.model.ParentsDao;
import kids.members.parents.model.ParentsView;

public class DetailParentsController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		String pid = request.getParameter("pid");
		
		ParentsDao pdao = new ParentsDao();
		ParentsView bean = pdao.selectDetailData(pid);
		
		System.out.println("bean");
		
		request.setAttribute("bean", bean);
		
		String gotopage = "parents/paDetail.jsp";
		super.GotoPage(gotopage);
	}
} 
