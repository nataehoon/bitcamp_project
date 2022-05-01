package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/first")
public class HelloController {
	@RequestMapping(value = "/caller1.he", method = RequestMethod.GET)
	public String home(Model model) {
		System.out.println("가나다");
		model.addAttribute("greeting", "여러분 방가방가");
		model.addAttribute("message", "코로나 퇴치합시다");
		
		return "hello";
	}
	
	@RequestMapping(value = "/hohoho.he", method = RequestMethod.GET)
	public ModelAndView hohoho() {
		ModelAndView mav = new ModelAndView("hohoho");
		
		mav.addObject("hohoho", "안녕하세요 홍홍홍");
		
		List<String> lists = new ArrayList<String>();
		lists.add("가나");
		lists.add("다라");
		lists.add("마바");
		
		mav.addObject("lists", lists);
		
		return mav;
	}
}
