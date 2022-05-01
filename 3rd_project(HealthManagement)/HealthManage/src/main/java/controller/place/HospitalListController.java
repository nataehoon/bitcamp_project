package controller.place;

import java.util.List;

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
public class HospitalListController extends SuperClass {
	private final String command = "/holist.pl";
	private ModelAndView mav = null;
	
	@Autowired
	@Qualifier("hodao")
	private HospitalDao dao;
	
	public HospitalListController() {
		super("holist", null);
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "gu", required = false) String gu) {
		List<Hospital> lists = dao.SelectData(gu);
		System.out.println(lists.size());
		
		mav.addObject("lists" ,lists);
		mav.setViewName(super.getpage);
		return this.mav;
	}

}
