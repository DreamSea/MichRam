package controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import connection.ConnectionManager;
import connection.UpdateType;
import wat.Game;
import wat.Lobby;

@Controller
public class GameController {
	
	@RequestMapping("/game")
    public String getLobby(HttpServletRequest request, Model model, @RequestParam int index) {
    	System.out.println("(GameController) hi: "+request.getSession().getId());
        return "game";
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
