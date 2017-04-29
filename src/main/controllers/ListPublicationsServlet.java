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

        //List<Publications> publications = publicationsService.getAll();
//        Integer userId = Integer.parseInt(req.getSession().getAttribute("userId").toString());
//        List<Publications> usersPublications = publicationsService.getUsersPublications(userId);
        //req.setAttribute("publications", publications);
       // req.setAttribute("usersPublications", usersPublications);
        //////////////////////////////////////////////////////////////////
        String button = req.getParameter("delete");

        //Integer userId = Integer.parseInt(req.getSession().getAttribute("userId").toString());
//        if ("update".equals(button)) {
//            // publicationsService.update();
//        } else
           // if("delete".equals(button)) { //(isDelete(button)) {
                if ( button != null){
                deleteStudent(req.getParameter("delete"));
                resp.sendRedirect(req.getContextPath() + "/listPublications");
//            int publicationsId = getPublicationId(button);
//            publicationsService.delete(publicationsId);
//        }else if ("read".equals(button)) {
//
//        }else if ("new publication".equals(button)) {
//            //publicationsService.insert(11, userId, "newpub2", "novel");
//        }
            }else {
                Integer userId = Integer.parseInt(req.getSession().getAttribute("userId").toString());
                List<Publications> usersPublications = publicationsService.getUsersPublications(userId);
                req.setAttribute("usersPublications", usersPublications);
                //resp.sendRedirect(req.getContextPath() + "/listPublications");
                ///////////////////////////////////////////////////////////////////
                getServletContext().getRequestDispatcher("/listPublications.jsp").forward(req, resp);
            }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


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

    private void deleteStudent(String id){
        if (id.matches("\\d+")) {
            publicationsService.delete(Integer.parseInt(id));
        }
    }


}
