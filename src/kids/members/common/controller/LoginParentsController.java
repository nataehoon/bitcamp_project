package kids.members.common.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.common.controller.SuperClass;
import kids.members.parents.model.ParentsDao;
import kids.members.parents.model.ParentsMiniView;

public class LoginParentsController extends SuperClass {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
		String pid = request.getParameter("pid");
		String password = request.getParameter("password");
		System.out.println(pid + "/" + password);
		
		ParentsDao pdao = new ParentsDao();
		List<ParentsMiniView> plists = pdao.login(pid,password);
		//Parents bean = pdao.selectData(pid, password);
		
		String gotopage = "";
		
		if(plists == null) {
			System.out.println("로그인에 실패하였습니다.");
			String message = "가입되지 않은 아니디거나 비밀번호가 일치하지 않습니다.";
			request.setAttribute("pErrmsg", message);
			
			request.setAttribute("pid", pid);
			
			gotopage = "/start.jsp";
			super.GotoPage(gotopage);
		}else if(plists.get(0).getSubmit().equals("미승인")) {
			System.out.println("미승인 계정");
			String message = "가입신청이 미승인 상태입니다.";
			
			request.setAttribute("pid", pid);
			request.setAttribute("pErrmsg", message);
			
			gotopage = "/start.jsp";
			super.GotoPage(gotopage);
		}else {
			System.out.println("로그인에 성공하셨습니다.");
			
			super.session.setAttribute("plists", plists);
			super.session.setAttribute("loginfo", plists.get(0));
			
			gotopage = "/common/main2.jsp" ;
			super.GotoPage(gotopage);
		}
		
		
		
	}
}
 
