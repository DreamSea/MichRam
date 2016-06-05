package controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import wat.Lobby;
import wat.Player;

@Controller
public class LobbyController {

    @RequestMapping("/lobby")
    public String getLobby(HttpServletRequest request, Model model) {
    	System.out.println("(LobbyController) hi: "+request.getSession().getId());
    	model.addAttribute("hmm", request.getSession());
    	model.addAttribute("queues", Lobby.getQueues());
    	model.addAttribute("games", Lobby.getGames());
        return "lobby";
    }

    @RequestMapping(value="/join", method=RequestMethod.POST)
    public String joinQueue(HttpServletRequest request, Model model, 
    		@RequestParam String playerName, 
    		@RequestParam int index) {
    	System.out.println("(LobbyController) hi: "+request.getSession().getId());
    	if (playerName.equals("")) playerName = "anon"+request.getSession().getId().substring(0, 2);
    	Lobby.joinQueue(index, new Player(playerName, request.getSession().getId()));
    	model.addAttribute("queue", Lobby.getQueue(index));
        return "queue";
    }
}
