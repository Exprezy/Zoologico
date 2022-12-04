package dominio;
import java.util.Date;


public class CuidadorEspecie {
    private long idCuidadorEspecie, idCuidador, idEspecie;
    private Date fechaInicio;

    public CuidadorEspecie() {
    }

    public CuidadorEspecie(long idCuidadorEspecie, long idCuidador, long idEspecie, Date fechaInicio) {
        this.idCuidadorEspecie = idCuidadorEspecie;
        this.idCuidador = idCuidador;
        this.idEspecie = idEspecie;
        this.fechaInicio = fechaInicio;
    }

    public long getIdCuidadorEspecie() {
        return idCuidadorEspecie;
    }

    public void setIdCuidadorEspecie(long idCuidadorEspecie) {
        this.idCuidadorEspecie = idCuidadorEspecie;
    }

    public long getIdCuidador() {
        return idCuidador;
    }

    public void setIdCuidador(long idCuidador) {
        this.idCuidador = idCuidador;
    }

    public long getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(long idEspecie) {
        this.idEspecie = idEspecie;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    
}
