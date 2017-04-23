package main.services;

import main.model.pojo.Users;

import java.util.List;

/**
 * Created by admin on 20.04.2017.
 */
public interface UserServiceInterface {
    Users auth(String login, String password);
    public List<Users> getAll();
    public Users get(Integer id);
    public void delete(Integer id);
    //public UsersInformation create();
    public void insert(String login, String password);
}
