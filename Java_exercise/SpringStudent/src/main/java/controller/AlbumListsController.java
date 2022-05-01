package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.Album;
import dao.AlbumDao;
import utility.Paging;

@Controller 
public class AlbumListsController { 
	@Autowired
	@Qualifier("dao")
	private AlbumDao albumDao ;
	
	@RequestMapping(value="/list.al") //, method=RequestMethod.GET)
	public ModelAndView handleRequest(
		@RequestParam(value = "what", required = false ) String what,
		@RequestParam(value = "keyword", required = false ) String keyword,
		@RequestParam(value = "pageNumber", required = false ) String pageNumber,
		@RequestParam(value = "pageSize", required = false ) String pageSize,
		HttpServletRequest request, 
		HttpSession session) {
//		System.out.println("==========================================================");
		String loginfo = (String)session.getAttribute("loginfo");		
		System.out.print("세션 정보 보기 01 : ");
		System.out.println(loginfo);
		
		System.out.println("==========================================================");
		System.out.print("what : " + what + ", ");
		System.out.print("keyword : " + keyword + ", ");
		System.out.print("pageNumber : " + pageNumber + ", ");
		System.out.print("pageSize : " + pageSize + ", ");
		
		//System.out.print( 3 / 0 );
	
		// 필드 검색을 위한 코딩
		Map<String, String> map = new HashMap<String, String>() ;	
		
		if( what != null && what.equals("all")){
			what = null ; 
		}
		map.put("what", what ) ;		
		
		// %는 데이터 베이스의 like 연산자 때문에 작성함
		map.put("keyword", "%" + keyword + "%" ) ;
		
		int totalCount = albumDao.GetTotalCount(map);
		System.out.print("totalCount : " + totalCount + ", ");
		String url = request.getContextPath() + "/album/list" ;
		
		ModelAndView mav = new ModelAndView();
		
		Paging pageInfo 
			= new Paging( pageNumber, pageSize, totalCount, url, what, keyword, null);
		
		System.out.print( "offset : " + pageInfo.getOffset() + ", " ) ; 
		System.out.print( "limit : " + pageInfo.getLimit() + ", " ) ;  
		
		List<Album> albumLists = this.albumDao.GetAlbumList(pageInfo, map);
		
		System.out.println("갯수 : " + albumLists.size());
		mav.addObject( "albumLists", albumLists );		
		mav.addObject( "pageInfo", pageInfo );
		mav.setViewName( "alList");
				

//		System.out.print("세션 정보 보기 : 02 ");
//		loginfo = (String)session.getAttribute("loginfo");
//		System.out.println(loginfo);	
//		
//		System.out.println("세션 정보 갱신함");
//		session.setAttribute("loginfo", "김철수(kim)");
		return mav;
	}	
}