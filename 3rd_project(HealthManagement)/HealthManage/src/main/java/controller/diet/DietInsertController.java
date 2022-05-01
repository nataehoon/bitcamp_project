package controller.diet;

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

import bean.Diet;
import controller.common.SuperClass;
import dao.DietDao;

@Controller
public class DietInsertController extends SuperClass {
	private final String command = "/insert.di";
	private ModelAndView mav = null;
	private String redirect = "redirect:/dietlist.di" ;
	
	@Autowired
	@Qualifier("ddao")
	private DietDao dao;
	
	@ModelAttribute("diet")
	public Diet mydig() {
		return new Diet();
	}
	
	public DietInsertController() {
		super("dietinsert", "dietlist");
		this.mav = new ModelAndView();
	}
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "id", required = true) String id) {
		mav.addObject("bean", id);
		this.mav.setViewName(super.getpage);
		return this.mav;
	}
	
	@PostMapping(command)
	public ModelAndView doPost(
			@ModelAttribute("diet") @Valid Diet xxx, BindingResult asdf, HttpServletRequest request) {
		if(asdf.hasErrors()) {
			System.out.println("유효성 검사에 문제 있음");
			System.out.println(xxx.toString());
			System.out.println(asdf.toString());
			mav.addObject("bean", xxx);
			mav.setViewName(super.getpage);
		}else {
			System.out.println("유효성 검사에 문제가 없음");
			MultipartFile multi = xxx.getAsdf();
			String uploadPath = "/upload";
			String realPath = request.getRealPath(uploadPath);
			System.out.println(realPath);
			
			try {
				File destination = utility.Utility.getUploadedFileInfo(multi, realPath);
				
				multi.transferTo(destination);
				xxx.setImage(destination.getName());
				
				this.dao.InsertData(xxx);
				
				mav.clear();
				
				String gotopage = this.redirect + "?id=" + xxx.getId();
				mav.setViewName(gotopage);
				
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
				mav.setViewName("");
			}
			
		}
		return this.mav;
	}
	
}
