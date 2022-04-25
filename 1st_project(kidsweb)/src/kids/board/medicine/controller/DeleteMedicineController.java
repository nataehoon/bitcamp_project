package kids.board.medicine.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.board.medicine.model.MedicineDao;
import kids.board.notice_board.controller.ListNoticeController;
import kids.common.controller.SuperClass;

public class DeleteMedicineController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
		int meno = Integer.parseInt(request.getParameter("meno"));
		System.out.println("meno"+ meno);
		MedicineDao dao = new MedicineDao();
		
		int cnt = -99999;
		cnt = dao.DeleteData(meno);
		if(cnt == 1) {
			System.out.println("투약의뢰서 삭제 완료");
			new ListMedicineController().doGet(request, response);
		}else {
			System.out.println("투약의뢰서 삭제 실패");
			new ListMedicineController().doGet(request, response);
		}
	}
} 
