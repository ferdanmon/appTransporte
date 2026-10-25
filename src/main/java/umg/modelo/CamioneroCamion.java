package umg.modelo;


public class CamioneroCamion {
    private int idCamioneroCamion;
    private int idCamionero;
    private int idCamion;

    public CamioneroCamion(int idCamioneroCamion, int idCamionero, int idCamion) {
        this.idCamioneroCamion = idCamioneroCamion;
        this.idCamionero = idCamionero;
        this.idCamion = idCamion;
    }

    public CamioneroCamion() {
    }
    
    
    public int getIdCamioneroCamion() {
        return idCamioneroCamion;
    }

    public void setIdCamioneroCamion(int idCamioneroCamion) {
        this.idCamioneroCamion = idCamioneroCamion;
    }

    public int getIdCamionero() {
        return idCamionero;
    }

    public void setIdCamionero(int idCamionero) {
        this.idCamionero = idCamionero;
    }

    public int getIdCamion() {
        return idCamion;
    }

    public void setIdCamion(int idCamion) {
        this.idCamion = idCamion;
    }

    @Override
    public String toString() {
        return "CamioneroCamion{" + "idCamioneroCamion=" + idCamioneroCamion + ", idCamionero=" + idCamionero + ", idCamion=" + idCamion + '}';
    }
    
    
}
