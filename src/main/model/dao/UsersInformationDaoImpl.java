package main.model.dao;

import main.model.pojo.UsersInformation;
import main.model.connection.ManagementSystem;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 18.04.2017.
 */
public class UsersInformationDaoImpl implements UsersInformationDao {
    static{
        PropertyConfigurator.configure("C:\\Users\\admin\\Documents\\lab3_Suslov_KV\\lab3\\lo4j.properties");
    }

    //private Connection connection;
   // private ConnectionPool connectionPool;

    public static final String SELECT_ALL_USERSINFORMATION = "SELECT * FROM USERS_INFORMATION";
    public static final String INSERT_USERSINFORMATION = "INSERT INTO USERS_INFORMATION" +
            "(firstname, secondname, lastname) VALUES(?,?, ?)";
    public static final String UPDATE_USERSINFORMATION = "UPDATE USERS_INFORMATION SET " +
            "firstname=?, secondname=?, lastname=? WHERE id=?";
    public static final String DELETE_USERSINFORMATION = "DELETE FROM USERS_INFORMATION WHERE id=?";
    public static final String GET_BY_ID = "SELECT * FROM USERS_INFORMATION where id = ?";

//    public UsersInformationDaoImpl(Connection connection){//}, ConnectionPool connectionPool) {
//        this.connection = connection;
//        //this.connectionPool = connectionPool;
//    }

    public PreparedStatement getPrepareStatement(String sql) {
        Connection connection = ManagementSystem.getCon();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
        } catch (SQLException e) {
            Logger.getLogger(Exception.class.getName()).log(Level.ERROR, "Catch SQLException", e);
        }

        return ps;
    }

    public void closePrepareStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
               Logger.getLogger(Exception.class.getName()).log(Level.ERROR, "Catch SQLException", e);
            }
        }
    }

    public List<UsersInformation> getAll() {
        List<UsersInformation> list = new ArrayList<UsersInformation>();
        PreparedStatement preparedStatement = getPrepareStatement(SELECT_ALL_USERSINFORMATION);
        try {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                UsersInformation usersInformation = new UsersInformation(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4));
//                usersInformation.setId(rs.getInt(1));
//                usersInformation.setFirstName(rs.getString(2));
//                usersInformation.setSecondName(rs.getString(3));
//                usersInformation.setLastName(rs.getString(4));
                list.add(usersInformation);
            }
        } catch (SQLException e) {
            Logger.getLogger(Exception.class.getName()).log(Level.ERROR, "Catch SQLException", e);
        } finally {
            closePrepareStatement(preparedStatement);
        }

        return list;
    }

    public void insertUsersInformation(UsersInformation usersInformation) {
        PreparedStatement preparedStatement = getPrepareStatement(INSERT_USERSINFORMATION);
        try {
            //preparedStatement.setLong(1, usersInformation.getId());
            preparedStatement.setString(1, usersInformation.getFirstName());
            preparedStatement.setString(2, usersInformation.getSecondName());
            preparedStatement.setString(3, usersInformation.getLastName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
           Logger.getLogger(Exception.class.getName()).log(Level.ERROR, "Catch SQLException", e);
        }finally {
            closePrepareStatement(preparedStatement);
        }
    }

    public void insertUsersInformation(String firstName, String secondName, String lastName) {
        PreparedStatement preparedStatement = getPrepareStatement(INSERT_USERSINFORMATION);
        try {
            //preparedStatement.setLong(1, usersInformation.getId());
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, secondName);
            preparedStatement.setString(3, lastName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(Exception.class.getName()).log(Level.ERROR, "Catch SQLException", e);
        }finally {
            closePrepareStatement(preparedStatement);
        }
    }

    public void updateUsersInformation(UsersInformation usersInformation){
        PreparedStatement preparedStatement = getPrepareStatement(UPDATE_USERSINFORMATION);
        try {
            preparedStatement.setString(1, usersInformation.getFirstName());
            preparedStatement.setString(2, usersInformation.getSecondName());
            preparedStatement.setString(3, usersInformation.getLastName());
            preparedStatement.setLong(4, usersInformation.getId());
            preparedStatement.execute();
        }catch (SQLException e){
            Logger.getLogger(Exception.class.getName()).log(Level.ERROR, "Catch SQLException", e);
        }
        finally {
            closePrepareStatement(preparedStatement);
        }
    }

    public void deleteUsersInformation(Integer id) {
        PreparedStatement preparedStatement = getPrepareStatement(DELETE_USERSINFORMATION);
        try {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e){
            Logger.getLogger(Exception.class.getName()).log(Level.ERROR, "Catch SQLException", e);
        }finally {
            closePrepareStatement(preparedStatement);
        }
    }

    public UsersInformation get(Integer id) {
        PreparedStatement preparedStatement = getPrepareStatement(GET_BY_ID);
        try {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                UsersInformation usersInformation = new UsersInformation(rs.getLong("id"), rs.getString("firstname"),
                        rs.getString("secondname"),rs.getString("lastname"));
                return usersInformation;
            }
        } catch (SQLException e) {
           Logger.getLogger(Exception.class.getName()).log(Level.ERROR, "Catch SQLException", e);
        }finally {
            closePrepareStatement(preparedStatement);
        }
        return null;
    }

    public UsersInformation create() {
        return new UsersInformation(0, "", "", "");
    }
}

