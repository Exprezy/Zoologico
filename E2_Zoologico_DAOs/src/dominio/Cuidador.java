package dominio;

public class Cuidador {
    private long idCuidador, idEmpleado;

    public Cuidador() {
    }

    public Cuidador(long idCuidador, long idEmpleado) {
        this.idCuidador = idCuidador;
        this.idEmpleado = idEmpleado;
    }

    public long getIdCuidador() {
        return idCuidador;
    }

    public void setIdCuidador(long idCuidador) {
        this.idCuidador = idCuidador;
    }

    public long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    
}
