package kids.management.st_total.st_manage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.common.controller.SuperClass;
import kids.management.st_total.st_manage.model.St_management;
import kids.management.st_total.st_manage.model.St_managementDao;
import kids.members.parents.model.ParentsMiniView;

public class ListStudentHWController extends SuperClass {
  @Override
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	super.doGet(request, response);
	
	//ParentsMiniView loginfo = (ParentsMiniView)super.session.getAttribute("loginfo");
	St_managementDao dao = new St_managementDao();
	List<St_management> lists = dao.getList();
	System.out.println("sthw리스트 나왔는지 확인" + lists.size());
	
	request.setAttribute("lists", lists);
	String gotopage = "/st_manage/sthwList.jsp" ;
	super.GotoPage(gotopage);
}
}
