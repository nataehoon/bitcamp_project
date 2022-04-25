package kids.members.parents.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.common.controller.SuperClass;
import kids.members.parents.model.ParentsDao;
import kids.members.parents.model.ParentsMiniView;

public class paChangeLoginfoController extends SuperClass{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		String pid = request.getParameter("pid");
		int sid = Integer.parseInt(request.getParameter("sid"));
		System.out.println("pid : "+pid);
		System.out.println("sid : "+sid);
		
		ParentsDao pdao = new ParentsDao();
		ParentsMiniView bean = pdao.selectMiniData(pid,sid);
		System.out.println("bean : "+bean);
		
		
		if(bean == null) {
			System.out.println("bean null");
		}else {
			super.session.setAttribute("loginfo", bean);
			String gotopage = "/common/main2.jsp" ;
			//String gotopage = "/parents/historyback.jsp"; //데이터가 보존되지 않는다.
			super.GotoPage(gotopage);
		}
		
		
	}
}
