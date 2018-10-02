package models;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author beto
 */
public class modelsConexion {

    private final String base = "storephonedoctor";
    private final String user = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost/" + base;
    private Connection con;
    static Statement st = null;
    static ResultSet rs;

    public Connection getConexion() {
        try {
            
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion Exitosa");

        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return con;

    }
}