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
public class LogDeleteController extends SuperClass {
	private final String command = "/delete.lo";
	private ModelAndView mav = null;
	
	@Autowired
	@Qualifier("lodao")
	private ExerciseLogDao dao;
	
	public LogDeleteController() {
		super("loglist", null);
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "logno", required = true) int logno) {
		
		int cnt = -99999;
		cnt = dao.DeleteData(logno);
		
		this.mav.setViewName(super.getpage);
		return this.mav;
		
	}
}
