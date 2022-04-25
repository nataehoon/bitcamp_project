package kids.members.parents.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.common.controller.SuperClass;
import kids.members.parents.model.ParentsDao;

public class DeleteParentsController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		String pid = request.getParameter("pid");
		
		ParentsDao pdao = new ParentsDao();
		int cnt = pdao.deleteData(pid);
		System.out.println("deleteData cnt " + cnt);
		
		session.invalidate();
		
		String gotopage = "/start.jsp";
		super.GotoPage(gotopage);
	}
} 
