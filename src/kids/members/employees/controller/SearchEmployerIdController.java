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

public class SearchEmployerIdController extends SuperClass {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		String email = request.getParameter("email");
		
		System.out.println("name, birth, email : "+name+"/"+birth+"/"+email);
		EmployeesDao dao = new EmployeesDao();
		Employees bean = dao.Employees(name, email);
		
		if(bean == null) { //입력받은 정보와 일치하는 아이디가 없다
			
			System.out.println("일치하는 정보가 없다!");
			request.setAttribute("message", "일치하는 정보가 없습니다");
			request.setAttribute("name", name);
			request.setAttribute("email", email);
			
			String gotopage = "/employees/empIdSearch.jsp";
			super.GotoPage(gotopage);
		}else { //일치하는 아이디가 있다.
			MailSend ms = new MailSend();
			String code = ms.mailSend(email);
			
			System.out.println("mail 보내기 완료");
			System.out.println("code : "+code);
			System.out.println("bean : "+bean);
			
			request.setAttribute("code", code);
			request.setAttribute("bean", bean);
			String gotopage ="/employees/empIdSearch.jsp";
			super.GotoPage(gotopage);
		}
		
	}
}
