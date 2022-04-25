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

public class InsertEmployerController extends SuperClass {
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
		
		String gotopage = "/employees/empInsertForm.jsp" ;
		super.GotoPage(gotopage);
	}	

/*	@Override
	public boolean validate(HttpServletRequest request) {
		boolean isCheck = true;
		System.out.println(bean);
		
		if(bean.getTid().length() < 4 || bean.getTid().length() > 10) {
			System.out.println("asdsad" + bean.getTid().length());
			request.setAttribute(super.PREFIX + "tid", "아이디는 4자리 이상 10자리 이하여야 합니다.");
			isCheck = false;
		}
		if(bean.getPassword().length() < 4 || bean.getPassword().length() > 12) {
			request.setAttribute(super.PREFIX + "password", "비밀번호는 4자리 이상 12자리 이하여야 합니다.");
			isCheck = false;
		}
		if(bean.getName().length() < 2 || bean.getName().length() > 10) {
			request.setAttribute(super.PREFIX + "name", "이름 2자리 이상 10자리 이하여야 합니다.");
			isCheck = false;
		}
		if(bean.getBirth() == null || bean.getBirth().equals("")) {
			request.setAttribute(super.PREFIX + "birth", "생일은 반드시 입력되어야 합니다.");
			isCheck = false;
		}
		String inputdate = "\\d{4}[-/]\\d{2}[-/]\\d{2}";
		
		boolean result = Pattern.matches(inputdate, bean.getBirth());
		if(result == false) {
			request.setAttribute(super.PREFIX + "birth", "생일은 'yyyy/mm/dd'형식으로 입력해 주세요.");
			isCheck = false;
		}
		if(bean.getZipcode() == null || bean.getZipcode().equals("")) {
			request.setAttribute(super.PREFIX + "zipcod", "우편 번호는 반드시 입력되어야 합니다.");
			isCheck = false;
		}
		if(bean.getAddress1() == null || bean.getAddress1().equals("")) {
			request.setAttribute(super.PREFIX + "address1", "우편 번호 찾기를 클릭하세요.");
			isCheck = false;
		}
		return isCheck;
	}
*/	
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
			bean.setSubject_code(Integer.parseInt(multi.getParameter("subject_code")));
			bean.setClass_id(Integer.parseInt(multi.getParameter("class_id")));
			
			
			if(request.getParameter("responsibilities") == null || request.getParameter("responsibilities").equals("")) {
				bean.setResponsibilities("직원");
			}
			
			if(request.getParameter("salary") == null || request.getParameter("salary").equals("")) {
				bean.setSalary(0);
			}
			
			if(request.getParameter("submit") == null || request.getParameter("submit").equals("")) {
				bean.setSubmit("미승인");
			}
			
			EmployeesDao dao = new EmployeesDao();
			
	/*		if(this.validate(request) == true) { */
				System.out.println("가입신청이 완료되었습니다.");
				int cnt = -99999;
				cnt = dao.InsertData(bean);
				
				System.out.println("cnt : " + cnt);
				String gotopage = "/start.jsp";
				super.GotoPage(gotopage);
	/*		} else { 
				System.out.println("가입신청 실패");
				
				request.setAttribute("bean", bean);
				
				new InsertEmployerController().doGet(request, response);
			} */
		}
}

