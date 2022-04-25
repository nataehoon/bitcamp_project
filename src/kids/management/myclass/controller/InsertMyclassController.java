package kids.management.myclass.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kids.common.controller.SuperClass;
import kids.management.myclass.model.Myclass;
import kids.management.myclass.model.MyclassDao;


public class InsertMyclassController extends SuperClass {
	private Myclass bean = null ;
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		String gotopage = "/myclass/myclInsert.jsp" ;
		super.GotoPage(gotopage);
	}
	
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
		//MultipartRequest multi = (MultipartRequest)request.getAttribute("multi") ;
		
		bean = new Myclass();
		// int class_id ;
		String class_name = (String)request.getParameter("class_name") ;
		String remark = (String)request.getParameter("remark") ;
		System.out.println(class_name + remark);
		//bean.setClass_id(class_id)
		bean.setClass_name(class_name);
		bean.setRemark(remark);
		
		MyclassDao dao = new MyclassDao();
        
        int cnt = -99999;
		 cnt = dao.insertData(bean);
        if(cnt == 1) {
        	System.out.println("myclass입력 완료");
        }
        new ListMyclassController().doGet(request, response);
        
//		if (this.validate(request) == true) {
//	         System.out.println("teacher insert validation check success");
//	         
//	 		 cnt = dao.insertData(bean);
//	         
//	         new ListMyclassController().doGet(request, response);
//	         
//	      } else {
//	         System.out.println("teacher insert validation check failure");
//	         request.setAttribute("bean", bean);
//	         super.doPost(request, response);
//	         
//	         String gotopage = "/myclass/myclassInsert.jsp" ;
//	 		super.GotoPage(gotopage);
//	 		}
      }
}

