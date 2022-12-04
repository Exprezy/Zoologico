/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs;

import dominio.Habitat;
import dominio.HabitatContinente;
import java.util.List;

/**
 *
 * @author MoonA
 */
public interface IHabitatContinenteDAO {
    
    /**
     * Método que permite agregar
     * @param idHabitatContinente
     * @param idHabitat
     * @param idContinente 
     */
    public void agregar(long idHabitatContinente, Habitat hab, long idContinente);
    
    /**
     * Método que permite consultar todos los registros
     */
    public List<HabitatContinente> consultarTodo();
    
    /**
     * Método que permite consultar un habitat
     * @param id 
     */
    public HabitatContinente consultarHabitatContinente(long id);
}
