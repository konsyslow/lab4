package main.controllers;

import main.model.pojo.Publications;
import main.services.PublicationsService;
import main.services.PublicationsServiceInterface;
import main.services.UsersInformationInterface;
import main.services.UsersInformationService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by admin on 20.04.2017.
 */
public class PublicationsServlet extends HttpServlet {
    private static PublicationsServiceInterface publicationsService = new PublicationsService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("value", "Hello, user");

        List<Publications> publications = publicationsService.getAll();
        req.setAttribute("publications", publications);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/publications.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


}
