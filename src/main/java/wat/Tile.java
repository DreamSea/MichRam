package wat;

import java.util.ArrayList;
import java.util.List;

public class Tile {
	private int index;
	private double xCoord;
	private double yCoord;
	private List<Tile> nextTiles = new ArrayList<>();
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public double getxCoord() {
		return xCoord;
	}
	public void setxCoord(double xCoord) {
		this.xCoord = xCoord;
	}
	public double getyCoord() {
		return yCoord;
	}
	public void setyCoord(double yCoord) {
		this.yCoord = yCoord;
	}
	public List<Tile> getNextTiles() {
		return nextTiles;
	}
	
	public void addNextTiles(Tile tile) {
		nextTiles.add(tile);
	}
}
