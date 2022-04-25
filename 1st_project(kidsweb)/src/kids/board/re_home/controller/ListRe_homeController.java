package kids.board.re_home.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.board.re_home.model.Re_home;
import kids.board.re_home.model.Re_homeDao;
import kids.common.controller.SuperClass;
import kids.members.employees.model.Employees;
import kids.members.parents.model.ParentsDao;
import kids.members.parents.model.ParentsMiniView;
import kids.members.student.model.Student;
import kids.members.student.model.StudentDao;

public class ListRe_homeController extends SuperClass {
	@Override
	//직원용(담임)
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		String status = request.getParameter("status");
		if(status == null || status.equals("null") || status.equals("")) {
			status = "all";
		}
		String imsisid = request.getParameter("sid");
		if(imsisid == null || imsisid.equals("null") || imsisid.equals("")) {
			imsisid = "0";
		}
		int sid = Integer.parseInt(imsisid);
		
		Employees loginfo = (Employees)super.session.getAttribute("loginfo");
		int class_id = loginfo.getClass_id();
		
		StudentDao sdao = new StudentDao();
		List<Student> slists = sdao.selectDataList(class_id);
		request.setAttribute("slists", slists);
		
		ParentsDao pdao = new ParentsDao();
		List<ParentsMiniView> plists = pdao.selectPidList(sid);  
		
		Re_homeDao rdao = new Re_homeDao();
		List<Re_home> lists =rdao.selectDataList(status, plists);
		
		
		
		
		
		//학부모일때는 신청하기 기능만 가능... 근데 본인이 작성한 글을 볼 수 있어야 한다. 승인상태 확인 가능
		
		//선생님은 목록보기 및 승인하기 기능 가능
		//선생님일때는 loginfo.tid와 게시물의 tid를 비교하여 같으면 출력한다.
		//조건 처리 : not check/check, 
		//선생님과 학부모의 접점은 sid. 학부모 loginfo의 sid와 선생님의 class_id에서 얻은 학생들의 sid를 비교해서 같으면 출력한다.
		//선생님의 loginfo의 class_id를 챙겨 학생 테이블에서 같은 class_id를 가진 학생들의 목록을 출력한다. 그리고 sid를 학부모의 loginfo와 비교한다.
		//같을 경우만 출력.
		//c:forEach 안에 c:if를 써서 처리.
		//학부모일때는 loginfo.pid와 게시물의 pid를 비교하여 같으면 출력한다.
		
	}
}
