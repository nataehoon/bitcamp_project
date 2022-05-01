package shopping.comment.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import shopping.comment.model.Comment;
import shopping.common.controller.SuperClass;
import shopping.common.model.DatabaseDao;

public class CommentListController extends SuperClass {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
//		int no = Integer.parseInt( request.getParameter("no") ) ; 
//		System.out.println( this.getClass() + " no : " + no );
//		CommentDao dao = new CommentDao() ;
//		List<Comment> comments =  dao.SelectCommentListByPk( no ) ;
//		System.out.println( "Comment 개수 : " + comments.size() );
//		
//		JSONArray jsArr = new JSONArray() ;
//		
//		for( Comment comm : comments){
//			JSONObject jsObj = new JSONObject();
//			jsObj.put("cnum", comm.getCnum() ) ;
//			jsObj.put("writer", comm.getWriter() ) ;
//			jsObj.put("content", comm.getContent() ) ;
//			jsObj.put("regdate", comm.getRegdate() ) ;			
//			jsArr.add( jsObj ) ;
//		}
//			
//		request.setAttribute("jsArr", jsArr); 
//		
//		String gotopage = "/comment/comment.jsp" ;
//		super.GotoPage(gotopage);	
	}
}