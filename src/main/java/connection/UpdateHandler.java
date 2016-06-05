package connection;
import java.io.IOException;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class UpdateHandler extends TextWebSocketHandler {
	
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
    	System.out.println(session.getId()+": "+message.getPayload());
    	try {
			session.sendMessage(new TextMessage("yo"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @Override
    public void afterConnectionEstablished(WebSocketSession socketSession) throws IOException {
    	System.out.println("hi: "+socketSession.getId());
    	System.out.println(socketSession.getHandshakeHeaders());
    	System.out.println(socketSession.getAttributes());
    	
    	String httpSessionId = socketSession.getAttributes().get("HTTP.SESSION.ID").toString();
    	if (httpSessionId == null) {
    		socketSession.close();
    	} else {
    		ConnectionManager.sendToAllListeners(UpdateType.PLAYER_JOINED, "session "+socketSession.getId());
    		ConnectionManager.addSocketSession(httpSessionId, socketSession);
    	}
    }
    
    @Override
    public void afterConnectionClosed(WebSocketSession socketSession, CloseStatus closeStatus) {
    	System.out.println("bye: "+socketSession.getId()+" "+closeStatus.getCode()+" "+closeStatus.getReason());
    	String httpSessionId = socketSession.getAttributes().get("HTTP.SESSION.ID").toString();
    	if (httpSessionId != null) {
    		ConnectionManager.removeSocketSession(httpSessionId);
    		ConnectionManager.sendToAllListeners(UpdateType.PLAYER_LEFT, "session "+socketSession.getId());
    	}
    }

}