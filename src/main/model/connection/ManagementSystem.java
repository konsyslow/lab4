package main.model.connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Locale;

/**
 * Created by admin on 19.04.2017.
 */
public class ManagementSystem {
    private static Connection con;
    private static ManagementSystem instance;
    private static DataSource dataSource;

    public ManagementSystem() {
    }

    public static Connection getCon() {
        Locale.setDefault(Locale.ENGLISH);
            try {
                Context ctx = new InitialContext();
                dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/StudentsDS");
                con = dataSource.getConnection();
            } catch (NamingException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        return con;
    }
}