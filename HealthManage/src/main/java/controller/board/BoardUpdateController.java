package controller.board;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import bean.Board;
import controller.common.SuperClass;
import dao.BoardDao;

@Controller
public class BoardUpdateController extends SuperClass {
	private final String command = "/update.bo";
	private ModelAndView mav = null;
	private final String redirect = "redirect:/dietlist.bo";
	
	@Autowired
	@Qualifier("bdao")
	private BoardDao dao;
	
	public BoardUpdateController() {
		super("boardupdate", null);
		this.mav = new ModelAndView();
	}
	
	@ModelAttribute("board")
	public Board mydiet() {
		return new Board();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "bono", required = true) int bono) {
		Board bean = dao.SelectByPk(bono);
		
		mav.addObject("bean", bean);
		mav.setViewName(super.getpage);
		return this.mav;
	}
	
	@PostMapping(command)
	public ModelAndView doPost(
			@ModelAttribute("board") @Valid Board xxx, BindingResult asdf, HttpServletRequest request) {
		String gotopage = this.redirect + "?bono=" + xxx.getBono();
		if(asdf.hasErrors()) {
			System.out.println("유효성 검사 문제 있음");
			mav.addObject("bean", xxx);
			mav.setViewName(super.getpage);
		}else {
			System.out.println("유효성 검사 통과");
			MultipartFile multi = xxx.getAsdf();
			String uploadPath = "/upload";
			String realPath = request.getRealPath(uploadPath);
			System.out.println(realPath);
			
			try {
				File destination = utility.Utility.getUploadedFileInfo(multi, realPath);
				multi.transferTo(destination);
				xxx.setId(destination.getName());

				mav.setViewName(gotopage);
				this.dao.UpdateData(xxx);
				
			} catch (IllegalStateException e) {
				e.printStackTrace();
				mav.setViewName("");
			} catch (Exception e) {
				e.printStackTrace();
				mav.setViewName(gotopage);
			}
			
			
		}
		return this.mav;
	}

}
