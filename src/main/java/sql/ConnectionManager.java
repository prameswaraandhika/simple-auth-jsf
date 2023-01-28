package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andhika Prameswara <prameswaara@gmail.com>
 */
public class ConnectionManager {

    private final String USER = "postgres";
    private final String PASSWORD = "";
    private final String DATABASE = "";

    public Connection getConnection() {
        String driver = "org.postgresql.Driver";
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + DATABASE, USER, PASSWORD);
            System.out.println("Database connection succed!");
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.WARNING, null, e);
            System.out.println("Database connection failed!");
        }
        return con;
    }

}
