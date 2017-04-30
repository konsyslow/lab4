package main.controllers;

import main.services.PublicationsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by admin on 30.04.2017.
 */
@Controller
@RequestMapping(value="/allPublications")
public class AllPublicationsController {
    @Autowired
    private PublicationsServiceInterface publicationsService;
    @RequestMapping(method = RequestMethod.GET)
    public String showList(Model model){
        model.addAttribute("publications",publicationsService.getAll());
        model.addAttribute("value", "Hello,user");
        return "publications";
    }
}
