package main.services;

import main.model.dao.UserDAO;
import main.model.dao.UserDAOImpl;
import main.model.pojo.Users;

import java.util.List;

/**
 * Created by admin on 20.04.2017.
 */
public class UserService implements UserServiceInterface {
    private static UserDAO userDAO = new UserDAOImpl(ManagementSystem.getCon());

    public Users auth(String login, String password) {
        Users user = userDAO.findUserByLoginAndPassword(login, password);
        //Users user = new Users(1,"login2","login2", 0);
        //LOGGER.debug("user: " + user);

        if (user != null && user.isBlocked()==1) {
            return null;
        }
       // logger.debug("user not blocked");

        return user;
    }

    public void insert(String login, String password){
        userDAO.insertUser(login, password);
    }

    public List<Users> getAll(){
        return userDAO.getAll();
    }

    public Users get(Integer id) {
        return userDAO.get(id);
    }

    public void delete(Integer id) {
        userDAO.deleteUser(id);
    }


}
