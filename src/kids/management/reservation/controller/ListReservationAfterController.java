package kids.management.reservation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.common.controller.SuperClass;
import kids.common.utility.PagingRes;
import kids.management.reservation.model.Reservation;
import kids.management.reservation.model.ReservationDao;
import kids.members.employees.model.Employees;
import kids.members.employees.model.EmployeesDao;

public class ListReservationAfterController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		String pageNumber = request.getParameter("pageNumber");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		
		String order = request.getParameter("order");
		String keyword = request.getParameter("keyword");
	
		if(year == null || year.equals("null") || year.equals("")) {
			System.out.println("year null 처리 들어옴");
			year = "2021" ;
		}	
		
		if(month == null || month.equals("null") || month.equals("")) {
			System.out.println("month null 처리 들어옴");
			month = "5" ;
			
		}	
		request.setAttribute("month", month);
		if(month.length()<2) {
			month = "0" + month;
		}
		if(order == null || order.equals("null") || order.equals("")) {
			order = "desc" ;
		}	
		if(keyword == null || keyword.equals("null") || keyword.equals("")) {
			keyword = "all" ;
		}		
		
		System.out.println("parameters : "+pageNumber+"/"+year+"/"+month+"/"+order+"/"+keyword);
			
		String contextPath = request.getContextPath() ;
		String url = contextPath + "/Kids?command=resAfterList" ;
		
		ReservationDao rdao = new ReservationDao();
		
		// 행(row) 총 개수
		int totalCount = rdao.SelectAfterTotalCount(year, month, order, keyword) ; 
		System.out.println("total data size : " + totalCount); 
		
		PagingRes pageInfo = new PagingRes(pageNumber, totalCount, url, year, month, order, keyword);

		List<Reservation> lists = rdao.selectDataAfterList(
				pageInfo.getBeginRow(),
				pageInfo.getEndRow(),
				year,
				month,
				order,
				keyword);
	
		System.out.println("reservation list count : " + lists.size()); 
		
		
		request.setAttribute("lists", lists);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("year", year);
	
		request.setAttribute("order", order);
		request.setAttribute("keyword", keyword);
		
		// 자주 사용되는 파라미터를 속성으로 정의합니다. 
		String parameters = "pageNumber="+pageNumber+"&year="+year+"&month="+month+"&order="+order+"&keyword=" + keyword;
		System.out.println("parameters : "+parameters);
		request.setAttribute("parameters",parameters);
		
		System.out.println("painginfo : "+pageInfo.getPagingHtml());
		
		
		String gotopage = "/reservation/resAfterList.jsp" ;
		super.GotoPage(gotopage);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
} 
 