package controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import connection.ConnectionManager;
import connection.UpdateType;
import wat.Board;
import wat.Game;
import wat.Lobby;
import wat.Player;

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
    		Player currentPlayer = game.getCurrentPlayer();
    		int roll = game.doRoll();
    		ConnectionManager.sendToAllListeners(UpdateType.DICE_ROLLED, currentPlayer.getName()+" rolling 2d6 = "+roll+", location = "+currentPlayer.getLocation().getIndex());
    	}
    }
}
