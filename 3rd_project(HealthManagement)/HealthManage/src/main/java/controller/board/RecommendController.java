package controller.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.BoardDao;

@Controller
public class RecommendController {
	private final String command = "/borecommend.bo";
	private ModelAndView mav = null;
	
	@Autowired
	@Qualifier("bdao")
	private BoardDao dao;
	
	public RecommendController() {
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "bono", required = true) int bono) {
		int cnt = -99999;
		cnt = dao.UpdateRecommend(bono);
		
		String gotopage = "redirect:/detail.bo?bono=" + bono;
		mav.setViewName(gotopage);
		return this.mav;
	}

}
