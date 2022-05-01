package controller.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.Member;
import controller.common.SuperClass;
import dao.MemberDao;

@Controller
public class MeLoginController extends SuperClass {
	private final String command = "/login.me";
	private ModelAndView mav = null;
	private String redirect = "redirect:/main.co" ;
	
	@Autowired
	@Qualifier("mdao")
	private MemberDao dao;
	
	public MeLoginController() {
		super("login","main");
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet() {
		this.mav.setViewName(super.getpage);
		return this.mav;
	}
	
	@PostMapping(command)
	public ModelAndView doPost(
			@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "password", required = true) String password,
			HttpSession session) {
		Member bean = this.dao.SelectData(id, password);
		
		if(bean == null) {
			System.out.println("로그인 실패");
			String message = "아이디나 비밀번호가 잘못되었습니다.";
			mav.addObject("errmasg", message);
			mav.setViewName(super.getpage);
		}else {
			System.out.println("로그인 성공");
			session.setAttribute("loginfo", bean);
			mav.setViewName(redirect);
		}
		
		return this.mav;
		
	}

}
