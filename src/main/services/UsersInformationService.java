package main.services;
import java.util.List;

import main.model.connection.ManagementSystem;
import main.model.dao.UsersInformationDao;
import main.model.dao.UsersInformationDaoImpl;
import main.model.pojo.UsersInformation;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 19.04.2017.
 */
@Service
public class UsersInformationService implements UsersInformationInterface {

    //ManagementSystem managementSystem = new ManagementSystem();
    private  UsersInformationDao usersInformationDao;

    public UsersInformationDao getUsersInformationDao() {
        return usersInformationDao;
    }

    public void setUsersInformationDao(UsersInformationDao usersInformationDao) {
        this.usersInformationDao = usersInformationDao;
    }

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
