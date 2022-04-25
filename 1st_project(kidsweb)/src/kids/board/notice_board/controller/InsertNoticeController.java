package kids.board.notice_board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kids.board.notice_board.model.Notice_board;
import kids.board.notice_board.model.Notice_boardDao;
import kids.common.controller.SuperClass;
import kids.management.myclass.model.Myclass;
import kids.management.myclass.model.MyclassDao;

public class InsertNoticeController extends SuperClass {
	Notice_board bean = null;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		System.out.println("gogo");
		MyclassDao mdao = new MyclassDao();
		List<Myclass> mlists = mdao.SelectDataList();
		System.out.println("gogo");
		request.setAttribute("mlists", mlists);
		
		String gotopage = "/notice_board/goInsert.jsp" ;
		super.GotoPage(gotopage);
	}	
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
		MultipartRequest multi = (MultipartRequest)request.getAttribute("multi");
		
		bean = new Notice_board();
		
		bean.setClass_id(Integer.parseInt(multi.getParameter("class_id")));
		bean.setContent(multi.getParameter("content"));
		bean.setFiles(multi.getFilesystemName("files"));
		bean.setRegdate(multi.getParameter("regdate"));
		bean.setTid(multi.getParameter("tid"));
		bean.setTitle(multi.getParameter("title"));
		
		if(this.validate(request) == true) {
			System.out.println("글쓰기 성공");
			Notice_boardDao dao = new Notice_boardDao();
			int cnt = -99999;
			cnt = dao.InsertData(bean);
			
			new ListNoticeController().doGet(request, response);			
		}else {
			System.out.println("글쓰기 실패");
			
			request.setAttribute("bean", bean);
			
			String gotopage = "/notice_board/goInsert.jsp";
			super.GotoPage(gotopage);
		}
	}
	
	@Override
	public boolean validate(HttpServletRequest request) {
		boolean isCheck = true;
		
		if(bean.getTitle().length() < 2 || bean.getTitle().length() > 20) {
			request.setAttribute(super.PREFIX + "title" , "제목은 3글자 이상 20자 이하로 입력하셔야 합니다");
			isCheck = false;
		}
		
		return isCheck;
		
	}
} 
