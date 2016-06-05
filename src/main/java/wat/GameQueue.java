package wat;

import java.util.ArrayList;
import java.util.List;

public class GameQueue {
	private int maxPlayers;
	private List<Player> playerList;
	
	public GameQueue(int maxPlayers) {
		this.maxPlayers = maxPlayers;
		playerList = new ArrayList<Player>();
	}
	
	public int getMaxPlayers() {
		return maxPlayers;
	}
	
	public int getNumPlayers() {
		return playerList.size();
	}
	
	public List<Player> getPlayers() {
		return playerList;
	}
	
	public void addPlayer(Player player) {
		// lazy duplicate check
		for (Player p : playerList) {
			if (p.getHttpSessionId().equals(player.getHttpSessionId())) {
				return;
			}
		}
		if (playerList.size() < maxPlayers) {
			playerList.add(player);	
		}
		if (playerList.size() == maxPlayers) {
			Lobby.convertToGame(this);
		}
	}
	
	public boolean isReady() {
		return (playerList.size() == maxPlayers);
	}
}
