package controller.diet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.Diet;
import controller.common.SuperClass;
import dao.DietDao;

@Controller
public class DietDetailController extends SuperClass {
	private final String command = "/detail.di";
	private ModelAndView mav = null;
	
	@Autowired
	@Qualifier("ddao")
	private DietDao dao;
	
	public DietDetailController() {
		super("dietdetail", null);
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "dietno", required = true) int dietno) {
		
		Diet bean = dao.selectByPk(dietno);
		System.out.println(bean);
		
		mav.addObject("bean", bean);
		
		this.mav.setViewName(super.getpage);
		return this.mav;
		
	}
}
