package kids.board.medicine.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.board.medicine.model.MedicineDao;
import kids.common.controller.SuperClass;

public class CheckMedicineController extends SuperClass {
 @Override
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	super.doGet(request, response);

	int meno = Integer.parseInt(request.getParameter("meno"));
	
	MedicineDao dao = new MedicineDao();
	int cnt = dao.CheckData(meno);
	System.out.println("meno");
	if(cnt > 0 ) {
		System.out.println("정상적으로 '읽음'으로 변경되었습니다.");
	}else {
		System.out.println("입력에 실패했습니다.");
	}
	
	//request.setAttribute("bean", bean);
	//request.setAttribute("content", content);
	
	new ListMedicineController().doGet(request, response);
}
}
