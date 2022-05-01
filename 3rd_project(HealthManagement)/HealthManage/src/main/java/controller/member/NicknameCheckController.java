package controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.Member;
import controller.common.SuperClass;
import dao.MemberDao;

@Controller
public class NicknameCheckController extends SuperClass {
	private final String command = "/nicknamecheck.me";
	private ModelAndView mav = null;
	
	@Autowired
	@Qualifier("mdao")
	private MemberDao dao;
	
	public NicknameCheckController() {
		super("nickCheck", null);
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "nickname", required = true) String nickname) {
		Member bean = this.dao.SelectByNickname(nickname);
		
		if (bean != null ) { // 존재하는 경우
			if (bean.getNickname().equalsIgnoreCase("admin")) { // 관리자인 경우
				this.mav.addObject("message", "admin은(는) <font color='red'><b>사용 불가능</b></font>한 닉네임입니다.") ;
				this.mav.addObject("isCheck2", false) ;
				
			} else { // 일반 사용자 인 경우
				this.mav.addObject("message", nickname + "은(는) <font color='red'><b>사용중</b></font>인 닉네임입니다.") ;
				this.mav.addObject("isCheck2", false) ;
			}
		} else { // 존재 하지 않는 경우
			this.mav.addObject("message", nickname + "은(는) <font color='blue'><b>사용 가능</b></font>한 닉네임입니다.") ;
			this.mav.addObject("isCheck2", true) ;
		}
		
		this.mav.setViewName(super.getpage); 
		
		return this.mav;
		
	}

}
