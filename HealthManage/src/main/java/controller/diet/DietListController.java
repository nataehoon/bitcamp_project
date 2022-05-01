package controller.diet;

import java.util.List;

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
public class DietListController extends SuperClass {
	private final String command = "/dietlist.di";
	private ModelAndView mav = null;
	
	@Autowired
	@Qualifier("ddao")
	private DietDao dao;
	
	public DietListController() {
		super("dietlist", null);
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "id", required = true) String id) {
		List<Diet> lists = dao.SelectData(id);
		System.out.println(lists.size());
		System.out.println(lists.toString());
		
		mav.addObject("id", id);
		mav.addObject("lists", lists);
		mav.setViewName(super.getpage);
		
		return this.mav;
	}

}
