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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by admin on 20.04.2017.
 */
public class ListPublicationsServlet extends HttpServlet {
    private static PublicationsServiceInterface publicationsService = new PublicationsService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("value", "Hello, user");
        String button = req.getParameter("delete");
            if ( button != null){
                deleteStudent(req.getParameter("delete"));
                resp.sendRedirect(req.getContextPath() + "/listPublications");
            }else {
                Integer userId = Integer.parseInt(req.getSession().getAttribute("userId").toString());
                List<Publications> usersPublications = publicationsService.getUsersPublications(userId);
                req.setAttribute("usersPublications", usersPublications);
                getServletContext().getRequestDispatcher("/listPublications.jsp").forward(req, resp);
            }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    private void deleteStudent(String id){
        if (id.matches("\\d+")) {
            publicationsService.delete(Integer.parseInt(id));
        }
    }


}
