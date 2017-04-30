package main.controllers;

import main.services.*;
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
        String hash_pass = null;
        try {
             hash_pass = PasswordStorage.createHash(password);
        }catch(PasswordStorage.CannotPerformOperationException e){
            e.printStackTrace();
        }
        LOGGER.debug("userstr " + login + password);

        LOGGER.debug("user " + login + password);
       // Logger.getLogger(RegistrationServlet.class.getName()).log(Level.DEBUG, "user " + login + password);

        LOGGER.debug("user " + firstName + secondName + lastName);
        if(firstName=="" && secondName=="" && lastName=="" &&
                login=="" && password=="") {
            resp.sendRedirect(req.getContextPath() + "/Registration");
        }else{
            userService.insert(login,hash_pass);
            usersInformationService.insert(firstName,secondName,lastName);
            resp.sendRedirect(req.getContextPath() + "/");
        }

    }
}
