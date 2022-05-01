package controller.board;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
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
public class BoardInsertController extends SuperClass {
	private final String command = "/insert.bo";
	private ModelAndView mav = null;
	private String redirect = "";
	
	@Autowired
	@Qualifier("bdao")
	private BoardDao dao;
	
	public BoardInsertController() {
		super("boardinsert", null);
		this.mav = new ModelAndView();
	}
	
	@ModelAttribute("board")
	public Board mydiet() {
		return new Board();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "category", required = true) String category) {
		mav.addObject("id", id);
		mav.addObject("category", category);
		mav.setViewName(super.getpage);
		return this.mav;
	}
	
	@PostMapping(command)
	public ModelAndView doPost(
			@ModelAttribute("board") @Valid Board xxx, BindingResult asdf, HttpServletRequest request) {
		System.out.println(xxx.toString());
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
				xxx.setImage(destination.getName());
				System.out.println(xxx.toString());
				
				if(xxx.getCategory().equals("다이어트")) {
					this.redirect = "redirect:/list.bo?category=diet";
				}else if(xxx.getCategory().equals("체형")) {
					this.redirect = "redirect:/list.bo?category=posture";
				}else if(xxx.getCategory().equals("대사증후군")) {
					this.redirect = "redirect:/list.bo?category=ms";
				}else if(xxx.getCategory().equals("운동일지")) {
					this.redirect = "redirect:/list.bo?category=log";
				}
				
				System.out.println(xxx.toString());
				mav.clear();
				mav.setViewName(this.redirect);
				
				this.dao.InsertData(xxx);
				
			} catch (IllegalStateException e) {
				e.printStackTrace();
				mav.setViewName("");
			} catch (Exception e) {
				e.printStackTrace();
				mav.setViewName(this.redirect);
			}
		}
		return this.mav;
	}

}
