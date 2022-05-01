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
import dao.NoticeboardDao;

@Controller
public class NoticeDetailController extends SuperClass {
	private final String command = "/nodetail.bo";
	private ModelAndView mav = null;
	private final String redirect = "redirect:/dietlist.bo";
	
	@Autowired
	@Qualifier("ndao")
	private NoticeboardDao dao;
	
	public NoticeDetailController() {
		super("nodetail", null);
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "notino", required = true) int notino) {
		Noticeboard bean = dao.SelectByPk(notino);
		
		mav.addObject("bean", bean);
		mav.setViewName(super.getpage);		
		return this.mav;
	}

}
