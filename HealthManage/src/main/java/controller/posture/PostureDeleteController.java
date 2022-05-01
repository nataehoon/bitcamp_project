package controller.posture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import controller.common.SuperClass;
import dao.PostureDao;

@Controller
public class PostureDeleteController extends SuperClass {
	private final String command = "/podelete.po";
	private ModelAndView mav = null;
	private String redirect = "redirect:/polist.po" ;

	@Autowired
	@Qualifier("pdao")
	private PostureDao dao;
	
	
	public PostureDeleteController() {
		super("polist", null);
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "pono", required = true) int pono,
			@RequestParam(value = "id", required = true) String id) {
		int cnt = -99999;
		cnt = dao.DeleteData(pono);
		System.out.println("id : " + id);
		
		String gotopage = this.redirect + "?id=" +id;
		
		mav.clear();
		
		mav.setViewName(gotopage);
		
		return this.mav;
	}

}
