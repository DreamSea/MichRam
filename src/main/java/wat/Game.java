package wat;

import java.util.List;

public class Game {

	private List<Player> players;
	private Board board;
	
	private void initBoard() {
    	board = new Board();
    	Tile[] tiles = new Tile[8];
    	tiles[0] = makeTile(0, 0, 0);
    	tiles[1] = makeTile(1, 1, 0);
    	tiles[2] = makeTile(2, 2, 0);
    	tiles[3] = makeTile(3, 2, 1);
    	tiles[4] = makeTile(4, 2, 2);
    	tiles[5] = makeTile(5, 1, 2);
    	tiles[6] = makeTile(6, 0, 2);
    	tiles[7] = makeTile(7, 0, 1);
    	board.setTiles(tiles);
	}

    private Tile makeTile(int index, double xCoord, double yCoord) {
    	Tile toReturn = new Tile();
    	toReturn.setIndex(index);
    	toReturn.setxCoord(xCoord);
    	toReturn.setyCoord(yCoord);
    	return toReturn;
    }
	
	public Game(List<Player> players) {
		initBoard();
		this.players = players;
	}
	
	
}