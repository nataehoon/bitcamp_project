package controller.diet;

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

import bean.Diet;
import bean.Log;
import controller.common.SuperClass;
import dao.DietDao;

@Controller
public class DietUpdateController extends SuperClass {
	private final String command = "/update.di";
	private ModelAndView mav = null;
	private String redirect = "redirect:/dietdetail.di?dietno=" ;
	
	@Autowired
	@Qualifier("ddao")
	private DietDao dao;
	
	@ModelAttribute("diet")
	public Diet mydiet() {
		return new Diet();
	}
	
	public DietUpdateController() {
		super("dietupdate", "dietdetail");
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value="dietno", required = true) int dietno) {
		//운동올지 수정폼 이동
		Diet bean = dao.selectByPk(dietno);
		System.out.println(bean);
		
		mav.addObject("bean", bean);
		
		this.mav.setViewName(super.getpage);
		return this.mav;
	}
	
	@PostMapping(command)
	public ModelAndView doPost(
			@ModelAttribute("log") @Valid Diet xxx, BindingResult asdf) {
		if(asdf.hasErrors()) {
			System.out.println("유효성 검사에 문제 있음");
			System.out.println(xxx.toString());
			System.out.println(asdf.toString());
			mav.addObject("bean", xxx);
			mav.setViewName(getpage);
		}else {
			System.out.println("유효성 검사에 문제 없음");
			int cnt = -99999;
			cnt = dao.UpdateData(xxx);
			
			String gotopage = this.redirect + xxx.getDietno();
			mav.setViewName(gotopage);
		}
		return this.mav;
		
	}

}
