package controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.Board;
import bean.Comment;
import bean.Member;
import controller.common.SuperClass;
import dao.BoardDao;
import utility.FlowParameters;
import utility.Paging;

@Controller
public class BoardDetailController extends SuperClass {
	private final String command = "/detail.bo";
	private ModelAndView mav = null;
	private final String redirect = "redirect:/dietlist.bo";
	
	@Autowired
	@Qualifier("bdao")
	private BoardDao dao;
	
	public BoardDetailController() {
		super("boarddetail", null);
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "bono", required = true) int bono,
			@RequestParam(value = "pageNumber", required = false) String pageNumber,
			@RequestParam(value = "pageSize", required = false) String pageSize,
			HttpServletRequest request,
			HttpSession session) {
		Board bean = dao.SelectByPk(bono);
		
		if(bean != null) {
			Member login = (Member)session.getAttribute("loginfo");
			System.out.println("sdasdasd : "+login);
			if(login == null || !bean.getId().equals(login.getId())) {
				dao.UpdateReadhit(bono);
			}
		}
		
		FlowParameters parameters = new FlowParameters(pageNumber, pageSize, null, null);
		
		int totalCount = dao.SelectTotalCoCount(bono);
		System.out.println(totalCount);
		
		String contextpath = request.getContextPath() + "/";
		String url = contextpath + this.command + "?bono=" + bono + "&";
		
		Paging pageInfo = new Paging(parameters.getPageNumber(), parameters.getPageSize(),
									totalCount, url, null, null);
		
		List<Comment> clists = dao.SelectCoData(bono,
				pageInfo.getOffset(),
				pageInfo.getLimit());
		System.out.println(clists.size());
		System.out.println(clists.toString());
		mav.addObject("pagingHtml", pageInfo.getPagingHtml());
		mav.addObject("pagingStatus", pageInfo.getPagingStatus());
		
		mav.addObject("clists", clists);
		
		mav.addObject("bean", bean);
		mav.setViewName(super.getpage);		
		return this.mav;
	}

}
