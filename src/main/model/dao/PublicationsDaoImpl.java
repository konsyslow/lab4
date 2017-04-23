package main.model.dao;

import main.model.pojo.Publications;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 19.04.2017.
 */
public class PublicationsDaoImpl implements PublicationsDao {

    private Connection connection;
    //private ConnectionPool connectionPool;

    public static final String SELECT_ALL_PUBLICATIONS = "SELECT * FROM PUBLICATIONS";
    public static final String INSERT_PUBLICATIONS = "INSERT INTO PUBLICATIONS (id, user_id, name, genre) VALUES (?,?,?,?)";
    public static final String UPDATE_PUBLICATIONS = "UPDATE PUBLICATIONS SET user_id=? name=? genre=? WHERE id=?";
    public static final String DELETE_PUBLICATION = "DELETE FROM PUBLICATIONS WHERE id=?";

    public PublicationsDaoImpl(Connection connection){//, ConnectionPool connectionPool) {
        this.connection = connection;
        //this.connectionPool = connectionPool;
    }

    public void returnConnectionInPool() {
        //connectionPool.returnConnection(connection);
    }

    public PreparedStatement getPrepareStatement(String sql) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ps;
    }

    public void closePrepareStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Publications> getAll() {
        List<Publications> list = new ArrayList<Publications>();
        PreparedStatement preparedStatement = getPrepareStatement(SELECT_ALL_PUBLICATIONS);
        try {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Publications publication = new Publications();
                publication.setId(rs.getInt(1));
                publication.setUser_id(rs.getInt(2));
                publication.setName(rs.getString(3));
                publication.setGenre(rs.getString(4));
                list.add(publication);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
            preparedStatement.executeUpdate();
            closePrepareStatement(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePublication(Publications publication){
        PreparedStatement preparedStatement = getPrepareStatement(UPDATE_PUBLICATIONS);
        try {
            preparedStatement.setLong(1, publication.getUser_id());
            preparedStatement.setString(2, publication.getName());
            preparedStatement.setString(3, publication.getGenre());
            preparedStatement.setLong(4, publication.getId());
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            closePrepareStatement(preparedStatement);
        }
    }

    public void deletePublication(Publications publication) {
        PreparedStatement preparedStatement = getPrepareStatement(DELETE_PUBLICATION);
        try {
            preparedStatement.setLong(1, publication.getId());
            preparedStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            closePrepareStatement(preparedStatement);
        }
    }
}
