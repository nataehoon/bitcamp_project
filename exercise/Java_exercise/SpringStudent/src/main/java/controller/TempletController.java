package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.AlbumDao;

@Controller
public class TempletController {
	@Autowired
	@Qualifier("dao")
	private AlbumDao albunDao;
	
	@RequestMapping(value = "/xxxx.al", method = RequestMethod.GET)
	public String doGet() {
		
		return null;	
	}
	@RequestMapping(value = "/xxxx.al", method = RequestMethod.POST)
	public String doPost() {
		
		return null;
	}
}
