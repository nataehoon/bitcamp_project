package controller.health;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.Health;
import bean.Member;
import controller.common.SuperClass;
import dao.HealthDao;

@Controller
public class HealthInsertController extends SuperClass {
	private final String command = "/insert.he";
	private ModelAndView mav = null;
	private final String redirect = "redirect:/healthlist.he";
	
	@Autowired
	@Qualifier("hdao")
	private HealthDao dao;
	
	@ModelAttribute("inserthealth")
	public Health myhealth() {
		return new Health();
	}
	
	public HealthInsertController() {
		super("healthinsert", null);
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "id", required = true) String id) {
		Member mbean = dao.SelectById(id);
		
		mav.addObject("mbean", mbean);
		mav.setViewName(super.getpage);
		return this.mav;
	}
	
	@PostMapping(command)
	public ModelAndView doPost(
			@ModelAttribute("inserthealth") @Valid Health xxx, BindingResult asdf) {
		System.out.println(xxx.toString());
		if(asdf.hasErrors()) {
			System.out.println("유효성검사 문제");
			mav.addObject("bean", xxx);
			mav.setViewName(super.getpage);
		} else {
			System.out.println("유효성 검사 통과");
			int cnt = -99999;
			cnt = dao.InsertData(xxx);
			
			String gotopage = this.redirect + "?id=" + xxx.getId();
			mav.setViewName(gotopage);
		}
		
		return this.mav;
	}
}
