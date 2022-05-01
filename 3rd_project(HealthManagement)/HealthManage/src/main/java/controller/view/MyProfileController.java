package controller.view;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.Diet;
import bean.Health;
import bean.Log;
import bean.Posture;
import controller.common.SuperClass;
import dao.ViewDao;
import utility.FlowParameters;
import utility.Paging;

@Controller
public class MyProfileController extends SuperClass {
	private final String command = "/totalhealth";
	private ModelAndView mav = null;
	
	@Autowired
	@Qualifier("vdao")
	private ViewDao dao;
	
	public MyProfileController() {
		super("myprofile", null);
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "id", required = true) String id) {
		
		Health hbean = dao.SelectByPkHealth(id);
		Posture pbean = dao.SelectByPkPosture(id);
		
		
		mav.addObject("hbean", hbean);
		mav.addObject("pbean", pbean);
		
		List<Log> llist = dao.SelectLogData(id);
		List<Diet> dlist = dao.SelectDietData(id);
		
		double perfat3 = hbean.getFat()/hbean.getWeight()*100;
		String perfat1 = String.format("%.1f", perfat3);
		System.out.println(perfat1);
		mav.addObject("perfat1", perfat1);
		
		mav.addObject("llist", llist);
		mav.addObject("dlist", dlist);
		
		mav.setViewName(super.getpage);
		
		return this.mav;
	}

}
