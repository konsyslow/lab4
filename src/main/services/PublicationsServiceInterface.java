package main.services;

import main.model.pojo.Publications;

import java.util.List;

/**
 * Created by admin on 24.04.2017.
 */
public interface PublicationsServiceInterface {
    public List<Publications> getAll();
    public Publications get(Integer id);
    public void delete(Integer id);
    public void update(Publications publication);
   // public UsersInformation create();
    public void insert(Integer user_id, String name, String genre, String text);
    List<Publications> getUsersPublications(Integer userId);
}
