package controller.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.Board;
import bean.Noticeboard;
import controller.common.SuperClass;
import dao.BoardDao;
import dao.NoticeboardDao;

@Controller
public class NoticeDeleteController extends SuperClass {
	private final String command = "/nodelete.bo";
	private ModelAndView mav = null;
	private String redirect = "";
	
	@Autowired
	@Qualifier("ndao")
	private NoticeboardDao dao;
	
	public NoticeDeleteController() {	
		super("nolist", null);
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "notino", required = true) int notino) {
		
		int cnt = -99999;
		cnt = dao.DeleteData(notino);
		
		mav.setViewName(super.getpage);
		
		return this.mav;
	}

}
