/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import dominio.Guia;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author MoonA
 */
public class GuiaDAO implements DAOs.IGuiaDAO{

    IConexionDB conexion = new ConexionDB();

    public GuiaDAO(IConexionDB conexion) {
        this.conexion = conexion;
    }
    
    @Override
    public List<Guia> consultarTodo() {
        List<Guia> listaGuias = new LinkedList<>();
        Guia guia;
        try {
            Connection conexion = this.conexion.crearConexion();

            //Creamos un objeto que empaquetará el comando SQL que enviaremos a la BD
            Statement comando = conexion.createStatement();

            String codigoSQL = String.format("SELECT * FROM guia");

            ResultSet resultado = comando.executeQuery(codigoSQL);

            //Nos movemos dentro de los registros guardados uno a uno, devuelve false cuando 
            //se llega al final de los resultados
            while (resultado.next()) {
                Long idGuia = resultado.getLong("idguia");
                Long idEmpleado = resultado.getLong("empleado");
                guia = new Guia(idGuia, idEmpleado);
                listaGuias.add(guia);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            return listaGuias;
        }
    }
    
}
