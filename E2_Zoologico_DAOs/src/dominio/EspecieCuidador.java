package dominio;

public class EspecieCuidador {
    private long id, idCuidador, idEspecie;
    private boolean experto;

    public EspecieCuidador() {
    }

    public EspecieCuidador(long id, long idCuidador, long idEspecie, boolean experto) {
        this.id = id;
        this.idCuidador = idCuidador;
        this.idEspecie = idEspecie;
        this.experto = experto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public boolean isExperto() {
        return experto;
    }

    public void setExperto(boolean experto) {
        this.experto = experto;
    }
}
