package main.controllers;

import main.model.pojo.Publications;
import main.services.PublicationsService;
import main.services.PublicationsServiceInterface;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 27.04.2017.
 */
public class PublicationsServlet extends HttpServlet {

    private static PublicationsServiceInterface publicationsService = new PublicationsService();

    private static final Logger LOGGER = Logger.getLogger(PublicationsServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String publicationId = req.getParameter("id");
        String user_id = "", name = "", genre = "", text="";

        if ((publicationId != null) && (publicationId.matches("\\d+"))) {
            req.setAttribute("id", publicationId);
            Publications publication = publicationsService.get(Integer.parseInt(publicationId));
            if (publication != null){
                name = publication.getName();
                genre = publication.getGenre();
                text = publication.getText();
            }
        }
        req.setAttribute("name", name);
        req.setAttribute("genre", genre);
        req.setAttribute("text", text);


        req.getRequestDispatcher("/publications.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String id = req.getParameter("id");
            Integer user_id = Integer.parseInt(req.getSession().getAttribute("userId").toString());
            String name = req.getParameter("name");
            String genre = req.getParameter("genre");
            String text = req.getParameter("text");

             if ((id == null) || ("null".equals(id))) {
                publicationsService.insert(user_id, name, genre,text);
            }else{
                 Publications publication = publicationsService.get(Integer.parseInt(id));
                 publication.setUser_id(user_id);
                 publication.setName(name);
                 publication.setGenre(genre);
                 publication.setText(text);
                 publicationsService.update(publication);
            }
        }catch (Exception e){
            LOGGER.error(e);
        }
        resp.sendRedirect(req.getContextPath() + "/listPublications");
    }
}
