package kids.management.myclass.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.common.controller.SuperClass;
import kids.management.myclass.model.Myclass;
import kids.management.myclass.model.MyclassDao;

public class UpdateMyclassController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		int myclass_id = Integer.parseInt(request.getParameter("myclass_id")) ;
		
//		MyclassDao dao = new MyclassDao();
//		cnt = dao.UpdateData(bean) ;
				
//		request.setAttribute("bean", bean);
		request.setAttribute("myclass_id", myclass_id);
		String gotopage = "/myclass/myclUpdate.jsp" ;
		super.GotoPage(gotopage);
	}
	
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		Myclass bean = new Myclass() ;
		System.out.println("마이클래스 :"+ request.getParameter("class_id"));
		bean.setClass_id(Integer.parseInt(request.getParameter("class_id")));
		bean.setClass_name(request.getParameter("class_name"));
		bean.setRemark(request.getParameter("remark"));
		int cnt = -99999;
		MyclassDao dao = new MyclassDao();
		cnt = dao.UpdateData(bean) ;
		System.out.println("cnt" + cnt);
		if(cnt == 1) {
			System.out.println("학급이름 변경 완료");
			new ListMyclassController().doGet(request,response);
		}else {
			System.out.println("학급이름 변경 실패");
			request.setAttribute("bean", bean);
			new ListMyclassController().doGet(request,response);
		}
		
	}
}
