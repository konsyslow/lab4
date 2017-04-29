package main.model.dao;

import main.model.pojo.Publications;
import main.model.connection.ManagementSystem;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 19.04.2017.
 */
public class PublicationsDaoImpl implements PublicationsDao {
    static{
        PropertyConfigurator.configure("C:\\Users\\admin\\Documents\\lab3_Suslov_KV\\lab3\\lo4j.properties");
    }

    private Connection connection;
    //private ConnectionPool connectionPool;

    public static final String SELECT_ALL_PUBLICATIONS = "SELECT * FROM PUBLICATIONS WHERE user_id IN " +
            "(SELECT id FROM users WHERE isblocked = 0)";
    public static final String SELECT_PUBLICATIONS = "SELECT * FROM PUBLICATIONS WHERE user_id = ?";
    public static final String INSERT_PUBLICATIONS = "INSERT INTO PUBLICATIONS (user_id, name, genre, text) VALUES (?,?,?,?)";
    public static final String UPDATE_PUBLICATIONS = "UPDATE PUBLICATIONS SET user_id=?, name=?, genre=?, text=? WHERE id=?";
    public static final String DELETE_PUBLICATION = "DELETE FROM PUBLICATIONS WHERE id=?";
    public static final String GET_BY_ID = "SELECT * FROM PUBLICATIONS where id = ?";

    public PreparedStatement getPrepareStatement(String sql) {
        connection = ManagementSystem.getCon();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
        } catch (SQLException e) {
            Logger.getLogger(Exception.class.getName()).log(Level.ERROR, "Catch SQLException", e);
            e.printStackTrace();
        }

        return ps;
    }

    public void closePrepareStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
                connection.close();
            } catch (SQLException e) {
                Logger.getLogger(Exception.class.getName()).log(Level.ERROR, "Catch SQLException", e);
            }
        }
    }

    public List<Publications> getAll() {
        List<Publications> list = new ArrayList<Publications>();
        PreparedStatement preparedStatement = getPrepareStatement(SELECT_ALL_PUBLICATIONS);
        try {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Publications publication = new Publications(rs.getInt(1), rs.getInt(2),
                        rs.getString(3), rs.getString(4), rs.getString(5) );
                list.add(publication);
            }
        } catch (SQLException e) {
            Logger.getLogger(Exception.class.getName()).log(Level.ERROR, "Catch SQLException", e);
        } finally {
            closePrepareStatement(preparedStatement);
        }

        return list;
    }

    public List<Publications> getUsersPublications(Integer userId){
        List<Publications> list = new ArrayList<Publications>();
        PreparedStatement preparedStatement = getPrepareStatement(SELECT_PUBLICATIONS);
        try {
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Publications publication = new Publications(rs.getInt(1), rs.getInt(2),
                        rs.getString(3), rs.getString(4), rs.getString(5) );
                list.add(publication);
            }
        } catch (SQLException e) {
            Logger.getLogger(Exception.class.getName()).log(Level.ERROR, "Catch SQLException", e);
        } finally {
            closePrepareStatement(preparedStatement);
        }

        return list;
    }

    public void insertPublication(Publications publication) {
        PreparedStatement preparedStatement = getPrepareStatement(INSERT_PUBLICATIONS);
        try {
            preparedStatement.setLong(1, publication.getId());
            preparedStatement.setLong(2, publication.getUser_id());
            preparedStatement.setString(3, publication.getName());
            preparedStatement.setString(4, publication.getGenre());
            preparedStatement.setString(5, publication.getText());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(Exception.class.getName()).log(Level.ERROR, "Catch SQLException", e);
        } finally {
            closePrepareStatement(preparedStatement);
        }
    }

    public void insertPublication(long user_id, String name, String genre, String text) {
        PreparedStatement preparedStatement = getPrepareStatement(INSERT_PUBLICATIONS);
        try {
            preparedStatement.setLong(1, user_id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, genre);
            preparedStatement.setString(4, text);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(Exception.class.getName()).log(Level.ERROR, "Catch SQLException", e);
        } finally {
            closePrepareStatement(preparedStatement);
        }
    }

    public void updatePublication(Publications publication){
        PreparedStatement preparedStatement = getPrepareStatement(UPDATE_PUBLICATIONS);
        try {
            preparedStatement.setLong(1, publication.getUser_id());
            preparedStatement.setString(2, publication.getName());
            preparedStatement.setString(3, publication.getGenre());
            preparedStatement.setString(4, publication.getText());
            preparedStatement.setLong(5, publication.getId());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            Logger.getLogger(Exception.class.getName()).log(Level.ERROR, "Catch SQLException", e);
        }
        finally {
            closePrepareStatement(preparedStatement);
        }
    }

    public void deletePublication(Integer id) {
        PreparedStatement preparedStatement = getPrepareStatement(DELETE_PUBLICATION);
        try {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e){
            Logger.getLogger(Exception.class.getName()).log(Level.ERROR, "Catch SQLException", e);
        }finally {
            closePrepareStatement(preparedStatement);
        }
    }

    public Publications getById(Integer id) {
        PreparedStatement preparedStatement = getPrepareStatement(GET_BY_ID);
        try {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Publications publication = new Publications(rs.getInt("id"), rs.getInt("user_id"),
                        rs.getString("name"),rs.getString("genre"), rs.getString("text"));
                return publication;
            }
        } catch (SQLException e) {
             Logger.getLogger(Exception.class.getName()).log(Level.ERROR, "Catch SQLException", e);
        } finally {
            closePrepareStatement(preparedStatement);
        }
        return null;
    }


}
