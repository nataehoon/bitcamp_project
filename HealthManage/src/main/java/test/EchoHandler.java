//package test;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.web.socket.CloseStatus;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//public class EchoHandler extends TextWebSocketHandler {
//	private static List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
//	
//	@Override
//	public void afterConnectionEstablished(WebSocketSession session) throws Exception{
//		String user_name = searchUserName(session);
//		sessionList.add(session);
//	}
//	
//	@Override
//	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception{
//		String user_name = searchUserName(session);
//		for(WebSocketSession sess: sessionList) {
//			sess.sendMessage(new TextMessage(user_name+":"+message.getPayload()));
//		}
//	}
//	
//	@Override
//	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception{
//		String user_name = searchUserName(session);
//		System.out.println("연결 끊어짐");
//		for(WebSocketSession sess : sessionList) {
//			sess.sendMessage(new TextMessage(user_name+"님의 연결이 끊어졌습니다."));
//		}
//		sessionList.remove(session);
//	}
//	
//	public String searchUserName(WebSocketSession session)throws Exception{
//		String user_name;
//		Map<String, Object> map;
//		map = session.getAttributes();
//		user_name = (String) map.get("user_name");
//		return user_name;
//		
//	}
//}
