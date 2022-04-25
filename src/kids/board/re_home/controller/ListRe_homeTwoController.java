package kids.board.re_home.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.common.controller.SuperClass;
import kids.members.employees.model.Employees;
import kids.members.parents.model.ParentsMiniView;

public class ListRe_homeTwoController extends SuperClass {
	//학부모용
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		ParentsMiniView bean = (ParentsMiniView)super.session.getAttribute("loginfo");
		Employees ebean = (Employees)super.session.getAttribute("loginfo");
		
		
		
		
		
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
