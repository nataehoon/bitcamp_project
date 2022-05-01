package controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.Noticeboard;
import controller.common.SuperClass;
import dao.NoticeboardDao;
import utility.FlowParameters;
import utility.Paging;

@Controller
public class NoticeBoardListController extends SuperClass {
	private final String command = "/nolist.bo";
	private ModelAndView mav = null;

	@Autowired
	@Qualifier("ndao")
	private NoticeboardDao dao;
	
	public NoticeBoardListController() {
		super("nolist", null);
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			HttpServletRequest request,
			@RequestParam(value = "pageNumber", required = false) String pageNumber,
			@RequestParam(value = "pageSize", required = false) String pageSize,
			@RequestParam(value = "mode", required = false) String mode,
			@RequestParam(value = "keyword", required = false) String keyword) {
		
		FlowParameters parameters = new FlowParameters(pageNumber, pageSize, mode, keyword);
		
		int totalCount = dao.SelectTotalCount(parameters.getMode(), parameters.getKeyword());
		System.out.println(totalCount);
		
		String contextpath = request.getContextPath() + "/";
		String url = contextpath + this.command + "?";
		
		Paging pageInfo = new Paging(parameters.getPageNumber(), parameters.getPageSize(), 
									totalCount, url, parameters.getMode(), parameters.getKeyword());
		
		List<Noticeboard> lists = dao.SelectData(
				pageInfo.getOffset(),
				pageInfo.getLimit(),
				parameters.getMode(),
				parameters.getKeyword());
		
		System.out.println(lists.size());
		System.out.println(lists.toString());
		
		mav.addObject("lists", lists);
		
		mav.addObject("pagingHtml", pageInfo.getPagingHtml());
		mav.addObject("pagingStatus", pageInfo.getPagingStatus());
		
		mav.addObject("mode", parameters.getMode());
		mav.addObject("keyword", parameters.getKeyword());
		
		mav.addObject("parameters", parameters.toString());
		
		mav.setViewName(super.getpage);
		
		return this.mav;
	}

}
