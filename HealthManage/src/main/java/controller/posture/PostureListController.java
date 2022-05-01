package controller.posture;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.Posture;
import controller.common.SuperClass;
import dao.PostureDao;
import utility.FlowParameters;
import utility.Paging;

@Controller
public class PostureListController extends SuperClass {
	private final String command = "/polist.po";
	private ModelAndView mav = null;
	private final String redirect = "redirect:/polist.po";
	
	@Autowired
	@Qualifier("pdao")
	private PostureDao dao;
	
	public PostureListController() {
		super("polist", null);
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
		
		Posture bean1 = dao.SelectByPk1(id);
		Posture bean2 = dao.SelectByPk2(id);
		
		List<Posture> lists = dao.SelectData(id);
		System.out.println(lists.size());
		
		if(totalCount == 1) {
			mav.addObject("bean1", bean1);
			System.out.println("asdasdasd"+bean2);
		}else if(totalCount > 1) {
			mav.addObject("bean1", bean1);
			mav.addObject("bean2", bean2);
		}
			
		mav.addObject("pagingHtml", pageInfo.getPagingHtml());
		mav.addObject("pagingStatus", pageInfo.getPagingStatus());
		mav.addObject("parameters", parameters.toString());
		mav.addObject("id", id);
		mav.addObject("lists", lists);
		
		mav.setViewName(super.getpage);
		return this.mav;
	}

}
