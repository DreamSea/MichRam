package wat;

import java.util.ArrayList;
import java.util.List;

public class Lobby {
	private static List<GameQueue> queueingList = new ArrayList<GameQueue>();
	private static List<Game> gameList = new ArrayList<Game>();
	
	static {
		addQueue(2);
	}
	
	public static void addQueue(int numPlayers) {
		queueingList.add(new GameQueue(numPlayers));
	}
	
	public static void addGame(Game game) {
		gameList.add(game);
	}
	
	public static List<GameQueue> getQueues() {
		return queueingList;
	}
	
	public static List<Game> getGames() {
		return gameList;
	}

	public static void convertToGame(GameQueue gameQueue) {
		Game newGame = new Game(gameQueue.getPlayers());
		gameList.add(newGame);
	}

	public static void joinQueue(int index, Player player) {
		queueingList.get(index).addPlayer(player);
	}

	public static Object getQueue(int index) {
		return queueingList.get(index);
	}
	
	
}
