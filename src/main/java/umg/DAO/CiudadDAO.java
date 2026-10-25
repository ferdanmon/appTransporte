package umg.DAO;
import umg.modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

public class CiudadDAO {
    //metodos para almacenar datos en la tabla ciudad de la base de datos db_paqueteria 
    public void insertar(Ciudad ciudad) throws SQLException{
        //crear la instruccion de sql para realizar la operaciion a nivel de base de datos
        String sql= "INSERT INTO ciudad(Nombre) VALUES (?)";
        try (Connection cn= ConexionDB.abrir();
                PreparedStatement ps= cn.prepareStatement(sql)){
                //asignar el valor al parametro correspondiente 
                ps.setString(1, ciudad.getNombre());
                int filas = ps.executeUpdate();
                if (filas ==0){
                    throw new SQLException("No se almaceno ningun registro.");
                }
        }
        
    }
    //metodos para actualizar datos
    //metodos para almacenar datos en la tabla ciudad de la base de datos db_paqueteria 
    public void actualizar (Ciudad ciudad) throws SQLException{
        //crear la instruccion de sql para realizar la operaciion a nivel de base de datos
        String sql= "UPDATE ciudad SET Nombre= ? WHERE idCiudad = ?";
        try (Connection cn= ConexionDB.abrir();
                PreparedStatement ps= cn.prepareStatement(sql)){
                //asignar el valor al parametro correspondiente 
                ps.setString(1, ciudad.getNombre());
                ps.setInt(2,ciudad.getIdCiudad());
                int filas = ps.executeUpdate();
                if (filas ==0){
                    throw new SQLException("No se pudo actualizar el registro.");
                }
        }
        
    }
    
    public List<Ciudad> listar() throws SQLException{
        List <Ciudad> lista = new ArrayList<>();
        String sql = "SELECT idCiudad,Nombre FROM ciudad";
        
        try (Connection cn= ConexionDB.abrir();
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()){
            
            while(rs.next()){
                
                Ciudad ciudad= new Ciudad();
                ciudad.setIdCiudad(rs.getInt("idCiudad"));
                ciudad.setNombre(rs.getString("Nombre"));
                
                lista.add(ciudad);
            }
        }
        
            return lista; 
            
    }
    
    //metodo eliminar 
    public void eliminar (int id) throws SQLException{
        //crear la instruccion de sql para realizar la operaciion a nivel de base de datos
        String sql= "DELETE FROM ciudad WHERE idCiudad = ?";
        try (Connection cn= ConexionDB.abrir();
                PreparedStatement ps= cn.prepareStatement(sql)){
                //asignar el valor al parametro correspondiente 
                
                ps.setInt(1, id);
                int filas = ps.executeUpdate();
                if (filas ==0){
                    throw new SQLException("No se pudo eliminar el registro.");
                }
        }
        
    }
    
}
