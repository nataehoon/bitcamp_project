package kids.management.sales_table.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.common.controller.SuperClass;
import kids.common.utility.FlowParameters;
import kids.common.utility.Paging;
import kids.management.sales_table.model.Sales_table2;
import kids.management.sales_table.model.Sales_tableDao;

public class ListSalesController extends SuperClass {
@Override
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	super.doGet(request, response);

	FlowParameters parameters
		= new FlowParameters(
				request.getParameter("pageNumber"),
				request.getParameter("mode"),
				request.getParameter("keyword"));
	
	System.out.println("parameter list");
	System.out.println(parameters.toString());
		
	String contextPath = request.getContextPath();
	String url = contextPath + "/Kids?command=salList";
	
	Sales_tableDao dao = new Sales_tableDao();
	
	// 행 총 개수
	int totalCount = dao.SelectTotalCount(parameters.getMode(), parameters.getKeyword()); // 행(row) 총 개수
	System.out.println("total data size : " + totalCount);
	Paging pageInfo = new Paging(parameters.getPageNumber(),
								totalCount,
								url, 
								parameters.getMode(),
								parameters.getKeyword());
	
	List<Sales_table2> lists = dao.SelectDataList(
			pageInfo.getBeginRow()
			, pageInfo.getEndRow()
			, parameters.getMode()
			, parameters.getKeyword());
	
	System.out.println("비긴로" + pageInfo.getBeginRow() +"/" + "앤드로" + pageInfo.getEndRow());
	System.out.println("board list count : " + lists.size());
	
	request.setAttribute("lists", lists);
	request.setAttribute("pageInfo", pageInfo);
	
	// 자주 사용되는 파라미터를 속성으로 정의합니다.
	request.setAttribute("parameters", parameters.toString());
	
	String gotopage = "/sales/salList.jsp" ;
	super.GotoPage(gotopage);
	
}
} 
