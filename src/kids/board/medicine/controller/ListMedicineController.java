package kids.board.medicine.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.board.medicine.model.Medicine2;
import kids.board.medicine.model.MedicineDao;
import kids.common.controller.SuperClass;
import kids.common.utility.FlowParameters;
import kids.common.utility.Paging;

public class ListMedicineController extends SuperClass {
@Override
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	super.doGet(request, response);
	
	System.out.println("리스트메디슨 컨트롤러");
	
	FlowParameters parameters = new FlowParameters(
			request.getParameter("pageNumber"),
			request.getParameter("mode"),
			request.getParameter("keyword"));
	System.out.println("parameters list : " + parameters.toString());
	
	String url = request.getContextPath() + "/Kids?command=meList";
	
	MedicineDao dao = new MedicineDao();
	int totalCount = dao.SelectTotalCount(
				parameters.getMode(),
				parameters.getKeyword());
	
	Paging pageInfo = new Paging(
			parameters.getPageNumber(),
			totalCount,
			url,
			parameters.getMode(),
			parameters.getKeyword());
			
	List<Medicine2> lists = dao.SelectDataList(
			pageInfo.getBeginRow(),
			pageInfo.getEndRow(),
			parameters.getMode(),
			parameters.getKeyword());
	
	List<Medicine2> cn_lists = dao.SelectDataList();
	
	System.out.println("notice_board size : " + lists.size());
	
	request.setAttribute("lists", lists);
	request.setAttribute("pageInfo", pageInfo);
	request.setAttribute("parameters", parameters);
	request.setAttribute("cn_lists", cn_lists);
	
	String gotopage = "/medicine/meList.jsp" ;
	super.GotoPage(gotopage);
	 
}	
} 
