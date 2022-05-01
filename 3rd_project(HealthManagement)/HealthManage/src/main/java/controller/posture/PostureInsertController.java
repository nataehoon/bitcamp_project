package controller.posture;

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

import bean.Posture;
import controller.common.SuperClass;
import dao.PostureDao;

@Controller
public class PostureInsertController extends SuperClass {
	private final String command = "/insert.po";
	private ModelAndView mav = null;
	private final String redirect = "redirect:/polist.po?";
	
	@Autowired
	@Qualifier("pdao")
	private PostureDao dao;
	
	@ModelAttribute("po")
	public Posture mypos() {
		return new Posture();
	}
	
	public PostureInsertController() {
		super("poinsert", "polist");
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "id", required = true) String id) {
		mav.addObject("id", id);
		mav.setViewName(super.getpage);
		return this.mav;
	}
	
	@PostMapping
	public ModelAndView doPost(
			@ModelAttribute("po") @Valid Posture xxx, BindingResult asdf, HttpServletRequest request) {
		String gotopage = redirect + "id=" + xxx.getId();
		if(asdf.hasErrors()) {
			System.out.println("유효성 검사 문제");
			
			mav.addObject("bean", xxx);
			mav.setViewName(super.getpage);
		}else {
			System.out.println("유효성 검사 통과");
			MultipartFile multi1 = xxx.getFront();
			MultipartFile multi2 = xxx.getBack();
			MultipartFile multi3 = xxx.getLeft();
			MultipartFile multi4 = xxx.getRight();
			String uploadPath = "/upload";
			String realPath = request.getRealPath(uploadPath);
			System.out.println(realPath);
			System.out.println(xxx.toString());
			
			try {
				File destination1 = utility.Utility.getUploadedFileInfo(multi1, realPath);
				File destination2 = utility.Utility.getUploadedFileInfo(multi2, realPath);
				File destination3 = utility.Utility.getUploadedFileInfo(multi3, realPath);
				File destination4 = utility.Utility.getUploadedFileInfo(multi4, realPath);
				
				multi1.transferTo(destination1);
				multi2.transferTo(destination2);
				multi3.transferTo(destination3);
				multi4.transferTo(destination4);
				xxx.setImage1(destination1.getName());
				xxx.setImage2(destination2.getName());
				xxx.setImage3(destination3.getName());
				xxx.setImage4(destination4.getName());
				
				mav.clear();
				mav.setViewName(gotopage);
				
				this.dao.InsertData(xxx);
				
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
