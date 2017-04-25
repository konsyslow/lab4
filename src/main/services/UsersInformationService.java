package main.services;
import java.util.List;

import main.model.connection.ManagementSystem;
import main.model.dao.UsersInformationDao;
import main.model.dao.UsersInformationDaoImpl;
import main.model.pojo.UsersInformation;
/**
 * Created by admin on 19.04.2017.
 */
public class UsersInformationService implements UsersInformationInterface {

    //ManagementSystem managementSystem = new ManagementSystem();
    public static UsersInformationDao usersInformationDao = new UsersInformationDaoImpl();

    public  List<UsersInformation> getAll(){
        return usersInformationDao.getAll();
    }

    public UsersInformation get(Integer id) {
        return usersInformationDao.get(id);
    }

    public void delete(Integer id) {
        usersInformationDao.deleteUsersInformation(id);
    }

//    public UsersInformation create() {
//        return usersInformationDao.create();
//    }

    public void insert(String firtsName, String secondName, String lastName){
        usersInformationDao.insertUsersInformation( firtsName,  secondName,  lastName);
    }

    public void save(Integer id, String firtsName, String secondName, String lastName) {
        UsersInformation usersInformation = new UsersInformation(id, firtsName,secondName, lastName);
        usersInformationDao.updateUsersInformation(usersInformation);
    }

}
