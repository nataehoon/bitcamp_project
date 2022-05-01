package controller.posture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import bean.Posture;
import controller.common.SuperClass;
import dao.PostureDao;

@Controller
public class PostureUpdateController extends SuperClass {
	private final String command = "/update.po";
	private ModelAndView mav = null;
	private String redirect = "redirect:/polist.po" ;

	@Autowired
	@Qualifier("pdao")
	private PostureDao dao;
	
	@ModelAttribute("posture")
	public Posture myhealth() {
		return new Posture();
	}
	
	public PostureUpdateController() {
		super("poupdate", "polist");
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet() {
		this.mav.setViewName(super.getpage);
		return this.mav;
	}
	
	@PostMapping(command)
	public ModelAndView doPost(
			@ModelAttribute("posture") @Valid Posture xxx, BindingResult asdf) {
		if(asdf.hasErrors()) {
			System.out.println("유효성 검사에 문제 있음");
			mav.addObject("bean", xxx);
			mav.setViewName(getpage);
		}else {
			System.out.println("유효성검사 문제없음");
			int cnt = -99999;
			cnt = dao.UpdateData(xxx);
			
			mav.setViewName(redirect);
		}
		return this.mav;
	}

}
