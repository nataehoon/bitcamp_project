package controller.posture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.Posture;
import controller.common.SuperClass;
import dao.PostureDao;

@Controller
public class PostureDetailController extends SuperClass {
	private final String command = "/detail.po";
	private ModelAndView mav = null;
	
	@Autowired
	@Qualifier("pdao")
	private PostureDao dao;
	
	public PostureDetailController() {
		super("podetail", null);
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "pono", required = true) int pono) {
		
		Posture bean = dao.SelectPk(pono);
		System.out.println(bean);
		
		mav.addObject("bean", bean);
		
		this.mav.setViewName(super.getpage);
		return this.mav;
		
	}
}
