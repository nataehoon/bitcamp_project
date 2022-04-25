package kids.management.reservation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.common.controller.SuperClass;
import kids.management.reservation.model.ReservationDao;

public class DeleteResevationController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		int rid = Integer.parseInt(request.getParameter("rid"));
		String page = request.getParameter("page");
		if(page == null || page.equals("null") || page.equals("")) {
			page = "reservation";
		}
		
		ReservationDao rdao = new ReservationDao();
		int cnt = rdao.deleteData(rid);
		if(cnt != 1) {
			System.out.println("삭제 실패");
		}else if(page.equals("after")){
			System.out.println("after로 들어옴!");
			new ListReservationAfterController().doGet(request, response);
		}else {
			System.out.println("before!");
			new ListResevationController().doGet(request, response);
		}
	}
} 
