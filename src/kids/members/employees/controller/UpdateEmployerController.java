package kids.members.employees.controller;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kids.common.controller.SuperClass;
import kids.management.myclass.model.Myclass;
import kids.management.myclass.model.MyclassDao;
import kids.management.subject.model.Subject;
import kids.management.subject.model.SubjectDao;
import kids.members.employees.model.Employees;
import kids.members.employees.model.EmployeesDao;

public class UpdateEmployerController extends SuperClass {
	Employees bean = null;
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		SubjectDao sdao = new SubjectDao();
		List<Subject> slists = sdao.SelectDataList();
		System.out.println("slists size : " + slists.size());
		request.setAttribute("slists", slists);
		
		MyclassDao cdao = new MyclassDao();
		List<Myclass> clists = cdao.SelectDataList();
		System.out.println("clists size : " + clists.size());
		request.setAttribute("clists", clists);
		
		String tid = request.getParameter("tid");
		EmployeesDao dao = new EmployeesDao();
		Employees bean = dao.DetailData(tid);
		
		System.out.println(bean);
		
		request.setAttribute("bean", bean);
		
		String gotopage = "/employees/empUpdate.jsp";
		super.GotoPage(gotopage);
		
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
		MultipartRequest multi = (MultipartRequest)request.getAttribute("multi");
		
		bean = new Employees();
		
		bean.setAddress1(multi.getParameter("address1"));
		bean.setAddress2(multi.getParameter("address2"));
		bean.setBirth(multi.getParameter("birth"));
		bean.setEmail(multi.getParameter("email1")+"@"+multi.getParameter("email2"));
		bean.setGender(multi.getParameter("gender"));
		bean.setHp(multi.getParameter("hp"));
		bean.setImage(multi.getFilesystemName("image"));
		bean.setName(multi.getParameter("name"));
		bean.setPassword(multi.getParameter("password"));
		bean.setTid(multi.getParameter("tid"));
		bean.setZipcode(multi.getParameter("zipcode"));
		if(request.getParameter("subject_code") == null || request.getParameter("subject_code").equals("")) {
			bean.setSubject_code(0);
		}else {
		bean.setSubject_code(Integer.parseInt(multi.getParameter("subject_code")));
		}
		if(request.getParameter("class_id") == null || request.getParameter("class_id").equals("")) {
			bean.setClass_id(0);
		}else {
		bean.setClass_id(Integer.parseInt(multi.getParameter("class_id")));
		}
		
		EmployeesDao dao = new EmployeesDao();
		
			System.out.println("직원정보 수정이 완료되었습니다.");
			int cnt = -99999;
			cnt = dao.UpdateData(bean);
			
			System.out.println("cnt : " + cnt);
			request.setAttribute("tid", bean.getTid());
			
			new DetailEmployerController().doGet(request, response);
			
	}
		
}
