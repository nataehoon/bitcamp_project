package controller.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.Diet;
import bean.Health;
import bean.Log;
import bean.Member;
import bean.Posture;
import controller.common.SuperClass;
import dao.ViewDao;

@Controller
public class MemberDetailController extends SuperClass {
	private final String command = "/detail.vw";
	private ModelAndView mav = null;
	
	@Autowired
	@Qualifier("vdao")
	private ViewDao dao;
	
	public MemberDetailController() {
		super("memberdetail", null);
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "id", required = true) String id) {
		Health hbean = dao.SelectByPkHealth(id);
		Posture pbean = dao.SelectByPkPosture(id);
		Member mbean = dao.SelectByPk(id);
		
		mav.addObject("hbean", hbean);
		mav.addObject("pbean", pbean);
		mav.addObject("mbean", mbean);
		
		List<Log> llists = dao.SelectLogData(id);
		List<Diet> dlists = dao.SelectDietData(id);
		
		if (hbean != null) {
			double perfat3 = hbean.getFat()/hbean.getWeight()*100;
			String perfat1 = String.format("%.1f", perfat3);
			System.out.println(perfat1);
			mav.addObject("perfat1", perfat1);
		}
		
		mav.addObject("llists", llists);
		mav.addObject("dlists", dlists);
		
		mav.setViewName(super.getpage);
		
		return this.mav;
	}
}
