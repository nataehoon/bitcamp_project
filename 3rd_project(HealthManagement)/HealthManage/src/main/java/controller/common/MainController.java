package controller.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import bean.Board;
import bean.Noticeboard;
import dao.BoardDao;

@Controller
public class MainController extends SuperClass {
	private final String command = "/main.co";
	private ModelAndView mav = null;
	
	@Autowired
	@Qualifier("bdao")
	private BoardDao dao;
	
	public MainController() {
		super("main", null);
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet() {
		List<Board> blists = dao.SelectBoData();
		List<Noticeboard> nlists = dao.SelectNoData();
		
		mav.addObject("blists", blists);		
		mav.addObject("nlists", nlists);
		
		mav.setViewName(super.getpage);
		
		return this.mav;
	}

}
