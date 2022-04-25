package kids.management.subject.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.common.controller.SuperClass;
import kids.management.subject.model.Subject;
import kids.management.subject.model.SubjectDao;


public class InsertSubjectController extends SuperClass {
	private Subject bean = null ;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		String gotopage = "/subject/IsertSubject.jsp" ;
		super.GotoPage(gotopage);
	}
	
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
		bean = new Subject() ;
		//bean.setSubject_code ;
		bean.setSubject(request.getParameter("subject"));
		bean.setRemark(request.getParameter("remark"));
	
		System.out.println("bean information");
		System.out.println(bean.toString()); 
		
		if (this.validate(request) == true) {
			System.out.println("subject insert validation check success");
			SubjectDao dao = new SubjectDao();
			int cnt = - 999999 ;
			cnt = dao.InsertData(bean) ;
			
			new ListSubjectController().doGet(request, response); 
			
		} else {
			System.out.println("subject insert validation check failure");
			
			request.setAttribute("bean", bean);
			String gotopage = "/subject/InsertSubject.jsp" ;
			super.GotoPage(gotopage);
	   }
	}
}
