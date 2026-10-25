package umg.modelo;


public class Camion {
    private int idCamion;
    private String noPlaca;
    private String modelo;
    private String tipo;
    private int potencia; 

    public Camion(int idCamion, String noPlaca, String modelo, String tipo, int potencia) {
        this.idCamion = idCamion;
        this.noPlaca = noPlaca;
        this.modelo = modelo;
        this.tipo = tipo;
        this.potencia = potencia;
    }

    public Camion() {
    }

    public int getIdCamion() {
        return idCamion;
    }

    public void setIdCamion(int idCamion) {
        this.idCamion = idCamion;
    }

    public String getNoPlaca() {
        return noPlaca;
    }

    public void setNoPlaca(String noPlaca) {
        this.noPlaca = noPlaca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return "Camion{" + "idCamion=" + idCamion + ", noPlaca=" + noPlaca + ", modelo=" + modelo + ", tipo=" + tipo + ", potencia=" + potencia + '}';
    }
    
    
}
