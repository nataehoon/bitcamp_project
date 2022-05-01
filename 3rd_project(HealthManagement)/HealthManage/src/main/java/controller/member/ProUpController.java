package controller.member;

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

import bean.Member;
import controller.common.SuperClass;
import dao.MemberDao;

@Controller
public class ProUpController extends SuperClass {
	private final String command = "proupdate.me";
	private ModelAndView mav = null;
	private final String redirect = "redirect:/detail.me";
	
	@Autowired
	@Qualifier("mdao")
	private MemberDao dao;
	
	@ModelAttribute("pro")
	private Member mymemeber() {
		return new Member();
	}
	
	public ProUpController() {
		super("proupdate", null);
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "id", required = true) String id) {
		Member bean = dao.SelectByPk(id);
		
		mav.addObject("bean", bean);
		mav.setViewName(super.getpage);
		return this.mav;
	}
	
	@PostMapping(command)
	public ModelAndView doPost(
		@ModelAttribute("pro") @Valid Member xxx, BindingResult asdf, HttpServletRequest request) {
		MultipartFile multi = xxx.getAsdf();
		String uploadPath = "/upload";
		String realPath = request.getRealPath(uploadPath);
		System.out.println(realPath);
		
		try {
			File destination = utility.Utility.getUploadedFileInfo(multi, realPath);
			
			multi.transferTo(destination);
			xxx.setImage(destination.getName());
			
			this.dao.UpdateProData(xxx);
			
			mav.clear();
			String gotopage = this.redirect + "?id=" + xxx.getId();
			mav.setViewName(gotopage);
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("");
		}
		return this.mav;
	}
}
