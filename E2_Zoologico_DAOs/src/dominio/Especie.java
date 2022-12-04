package dominio;

public class Especie {
    private long idEspecie, idZona;
    private String nombreEspanol, nombreCientifico, descripcion;
    
    public Especie() {
    }

    public Especie(long idEspecie, long idZona, String nombreEspanol, String nombreCientifico, String descripcion) {
        this.idEspecie = idEspecie;
        this.idZona = idZona;
        this.nombreEspanol = nombreEspanol;
        this.nombreCientifico = nombreCientifico;
        this.descripcion = descripcion;
    }

    public long getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(long idEspecie) {
        this.idEspecie = idEspecie;
    }

    public long getIdZona() {
        return idZona;
    }

    public void setIdZona(long idZona) {
        this.idZona = idZona;
    }

    public String getNombreEspanol() {
        return nombreEspanol;
    }

    public void setNombreEspanol(String nombreEspanol) {
        this.nombreEspanol = nombreEspanol;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
