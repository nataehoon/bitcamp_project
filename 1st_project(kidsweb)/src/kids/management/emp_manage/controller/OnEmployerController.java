package kids.management.emp_manage.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.common.controller.SuperClass;
import kids.management.emp_manage.model.Emp_Manage;
import kids.management.emp_manage.model.Emp_ManageDao;

public class OnEmployerController extends SuperClass {
	private String tid;
	private String attendance;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		this.tid = request.getParameter("tid");
		System.out.println(this.tid);
		this.attendance = request.getParameter("attendance");
		
		if(this.validate(request) == true) {
			System.out.println("출근완료");
			Emp_ManageDao dao = new Emp_ManageDao();
			int cnt = -99999;
			cnt = dao.AttData(this.tid);
			
			String gotopag = "/emp_manage/att.jsp";
			super.GotoPage(gotopag);
			
		}else {
			System.out.println("이미 출근처리가 되었습니다.");
			String messege = "이미 출근처리가 완료 되었습니다";
			super.setErrorMessage(messege);
			
			String gotopag = "/emp_manage/afteratt.jsp";
			super.GotoPage(gotopag);
		}
			
	}
	public boolean validate(HttpServletRequest request) {
		boolean attCheck = true;
		
		Emp_ManageDao dao = new Emp_ManageDao();
		Emp_Manage bean = dao.EmpmAttData(tid,attendance);
		
		if(bean != null) {
			attCheck = false;
		}
		
		return attCheck;
	}
}
