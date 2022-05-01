package controller.view;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.Member;
import controller.common.SuperClass;
import dao.ViewDao;
import utility.FlowParameters;
import utility.Paging;

@Controller
public class MemerInfoController extends SuperClass {
	private final String command = "/members.vw";
	private ModelAndView mav = null;
	
	@Autowired
	@Qualifier("vdao")
	private ViewDao dao;
	
	public MemerInfoController() {
		super("memberlist", null);
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "pageNumber", required = false) String pageNumber,
			@RequestParam(value = "pageSize", required = false) String pageSize,
			@RequestParam(value = "mode", required = false) String mode,
			@RequestParam(value = "keyword", required = false) String keyword,
			HttpServletRequest request) {
		FlowParameters parameters = new FlowParameters(pageNumber, pageSize, mode, keyword);
		
		int totalCount = dao.SelectTotalCount(parameters.getMode(), parameters.getKeyword());
		System.out.println(totalCount);
		
		String contextpath = request.getContextPath() + "/";
		String url = contextpath + this.command + "&";
		
		Paging pageInfo = new Paging(parameters.getPageNumber(), parameters.getPageSize(),
									totalCount, url, parameters.getMode(), parameters.getKeyword());
		
		List<Member> mlists = dao.SelectData(
				pageInfo.getOffset(),
				pageInfo.getLimit(),
				parameters.getMode(),
				parameters.getKeyword());
		
		mav.addObject("mlists", mlists);
		
		mav.addObject("pagingHtml", pageInfo.getPagingHtml());
		mav.addObject("pagingStatus", pageInfo.getPagingStatus());
		
		mav.addObject("mode", parameters.getMode());
		mav.addObject("keyword", parameters.getKeyword());
		
		mav.addObject("parameters", parameters.toString());
		
		mav.setViewName(super.getpage);
		return this.mav;
	}
}
