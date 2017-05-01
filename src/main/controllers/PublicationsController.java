package main.controllers;

import main.model.pojo.Publications;
import main.services.PublicationsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by admin on 01.05.2017.
 */
@Controller
public class PublicationsController {
    @Autowired
    private PublicationsServiceInterface publicationsService;

    @RequestMapping(value="/publications",method = RequestMethod.GET)
    public ModelAndView showPublications(@RequestParam(name="id", required = false) String publicationId,
                                        Model model){
        ModelAndView mav = new ModelAndView();
        String user_id = "", name = "", genre = "", text="";

        if ((publicationId != null) && (publicationId.matches("\\d+"))) {
            model.addAttribute("publicationId",publicationId);
            Publications publication = publicationsService.get(Integer.parseInt(publicationId));
            if (publication != null){
                name = publication.getName();
                genre = publication.getGenre();
                text = publication.getText();
            }

        }

        model.addAttribute("name",name);
        model.addAttribute("genre",genre);
        model.addAttribute("text",text);
        return mav;
    }

    @RequestMapping(value="/publications",method = RequestMethod.POST)
    public ModelAndView actionsWithPublications(@RequestParam(name="publicationId", required = false) String publicationId,
                                         @RequestParam(name="name", required = false) String name,
                                         @RequestParam(name="genre", required = false) String genre,
                                         @RequestParam(name="text", required = false) String text,
                                         Model model, HttpSession session) {

        ModelAndView mav = new ModelAndView();
        try {
            Integer userId = Integer.parseInt(session.getAttribute("userId").toString());

            if ((publicationId == null) || ("null".equals(publicationId))) {
                publicationsService.insert(userId, name, genre, text);
            } else {
                Publications publication = publicationsService.get(Integer.parseInt(publicationId));
                publication.setUser_id(userId);
                publication.setName(name);
                publication.setGenre(genre);
                publication.setText(text);
                publicationsService.update(publication);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        mav.setViewName("redirect:/listPublications");
        return mav;
    }
}
