package dominio;

public class Habitat {
    private long idHabitat;
    private String nombre, clima, tipoVegetacion;

    public Habitat() {
    }

    public Habitat(long idHabitat, String nombre, String clima, String tipoVegetacion) {
        this.idHabitat = idHabitat;
        this.nombre = nombre;
        this.clima = clima;
        this.tipoVegetacion = tipoVegetacion;
    }

    public long getIdHabitat() {
        return idHabitat;
    }

    public void setIdHabitat(long idHabitat) {
        this.idHabitat = idHabitat;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getTipoVegetacion() {
        return tipoVegetacion;
    }

    public void setTipoVegetacion(String tipoVegetacion) {
        this.tipoVegetacion = tipoVegetacion;
    }
    
}
