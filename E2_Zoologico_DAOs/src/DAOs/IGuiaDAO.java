/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs;

import dominio.Guia;
import java.util.List;

/**
 *
 * @author MoonA
 */
public interface IGuiaDAO {
    /**
     * Método que permite consultar todas las quejas de la BD
     * @return 
     */
    public List<Guia> consultarTodo();
}
