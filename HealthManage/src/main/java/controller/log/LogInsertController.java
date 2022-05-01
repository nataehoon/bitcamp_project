package controller.log;

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

import bean.Log;
import controller.common.SuperClass;
import dao.ExerciseLogDao;

@Controller
public class LogInsertController extends SuperClass {
	private final String command = "/insert.lo";
	private ModelAndView mav = null;
	private String redirect = "redirect:/loglist.lo" ;
	
	@Autowired
	@Qualifier("lodao")
	private ExerciseLogDao dao;
	
	@ModelAttribute("log")
	public Log mylog() {
		return new Log();
	}
	
	public LogInsertController() {
		super("loginsert", null);
		this.mav = new ModelAndView();
	}
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "id", required = true) String id) {
		mav.addObject("bean", id);
		this.mav.setViewName(super.getpage);
		return this.mav;
	}
	
	@PostMapping(command)
	public ModelAndView doPost(
			@ModelAttribute("log") @Valid Log xxx, BindingResult asdf) {
		System.out.println("sdkaskdjsakdj");
		
		if(asdf.hasErrors()) {
			System.out.println("유효성 검사에 문제 있음");
			System.out.println(xxx.toString());
			System.out.println(asdf.toString());
			mav.addObject("bean", xxx);
			mav.setViewName(super.getpage);
		}else {
			System.out.println("유효성 검사에 문제가 없음");
			int cnt = -99999;
			cnt = dao.InsertData(xxx);
			String gotopage = redirect + "?id=" + xxx.getId();
			mav.setViewName(gotopage);
		}
		return this.mav;
	}
	
}
