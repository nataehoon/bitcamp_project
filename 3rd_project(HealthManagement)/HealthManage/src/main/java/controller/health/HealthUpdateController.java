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
import controller.common.SuperClass;
import dao.HealthDao;

@Controller
public class HealthUpdateController extends SuperClass {
	private final String command = "/update.he";
	private ModelAndView mav = null;
	private String redirect = "redirect:/healthlist.he" ;

	@Autowired
	@Qualifier("hdao")
	private HealthDao dao;
	
	@ModelAttribute("inserthealth")
	public Health myhealth() {
		return new Health();
	}
	
	public HealthUpdateController() {
		super("healthupdate", "healthlist");
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "healthno", required = true) int healthno) {
		Health bean = dao.SelectByPk(healthno);
		
		mav.addObject("bean", bean);
		this.mav.setViewName(super.getpage);
		return this.mav;
	}
	
	@PostMapping(command)
	public ModelAndView doPost(
			@ModelAttribute("inserthealth") @Valid Health xxx, BindingResult asdf) {
		if(asdf.hasErrors()) {
			System.out.println("유효성 검사에 문제 있음");
			mav.addObject("bean", xxx);
			mav.setViewName(getpage);
		}else {
			System.out.println("유효성검사 문제없음");
			int cnt = -99999;
			cnt = dao.UpdateData(xxx);
			
			String gotopage = this.redirect + "&id=" + xxx.getId();
			mav.setViewName(gotopage);
		}
		return this.mav;
	}

}
