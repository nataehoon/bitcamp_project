package controller.place;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.Fitness;
import controller.common.SuperClass;
import dao.FitnessDao;

@Controller
public class FitnessDetailController extends SuperClass {
	private final String command = "/fitdetail.pl";
	private ModelAndView mav = null;
	
	@Autowired
	@Qualifier("fdao")
	private FitnessDao dao;
	
	public FitnessDetailController() {
		super("fitdetail", null);
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "fitno", required = true) int fitno) {
		Fitness bean = dao.SelectByPk(fitno);
		
		mav.addObject("bean" ,bean);
		
		mav.setViewName(super.getpage);
		return this.mav;
	}
}
