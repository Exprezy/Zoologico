package dominio;

public class Zona {
    private long idZona;
    private String nombreZona;
    private double extension;

    public Zona() {
    }

    public Zona(long idZona, String nombreZona, double extension) {
        this.idZona = idZona;
        this.nombreZona = nombreZona;
        this.extension = extension;
    }

    public long getIdZona() {
        return idZona;
    }

    public void setIdZona(long idZona) {
        this.idZona = idZona;
    }

    public String getNombreZona() {
        return nombreZona;
    }

    public void setNombreZona(String nombreZona) {
        this.nombreZona = nombreZona;
    }

    public double getExtension() {
        return extension;
    }

    public void setExtension(double extension) {
        this.extension = extension;
    }
    
}
