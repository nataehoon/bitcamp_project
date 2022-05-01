package controller.place;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.Hospital;
import controller.common.SuperClass;
import dao.HospitalDao;

@Controller
public class HospitalDetailController extends SuperClass {
	private final String command = "hodetail.pl";
	private ModelAndView mav = null;
	
	@Autowired
	@Qualifier("hodao")
	private HospitalDao dao;
	
	public HospitalDetailController() {
		super("hospitaldetail", null);
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "hono", required = true) int hono) {
		Hospital bean = dao.SelectByPk(hono);
		
		mav.addObject("bean", bean);
		
		mav.setViewName(super.getpage);
		return this.mav;
	}

}
