package main.controllers;

import main.model.pojo.Publications;
import main.services.PublicationsService;
import main.services.PublicationsServiceInterface;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by admin on 29.04.2017.
 */
public class ReadingServlet extends HttpServlet {
    private static PublicationsServiceInterface publicationsService = new PublicationsService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String publicationId = req.getParameter("id");
        String user_id = "", name = "", genre = "", text="";

        if ((publicationId != null) && (publicationId.matches("\\d+"))) {
            req.setAttribute("id", publicationId);
            Publications publication = publicationsService.get(Integer.parseInt(publicationId));
            if (publication != null){
                name = publication.getName();
                text = publication.getText();
            }
        }
        req.setAttribute("name", name);
        req.setAttribute("text", text);
        getServletContext().getRequestDispatcher("/reading.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
