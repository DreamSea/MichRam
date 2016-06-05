package connection;
import java.io.IOException;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MyHandler extends TextWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
    	System.out.println(session.getId()+": "+message.getPayload());
    	try {
			session.sendMessage(new TextMessage("yo"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // ...
    }
    
    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
    	System.out.println("hi: "+session.getId());
    	System.out.println(session.getHandshakeHeaders());
    	System.out.println(session.getAttributes());
    }
    
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) {
    	System.out.println("bye: "+session.getId()+" "+closeStatus.getCode()+" "+closeStatus.getReason());
    }

}