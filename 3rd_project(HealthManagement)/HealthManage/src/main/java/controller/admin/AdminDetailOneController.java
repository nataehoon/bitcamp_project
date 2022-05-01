package controller.admin;

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
import dao.AdminDao;
import utility.FlowParameters;
import utility.Paging;

@Controller
public class AdminDetailOneController extends SuperClass {
	private final String command = "/detailone.am";
	private ModelAndView mav = null;
	
	@Autowired
	@Qualifier("addao")
	private AdminDao dao;
	
	public AdminDetailOneController() {
		super("admindetailone", null);
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "part", required = true) String part,
			@RequestParam(value = "pageNumber", required = false) String pageNumber,
			@RequestParam(value = "pageSize", required = false) String pageSize,
			HttpServletRequest request) {
		
		FlowParameters parameters = new FlowParameters(pageNumber, pageSize, null, null);
		
		int totalCount = 0;
		if(part.equals("po")) {
			totalCount = dao.SelectTotalCountByPoPk(id);
		}else if(part.equals("health")) {
			totalCount = dao.SelectTotalCountByHealthPk(id);
		}else if(part.equals("diet")) {
			totalCount = dao.SelectTotalCountByDietPk(id);
		}else if(part.equals("log")) {
			totalCount = dao.SelectTotalCountByLogPk(id);
		}
		
		System.out.println(totalCount);
		String contextpath = request.getContextPath() + "/";
		String url = contextpath + this.command + "&";
		
		Paging pageInfo = new Paging(parameters.getPageNumber(), parameters.getPageSize(),
									totalCount, url, null, null);
		
		mav.addObject("pagingHtml", pageInfo.getPagingHtml());
		mav.addObject("pagingStatus", pageInfo.getPagingStatus());
		
		mav.addObject("mode", parameters.getMode());
		mav.addObject("keyword", parameters.getKeyword());
		
		mav.addObject("parameters", parameters.toString());
		
		if(part.equals("po")) {
			List<Posture> plists = dao.SelectPoData(id);
			mav.addObject("lists", plists);
		}else if(part.equals("health")) {
			List<Health> hlists = dao.SelectHealthData(id);
			mav.addObject("lists", hlists);
		}else if(part.equals("diet")) {
			List<Diet> dlists = dao.SelectDietData(id);
			mav.addObject("lists", dlists);
		}else if(part.equals("log")) {
			List<Log> llists = dao.SelectLogData(id);
			mav.addObject("lists", llists);
		}
		
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
