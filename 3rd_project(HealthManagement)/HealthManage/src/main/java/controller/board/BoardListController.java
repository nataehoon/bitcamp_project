package controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.Board;
import controller.common.SuperClass;
import dao.BoardDao;
import utility.FlowParameters;
import utility.Paging;

@Controller
public class BoardListController extends SuperClass {
	private final String command = "/list.bo";
	private ModelAndView mav = null;
	private final String redirect = "redirect:/dietlist.bo";
	
	@Autowired
	@Qualifier("bdao")
	private BoardDao dao;
	
	public BoardListController() {
		super("boardlist", null);
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "category", required = true) String category,
			@RequestParam(value = "pageNumber", required = false) String pageNumber,
			@RequestParam(value = "pageSize", required = false) String pageSize,
			@RequestParam(value = "mode", required = false) String mode,
			@RequestParam(value = "keyword", required = false) String keyword,
			HttpServletRequest request) {
		
		String mocategory = "";
		if(category.equals("diet")) {
			mocategory = "다이어트";
		}else if(category.equals("posture")) {
			mocategory = "체형";
		}else if(category.equals("ms")) {
			mocategory = "대사증후군";
		}else if(category.equals("log")) {
			mocategory = "운동일지";
		}
		System.out.println("["+ mocategory + "]");
		
		FlowParameters parameters = new FlowParameters(pageNumber, pageSize, mode, keyword);
		
		int totalCount = dao.SelectTotalCount(parameters.getMode(), parameters.getKeyword(), mocategory);
		System.out.println(totalCount);
		
		String contextpath = request.getContextPath() + "/";
		String url = contextpath + this.command + "?category=" + category + "&";
		
		Paging pageInfo = new Paging(parameters.getPageNumber(), parameters.getPageSize(),
									totalCount, url, parameters.getMode(), parameters.getKeyword());
		
		List<Board> lists = dao.SelectData(mocategory,
				pageInfo.getOffset(),
				pageInfo.getLimit(),
				parameters.getMode(),
				parameters.getKeyword());
		System.out.println(lists.size());
		System.out.println(lists.toString());
		
		mav.addObject("category", category);
		mav.addObject("mocategory", mocategory);
		mav.addObject("lists", lists);
		mav.addObject("pagingHtml", pageInfo.getPagingHtml());
		mav.addObject("pagingStatus", pageInfo.getPagingStatus());
		
		mav.addObject("mode", parameters.getMode());
		mav.addObject("keyword", parameters.getKeyword());
		
		mav.addObject("parameters", parameters.toString());
		
		mav.setViewName(getpage);
		return this.mav;
	}

}
