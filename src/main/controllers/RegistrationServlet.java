package main.controllers;

import main.services.UserService;
import main.services.UserServiceInterface;
import main.services.UsersInformationInterface;
import main.services.UsersInformationService;
import org.apache.log4j.Level;
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
//    static{
//        PropertyConfigurator.configure("C:\\Users\\admin\\Documents\\lab3_Suslov_KV\\lab3\\lo4j.properties");
//    }

    private static final Logger LOGGER = Logger.getLogger(RegistrationServlet.class);
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
        LOGGER.debug("userstr " + login + password);
        userService.insert(login,password);
        LOGGER.debug("user " + login + password);
       // Logger.getLogger(RegistrationServlet.class.getName()).log(Level.DEBUG, "user " + login + password);
        usersInformationService.insert(firstName,secondName,lastName);
        LOGGER.debug("user " + firstName + secondName + lastName);
//        Logger.getLogger(RegistrationServlet.class.getName()).
//                log(Level.DEBUG, "user " + firstName + secondName + lastName );
        //resp.sendRedirect("welcome.jsp");
//        req.getSession().setAttribute("userLogin", login);
       resp.sendRedirect(req.getContextPath() + "/");

    }
}
