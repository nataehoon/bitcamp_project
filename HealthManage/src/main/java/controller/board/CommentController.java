package controller.board;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.Comment;
import controller.common.SuperClass;
import dao.BoardDao;

@Controller
public class CommentController extends SuperClass{
	private ModelAndView mav = null;
	private final String redirect = "redirect:/detail.bo";
	
	@Autowired
	@Qualifier("bdao")
	private BoardDao dao;
	
	@ModelAttribute("comment")
	public Comment mycomment() {
		return new Comment();
	}
	
	public CommentController() {
		super("boarddetail", null);
		this.mav = new ModelAndView();
	}
	
	@PostMapping("/coinsert.bo")
	public ModelAndView doPost(
			@ModelAttribute("comment") @Valid Comment xxx, BindingResult asdf) {
		System.out.println(xxx.toString());
		String gotopage = this.redirect + "?bono=" + xxx.getBono();
		if(asdf.hasErrors()) {
			System.out.println("유효성 검사에 문제 있음");
			mav.addObject("bean1", xxx);
			mav.setViewName(gotopage);
		} else {
			System.out.println("유효성 검사 통과");
			int cnt = -99999;
			cnt = dao.InsertCoData(xxx);
			
			mav.setViewName(gotopage);
		}
		
		return this.mav;
		
	}
	
	@GetMapping("/codelete.bo")
	public ModelAndView doGet(
			@RequestParam(value = "cono", required = true) int cono) {
		Comment cobean = dao.SelectByCo(cono);
		
		int cnt = -99999;
		cnt = dao.DeleteCo(cono);
		
		String gotopage = this.redirect + "?bono=" + cobean.getBono();
		mav.setViewName(gotopage);
		return this.mav;
	}
	
	@PostMapping("/coupdate.bo")
	public ModelAndView doPostu(
			@ModelAttribute("comment") @Valid Comment xxx, BindingResult asdf) {
		System.out.println(xxx.toString());
		if(asdf.hasErrors()) {
			System.out.println("유효성 검사 문제");
			
			mav.addObject("upcobean", xxx);
			mav.setViewName("");
		} else {
			System.out.println("유효성 검사 통과");
			int cnt = -99999;
			cnt = dao.UpdateCoData(xxx);
			
			String gotopage = this.redirect + "?bono=" + xxx.getBono();
			System.out.println(gotopage);
			mav.setViewName(gotopage);
		}
		
		return this.mav;
		
	}
}
