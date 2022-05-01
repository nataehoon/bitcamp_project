package controller.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.Log;
import controller.common.SuperClass;
import dao.ExerciseLogDao;

@Controller
public class LogDetailController extends SuperClass {
	private final String command = "/detail.lo";
	private ModelAndView mav = null;
	
	@Autowired
	@Qualifier("lodao")
	private ExerciseLogDao dao;
	
	public LogDetailController() {
		super("logdetail", null);
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "logno", required = true) int logno) {
		
		Log bean = dao.selectByPk(logno);
		System.out.println(bean);
		
		mav.addObject("bean", bean);
		
		this.mav.setViewName(super.getpage);
		return this.mav;
		
	}
}
