package dominio;
public class Guia {
    private long idGuia, idEmpleado;

    public Guia() {
    }

    public Guia(long idGuia, long idEmpleado) {
        this.idGuia = idGuia;
        this.idEmpleado = idEmpleado;
    }
    

    public long getIdGuia() {
        return idGuia;
    }

    public void setIdGuia(long idGuia) {
        this.idGuia = idGuia;
    }

    public long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    
}
