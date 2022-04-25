package kids.board.activity_comment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kids.board.activity.model.ActivityDao;
import kids.board.activity_comment.model.Activity_comment;
import kids.board.activity_comment.model.Activity_commentDao;
import kids.common.controller.SuperClass;

public class InsertAcCommentController extends SuperClass{
	private Activity_comment bean = null ;
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		String gotopage = "/activity/accoInsert.jsp" ;
		super.GotoPage(gotopage);
	}
	
		@Override
		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			super.doPost(request, response);
	
			//MultipartRequest multi = (MultipartRequest)request.getAttribute("multi") ;
			
			bean = new Activity_comment() ;
			bean.setContent("content") ;
//			bean.setDate("date");
			bean.setRemark("remark");
			bean.setTid("tid");
			bean.setPid("pid");
			
			
			Activity_commentDao dao = new Activity_commentDao();
				int cnt = -99999 ;
				cnt = dao.InsertData(bean) ;
				
				new ListAcCommentController().doGet(request, response);
				
		
		}
	}

