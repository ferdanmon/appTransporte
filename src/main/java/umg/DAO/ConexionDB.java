package umg.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException; 
//para capturar errores

public class ConexionDB {
    private static final String URL =
        "jdbc:mysql://localhost:3306/db_paqueteria"
        + "?useSSL=false"
        + "&allowPublicKeyRetrieval=true"
        + "&serverTimezone=America/Guatemala";
    
    private static final String USER = "root";
    private static final String PASS = "Mysql11const";
    
    public static Connection abrir() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}

//Si hago otra conexion con otro nombre de base de dtos en SQL solo cambiamos el nombre donde dice db_paqueteria
//Donde dice user es nuestro usuario que si tambien en Mysql es root    
