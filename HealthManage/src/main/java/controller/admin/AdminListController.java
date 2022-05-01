package controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.Combo01;
import controller.common.SuperClass;
import dao.AdminDao;
import utility.FlowParameters;
import utility.Paging;

@Controller
public class AdminListController extends SuperClass {
	private final String command = "/adminlist.am";
	private ModelAndView mav = null;
	
	@Autowired
	@Qualifier("addao")
	private AdminDao dao;
	
	public AdminListController() {
		super("adminlist", null);
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "part", required = true) String part,
			@RequestParam(value = "pageNumber", required = false) String pageNumber,
			@RequestParam(value = "pageSize", required = false) String pageSize,
			@RequestParam(value = "mode", required = false) String mode,
			@RequestParam(value = "keyword", required = false) String keyword,
			HttpServletRequest request) {
		
		FlowParameters parameters = new FlowParameters(pageNumber, pageSize, mode, keyword);
		
		int totalCount = 0;
		if(part.equals("po")) {
			totalCount = dao.SelectTotalPoCount(parameters.getMode(), parameters.getKeyword());
		}else if(part.equals("health")) {
			totalCount = dao.SelectTotalHealthCount(parameters.getMode(), parameters.getKeyword());
		}else if(part.equals("diet")) {
			totalCount = dao.SelectTotalDietCount(parameters.getMode(), parameters.getKeyword());
		}else if(part.equals("log")) {
			totalCount = dao.SelectTotalLogCount(parameters.getMode(), parameters.getKeyword());
		}
		
		System.out.println(totalCount);
		
		String contextpath = request.getContextPath() + "/";
		String url = contextpath + this.command + "&";
		
		Paging pageInfo = new Paging(parameters.getPageNumber(), parameters.getPageSize(),
									totalCount, url, parameters.getMode(), parameters.getKeyword());
		
		if(part.equals("po")) {
			List<Combo01> lists = dao.SelectPoMeData(
					pageInfo.getOffset(),
					pageInfo.getLimit(),
					parameters.getMode(),
					parameters.getKeyword());
			mav.addObject("lists", lists);
		}else if(part.equals("health")) {
			List<Combo01> lists = dao.SelectHealthMeData(
					pageInfo.getOffset(),
					pageInfo.getLimit(),
					parameters.getMode(),
					parameters.getKeyword());
			mav.addObject("lists", lists);
		}else if(part.equals("diet")) {
			List<Combo01> lists = dao.SelectDietMeData(
					pageInfo.getOffset(),
					pageInfo.getLimit(),
					parameters.getMode(),
					parameters.getKeyword());
			mav.addObject("lists", lists);
		}else if(part.equals("log")) {
			List<Combo01> lists = dao.SelectLogMeData(
					pageInfo.getOffset(),
					pageInfo.getLimit(),
					parameters.getMode(),
					parameters.getKeyword());
			mav.addObject("lists", lists);
		}
		
		mav.addObject("pagingHtml", pageInfo.getPagingHtml());
		mav.addObject("pagingStatus", pageInfo.getPagingStatus());
		
		mav.addObject("mode", parameters.getMode());
		mav.addObject("keyword", parameters.getKeyword());
		
		mav.addObject("parameters", parameters.toString());
		
		String partname = null;
		if(part.equals("po")) {
			partname = "체형";
		}else if(part.equals("health")) {
			partname = "건강기록";
		}else if(part.equals("diet")) {
			partname = "다이어트";
		}else if(part.equals("log")) {
			partname = "운동일지";
		}
		
		mav.addObject("part", part);
		mav.addObject("partname", partname);
		mav.setViewName(super.getpage);
		
		return this.mav;
	}

}
