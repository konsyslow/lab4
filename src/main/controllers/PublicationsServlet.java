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
        String user_id = "", name = "", genre = "";

        if ((publicationId != null) && (publicationId.matches("\\d+"))) {
            req.setAttribute("id", publicationId);
            Publications publication = publicationsService.get(Integer.parseInt(publicationId));
            if (publication != null){
                name = publication.getName();
                genre = publication.getGenre();
                user_id = String.valueOf(publication.getUser_id());
            }
        }

        //req.setAttribute("user_id", user_id);
        req.setAttribute("name", name);
        req.setAttribute("genre", genre);


        req.getRequestDispatcher("/publications.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String id = req.getParameter("id");
            //int user_id = Integer.parseInt(req.getParameter("user_id"));
            Integer user_id = Integer.parseInt(req.getSession().getAttribute("userId").toString());
            String name = req.getParameter("name");
            String genre = req.getParameter("genre");

             if ((id == null) || ("null".equals(id))) {
                publicationsService.insert(user_id, name, genre);
            }else{
                 Publications publication = publicationsService.get(Integer.parseInt(id));
                 publication.setUser_id(user_id);
                 publication.setName(name);
                 publication.setGenre(genre);
                 publicationsService.update(publication);
            }
        }catch (Exception e){
            LOGGER.error(e);
        }
        resp.sendRedirect(req.getContextPath() + "/listPublications");
    }

//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
//        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
//                config.getServletContext());
//    }
}
