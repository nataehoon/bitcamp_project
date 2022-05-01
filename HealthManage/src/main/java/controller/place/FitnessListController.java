package controller.place;

import java.util.List;

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
public class FitnessListController extends SuperClass {
	private final String command = "/fitlist.pl";
	private ModelAndView mav = null;

	@Autowired
	@Qualifier("fdao")
	private FitnessDao dao;
	
	public FitnessListController() {
		super("fitlist", null);
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "gu", required = false) String gu) {
		System.out.println("gu : " + gu);
		List<Fitness> lists = dao.SelectData(gu);
		System.out.println(lists.size());
		
		mav.addObject("lists", lists);
		mav.setViewName(super.getpage);
		return this.mav;
	}	 

}
