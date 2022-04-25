package kids.members.employees.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.common.controller.SuperClass;
import kids.common.utility.MailSend;
import kids.members.employees.model.Employees;
import kids.members.employees.model.EmployeesDao;
import kids.members.parents.model.Parents;
import kids.members.parents.model.ParentsDao;
import kids.members.student.model.Student;
import kids.members.student.model.StudentDao;

public class SearchEmployerPasswordController extends SuperClass {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		String tid = request.getParameter("tid");
		String email = request.getParameter("email");
		System.out.println("tid : "+tid);
		System.out.println("email :"+email);
		
		EmployeesDao pdao = new EmployeesDao();
		Employees bean = pdao.searchPassword(tid, email);
		
		if(bean == null) { //일치하는 정보가 없다
			System.out.println("일치하는 정보가 없다");
			request.setAttribute("message", "일치하는 정보가 없습니다");
			request.setAttribute("tid", tid);
			request.setAttribute("email", email);
			
			String gotopage = "/employees/empPaSearch.jsp";
			super.GotoPage(gotopage);
		}else { //정보가 일치한다.
			MailSend ms = new MailSend();
			String code = ms.mailSend(email);
			
			System.out.println("mail 보내기 완료");
			System.out.println("code : "+code);
			System.out.println("bean : "+bean);
			
			request.setAttribute("code", code);
			request.setAttribute("bean", bean);
			String gotopage ="/employees/empPaSearch.jsp";
			super.GotoPage(gotopage);
		}
	}
}