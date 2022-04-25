package kids.management.reservation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.common.controller.SuperClass;
import kids.management.reservation.model.Reservation;
import kids.management.reservation.model.ReservationDao;
import kids.members.employees.model.Employees;
import kids.members.employees.model.EmployeesDao;

public class UpdateResevationController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//상담일지 작성 form으로 이동
		super.doGet(request, response);
		int rid = Integer.parseInt(request.getParameter("rid"));
		ReservationDao rdao = new ReservationDao();
		Reservation bean = rdao.selectDataByPk(rid);
		request.setAttribute("bean", bean);
		
		EmployeesDao edao = new EmployeesDao();
		List<Employees> elists = edao.getEmployeesListAll();
		request.setAttribute("elists", elists);
				
		String gotopage = "/reservation/resUpdate.jsp";
		super.GotoPage(gotopage);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// form 으로 입력 받고 고치기 (상담일지 작성)
		super.doPost(request, response);
		String name = request.getParameter("name");
		String hp = request.getParameter("hp");
		String res_date = request.getParameter("date");
		String tid = request.getParameter("tid");
		String textarea = request.getParameter("textarea");
		int rid = Integer.parseInt(request.getParameter("rid"));
		String reg_date = request.getParameter("regdate");
		
		Reservation bean = new Reservation();
		bean.setStatus("상담완료");
		bean.setName(name);
		bean.setHp(hp);
		bean.setRes_date(res_date);
		bean.setTid(tid);
		bean.setTextarea(textarea);
		bean.setRid(rid);
		bean.setReg_date(reg_date);
		
		ReservationDao rdao = new ReservationDao();
		int cnt = rdao.update(bean);
		if(cnt != 1) {
			System.out.println("수정 실패");
		}else {
			new ListReservationAfterController().doGet(request, response);
		}
	}
} 
