package models;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Norberto
 */
public class ModelAgenda {

    private Connection conexion;
    private Statement st;
    private ResultSet rs;

    private String nombre;
    private String email;
    private Integer id;

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public Statement getSt() {
        return st;
    }

    public void setSt(Statement st) {
        this.st = st;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void cambiarDatos() {
        try {
            this.setId(rs.getInt("id_contacto"));
            this.setNombre(rs.getString("nombre"));
            this.setEmail(rs.getString("email"));
        } catch (SQLException e) {
            System.out.println("Error 01: \n" + e.getMessage());
        }
    }

    /**
     * Modelo que permite hacer la consulta a la base de datos
     *
     *
     */
    public void consultaSql() {
        try {
            conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda_mvc", "user_mvc", "pass_mvc.2018");
            st = conexion.createStatement();
            rs = st.executeQuery("SELECT * FROM contactos;");
            rs.next();
            id = rs.getInt("id_contacto");
            nombre = rs.getString("nombre");
            email = rs.getString("email");
            this.setId(id);
            this.setEmail(email);
            this.setNombre(nombre);

        } catch (SQLException sql) {
            System.out.println("Error 02:\n " + sql.getMessage());
        }

    }

    /**
     * Modelo que permite obtener el primer registro de la tabla contactos
     *
     */
    public void primerRegistro() {
        try {
            rs.first();
            cambiarDatos();
        } catch (SQLException sql) {
            System.out.println("Error 04:\n " + sql.getMessage());
        }
    }

    /**
     * Modelo que permite obtener el registro registro de la tabla contactos
     *
     */
    public void anteriorRegistro() {
        try {
            if (!rs.isFirst()) {
                rs.previous();
                cambiarDatos();
            }
        } catch (SQLException sql) {
            System.out.println("Error 05:\n " + sql.getMessage());
        }
    }

    /**
     * Modelo que permite obtener el siguiente registro de la tabla contactos
     *
     */
    public void siguienteRegistro() {
        try {
            if (!rs.isLast()) {
                rs.next();
                cambiarDatos();
            }
        } catch (SQLException sql) {
            System.out.println("Error 06:\n " + sql.getMessage());
        }
    }

    /**
     * Modelo que permite obtener el ultimo registro de la tabla contactos
     *
     */
    public void ultimoRegistro() {
        try {
            rs.last();
            cambiarDatos();
        } catch (SQLException sql) {
            System.out.println("Error 07:\n " + sql.getMessage());
        }
    }

}
