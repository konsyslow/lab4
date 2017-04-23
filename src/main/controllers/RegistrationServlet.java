package main.controllers;

import main.services.UserService;
import main.services.UserServiceInterface;
import main.services.UsersInformationInterface;
import main.services.UsersInformationService;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 23.04.2017.
 */
public class RegistrationServlet extends HttpServlet {
    private static UsersInformationInterface usersInformationService = new UsersInformationService();
    private static UserServiceInterface userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/reg.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String secondName = req.getParameter("secondName");
        String lastName = req.getParameter("lastName");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        userService.insert(login,password);
        usersInformationService.insert(firstName,secondName,lastName);
        //resp.sendRedirect("welcome.jsp");
//        req.getSession().setAttribute("userLogin", login);
       resp.sendRedirect(req.getContextPath() + "/");

    }
}
