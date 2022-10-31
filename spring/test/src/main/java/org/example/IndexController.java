package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Locale;

@Controller
public class IndexController {

    // HTTP GET localhost:8080
//    @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String index(Locale locale, Model model, HttpServletRequest request) {

        LocalDateTime localDateTime = LocalDateTime.now();
        model.addAttribute("now", localDateTime);
        // model: HttpServletRequest
        request.setAttribute("now", localDateTime);
        // localhost:8080 -- forward --> /WEB-INF/views/index.jsp
        
        System.out.println("IndexController");

        // /WEB-INF/views/index.jsp
        return "index";
    }
}
