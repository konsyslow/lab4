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
public class PublicationsServlet extends HttpServlet {
    private static PublicationsServiceInterface publicationsService = new PublicationsService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("value", "Hello, user");

        List<Publications> publications = publicationsService.getAll();
        Integer userId = Integer.parseInt(req.getSession().getAttribute("userId").toString());
        List<Publications> usersPublications = publicationsService.getUsersPublications(userId);
        req.setAttribute("publications", publications);
        req.setAttribute("usersPublications", usersPublications);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/publications.jsp");
        dispatcher.forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String button = req.getParameter("button");

        Integer userId = Integer.parseInt(req.getSession().getAttribute("userId").toString());
        if ("update".equals(button)) {
            // publicationsService.update();
        } else if (isDelete(button)) {
            int publicationsId = getPublicationId(button);
            publicationsService.delete(publicationsId);
        }else if ("read".equals(button)) {

        }else if ("new publication".equals(button)) {
            publicationsService.insert(11, userId, "newpub2", "novel");
        }
        resp.sendRedirect(req.getContextPath() + "/publications");
    }

    private boolean isDelete(String inputString){
        String regularExpression = "delete(.*)";
        Pattern pattern = Pattern.compile(regularExpression);
        Matcher match = pattern.matcher(inputString);
        return match.matches();
    }
    private int getPublicationId(String inputString){
        int res = -1;
        String regularExpression = "\\d+";
        Pattern pattern = Pattern.compile(regularExpression);
        Matcher match = pattern.matcher(inputString);
        if (match.find()) {
            res = Integer.parseInt(match.group().toString());
        }
        return res;
    }


}
