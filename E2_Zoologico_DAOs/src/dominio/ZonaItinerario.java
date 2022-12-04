package dominio;

public class ZonaItinerario {
    private long idZonaItinerario, idZona, idItinerario;

    public ZonaItinerario() {
    }

    public ZonaItinerario(long idZonaItinerario, long idZona, long idItinerario) {
        this.idZonaItinerario = idZonaItinerario;
        this.idZona = idZona;
        this.idItinerario = idItinerario;
    }

    public long getIdZonaItinerario() {
        return idZonaItinerario;
    }

    public void setIdZonaItinerario(long idZonaItinerario) {
        this.idZonaItinerario = idZonaItinerario;
    }

    public long getIdZona() {
        return idZona;
    }

    public void setIdZona(long idZona) {
        this.idZona = idZona;
    }

    public long getIdItinerario() {
        return idItinerario;
    }

    public void setIdItinerario(long idItinerario) {
        this.idItinerario = idItinerario;
    }
    
}
