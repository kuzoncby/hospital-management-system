package gov.whocare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Kuzon on 2016/7/5.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public ModelAndView getHome() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("hello", "Kuzon");
        return mv;
    }

    @RequestMapping("/hello")
    public String getHello() {
        return "Kuzon";
    }

}
