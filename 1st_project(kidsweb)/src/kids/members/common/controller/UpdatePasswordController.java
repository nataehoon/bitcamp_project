package kids.members.common.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.common.controller.SuperClass;
import kids.members.parents.model.ParentsDao;

public class UpdatePasswordController extends SuperClass {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		// 보호자 비밀번호 변경
		String pid = request.getParameter("pid");
		String password = request.getParameter("password");
		
		System.out.println("pid : "+pid);
		System.out.println("password : "+password);
		
		ParentsDao pdao = new ParentsDao();
		int cnt = pdao.updatePassword(pid,password);
		
		System.out.println("cnt : "+cnt);
		
		if(cnt==1) {
			String gotopage = "/parents/paUpdatePwdOK.jsp";
			super.GotoPage(gotopage);
		}
		
		System.out.println("업데이트 실패함 ");
		//왜 실패하는거지? 왜왜왜왜왜
		
	}
}
