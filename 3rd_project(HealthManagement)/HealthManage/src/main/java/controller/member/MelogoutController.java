package controller.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import controller.common.SuperClass;
import dao.MemberDao;

@Controller
public class MelogoutController extends SuperClass {
	private final String command = "/logout.me";
	private ModelAndView mav = null;
	private final String redirect = "redirect:/main.co";
	
	public MelogoutController() {
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(HttpSession session) {
		session.invalidate();
		
		mav.setViewName(redirect);
		return this.mav;
	}
}
