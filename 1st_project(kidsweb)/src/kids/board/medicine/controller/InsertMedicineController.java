package kids.board.medicine.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.board.medicine.model.Medicine2;
import kids.board.medicine.model.MedicineDao;
import kids.board.notice_board.controller.ListNoticeController;
import kids.common.controller.SuperClass;
import kids.members.parents.model.ParentsMiniView;

public class InsertMedicineController extends SuperClass {
Medicine2 bean = null;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat format2 = new SimpleDateFormat ( "yyyy년 MM월 dd일");
				
		Date time = new Date();
				
		String time1 = format1.format(time);
		String time2 = format2.format(time);
				
		System.out.println(time1);
		System.out.println(time2);
		request.setAttribute("time", time2);
		
		String gotopage = "/medicine/meInsert.jsp" ;
		super.GotoPage(gotopage);
	}	
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		bean = new Medicine2();
		
		
		if(this.validate(request) == true) {
			System.out.println("글쓰기 성공");
			//파라미터값 합치기
			String amount = request.getParameter("amount_1")+request.getParameter("amount_2");
			String hour = request.getParameter("hour_1")+" "+request.getParameter("hour_2")+" ";
			hour += request.getParameter("hour_3")+" "+request.getParameter("hour_4");
			bean.setAmount(amount);
			bean.setCategory(request.getParameter("category"));
			bean.setHour(hour);
			bean.setPid((String)session.getAttribute("pid"));
			bean.setRegdate(hour);
			bean.setReps(Integer.parseInt(request.getParameter("reps")));
			bean.setStoragemethod(request.getParameter("storagemethod"));
			bean.setTextarea(request.getParameter("textarea"));
			
			ParentsMiniView bean2 = (ParentsMiniView)session.getAttribute("loginfo");
			bean.setSid(bean2.getSid());
			
			System.out.println("sid="+bean2.getSid());
			// regdate, meno, tid, checks 는 쿼리문에서 넣기
			
			MedicineDao dao = new MedicineDao();
			int cnt = -99999;
			
			cnt = dao.InsertData(bean);
			
			new ListMedicineController().doGet(request, response);			
			
		}else {
			System.out.println("글쓰기 실패");
			
			request.setAttribute("bean", bean);
			
			String gotopage = "/medicine/meInsert.jsp";
			super.GotoPage(gotopage);
		}
	}
	
	@Override
	public boolean validate(HttpServletRequest request) {
		boolean isCheck = true;
		final String REGEX = "[0-9]+";
		String hour = request.getParameter("hour_3") + request.getParameter("hour_4");
		// category, storagemethod, hour_3,hour_4,amount_1,reps
		/*
		if(request.getParameter("category").equals("null") || request.getParameter("category").equals("") || request.getParameter("category") == null) {
			request.setAttribute(super.PREFIX + "category" , "반드시 하나 이상 선택해야 합니다.");
			isCheck = false;
		}
		if(request.getParameter("storagemethod").equals("null") || request.getParameter("storagemethod").equals("") || request.getParameter("storagemethod") == null) {
			request.setAttribute(super.PREFIX + "storagemethod" , "반드시 하나 이상 선택해야 합니다.");
			isCheck = false;
		}
		*/
		if(hour.equals("null") || hour.equals("") || hour == null ) {
			
			System.out.println("&& 통");
			request.setAttribute(super.PREFIX + "hour_3" , "반드시 하나 이상 입력해야 합니다.");
			request.setAttribute(super.PREFIX + "hour_4" , "반드시 하나 이상 입력해야 합니다.");
			isCheck = false;
			
		}else {
			if(!(request.getParameter("hour_3").equals("null") || request.getParameter("hour_3").equals("") || request.getParameter("hour_3") == null) &&
			!((String)request.getParameter("hour_3")).matches(REGEX)) {
				request.setAttribute(super.PREFIX + "hour_3" , "숫자만 입력 가능합니다.");
				isCheck = false;
			}
			if(!(request.getParameter("hour_4").equals("null") || request.getParameter("hour_4").equals("") || request.getParameter("hour_4") == null) &&
			!((String)request.getParameter("hour_4")).matches(REGEX)) {
				request.setAttribute(super.PREFIX + "hour_4" , "숫자만 입력 가능합니다.");
				isCheck = false;
			}
		}
		
		if(request.getParameter("amount_1").equals("null") || request.getParameter("amount_1").equals("") || request.getParameter("amount_1") == null) {
			request.setAttribute(super.PREFIX + "amount_1" , "반드시 숫자 형태로 입력해야 합니다.");
			isCheck = false;
		}else {
			if(!((String)request.getParameter("amount_1")).matches(REGEX)) {
				request.setAttribute(super.PREFIX + "amount_1" , "숫자만 입력 가능합니다.");
				isCheck = false;
			}
		}
		
		if(request.getParameter("reps").equals("null") || request.getParameter("reps").equals("") || request.getParameter("reps") == null) {
			request.setAttribute(super.PREFIX + "reps" , "반드시 숫자 형태로 입력해야 합니다.");
			isCheck = false;
		}else {
			if(!((String)request.getParameter("reps")).matches(REGEX)) {
				request.setAttribute(super.PREFIX + "reps" , "숫자만 입력 가능합니다.");
				isCheck = false;
			}
		}
		
//		if(bean.getTitle().length() < 2 || bean.getTitle().length() > 20) {
//			request.setAttribute(super.PREFIX + "title" , "제목은 3글자 이상 20자 이하로 입력하셔야 합니다");
//			isCheck = false;
//		}
		
		return isCheck;
		
	}
} 
