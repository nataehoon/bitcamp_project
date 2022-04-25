package kids.members.student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.common.controller.SuperClass;
import kids.common.utility.FlowParameters;
import kids.common.utility.Paging;
import kids.members.student.model.Student;
import kids.members.student.model.StudentDao;

public class ListStudentController extends SuperClass {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		FlowParameters parameters 
		= new FlowParameters(
				request.getParameter("pageNumber"), 
				request.getParameter("mode"), 
				request.getParameter("keyword")); 
	
	System.out.println("parameter list ");
	System.out.println(parameters.toString());
		
	String contextPath = request.getContextPath() ;
	String url = contextPath + "/Kids?command=stList" ;
	
	StudentDao dao = new StudentDao();
	
	int totalCount = dao.SelectTotalCount(parameters.getMode(), parameters.getKeyword()) ; 
	System.out.println("total data size : " + totalCount); 
	
	Paging pageInfo = new Paging(
							parameters.getPageNumber(), 
							totalCount, 
							url, 
							parameters.getMode(), 
							parameters.getKeyword()) ;	 	
	    
	List<Student> lists = dao.selectDataList(
				pageInfo.getBeginRow(), 
				pageInfo.getEndRow(), 
				parameters.getMode(), 
				parameters.getKeyword() ) ;
	
	System.out.println("student list count : " + lists.size()); 
	
	request.setAttribute("lists", lists);
	request.setAttribute("pageInfo", pageInfo);
	
	// 자주 사용되는 파라미터를 속성으로 정의합니다. 
	request.setAttribute("parameters", parameters.toString());
	
	String gotopage = "/student/stList.jsp" ;
	super.GotoPage(gotopage);
	}	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		}
		
	
	}
