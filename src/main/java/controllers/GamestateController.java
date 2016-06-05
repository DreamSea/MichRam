package controllers;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.WebSocketSession;

import connection.ConnectionManager;
import connection.UpdateHandler;
import connection.UpdateType;
import wat.Board;
import wat.Tile;

@RestController
public class GamestateController {
	
    @RequestMapping("/board")
    public Board getBoard() {
    	Board board = new Board();
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
        return board;
    }
    
    private Tile makeTile(int index, double xCoord, double yCoord) {
    	Tile toReturn = new Tile();
    	toReturn.setIndex(index);
    	toReturn.setxCoord(xCoord);
    	toReturn.setyCoord(yCoord);
    	return toReturn;
    }
    
    private static Random r = new Random();
    
//    @RequestMapping("/rollDice")
//    public void rollDice(HttpServletRequest request) {
//    	WebSocketSession session = ConnectionManager.getSession(request.getSession().getId());
//    	if (session != null) {
//    		int roll = r.nextInt(6)+1;
//    		ConnectionManager.sendToAllListeners(UpdateType.DICE_ROLLED, "session "+session.getId()+" rolled "+roll);
//    	}
//    }

}
