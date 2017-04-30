package main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by admin on 30.04.2017.
 */
@Controller
@RequestMapping(value="/welcome")
public class HelloController {
    @RequestMapping(method = RequestMethod.GET)
    public String sayHello2() {
        return "login";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String sayHello3() {
        return "login";
    }
}
