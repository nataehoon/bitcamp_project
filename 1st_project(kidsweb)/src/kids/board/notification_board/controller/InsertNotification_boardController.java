package kids.board.notification_board.controller;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kids.board.notification_board.model.Notification_board;
import kids.board.notification_board.model.Notification_boardDao;
import kids.common.controller.SuperClass;

public class InsertNotification_boardController extends SuperClass {

	private static final long serialVersionUID = 1L;
	
	@Override
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	super.doPost(request, response);
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8");
	
	int class_id = Integer.parseInt(request.getParameter("class_id"));
	String pid = request.getParameter("pid");
	String contents = request.getParameter("contents");
	int send = Integer.parseInt(request.getParameter("send"));
	
	if(class_id < 1 || pid == null || pid.equals("")
			|| contents == null || contents.equals("") || send > 2 || send < 1) {
		System.out.println("채팅 입력 오류 입니다.");
		response.getWriter().write(0);
	}else {
		Notification_board bean = new Notification_board();
		
		pid = URLDecoder.decode(pid, "UTF-8");
		contents = URLDecoder.decode(contents, "UTF-8");
		
		bean.setClass_id(class_id);
		bean.setPid(pid);
		bean.setContents(contents);
		bean.setSend(send);
		session.setAttribute("send", 0);
		response.getWriter().write(new Notification_boardDao().InsertData(bean) + "");
	}
}
}
