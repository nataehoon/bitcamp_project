package controller.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.Health;
import controller.common.SuperClass;
import dao.HealthDao;

@Controller
public class HealthDetailController extends SuperClass {
	private final String command = "/detail.he";
	private ModelAndView mav = null;
	
	@Autowired
	@Qualifier("hdao")
	private HealthDao dao;
	
	public HealthDetailController() {
		super("healthdetail", null);
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "healthno", required = true) int healthno) {
		Health bean = dao.SelectByPk(healthno);
		
		double perfat3 = bean.getFat()/bean.getWeight()*100;
		String perfat1 = String.format("%.1f", perfat3);
		
		mav.addObject("perfat1", perfat1);
		mav.addObject("bean", bean);
		mav.setViewName(super.getpage);
		return this.mav;
	}
}
