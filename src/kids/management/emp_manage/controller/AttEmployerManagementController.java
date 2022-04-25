package kids.management.emp_manage.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.common.controller.SuperClass;
import kids.management.emp_manage.model.Emp_Manage;
import kids.management.emp_manage.model.Emp_ManageDao;
import kids.members.employees.model.Employees;
import kids.members.employees.model.EmployeesDao;

public class AttEmployerManagementController extends SuperClass {
	private String tid;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		this.tid = request.getParameter("tid");
		
		Date today = new Date();
		SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd");
		String fromDateTime = OffsetDateTime.now(ZoneId.systemDefault()).minusMonths(1).toString();
		String date = fromDateTime.substring(0, 10);
		String datefr = request.getParameter("datefr");
		String dateto = request.getParameter("dateto");

		if(request.getParameter("datefr") == null)
			datefr = date;
		else
			datefr = request.getParameter("datefr");

		if(request.getParameter("dateto") == null)
			dateto = day.format(today);
		else
			dateto = request.getParameter("dateto");
			
		System.out.println(datefr + "/" +dateto);
		EmployeesDao edao = new EmployeesDao();
		Employees ebean = edao.DetailData(tid);
		
		System.out.println("ebean : " + ebean);
		request.setAttribute("ebean", ebean);
		
		Emp_ManageDao mdao = new Emp_ManageDao();
		List<Emp_Manage> lists = mdao.SelectEmpData(datefr, dateto, tid);
		
		System.out.println("lists : " + lists.size());
		request.setAttribute("lists", lists);
		
		String gotopage = "/emp_manage/empmattDetail.jsp";
		super.GotoPage(gotopage);
		
	}
}
