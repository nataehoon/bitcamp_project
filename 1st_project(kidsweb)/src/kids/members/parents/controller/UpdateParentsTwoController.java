package kids.members.parents.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kids.common.controller.SuperClass;
import kids.members.parents.model.Parents;
import kids.members.parents.model.ParentsDao;

public class UpdateParentsTwoController extends SuperClass {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원 정보 수정 폼에서 전달 받음
		super.doPost(request, response);

		MultipartRequest multi = (MultipartRequest)request.getAttribute("multi");
		System.out.println("multi : "+multi);
		Parents bean = new Parents();
		String pid = multi.getParameter("pid");
		String name = multi.getParameter("name");
		String hp = multi.getParameter("hp");
		String address1 = multi.getParameter("address1");
		String address2 = multi.getParameter("address2");
		String gender = multi.getParameter("gender");
		String password = multi.getParameter("password");
		String birth = multi.getParameter("birth");
		String email = multi.getParameter("email1")+"@"+multi.getParameter("email2");
		
		String zipcode = multi.getParameter("zipcode");
		
		
		
		if(!(multi.getParameter("sid") == null || multi.getParameter("sid").equals("null") || multi.getParameter("sid").equals(""))){
			System.out.println("sid 처리");
			int sid = Integer.parseInt(multi.getParameter("sid"));
			bean.setSid(sid);
			System.out.println("sid : "+sid);
		}
		String relationship = multi.getParameter("relationship");
		String image = multi.getParameter("image");
		if(!(multi.getFilesystemName("fakeimage") == null || multi.getFilesystemName("fakeimage").equals("null") || multi.getFilesystemName("fakeimage").equals(""))){
			System.out.println("fakeimage 처리에 들어옴");
			image = multi.getFilesystemName("fakeimage");
		}
		System.out.println("image : "+ image);
		
		bean.setPid(pid);
		bean.setName(name);
		bean.setHp(hp);
		bean.setAddress1(address1);
		bean.setAddress2(address2);
		bean.setGender(gender);
		bean.setPassword(password);
		bean.setBirth(birth);
		bean.setEmail(email);
		bean.setImage(image);
		bean.setZipcode(zipcode);
		
		bean.setRelationship(relationship);
		bean.setSubmit("승인");
		bean.setResponsibilities("보호자");
		
		String imsic = multi.getParameter("childid");
		String imsic2 = multi.getParameter("childid2");
		
		System.out.println("childid : " + imsic);
		System.out.println("childid2 : " + imsic2);
		
		if(!(imsic == null || imsic.equals("null") || imsic.equals(""))) {
			System.out.println("imsic if문에 들어옴!");
			int childid = Integer.parseInt(imsic);
			bean.setChildid(childid);
		}
		if(!(imsic2 == null || imsic2.equals("null") || imsic2.equals(""))) {
			System.out.println("imsic2 if문에 들어옴!");
			int childid2 = Integer.parseInt(imsic2);
			bean.setChildid2(childid2);
		}
		
		System.out.println("bean : "+bean);
		
		ParentsDao pdao = new ParentsDao();
		int cnt = pdao.updateData(bean);
		System.out.println("cnt : "+cnt);

		if(cnt == 1) {// 수정 성공
			request.setAttribute("pid", pid);
			request.setAttribute("message", "수정이 완료되었습니다");
			String gotopage = "parents/updateOK.jsp";
			super.GotoPage(gotopage);
		}else {
			String gotopage = "parents/paUpdate.jsp";
			request.setAttribute("bean", bean);
			super.GotoPage(gotopage);
		}
	
	}
	
} 
