package controller.diet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import controller.common.SuperClass;
import dao.DietDao;

@Controller
public class DietDeleteController extends SuperClass {
	private final String command = "/delete.di";
	private ModelAndView mav = null;
	
	@Autowired
	@Qualifier("ddao")
	private DietDao dao;
	
	public DietDeleteController() {
		super("dietlist", null);
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "dietno", required = true) int dietno) {
		
		int cnt = -99999;
		cnt = dao.DeleteData(dietno);
		
		this.mav.setViewName(super.getpage);
		return this.mav;
		
	}
}
