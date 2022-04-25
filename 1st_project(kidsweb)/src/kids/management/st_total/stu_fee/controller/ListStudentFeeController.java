package kids.management.st_total.stu_fee.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.common.controller.SuperClass;
import kids.common.utility.FlowParametersStf;
import kids.common.utility.PagingStf;
import kids.management.st_total.stu_fee.model.Stu_fee2;
import kids.management.st_total.stu_fee.model.Stu_feeDao;

public class ListStudentFeeController extends SuperClass {
@Override
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	super.doGet(request, response);
	
	FlowParametersStf parameters
		= new FlowParametersStf(
				request.getParameter("pageNumber"),
				request.getParameter("month"),
				request.getParameter("paid"),
				request.getParameter("class_name"),
				request.getParameter("pageSize"));
	
	System.out.println("parameter list");
	System.out.println(parameters.toString());
		
	String contextPath = request.getContextPath();
	String url = contextPath + "/Kids?command=stfList";
	
	Stu_feeDao dao = new Stu_feeDao();
	
	// 행 총 개수
	int totalCount = dao.SelectTotalCount(parameters.getMonth(), parameters.getPaid(),parameters.getClass_name()); // 행(row) 총 개수
	System.out.println("total data size : " + totalCount);
	
	PagingStf pageInfo = new PagingStf(parameters.getPageNumber(),
								totalCount,
								url, 
								parameters.getMonth(),
								parameters.getPaid(),
								parameters.getClass_name(),
								parameters.getPageSize());
	
	List<Stu_fee2> lists = dao.SelectDataList(
			pageInfo.getBeginRow()
			, pageInfo.getEndRow()
			, parameters.getMonth()
			, parameters.getPaid()
			, parameters.getClass_name());
	
	System.out.println("비긴로" + pageInfo.getBeginRow() +"/" + "앤드로" + pageInfo.getEndRow());
	System.out.println("board list count : " + lists.size());
	
	request.setAttribute("lists", lists);
	request.setAttribute("pageInfo", pageInfo);
	
	// 자주 사용되는 파라미터를 속성으로 정의합니다.
	request.setAttribute("parameters", parameters.toString());
	
	
	String gotopage = "/stu_fee/stfList.jsp" ;
	super.GotoPage(gotopage);
}
} 
