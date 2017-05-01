package main.services;

import main.model.connection.ManagementSystem;
import main.model.dao.PublicationsDao;
import main.model.dao.PublicationsDaoImpl;
import main.model.pojo.Publications;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 24.04.2017.
 */
@Service
public class PublicationsService implements PublicationsServiceInterface {
    private PublicationsDao publicationsDao;

    public PublicationsDao getPublicationsDao() {
        return publicationsDao;
    }

    public void setPublicationsDao(PublicationsDao publicationsDao) {
        this.publicationsDao = publicationsDao;
    }

    public List<Publications> getAll() {

        return publicationsDao.getAll();
    }

    public Publications get(Integer id) {

        return publicationsDao.getById(id);
    }
    public void update(Publications publication){
        publicationsDao.updatePublication(publication);
    }

    public void delete(Integer id) {

        publicationsDao.deletePublication(id);
    }

    public void insert(Integer user_id, String name, String genre, String text) {
        publicationsDao.insertPublication(user_id, name, genre, text);
    }
    public List<Publications> getUsersPublications(Integer userId){
        return publicationsDao.getUsersPublications(userId);
    }
}
