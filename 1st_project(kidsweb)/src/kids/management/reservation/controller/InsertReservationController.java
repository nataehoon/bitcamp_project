package kids.management.reservation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.common.controller.SuperClass;
import kids.management.reservation.model.Reservation;
import kids.management.reservation.model.ReservationDao;

public class InsertReservationController extends SuperClass {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		String name = request.getParameter("name");
		String hp = request.getParameter("hp");
		String resdate = request.getParameter("resdate");
		
		Reservation bean = new Reservation();
		bean.setName(name);
		bean.setHp(hp);
		bean.setRes_date(resdate);
		
		ReservationDao rdao = new ReservationDao();
		boolean check = rdao.insertData(bean);
		
		String message = "";
		if(check==false) {
			message = "상담 예약이 실패했습니다.";
		}else {
			message = "상담 예약이 완료되었습니다.";
		}
		
		System.out.println("check : "+check); //false일경우 데이터 입력 실패
		
		String page = request.getParameter("page");
		if(page == null || page.equals("null") || page.equals("")) {
			page="lalala";
		}
		if(page.equals("list")) {
			new ListResevationController().doGet(request, response);
		}
		
		request.setAttribute("message",message);
		String gotopage = "/start.jsp";
		super.GotoPage(gotopage);
		
	}

		
} 
