package main.controllers;

import main.model.pojo.Publications;
import main.services.PublicationsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by admin on 30.04.2017.
 */
@Controller
@RequestMapping(value="/listPublications")
public class ListPublicationsController {
    @Autowired
    private  PublicationsServiceInterface publicationsService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView actionsWithList(@RequestParam(name="button", value = "delete", required = true) String button,
                                        Model model, HttpSession session){
        ModelAndView mav = new ModelAndView();
        if ( button != null) {
            deleteStudent(button);
            mav.setViewName("redirect:/listPublications");
        }else{
            Integer userId = Integer.parseInt(session.getAttribute("userId").toString());
            List<Publications> usersPublications = publicationsService.getUsersPublications(userId);
            model.addAttribute("usersPublications",usersPublications);
            model.addAttribute("value", "Hello,user");
//            LOGGER.debug("login: " + login);
        }
        return mav;
    }

    private void deleteStudent(String id){
        if (id.matches("\\d+")) {
            publicationsService.delete(Integer.parseInt(id));
        }
    }
}
