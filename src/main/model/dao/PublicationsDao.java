package main.model.dao;

import main.model.pojo.Publications;

import java.util.List;

/**
 * Created by admin on 19.04.2017.
 */
public interface PublicationsDao {
    //void insertPublication(Publications publication);
    List<Publications> getAll();
    List<Publications> getUsersPublications(Integer userId);
    void updatePublication(Publications publication);
    void deletePublication(Integer id);
    void insertPublication(long user_id, String name, String genre, String text);
    Publications getById(Integer id);
}
