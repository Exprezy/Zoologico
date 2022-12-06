/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOs;

import dominio.Queja;
import java.util.List;

/**
 *
 * @author MoonA
 */
public interface IQuejaDAO {
    
    /**
     * Permite agregar datos a la BD
     */
    public int agregar(Queja queja);
    
    /**
     * Método que permite consultar todas las quejas de la BD
     * @return 
     */
    public List<Queja> consultarTodo();
    
  
}
