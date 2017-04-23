package main.services;
import java.util.List;
import main.model.pojo.UsersInformation;

/**
 * Created by admin on 19.04.2017.
 */
public interface UsersInformationInterface {
    public List<UsersInformation> getAll();
    public UsersInformation get(Integer id);
    public void delete(Integer id);
    //public UsersInformation create();
    public void insert(String firtsName, String secondName, String lastName);
    public void  save(Integer id, String firtsName, String secondName, String lastName);
}
