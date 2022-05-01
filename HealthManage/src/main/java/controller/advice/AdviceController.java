package controller.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.Health;
import bean.Posture;
import controller.common.SuperClass;
import dao.AdviceboardDao;

@Controller
public class AdviceController extends SuperClass {
	private final String command = "/advice.ad";
	private ModelAndView mav = null;
	
	@Autowired
	@Qualifier("adao")
	private AdviceboardDao dao;
	
	public AdviceController() {
		super("advice", null);
		this.mav = new ModelAndView();
	}

	@GetMapping(command)
	public ModelAndView chat(
			@RequestParam(value = "id", required = true) String id) {
		Health hbean = dao.SelectHData(id);
		Posture pbean = dao.SelectPData(id);
		
		mav.addObject("hbean", hbean);
		mav.addObject("pbean", pbean);
		
		mav.setViewName(super.getpage);
		return mav;
	}

}
