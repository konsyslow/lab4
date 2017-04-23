package main.model.dao;

import main.model.pojo.Publications;

import java.util.List;

/**
 * Created by admin on 19.04.2017.
 */
public interface PublicationsDao {
    void insertPublication(Publications publication);
    List<Publications> getAll();
    void updatePublication(Publications publication);
    void deletePublication(Publications publication);
}
