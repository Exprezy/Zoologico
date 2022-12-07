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
    private String nombre;
    private String telefono;
    private String texto;

    /**
     * Constructor por omisión
     */
    public Queja() {
    }

    /**
     * Constructor que inicializa los atributos de la clase
     *
     * @param nombre
     * @param telefono
     * @param idQueja
     * @param texto
     */
    public Queja(String nombre, String telefono, String texto) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.texto = texto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
        return "Queja{" + "idQueja=" + idQueja + ", nombre=" + nombre + ", telefono=" + telefono + ", texto=" + texto + '}';
    }

    

}