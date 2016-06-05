package controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import wat.Board;
import wat.Lobby;

@RestController
public class GameStateController {
	
    @RequestMapping("/board")
    public Board getBoard(@RequestParam int index) {
        return Lobby.getGames().get(index).getBoard();
    }
}
