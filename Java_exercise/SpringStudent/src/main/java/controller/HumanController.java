package controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.Hobby;
import model.Human;
import model.Job;

@Controller
public class HumanController {
	@ModelAttribute("human")
	public Human some() {
		return new Human();
	}
	
	@ModelAttribute("hobbies")
	public List<Hobby> hobby_list(){
		List<Hobby> lists = new ArrayList<Hobby>();
		
		lists.add(new Hobby("reading", "독서"));
		lists.add(new Hobby("movie", "영화감상"));
		lists.add(new Hobby("baseball", "야구"));
		lists.add(new Hobby("football", "축구"));
		
		return lists;
	}
	
	@ModelAttribute("joblists")
	public List<Job> job_list(){
		List<Job> lists = new ArrayList<Job>();
		
		lists.add(new Job(0, "--- 선택해 주세요"));
		lists.add(new Job(1, "학생"));
		lists.add(new Job(2, "강사"));
		lists.add(new Job(3, "직원"));
		lists.add(new Job(4, "프로그래머"));
		
		return lists;
	}
	
	@ModelAttribute("speciallist")
	public String[] special_list(){
		String[] array = {"마라톤", "중국어", "아랍어"};
		
		return array;
	}
	
	@RequestMapping(value = "/mycaller.hm", method = RequestMethod.GET)
	public ModelAndView doGet() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("humanStart");
		return mav;
	}
	
//	@RequestParam(value = "id", required = true) String id,
//	@RequestParam(value = "name", required = true) String name
	
	@RequestMapping(value = "/mycaller.hm", method = RequestMethod.POST)
	public ModelAndView doPost2(
			@ModelAttribute("human") @Valid Human xxx,
			BindingResult errors) {
		
		ModelAndView mav = new ModelAndView("humanEnd");
		System.out.println(xxx.toString());
		
		if(errors.hasErrors()) {
			mav.setViewName("humanStart");
		}else {
			mav.setViewName("humanEnd");
		}
		
//		System.out.println("id : " + id);
//		System.out.println("name : " + name);

		return mav;
	}
}
