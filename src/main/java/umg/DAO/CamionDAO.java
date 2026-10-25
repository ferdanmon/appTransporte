package umg.DAO;
import umg.modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

public class CamionDAO {
    //metoo para guardar
    public void insertar (Camion camion) throws SQLException{
        String sql= "INSERT INTO camion (NoPlaca, Modelo, Tipo, Potencia) VALUES(?,?,?,?)";
        
        try (Connection cn= ConexionDB.abrir();
                PreparedStatement ps= cn.prepareStatement(sql)){
                //asignar el valor al parametro correspondiente 
                ps.setString(1, camion.getNoPlaca());
                ps.setString(2, camion.getModelo());
                ps.setString(3, camion.getTipo());
                ps.setDouble(4, camion.getPotencia());
                int filas = ps.executeUpdate();
                if (filas ==0){
                    throw new SQLException("No se almaceno ningun registro.");
                }
        }
    }
    
    //metodo para actualizar 
    public void actualizar (Camion camion) throws SQLException{
        String sql= "UPDATE camion SET NoPlaca = ?, Modelo = ?, Tipo = ?, Potencia = ? WHERE idCamion = ?";
        
        try (Connection cn= ConexionDB.abrir();
                PreparedStatement ps= cn.prepareStatement(sql)){
                //asignar el valor al parametro correspondiente 
                ps.setString(1, camion.getNoPlaca());
                ps.setString(2, camion.getModelo());
                ps.setString(3, camion.getTipo());
                ps.setDouble(4, camion.getPotencia());
                ps.setInt(5, camion.getIdCamion());
                int filas = ps.executeUpdate();
                if (filas ==0){
                    throw new SQLException("No se pudo actualizar ningun registro.");
                }
        }
    }
    
    //metodo para listar
    public List<Camion> listar() throws SQLException{
        List <Camion> lista = new ArrayList<>();
        String sql = "SELECT idCamion, NoPlaca, Modelo, Tipo, Potencia FROM camion";
        
        try (Connection cn= ConexionDB.abrir();
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()){
            
            while(rs.next()){
                
                Camion camion= new Camion();
                camion.setIdCamion(rs.getInt("idCamion"));
                camion.setNoPlaca(rs.getString("NoPlaca"));
                camion.setModelo(rs.getString("Modelo"));
                camion.setTipo(rs.getString("Tipo"));
                camion.setPotencia(rs.getInt("Potencia"));
                
                lista.add(camion);
            }
        }
        
            return lista; 
            
    }
    
    //metodo eliminar 
    public void eliminar (int id) throws SQLException{
    String sql= "DELETE FROM camion WHERE idCamion = ?";
    
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
