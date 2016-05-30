package hmm;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SandboxController {

    @RequestMapping("/")
    public String getCanvasHTML(HttpServletRequest request) {
    	System.out.println("hi: "+request.getSession().getId());
        return "sandbox";
    }

}
