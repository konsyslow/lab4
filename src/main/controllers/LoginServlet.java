package main.controllers;

import main.model.pojo.Users;
import main.services.UserService;
import main.services.UserServiceInterface;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 19.04.2017.
 */
public class LoginServlet extends HttpServlet {
//    static{
//        PropertyConfigurator.configure("lo4j.properties");
//    }

    private static UserServiceInterface userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login2.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (userService.auth(login, password) != null) {
            req.getSession().setAttribute("userLogin", login);
            //logger.debug("user: " + login + " logged" );
            resp.sendRedirect(req.getContextPath() + "/listUsers");
            //resp.sendRedirect(req.getContextPath() + "/welcome");


           // resp.sendRedirect(req.getContextPath() + "/students/");
        }else{
            resp.sendRedirect(req.getContextPath() + "/");
        }
    }
}
