package dominio;

public class Itinerario {
    private long idItinerario, idGuia;
    private int visitasMaximas, numeroZonas;
    private double longitud;
    private String duracionRecorrido, dias, horas;

    public Itinerario() {
    }

    public Itinerario(long idItinerario, long idGuia, int visitasMaximas, int numeroZonas, double longitud, String duracionRecorrido, String dias, String horas) {
        this.idItinerario = idItinerario;
        this.idGuia = idGuia;
        this.visitasMaximas = visitasMaximas;
        this.numeroZonas = numeroZonas;
        this.longitud = longitud;
        this.duracionRecorrido = duracionRecorrido;
        this.dias = dias;
        this.horas = horas;
    }

    public long getIdItinerario() {
        return idItinerario;
    }

    public void setIdItinerario(long idItinerario) {
        this.idItinerario = idItinerario;
    }

    public long getIdGuia() {
        return idGuia;
    }

    public void setIdGuia(long idGuia) {
        this.idGuia = idGuia;
    }

    public int getVisitasMaximas() {
        return visitasMaximas;
    }

    public void setVisitasMaximas(int visitasMaximas) {
        this.visitasMaximas = visitasMaximas;
    }

    public int getNumeroZonas() {
        return numeroZonas;
    }

    public void setNumeroZonas(int numeroZonas) {
        this.numeroZonas = numeroZonas;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getDuracionRecorrido() {
        return duracionRecorrido;
    }

    public void setDuracionRecorrido(String duracionRecorrido) {
        this.duracionRecorrido = duracionRecorrido;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }
    
    
    
}
