package connection;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

public class ConnectionManager {
	/**
	 * String httpSessionID
	 * WebSocketSession Socketsession
	 */
	private static Map<String, WebSocketSession> socketListeners = new HashMap<>();

	public static int getNumListeners() {
		return socketListeners.size();
	}
	
	static void addSocketSession(String httpSessionId, WebSocketSession socketSession) {
		socketListeners.put(httpSessionId, socketSession);
	}
	
	static void removeSocketSession(String httpSessionId) {
		socketListeners.remove(httpSessionId);
	}
    
    public static void sendToAllListeners(UpdateType type, String message) {
		for (WebSocketSession listeners : socketListeners.values()) {
			try {
				listeners.sendMessage(new TextMessage(type.toString()+": "+message));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }

}
