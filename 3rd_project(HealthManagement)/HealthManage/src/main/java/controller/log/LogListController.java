package controller.log;

import java.util.List;

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
public class LogListController extends SuperClass {
	private final String command = "/loglist.lo";
	private ModelAndView mav = null;
	private String redirect = "redirect:/loglist.lo" ;
	
	@Autowired
	@Qualifier("lodao")
	private ExerciseLogDao dao;
	
	public LogListController() {
		super("loglist", null);
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "id", required = true) String id) {
		//운동일지 리스트 호출
		List<Log> lists = dao.SelectData(id);
		System.out.println(lists.size());
		
		mav.addObject("id", id);
		mav.addObject("lists", lists);
		
		this.mav.setViewName(super.getpage);
		return this.mav;
	}

}
