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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import bean.Noticeboard;
import controller.common.SuperClass;
import dao.NoticeboardDao;

@Controller
public class NoticeInsertController extends SuperClass {
	private final String command = "/noinsert.bo";
	private ModelAndView mav = null;
	private final String redirect = "redirect:/nolist.bo";
	
	@Autowired
	@Qualifier("ndao")
	private NoticeboardDao dao;
	
	public NoticeInsertController() {
		super("noinsert", "nolist");
		this.mav = new ModelAndView();
	}
	
	@ModelAttribute("notice")
	public Noticeboard notice() {
		return new Noticeboard();
	}
	
	@GetMapping(command)
	public ModelAndView doGet() {
		mav.setViewName(super.getpage);
		return this.mav;
	}
	
	@PostMapping(command)
	public ModelAndView doPost(
			@ModelAttribute("notice") @Valid Noticeboard xxx, BindingResult asdf, HttpServletRequest request) {
		if(asdf.hasErrors()) {
			System.out.println("유효성검사에 문제있음");
			mav.addObject("bean", xxx);
			mav.setViewName(super.getpage);
		}else {
			System.out.println("유효성검사 통과");
			MultipartFile multi = xxx.getAsdf();
			String uploadPath = "/upload";
			String realPath = request.getRealPath(uploadPath);
			System.out.println(realPath);
			
			try {
				File destination = utility.Utility.getUploadedFileInfo(multi, realPath);
				
				multi.transferTo(destination);
				xxx.setImage(destination.getName());
				
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
