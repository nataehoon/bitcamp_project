package controller.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.Board;
import controller.common.SuperClass;
import dao.BoardDao;

@Controller
public class BoardDeleteController extends SuperClass {
	private final String command = "/delete.bo";
	private ModelAndView mav = null;
	private String redirect = "";
	
	@Autowired
	@Qualifier("bdao")
	private BoardDao dao;
	
	public BoardDeleteController() {
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "bono", required = true) int bono) {
		Board bean = dao.SelectByPk(bono);
		
		if(bean.getCategory() == "다이어트") {
			this.redirect = "redirect:/list.bo?category=diet";
		}else if(bean.getCategory() == "체형") {
			this.redirect = "redirect:/list.bo?category=posture";
		}else if(bean.getCategory() == "대사증후군") {
			this.redirect = "redirect:/list.bo?category=ms";
		}else if(bean.getCategory() == "운동일지") {
			this.redirect = "redirect:/list.bo?category=log";
		}
		
		int cnt = -99999;
		cnt = dao.DeleteData(bono);
		
		mav.setViewName(this.redirect);
		
		return this.mav;
	}

}
