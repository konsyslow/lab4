package main.model.dao;

import main.model.pojo.UsersInformation;

import java.util.List;

/**
 * Created by admin on 18.04.2017.
 */
public interface UsersInformationDao {
//    public Connection connection;
//    private ConnectionPool connectionPool;
    void insertUsersInformation(UsersInformation usersInformation);
    void insertUsersInformation(String firstName, String secondName, String lastName);
    List<UsersInformation> getAll();
    void updateUsersInformation(UsersInformation usersInformation);
    void deleteUsersInformation(Integer id);
    public UsersInformation get(Integer id);
    public UsersInformation create();
}
