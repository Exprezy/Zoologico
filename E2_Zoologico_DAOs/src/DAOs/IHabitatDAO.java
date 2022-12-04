/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs;

import Entidades.Habitat;
import java.util.List;

/**
 *
 * @author MoonA
 */
public interface IHabitatDAO {
    
    public void agregar(Habitat hab);
    
    public void actualizar(Habitat hab, long idContinente);
    
    public void eliminat(long id);
    
    public List<Habitat> consultarTodos();
    
    public Habitat consultar(long idHabitat);
}
