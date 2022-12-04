package dominio;

public class HabitatContinente {
    private long idHabitatContinente, idHabitat, idContinente;

    public HabitatContinente() {
    }

    public HabitatContinente(long idHabitatContinente, long idHabitat, long idContinente) {
        this.idHabitatContinente = idHabitatContinente;
        this.idHabitat = idHabitat;
        this.idContinente = idContinente;
    }

    public long getIdHabitatContinente() {
        return idHabitatContinente;
    }

    public void setIdHabitatContinente(long idHabitatContinente) {
        this.idHabitatContinente = idHabitatContinente;
    }

    public long getIdHabitat() {
        return idHabitat;
    }

    public void setIdHabitat(long idHabitat) {
        this.idHabitat = idHabitat;
    }

    public long getIdContinente() {
        return idContinente;
    }

    public void setIdContinente(long idContinente) {
        this.idContinente = idContinente;
    }
    
}
