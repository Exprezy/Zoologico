package dominio;

public class HabitatEspecie {
    private long idHabitatEspecie, idHabitat, idEspecie;
    public HabitatEspecie() {
    }

    public HabitatEspecie(long idHabitatEspecie, long idHabitat, long idEspecie) {
        this.idHabitatEspecie = idHabitatEspecie;
        this.idHabitat = idHabitat;
        this.idEspecie = idEspecie;
    }

    public long getIdHabitatEspecie() {
        return idHabitatEspecie;
    }

    public void setIdHabitatEspecie(long idHabitatEspecie) {
        this.idHabitatEspecie = idHabitatEspecie;
    }

    public long getIdHabitat() {
        return idHabitat;
    }

    public void setIdHabitat(long idHabitat) {
        this.idHabitat = idHabitat;
    }

    public long getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(long idEspecie) {
        this.idEspecie = idEspecie;
    }
    
}
