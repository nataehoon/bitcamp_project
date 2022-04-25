package kids.members.common.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.common.controller.SuperClass;
import kids.members.employees.model.EmployeesDao;

public class EmpUpPasswordController extends SuperClass {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		// 직원 비밀번호 변경
		String tid = request.getParameter("tid");
		String password = request.getParameter("password");
		
		System.out.println("tid : "+tid);
		System.out.println("password : "+password);
		
		EmployeesDao dao = new EmployeesDao();
		int cnt = dao.updatePassword(tid,password);
		
		System.out.println("cnt : "+cnt);
		
		if(cnt==1) {
			String gotopage = "/employees/empUpdatePwdOK.jsp";
			super.GotoPage(gotopage);
		}else {
		System.out.println("업데이트 실패함 ");
		}
	}
}
