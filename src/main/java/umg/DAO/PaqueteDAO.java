package umg.DAO;
import umg.modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

public class PaqueteDAO {
    public void insertar(Paquete paquete) throws SQLException{
        //crear la instruccion de sql para realizar la operaciion a nivel de base de datos
        String sql= "INSERT INTO paquete (Descripcion, Destinatario, DireccionEnvio, idCamionero, idCiudad) VALUES (?, ?, ?, ?, ?)";
        try (Connection cn= ConexionDB.abrir();
                PreparedStatement ps= cn.prepareStatement(sql)){
                //asignar el valor al parametro correspondiente 
                ps.setString(1, paquete.getDescripcion());
                ps.setString(2, paquete.getDestinatario());
                ps.setString(3, paquete.getDireccionEnvio());
                ps.setInt(4, paquete.getIdCamionero());
                ps.setInt(5, paquete.getIdCiudad());
                int filas = ps.executeUpdate();
                if (filas ==0){
                    throw new SQLException("No se almaceno ningun registro.");
                }
        }
        
    }
    //metodos para actualizar datos
    //metodos para almacenar datos en la tabla ciudad de la base de datos db_paqueteria 
    public void actualizar (Paquete paquete) throws SQLException{
        //crear la instruccion de sql para realizar la operaciion a nivel de base de datos
        String sql= "UPDATE paquete SET Descripcion=?, Destinatario=?, DireccionEnvio=?, idCamionero=?, idCiudad=? WHERE idPaquete = ?";
        try (Connection cn= ConexionDB.abrir();
                PreparedStatement ps= cn.prepareStatement(sql)){
                //asignar el valor al parametro correspondiente 
                ps.setString(1, paquete.getDescripcion());
                ps.setString(2, paquete.getDestinatario());
                ps.setString(3, paquete.getDireccionEnvio());
                ps.setInt(4, paquete.getIdCamionero());
                ps.setInt(5, paquete.getIdCiudad());
                ps.setInt(6, paquete.getIdPaquete());
                int filas = ps.executeUpdate();
                if (filas ==0){
                    throw new SQLException("Error al actualizar los datoss.");
                }
        }
        
    }
    
    public List<Paquete> listar() throws SQLException{
        List <Paquete> lista = new ArrayList<>();
        String sql = "SELECT idPaquete, Descripcion, Destinatario, DireccionEnvio, idCamionero, idCiudad FROM paquete";
        
        try (Connection cn= ConexionDB.abrir();
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()){
            
            while(rs.next()){
                
                Paquete paquete= new Paquete();
                paquete.setIdPaquete(rs.getInt("idPaquete"));
                paquete.setDescripcion(rs.getString("Descripcion"));
                paquete.setDestinatario(rs.getString("Destinatario"));
                paquete.setDireccionEnvio(rs.getString("DireccionEnvio"));
                paquete.setIdCamionero(rs.getInt("idCamionero"));
                paquete.setIdCiudad(rs.getInt("idCiudad"));
                
                lista.add(paquete);
            }
        }
        
            return lista; 
            
    }
    
    //metodo eliminar 
    public void eliminar (int id) throws SQLException{
        //crear la instruccion de sql para realizar la operaciion a nivel de base de datos
        String sql= "DELETE FROM paquete WHERE idPaquete = ?";
        try (Connection cn= ConexionDB.abrir();
                PreparedStatement ps= cn.prepareStatement(sql)){
                //asignar el valor al parametro correspondiente 
                
                ps.setInt(1, id);
                int filas = ps.executeUpdate();
                if (filas ==0){
                    throw new SQLException("No se pudo eliminar el registro");
                }
        }
        
    } 
    
    
}
