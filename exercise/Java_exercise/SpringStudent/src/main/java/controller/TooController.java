package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/first")
public class TooController {
	@RequestMapping(value = "/first.to", method = RequestMethod.GET)
	public String first(Model model) {
		model.addAttribute("aaa", "하이");
		model.addAttribute("bbb", "바이");
		
		System.out.println("fsdasg");
		return "first";
	}
	
	@RequestMapping(value = "/second.to", method = RequestMethod.GET)
	public ModelAndView second() {
		ModelAndView mav = new ModelAndView("second");
		
		mav.addObject("second", "두번째");
		
		List<String> list = new ArrayList<String>();
		list.add("하나");
		list.add("둘");
		list.add("셋");
		
		mav.addObject("list", list);
		
		return mav;
	}

}
