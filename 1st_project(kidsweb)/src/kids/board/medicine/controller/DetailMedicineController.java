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

public class DetailMedicineController extends SuperClass {
@Override
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	super.doGet(request, response);
	int meno = Integer.parseInt(request.getParameter("meno")) ;
	   
    MedicineDao dao = new MedicineDao();
    Medicine2 bean = dao.SelectDataByPk(meno);
    
    // 로그인한 사람의 객체 정보 
    //Member loginfo = (Member)super.session.getAttribute("loginfo");
    // 로그인 한 사람과 게시물 작성자가 다르거나, 작성자 정보가 없는 경우 
    /*if(loginfo.getId().equals(bean.getWriter())== false
          || bean.getWriter() == null) {
       dao.UpdateReadhit(no); // 조회수 1 증가시키기 
       bean.setReadhit(bean.getReadhit()+1);
    }*/
    System.out.println("디테일 메디슨 컨트롤러");
    request.setAttribute("bean", bean);
    
    String gotopage = "/medicine/meDetail.jsp" ;
    super.GotoPage(gotopage);
 }   
} 
