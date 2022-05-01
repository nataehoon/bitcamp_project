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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.Member;
import controller.common.SuperClass;
import dao.MemberDao;

@Controller
public class MeUpdateController extends SuperClass {
	private final String command = "/update.me";
	private ModelAndView mav = null;
	private String redirect = "redirect:/detail.me" ;
	
	@Autowired
	@Qualifier("mdao")
	private MemberDao dao;
	
	public MeUpdateController() {
		super("meupdate", "detail");
		this.mav = new ModelAndView();
	}
	@ModelAttribute("member")
	public Member mymember() {
		return new Member() ;
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "id", required = true) String id) {
		Member bean = dao.SelectByPk(id);
		
		mav.addObject("bean", bean);
		this.mav.setViewName(super.getpage);
		return this.mav;
	}
	
	@PostMapping(command)
	public ModelAndView doPost(
			@ModelAttribute("member") @Valid Member xxx, BindingResult asdf) {
		if(asdf.hasErrors()) {
			System.out.println("유효성 검사에 문제있음");
			System.out.println(xxx.toString());
			System.out.println(asdf.toString());
			mav.addObject("bean", xxx);
			mav.setViewName(super.getpage);
		}else {
			System.out.println("유효성 검사에 문제가 없음");
			int cnt = -99999;
			cnt = dao.UpdateData(xxx);
			
			String gotopage = this.redirect + "?id=" + xxx.getId();
			mav.setViewName(gotopage);
		}
		
		return this.mav;
		
	}
	
	
}
