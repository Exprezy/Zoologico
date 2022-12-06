/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author MoonA
 */
public class Queja {

    /**
     * Atributos de la clase queja
     */
    private long idQueja;
    private String texto, nombre;
    public long telefono;

    /**
     * Constructor por omisión
     */
    public Queja() {
    }

    /**
     * Constructor que inicializa los atributos de la clase
     *
     * @param idQueja
     * @param texto
     */
    public Queja(long idQueja, String texto) {
        this.idQueja = idQueja;
        this.texto = texto;
    }

    public long getIdQueja() {
        return idQueja;
    }

    public void setIdQueja(long idQueja) {
        this.idQueja = idQueja;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Queja{" + "idQueja=" + idQueja + ", texto=" + texto + '}';
    }

}
