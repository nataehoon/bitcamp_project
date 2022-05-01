package controller.member;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import bean.Member;
import controller.common.SuperClass;
import dao.MemberDao;

@Controller
public class MeInsertController extends SuperClass {
	private final String command = "/insert.me";
	private ModelAndView mav = null;
	private String redirect = "redirect:/login.me" ;
	
	@Autowired
	@Qualifier("mdao")
	private MemberDao dao;
	
	public MeInsertController() {
		super("meinsert", "login");
		this.mav = new ModelAndView();
	}
	@ModelAttribute("member")
	public Member mymember() {
		return new Member() ;
	}
	
	@GetMapping(command)
	public ModelAndView doGet() {
		this.mav.setViewName(super.getpage);
		return this.mav;
	}
	
	@PostMapping(command)
	public ModelAndView doPost(
			@ModelAttribute("member") @Valid Member xxx, BindingResult asdf) {
		System.out.println(xxx.toString());
		if(asdf.hasErrors()) {
			System.out.println("유효성 검사에 문제있음");
			System.out.println(xxx.toString());
			System.out.println(asdf.toString());
			mav.addObject("bean", xxx);
			mav.setViewName(super.getpage);
		}else {
			System.out.println("유효성 검사에 문제가 없음");
			int cnt = -99999;
			cnt = dao.InsertData(xxx);
			
			mav.setViewName(this.redirect);
		}
		
		return this.mav;
		
	}
	
	
}
