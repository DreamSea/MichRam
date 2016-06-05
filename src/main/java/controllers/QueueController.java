package controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import wat.Lobby;

public class QueueController {


    @RequestMapping(value="/join", method=RequestMethod.GET)
    public String joinQueue(HttpServletRequest request, Model model, 
    		@RequestParam int index) {
    	System.out.println("(QueueController) hi: "+request.getSession().getId());
    	model.addAttribute("queue", Lobby.getQueue(index));
        return "queue";
    }
	
	
}
