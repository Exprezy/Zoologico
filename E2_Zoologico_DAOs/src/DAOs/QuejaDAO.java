/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import dominio.Queja;
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
public class QuejaDAO implements IQuejaDAO {

    IConexionDB conexion = new ConexionDB();

    public QuejaDAO(IConexionDB conexion) {
        this.conexion = conexion;
    }

    @Override
    public int agregar(Queja queja) {
        int registrosAfectados = 0;
        try {
            Connection conexion = this.conexion.crearConexion();

            //Creamos un objeto que empaquetará el comando SQL que enviaremos a la BD
            Statement comando = conexion.createStatement();

            String codigoSQL = String.format("INSERT INTO queja(texto) VALUES('%d')",
                    queja.getTexto());
            registrosAfectados = comando.executeUpdate(codigoSQL);
            conexion.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            return registrosAfectados;
        }
    }

    @Override
    public List<Queja> consultarTodo() {
        List<Queja> listaQuejas = new LinkedList<>();
        Queja queja;

        try {
            Connection conexion = this.conexion.crearConexion();

            //Creamos un objeto que empaquetará el comando SQL que enviaremos a la BD
            Statement comando = conexion.createStatement();

            String codigoSQL = String.format("SELECT * FROM queja");

            ResultSet resultado = comando.executeQuery(codigoSQL);

            //Nos movemos dentro de los registros guardados uno a uno, devuelve false cuando 
            //se llega al final de los resultados
            while (resultado.next()) {
                Long idQueja = resultado.getLong("idQueja");
                String texto = resultado.getString("texto");
                queja = new Queja(idQueja, texto);
                listaQuejas.add(queja);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            return listaQuejas;
        }
    }

   

}
