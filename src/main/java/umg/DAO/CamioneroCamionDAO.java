package umg.DAO;
import umg.modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

public class CamioneroCamionDAO {
    public void insertar (CamioneroCamion cc) throws SQLException{
        String sql= "INSERT INTO camionerocamion(idCamionero, idCamion) VALUES(?,?)";
        
        try (Connection cn= ConexionDB.abrir();
                PreparedStatement ps= cn.prepareStatement(sql)){
                //asignar el valor al parametro correspondiente 
                ps.setInt(1, cc.getIdCamionero());
                ps.setInt(2, cc.getIdCamion());
                
                
                int filas = ps.executeUpdate();
                if (filas ==0){
                    throw new SQLException("No se pudo almacenar ningun registro.");
                }
        }
    }
    
    //metodo para actualizar 
    public void actualizar (CamioneroCamion cc) throws SQLException{
        String sql= "UPDATE camionerocamion SET idCamionero = ?, idCamion = ? WHERE idCamioneroCamion = ?";
        
        try (Connection cn= ConexionDB.abrir();
                PreparedStatement ps= cn.prepareStatement(sql)){
                //asignar el valor al parametro correspondiente 
                ps.setInt(1, cc.getIdCamionero());
                ps.setInt(2, cc.getIdCamion());
                ps.setInt(3, cc.getIdCamioneroCamion());
                int filas = ps.executeUpdate();
                if (filas ==0){
                    throw new SQLException("No se pudo actualizar ningun registro.");
                }
        }
    }
    
    //metodo para listar
    public List<CamioneroCamion> listar() throws SQLException{
        List <CamioneroCamion> lista = new ArrayList<>();
        String sql = "SELECT idCamioneroCamion, idCamionero, idCamion FROM camionerocamion";
        
        try (Connection cn= ConexionDB.abrir();
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()){
            
            while (rs.next()) {
                CamioneroCamion cc = new CamioneroCamion();
                cc.setIdCamioneroCamion(rs.getInt("idCamioneroCamion"));
                cc.setIdCamionero(rs.getInt("idCamionero"));
                cc.setIdCamion(rs.getInt("idCamion"));
                
                lista.add(cc);
            }
        }
        
            return lista; 
            
    }
    
    //metodo eliminar 
    public void eliminar (int id) throws SQLException{
    String sql= "DELETE FROM camionerocamion WHERE idCamioneroCamion = ?";
    
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
