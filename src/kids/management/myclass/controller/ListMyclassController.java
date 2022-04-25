package kids.management.myclass.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kids.common.controller.SuperClass;
import kids.management.myclass.model.Myclass;
import kids.management.myclass.model.MyclassDao;

public class ListMyclassController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		MyclassDao dao = new MyclassDao();
		List<Myclass> lists = dao.SelectDataList();
		request.setAttribute("lists", lists);
		String gotopage = "/myclass/myclList.jsp" ;
		super.GotoPage(gotopage);
	}
	
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}
}
