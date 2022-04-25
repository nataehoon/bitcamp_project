package kids.members.common.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.common.controller.SuperClass;
import kids.members.parents.model.Parents;
import kids.members.parents.model.ParentsDao;

public class CheckPidController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		System.out.println("pidCheckController에 왔음 . doGet");
		String pid = request.getParameter("pid") ;
		ParentsDao pdao = new ParentsDao();
		
		Parents bean = pdao.selectDataByPk(pid);
		
		if (bean == null) { // 존재 하지 않는 회원
			request.setAttribute("message", pid + "은(는) <font color='blue'><b>사용 가능</b></font>한 아이디입니다.");
			request.setAttribute("pid", pid);
			request.setAttribute("isCheck", true);
		}else {
			request.setAttribute("message", pid + "은(는) 이미 <font color='red'><b>사용중</b></font>인 아이디입니다.");
			request.setAttribute("pid", pid);
			request.setAttribute("isCheck", false);
		}
	
		String gotopage = "/parents/pidCheck.jsp" ;
		super.GotoPage(gotopage);
	}	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}
}

