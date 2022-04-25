package kids.management.st_total.stu_fee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.common.controller.SuperClass;
import kids.management.st_total.stu_fee.model.Stu_fee2;
import kids.management.st_total.stu_fee.model.Stu_feeDao;

public class UpdateStudentFeeController extends SuperClass {
 @Override
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	super.doGet(request, response);
	System.out.println("업데이트 stf get들어옴");
	new ListStudentFeeController().doGet(request, response);
}
 
 @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		String[] payno = request.getParameterValues("payno");
		//int remark = Integer.parseInt(request.getParameter("remark"));
		if(validate(request)) {
			Stu_feeDao dao = new Stu_feeDao();
			Stu_fee2 bean = null;
			int cnt = -99999;
			if(request.getParameter("state").equals("완납")) {
				cnt = dao.UpdateData(payno);
			}else if(request.getParameter("state").equals("분납")) {
				for(String a : payno) {
					cnt = dao.SelectDataByPk(a);
					if(cnt == 1) {
					// state가 분납일 때 insert 하기
						cnt = dao.InsertData(Integer.parseInt(a), Integer.parseInt(request.getParameter("remark")));
					}else {
						cnt = dao.UpdateData(Integer.parseInt(a), Integer.parseInt(request.getParameter("remark")));
					}
				}
			}
			
		}
		new ListStudentFeeController().doGet(request, response);
	}
 
 @Override
	public boolean validate(HttpServletRequest request) {
	boolean check = false;
	final String REGEX = "[0-9]+";
	
	if(request.getParameter("state").equals("분납")) {
		if(request.getParameter("remark").equals("null") || request.getParameter("remark").equals("") || request.getParameter("remark") ==null) {
			System.out.println("분납할 액수를 입력하세요.");
			request.setAttribute(super.PREFIX + "remark", "분납할 액수를 입력하세요.");
			check = false;
		}else if(!request.getParameter("remark").matches(REGEX)) {
			request.setAttribute(super.PREFIX + "remark", "숫자만 입력하세요.");
			check = false;
		}else {
			check = true;
		}
	}
	if(request.getParameter("state").equals("완납")) {
		String[] payno = request.getParameterValues("payno");
		Stu_feeDao dao = new Stu_feeDao();
		Stu_fee2 bean = null;
		int cnt = -99999;
		cnt = dao.SelectDataByPk(payno);//분납 찾기
		if(cnt == 1) {
			System.out.println("'분납'은 완납처리를 할 수 없습니다.");
			request.setAttribute(super.PREFIX + "remark", "'분납'은 완납처리를 할 수 없습니다.");
			check = false;
		}else {
			check = true;
		}
	}
	
		return check;
	}
}
