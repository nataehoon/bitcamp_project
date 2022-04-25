package kids.management.st_total.st_manage.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.common.controller.SuperClass;
import kids.management.myclass.controller.ListMyclassController;
import kids.management.st_total.st_manage.model.St_management;
import kids.management.st_total.st_manage.model.St_managementDao;
import kids.members.employees.model.Employees;
import kids.members.student.model.Student;
import kids.members.student.model.StudentDao;

public class InsertStudentHWController extends SuperClass {
 @Override
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	super.doGet(request, response);
	
	int whologin = (Integer.parseInt((String)super.session.getAttribute("whologin")));
	if(whologin == 1 || whologin == 2) {
		//ParentsMiniView tbean = (ParentsMiniView)super.session.getAttribute("loginfo");
		Employees tbean = (Employees)super.session.getAttribute("loginfo");
		int class_id = tbean.getClass_id();
		System.out.println("class_id" + class_id);
		List<Student> sbean = new ArrayList<Student>();
		St_managementDao dao = new St_managementDao();
		StudentDao sdao = new StudentDao();
		sbean = sdao.SelectDataListByPk(class_id); // class_id로 sid, name 찾음
		System.out.println("sbean"+sbean.size());
		request.setAttribute("sbean", sbean);
	}
	
	String gotopage = "/st_manage/sthwInsert.jsp" ;
	super.GotoPage(gotopage);
}
 @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		St_management bean = null;
		int cnt = -99999;
		bean.setSid(Integer.parseInt(request.getParameter("sid")));
		bean.setPoop(Integer.parseInt(request.getParameter("poop")));
		bean.setHealthy(request.getParameter("healthy"));
		//메디슨 생략
		bean.setAttendance(request.getParameter("attendance"));
		//regdate는 다오에서
		bean.setSleep(request.getParameter("sleep"));
		bean.setCondition(request.getParameter("condition"));
		bean.setMeal(request.getParameter("meal"));
		bean.setHeight(request.getParameter("height"));
		bean.setWeight(request.getParameter("weight"));
		bean.setRemark(request.getParameter("remark"));
		
		St_managementDao dao = new St_managementDao();
		cnt = dao.InsertData(bean);
		
		 new ListStudentHWController().doGet(request, response);
		
	}
}
