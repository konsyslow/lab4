package main.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import main.model.pojo.UsersInformation;
import main.services.UsersInformationInterface;
import main.services.UsersInformationService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 19.04.2017.
 */
public class ListController extends HttpServlet {
    public  static UsersInformationInterface service = new UsersInformationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("value", "Hello, ");

        List<UsersInformation> usersInformations = service.getAll();
        req.setAttribute("usersInformations", usersInformations);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listUsers.jsp");
        dispatcher.forward(req, resp);
    }

    @Override

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
