/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import dominio.Habitat;
import dominio.HabitatContinente;
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
public class HabitatContinenteDAO implements IHabitatContinenteDAO {

    /**
     * Atributo que permitirá la conexion a la base de datos
     */
    private IConexionDB conexion = new ConexionDB();

    /**
     * Constructor de la clase DAO
     * @param conexion 
     */
    public HabitatContinenteDAO(IConexionDB conexion) {
        this.conexion = conexion;
    }

    /**
     * Método que permite agregar datos a la base de datos
     * @param hab
     * @param idContinente 
     */
    @Override
    public void agregar(long idHabitatContinente ,Habitat hab, long idContinente) {
        try {
            Connection conexion = this.conexion.crearConexion();

            //Creamos un objeto que empaquetará el comando SQL que enviaremos a la BD
            Statement comando = conexion.createStatement();
            String query = String.format("INSERT INTO habitatcontinente VALUES ('%d', '%d', '%d')",
                    idHabitatContinente,
                    hab.getIdHabitat(),
                    idContinente);
            comando.executeUpdate(query);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /**
     * Método que permite consultar todos los registros de la base de datos
     * @return 
     */
    @Override
    public List<HabitatContinente> consultarTodo() {
        List<HabitatContinente> listaHabitatContinente = new LinkedList<>();

        try {
            Connection conexion = this.conexion.crearConexion();

            //Creamos un objeto que empaquetará el comando SQL que enviaremos a la BD
            Statement comando = conexion.createStatement();

            String codigoSQL = String.format("SELECT * FROM habitatcontinente");

            ResultSet resultados = comando.executeQuery(codigoSQL);

            //Nos movemos dentro de los registros guardados uno a uno, devuelve false cuando 
            //se llega al final de los resultados
            while (resultados.next()) {
                Long idHabitatContinente = resultados.getLong("idhabitatContinente");
                Long idHabitat = resultados.getLong("habitat");
                Long idContinente = resultados.getLong("continente");
                HabitatContinente hC = new HabitatContinente(idHabitatContinente, idHabitat, idContinente);
                listaHabitatContinente.add(hC);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            return listaHabitatContinente;
        }
    }

    /**
     * Método que permite consultar un registro específico de la base de datos
     * @param id
     * @return 
     */
    @Override
    public HabitatContinente consultarHabitatContinente(long id) {
        HabitatContinente hC = null;
        try {
            Connection conexion = this.conexion.crearConexion();

            //Creamos un objeto que empaquetará el comando SQL que enviaremos a la BD
            Statement comando = conexion.createStatement();

            String codigoSQL = String.format("SELECT idhabitatContinente, habitat, continente FROM habitatcontinente  WHERE idhabitatContinente = '%d'", id);

            ResultSet resultado = comando.executeQuery(codigoSQL);

            if (resultado.next()) {

                Long idHabitatContinente = resultado.getLong("idhabitatContinente");
                Long idHabitat = resultado.getLong("habitat");
                Long idContinente = resultado.getLong("continente");
                hC = new HabitatContinente(idHabitatContinente, idHabitat, idContinente);
            }
            conexion.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            return hC;
        }
    }

}
