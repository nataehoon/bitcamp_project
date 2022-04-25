package kids.members.parents.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.common.controller.SuperClass;
import kids.members.parents.model.Parents;
import kids.members.parents.model.ParentsDao;

public class UpdateParentsController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		String pid = request.getParameter("pid");
		ParentsDao pdao = new ParentsDao();
		Parents bean = pdao.selectDataByPk(pid);
		
		System.out.println("bean : "+bean);
		String[] email = bean.getEmail().split("@");
		String email1 = email[0];
		String email2 = email[1];
		System.out.println("email1 : "+email1);
		System.out.println("email2 : "+email2);
		
		
		request.setAttribute("bean", bean);
		request.setAttribute("email1", email1);
		request.setAttribute("email2", email2);
		
		int genderCheck = 0;
		if(bean.getGender().equals("남")) {
			
		}else {
			genderCheck = 1;
		}
		
		int relCheck = 0;
		if(bean.getRelationship().equals("아버지")) {
			
		}else if(bean.getRelationship().equals("어머니")) {
			relCheck = 1;
		}else if(bean.getRelationship().equals("조부모님")) {
			relCheck = 2;
		}else {
			relCheck = 3;
		}
		
		request.setAttribute("genderCheck", genderCheck);
		request.setAttribute("relCheck", relCheck);
		
		String gotopage = "parents/paUpdate.jsp";
		super.GotoPage(gotopage);
	}
} 
