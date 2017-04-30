package main.controllers;

import main.model.pojo.Users;
import main.services.UserServiceInterface;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by admin on 30.04.2017.
 */
@Controller
@SessionAttributes({"login","userId"})
public class LoginController {
    private static final Logger LOGGER = Logger.getLogger(LoginController.class);
    @Autowired
    private UserServiceInterface userServiceInterface;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String sayHello() {
        LOGGER.debug("LOGINNNN");
        return "login";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam(value = "login", required = true) String login,
                              @RequestParam(value = "password", required = true) String password) {
        ModelAndView mav = new ModelAndView();
        Users user = null;
        if ((user = userServiceInterface.auth(login, password)) != null) {
            mav.addObject("login", login);
            mav.addObject("userId", user.getId());
//            LOGGER.debug("login: " + login);
            mav.setViewName("redirect:/welcome");
        }else{
            mav.setViewName("redirect:/");
        }
        return mav;
    }
}
