package kids.board.activity.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kids.board.activity.model.Activity;
import kids.board.activity.model.ActivityDao;
import kids.common.controller.SuperClass;

public class InsertActivityController extends SuperClass {
	private Activity bean = null ;
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		
		
//		request.setAttribute("lists", lists);
		
		String gotopage = "/activity/acInsert.jsp" ;
		super.GotoPage(gotopage);
	}
	
		@Override
		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			super.doPost(request, response);
	
			MultipartRequest multi = (MultipartRequest)request.getAttribute("multi") ;
			
			bean = new Activity() ;
			
			System.out.println(Integer.parseInt(multi.getParameter("subject_code")));
			System.out.println(multi.getParameter("title"));
			System.out.println(multi.getParameter("content"));
			System.out.println(multi.getFilesystemName("image"));
			System.out.println(multi.getParameter("remark"));
			System.out.println(multi.getParameter("tid"));
			System.out.println(Integer.parseInt(multi.getParameter("class_id")));
			
			
			bean.setSubject_code(Integer.parseInt(multi.getParameter("subject_code"))) ;
			bean.setTitle(multi.getParameter("title")) ;
			bean.setContent(multi.getParameter("content"));
			bean.setImage(multi.getFilesystemName("image"));
			bean.setRemark(multi.getParameter("remark"));
			bean.setTid(multi.getParameter("tid"));
			bean.setClass_id(Integer.parseInt(multi.getParameter("class_id"))) ;
			
			ActivityDao adao = new ActivityDao();
			int cnt = adao.insertData(bean);
			
//			int cnt = -99999;
//			 cnt = dao.insertData(bean);
//	        if(cnt == 1) {
	        	System.out.println("activity입력 완료");
//	        }
	        new ListActivityController().doGet(request, response);
		}
	}