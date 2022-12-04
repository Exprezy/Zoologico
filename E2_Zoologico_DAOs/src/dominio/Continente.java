package dominio;

public class Continente {
    private long idContinente;
    private String nombre;

    public Continente() {
    }

    public Continente(long idContinente, String nombre) {
        this.idContinente = idContinente;
        this.nombre = nombre;
    }

    public long getIdContinente() {
        return idContinente;
    }

    public void setIdContinente(long idContinente) {
        this.idContinente = idContinente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Continente{" + "idContinente=" + idContinente + ", nombre=" + nombre + '}';
    }
    
}
