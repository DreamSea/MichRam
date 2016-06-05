package controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import connection.WebSocketConfig;

@Controller
public class GameController {
	
	@RequestMapping("/game")
    public String getLobby(HttpServletRequest request, Model model, @RequestParam int index) {
    	System.out.println("(GameController) hi: "+request.getSession().getId());
    	model.addAttribute("ip", WebSocketConfig.THIS_LOCAL_IP);
    	
        return "game";
	}
}
