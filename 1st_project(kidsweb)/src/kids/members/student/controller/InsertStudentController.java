package kids.members.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kids.common.controller.SuperClass;
import kids.management.reservation.model.Reservation;
import kids.management.reservation.model.ReservationDao;
import kids.members.student.model.Student;
import kids.members.student.model.StudentDao;

public class InsertStudentController extends SuperClass {
	private Student bean = null;
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);

		String gotopage = "/student/stInsert.jsp" ;
		super.GotoPage(gotopage);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
		MultipartRequest multi = (MultipartRequest)request.getAttribute("multi") ;
		
		bean = new Student();
		//int class_id = null;
		String name = multi.getParameter("name");
		String gender = multi.getParameter("gender");
		String hp = multi.getParameter("hp");
		String birth = multi.getParameter("birth");
		String zipcode = multi.getParameter("zipcode");
		String address1 = multi.getParameter("address1");
		String address2 = multi.getParameter("address2");
		String image = multi.getFilesystemName("image");
		String content = multi.getParameter("content");
	
//		bean.setClass_id(class_id);
		bean.setName(name);
		bean.setHp(hp);
		bean.setBirth(birth);
		bean.setAddress1(address1);
		bean.setAddress2(address2);
		bean.setGender(gender);
		bean.setTextarea(content);
		bean.setImage(image);
		
		
//	   if (this.validate(request) == true) {
//	         System.out.println("student insert validation check success");
	         StudentDao sdao = new StudentDao();
	         
	         int cnt = -99999;
	 		cnt = sdao.insertData(bean);
	         
	         new ListStudentController().doGet(request, response);
	         
//	      } else {
//	         System.out.println("student insert validation check failure");
//	         request.setAttribute("bean", bean);
//	         super.doPost(request, response);
//	         
//	         String gotopage = "/student/stlInsert.jsp" ;
//	 		super.GotoPage(gotopage);
//	 		}
	      }
	   
	   @Override
	   public boolean validate(HttpServletRequest request) {
	      boolean isCheck = true;
	      
		if(bean.getName().length() > 1 || bean.getName().length() < 5) {
			request.setAttribute(super.PREFIX + "name", "이름은(는) 1자리 이상 5자리이하이어야 합니다.");
	         isCheck = false;
	      }
		if(bean.getHp().length() > 7 || bean.getHp().length() < 11) {
			request.setAttribute(super.PREFIX + "hp", "핸드폰번호는 7자리 이상 11자리이하이어야 합니다.");
		}
		if(bean.getAddress1() == null || bean.getAddress1().equals("")) {
			request.setAttribute(super.PREFIX + "address1", " 주소는 필수 입력 사항입니다.");
		}
		if(bean.getAddress2() == null || bean.getAddress2().equals("")) {
			request.setAttribute(super.PREFIX + "address2", " 세부 주소는 필수 입력 사항입니다.");
		}
		if(bean.getGender() == null || bean.getGender().equals("")) {
			request.setAttribute(super.PREFIX + "gender", "성별은 필수 입력 사항입니다.");
		}
		
		 return isCheck;
	     }
}
