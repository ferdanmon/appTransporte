package umg.DAO;
import umg.modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

public class CamioneroDAO {
    //metoo para guardar
    public void insertar (Camionero camionero) throws SQLException{
        String sql= "INSERT INTO camionero(Nombre, Telefono, Direccion, Salario, Poblacion) VALUES(?,?,?,?,?)";
        
        try (Connection cn= ConexionDB.abrir();
                PreparedStatement ps= cn.prepareStatement(sql)){
                //asignar el valor al parametro correspondiente 
                ps.setString(1, camionero.getNombre());
                ps.setString(2, camionero.getTelefono());
                ps.setString(3, camionero.getDireccion());
                ps.setDouble(4, camionero.getSalario());
                ps.setString(5, camionero.getPoblacion());
                int filas = ps.executeUpdate();
                if (filas ==0){
                    throw new SQLException("No se almaceno ningun registro.");
                }
        }
    }
    
    //metodo para actualizar 
    public void actualizar (Camionero camionero) throws SQLException{
        String sql= "UPDATE camionero SET Nombre = ?, Telefono = ?, Direccion = ?, Salario = ?, Poblacion = ? WHERE idCamionero = ?";
        
        try (Connection cn= ConexionDB.abrir();
                PreparedStatement ps= cn.prepareStatement(sql)){
                //asignar el valor al parametro correspondiente 
                ps.setString(1, camionero.getNombre());
                ps.setString(2, camionero.getTelefono());
                ps.setString(3, camionero.getDireccion());
                ps.setDouble(4, camionero.getSalario());
                ps.setString(5, camionero.getPoblacion());
                ps.setInt(6, camionero.getIdCamionero());
                int filas = ps.executeUpdate();
                if (filas ==0){
                    throw new SQLException("No se almaceno ningun registro.");
                }
        }
    }
    
    //metodo para listar
    public List<Camionero> listar() throws SQLException{
        List <Camionero> lista = new ArrayList<>();
        String sql = "SELECT idCamionero, Nombre, Telefono, Direccion, Salario, Poblacion FROM camionero";
        
        try (Connection cn= ConexionDB.abrir();
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()){
            
            while(rs.next()){
                
                Camionero camionero= new Camionero();
                camionero.setIdCamionero(rs.getInt("idCamionero"));
                camionero.setNombre(rs.getString("Nombre"));
                camionero.setTelefono(rs.getString("Telefono"));
                camionero.setDireccion(rs.getString("Direccion"));
                camionero.setSalario(rs.getDouble("Salario"));
                camionero.setPoblacion(rs.getString("Poblacion"));
                
                lista.add(camionero);
            }
        }
        
            return lista; 
            
    }
    
    //metodo eliminar 
    public void eliminar (int id) throws SQLException{
    String sql= "DELETE FROM camionero WHERE idCamionero = ?";
    
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
