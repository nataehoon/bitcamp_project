package controller.advice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;
import org.springframework.web.context.request.SessionScope;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import bean.Member;

public class ReplyEchoHandelr extends TextWebSocketHandler {
	List<WebSocketSession> sessions = new ArrayList<>();
	Map<String, WebSocketSession> userSessions = new HashMap<>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception{
		System.out.println("afterConnectionEstablished : " + session);
		sessions.add(session);
		String senderId = getId(session);
		userSessions.put(senderId, session);
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception{
		System.out.println("handleTextMessage : " + session + ":" + message);
		String senderId = getId(session);
//		for (WebSocketSession sess: sessions) {
//			sess.sendMessage(new TextMessage(senderId + ":" + message));
//		}
		
		//protocol: cmd, 댓글 작성자, 게시글 작성자, bono(reply, user2, user1, 234)
		String msg = message.getPayload();
		if(!StringUtils.isEmpty(msg)) {
			String[] strs = message.getPayload().split(",");
			if(strs != null && strs.length == 4) {
				String cmd = strs[0];
				String replyWriter = strs[1];
				String boardWriter = strs[2];
				String bono = strs[3];
				
				WebSocketSession boardWriterSessions = userSessions.get(boardWriter);
				if(boardWriterSessions != null) {
					TextMessage tmpMsg = new TextMessage(replyWriter + "님이" + bono + "번 게시글에 댓글을 달았습니다.");
					boardWriterSessions.sendMessage(tmpMsg);
				}
			}
		}
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception{
		System.out.println("afterConnectionClosed : " + session + ":" + status);
	}
	
	private String getId(WebSocketSession session) {
		Map<String, Object> httpSession = session.getAttributes();
		Member loginUser = (Member)httpSession.get(SessionScope.class);
		if(null == loginUser) {
			return session.getId();
		}else {
			return null;
		}
	}

}
