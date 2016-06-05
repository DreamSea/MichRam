package controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/socketTest")
    public String getIndex(HttpServletRequest request) {
    	System.out.println("index: "+request.getSession().getId());
        return "gg";
    }

    @RequestMapping("/test")
    public String test() {
    	return "vestige";
    }
}