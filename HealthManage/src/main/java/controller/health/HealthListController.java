package controller.health;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.Health;
import controller.common.SuperClass;
import dao.HealthDao;
import utility.FlowParameters;
import utility.Paging;

@Controller
public class HealthListController extends SuperClass {
	private final String command = "/healthlist.he";
	private ModelAndView mav = null;

	@Autowired
	@Qualifier("hdao")
	private HealthDao dao;
	
	
	public HealthListController() {
		super("healthlist", null);
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "pageNumber", required = false) String pageNumber,
			@RequestParam(value = "pageSize", required = false) String pageSize,
			HttpServletRequest request) {
		
		FlowParameters parameters = new FlowParameters(pageNumber, pageSize, null, null);

		int totalCount = dao.SelectTotalCount(id);
		System.out.println(totalCount);
		
		String contextpath = request.getContextPath() + "/";
		String url = contextpath + this.command + "?id=" + id +"&";
		
		Paging pageInfo = new Paging(parameters.getPageNumber(), parameters.getPageSize(),
									totalCount, url, null, null);
		
		Health bean1 = dao.SelectByPk1(id);
		Health bean2 = dao.SelectByPk2(id);
		
		List<Health> lists = dao.SelectData(id,
				pageInfo.getOffset(),
				pageInfo.getLimit());
//		System.out.println(lists);
		
		if(totalCount == 1) {
			System.out.println("aa : "+bean1.toString());
			double perfat3 = bean1.getFat()/bean1.getWeight()*100;
			String perfat1 = String.format("%.1f", perfat3);
			System.out.println(perfat1);
			mav.addObject("perfat1", perfat1);
		}else if(totalCount > 1) {
			System.out.println("aa : "+bean1.toString());
			System.out.println("bb : "+bean2.toString());
			double perfat3 = bean1.getFat()/bean1.getWeight()*100;
			String perfat1 = String.format("%.1f", perfat3);
			System.out.println(perfat1);
			mav.addObject("perfat1", perfat1);
			double perfat4 = bean2.getFat()/bean2.getWeight()*100;
			String perfat2 = String.format("%.1f", perfat4);
			System.out.println(perfat2);
			mav.addObject("perfat2", perfat2);
		}
		mav.addObject("pagingHtml", pageInfo.getPagingHtml());
		mav.addObject("pagingStatus", pageInfo.getPagingStatus());
		mav.addObject("parameters", parameters.toString());
		
		mav.addObject("id", id);
		mav.addObject("bean1", bean1);
		mav.addObject("bean2", bean2);
		mav.addObject("lists", lists);
		
		mav.setViewName(super.getpage);
		return this.mav;
	}

}
