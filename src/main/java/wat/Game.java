package wat;

import java.util.List;

public class Game {

	private List<Player> players;
	private int currentPlayer;
	private Board board;

	private void initBoard() {
		board = new Board();
		Tile[] tiles = new Tile[79];
		tiles[0] = makeTile(0, 0, 8);
		tiles[1] = makeTile(1, 1, 7);
		tiles[2] = makeTile(2, 2, 6);
		tiles[3] = makeTile(3, 3, 6);
		tiles[4] = makeTile(4, 4, 6);
		tiles[5] = makeTile(5, 3, 5);
		tiles[6] = makeTile(6, 2, 4);
		tiles[7] = makeTile(7, 1, 4);
		tiles[8] = makeTile(8, 2, 3);
		tiles[9] = makeTile(9, 3, 3);
		tiles[10] = makeTile(10, 4, 3);
		tiles[11] = makeTile(11, 5, 3);
		tiles[12] = makeTile(12, 6, 4);
		tiles[13] = makeTile(13, 7, 4);
		tiles[14] = makeTile(14, 7, 3);
		tiles[15] = makeTile(15, 7, 2);
		tiles[16] = makeTile(16, 7, 1);
		tiles[17] = makeTile(17, 8, 0);
		tiles[18] = makeTile(18, 9, 0);
		tiles[19] = makeTile(19, 10, 1);
		tiles[20] = makeTile(20, 8, 3);
		tiles[21] = makeTile(21, 9, 3);
		tiles[22] = makeTile(22, 10, 3);
		tiles[23] = makeTile(23, 10, 2);
		tiles[24] = makeTile(24, 11, 2);
		tiles[25] = makeTile(25, 12, 2);
		tiles[26] = makeTile(26, 13, 1);
		tiles[27] = makeTile(27, 13, 2);
		tiles[28] = makeTile(28, 14, 3);
		tiles[29] = makeTile(29, 14, 4);
		tiles[30] = makeTile(30, 13, 4);
		tiles[31] = makeTile(31, 12, 4);
		tiles[32] = makeTile(32, 11, 5);
		tiles[33] = makeTile(33, 10, 5);
		tiles[34] = makeTile(34, 9, 6);
		tiles[35] = makeTile(35, 8, 7);
		tiles[36] = makeTile(36, 8, 8);
		tiles[37] = makeTile(37, 7, 8);
		tiles[38] = makeTile(38, 7, 9);
		tiles[39] = makeTile(39, 7, 10);
		tiles[40] = makeTile(40, 6, 11);
		tiles[41] = makeTile(41, 6, 8);
		tiles[42] = makeTile(42, 5, 9);
		tiles[43] = makeTile(43, 5, 10);
		tiles[44] = makeTile(44, 5, 11);
		tiles[45] = makeTile(45, 4, 11);
		tiles[46] = makeTile(46, 3, 12);
		tiles[47] = makeTile(47, 3, 13);
		tiles[48] = makeTile(48, 2, 13);
		tiles[49] = makeTile(49, 2, 12);
		tiles[50] = makeTile(50, 2, 11);
		tiles[51] = makeTile(51, 1, 10);
		tiles[52] = makeTile(52, 1, 9);
		tiles[53] = makeTile(53, 9, 7);
		tiles[54] = makeTile(54, 10, 7);
		tiles[55] = makeTile(55, 7, 11);
		tiles[56] = makeTile(56, 8, 11);
		tiles[57] = makeTile(57, 8, 12);
		tiles[58] = makeTile(58, 10, 8);
		tiles[59] = makeTile(59, 11, 8);
		tiles[60] = makeTile(60, 12, 8);
		tiles[61] = makeTile(61, 13, 7);
		tiles[62] = makeTile(62, 13, 8);
		tiles[63] = makeTile(63, 13, 9);
		tiles[64] = makeTile(64, 13, 10);
		tiles[65] = makeTile(65, 13, 11);
		tiles[66] = makeTile(66, 13, 12);
		tiles[67] = makeTile(67, 12, 12);
		tiles[68] = makeTile(68, 11, 12);
		tiles[69] = makeTile(69, 10, 12);
		tiles[70] = makeTile(70, 9, 12);
		tiles[71] = makeTile(71, 9, 11);
		tiles[72] = makeTile(72, 9, 10);
		tiles[73] = makeTile(73, 12, 9);
		tiles[74] = makeTile(74, 11, 10);
		tiles[75] = makeTile(75, 11, 11);
		tiles[76] = makeTile(76, 10, 11);
		tiles[77] = makeTile(77, 10, 10);
		tiles[78] = makeTile(78, 10, 9);

		tiles[0].addNextTiles(tiles[1]);
		tiles[1].addNextTiles(tiles[2]);
		tiles[2].addNextTiles(tiles[3]);
		tiles[3].addNextTiles(tiles[4]);
		tiles[4].addNextTiles(tiles[5]);
		tiles[5].addNextTiles(tiles[6]);
		tiles[6].addNextTiles(tiles[7]);
		tiles[7].addNextTiles(tiles[8]);
		tiles[8].addNextTiles(tiles[9]);
		tiles[9].addNextTiles(tiles[10]);
		tiles[10].addNextTiles(tiles[11]);
		tiles[11].addNextTiles(tiles[12]);
		tiles[12].addNextTiles(tiles[13]);
		tiles[13].addNextTiles(tiles[14]);
		tiles[14].addNextTiles(tiles[15]);
		tiles[14].addNextTiles(tiles[20]);
		tiles[15].addNextTiles(tiles[16]);
		tiles[16].addNextTiles(tiles[17]);
		tiles[17].addNextTiles(tiles[18]);
		tiles[18].addNextTiles(tiles[19]);
		tiles[19].addNextTiles(tiles[24]);
		tiles[20].addNextTiles(tiles[21]);
		tiles[21].addNextTiles(tiles[22]);
		tiles[22].addNextTiles(tiles[23]);
		tiles[23].addNextTiles(tiles[24]);
		tiles[24].addNextTiles(tiles[25]);
		tiles[25].addNextTiles(tiles[26]);
		tiles[26].addNextTiles(tiles[27]);
		tiles[27].addNextTiles(tiles[28]);
		tiles[28].addNextTiles(tiles[29]);
		tiles[29].addNextTiles(tiles[30]);
		tiles[30].addNextTiles(tiles[31]);
		tiles[31].addNextTiles(tiles[32]);
		tiles[32].addNextTiles(tiles[33]);
		tiles[33].addNextTiles(tiles[34]);
		tiles[34].addNextTiles(tiles[35]);
		tiles[34].addNextTiles(tiles[53]);
		tiles[35].addNextTiles(tiles[36]);
		tiles[36].addNextTiles(tiles[37]);
		tiles[37].addNextTiles(tiles[38]);
		tiles[37].addNextTiles(tiles[41]);
		tiles[38].addNextTiles(tiles[39]);
		tiles[39].addNextTiles(tiles[40]);
		tiles[40].addNextTiles(tiles[44]);
		tiles[41].addNextTiles(tiles[42]);
		tiles[42].addNextTiles(tiles[43]);
		tiles[43].addNextTiles(tiles[44]);
		tiles[44].addNextTiles(tiles[45]);
		tiles[45].addNextTiles(tiles[46]);
		tiles[46].addNextTiles(tiles[47]);
		tiles[47].addNextTiles(tiles[48]);
		tiles[48].addNextTiles(tiles[49]);
		tiles[49].addNextTiles(tiles[50]);
		tiles[50].addNextTiles(tiles[51]);
		tiles[51].addNextTiles(tiles[52]);
		tiles[52].addNextTiles(tiles[0]);
		tiles[53].addNextTiles(tiles[54]);
		tiles[54].addNextTiles(tiles[58]);
		tiles[55].addNextTiles(tiles[39]);
		tiles[56].addNextTiles(tiles[55]);
		tiles[57].addNextTiles(tiles[56]);
		tiles[58].addNextTiles(tiles[59]);
		tiles[58].addNextTiles(tiles[78]);
		tiles[59].addNextTiles(tiles[60]);
		tiles[60].addNextTiles(tiles[61]);
		tiles[61].addNextTiles(tiles[62]);
		tiles[61].addNextTiles(tiles[73]);
		tiles[62].addNextTiles(tiles[63]);
		tiles[63].addNextTiles(tiles[64]);
		tiles[64].addNextTiles(tiles[65]);
		tiles[65].addNextTiles(tiles[66]);
		tiles[66].addNextTiles(tiles[67]);
		tiles[67].addNextTiles(tiles[68]);
		tiles[68].addNextTiles(tiles[69]);
		tiles[69].addNextTiles(tiles[70]);
		tiles[70].addNextTiles(tiles[57]);
		tiles[71].addNextTiles(tiles[70]);
		tiles[72].addNextTiles(tiles[71]);
		tiles[73].addNextTiles(tiles[74]);
		tiles[74].addNextTiles(tiles[75]);
		tiles[75].addNextTiles(tiles[76]);
		tiles[76].addNextTiles(tiles[77]);
		tiles[77].addNextTiles(tiles[72]);
		tiles[78].addNextTiles(tiles[77]);

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
		currentPlayer = 0;
		this.players = players;
		for (Player p : this.players) {
			p.setLocation(board.getTiles()[0]);
		}
	}

	public Player getCurrentPlayer() {
		return players.get(currentPlayer);
	}

	public int doRoll() {
		int roll = Dice.rollDice(2, 6);
		Tile currentLocation = players.get(currentPlayer).getLocation();
		for (int i = 0; i < roll; i++) {
			currentLocation = currentLocation.getNextTiles().get(0);
		}
		players.get(currentPlayer).setLocation(currentLocation);
		currentPlayer = (currentPlayer + 1) % players.size();
		return roll;
	}

	public Board getBoard() {
		return board;
	}
}
