package controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import connection.ConnectionManager;
import connection.UpdateType;
import wat.Board;
import wat.Game;
import wat.Lobby;

@RestController
public class GamestateController {
	
    @RequestMapping("/board")
    public Board getBoard() {
        return Lobby.getGames().get(0).getBoard();
    }
    
    @RequestMapping("/rollDice")
    public void rollDice(HttpServletRequest request) {
    	Game game = Lobby.getGames().get(0);
    	if (game.getCurrentPlayer().getHttpSessionId().equals(request.getSession().getId())) {
    		String currentPlayerName = game.getCurrentPlayer().getName();
    		int roll = game.doRoll();
    		ConnectionManager.sendToAllListeners(UpdateType.DICE_ROLLED, currentPlayerName+" rolled "+roll);
    	}
    }
}
