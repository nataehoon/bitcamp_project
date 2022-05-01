package controller.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import controller.common.SuperClass;
import dao.HealthDao;

@Controller
public class HealthDeleteController extends SuperClass {
	private final String command = "/hedelete.he";
	private ModelAndView mav = null;
	private String redirect = "redirect:/healthlist.he" ;

	@Autowired
	@Qualifier("hdao")
	private HealthDao dao;
	
	
	public HealthDeleteController() {
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "healthno", required = true) int healthno,
			@RequestParam(value = "id", required = true) String id) {
		int cnt = -99999;
		cnt = dao.DeleteData(healthno);
		
		String gotopage = this.redirect + "?id=" + id;
		mav.setViewName(gotopage);
		
		return this.mav;
	}

}
