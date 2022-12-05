package DAOs;

import dominio.Empleado;
import dominio.Habitat;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import DAOs.*;
import java.util.List;

public class HabitatDAO {

    public IConexionDB conexion = new ConexionDB();

    public HabitatDAO(IConexionDB conexion) {
        this.conexion = conexion;
    }

    public boolean agregar(Habitat hab) {
        try {
            
            Connection con = conexion.crearConexion();
            Statement comando = con.createStatement();
            //INSERT INTO `zoologico_dis`.`habitat` (`idhabitat`, `nombre`, `clima`, `tipoVegetacion`) VALUES ('1', 'Desierto', 'Seco', 'Deserta');
            String query = "INSERT INTO `zoologico_dis`.`habitat` (`idhabitat`, `nombre`, `clima`, `tipoVegetacion`) "
                    + "VALUES ('"
                    + hab.getIdHabitat() + "', '"
                    + hab.getNombre() + "', '"
                    + hab.getClima() + "', '"
                    + hab.getTipoVegetacion()
                    + "');";
            comando.executeUpdate(query);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public boolean actualizar(Habitat hab) {
        try {
            //UPDATE `zoologico_dis`.`habitat` SET `nombre` = 'Jungla', `clima` = 'Humedo', `tipoVegetacion` = 'Jungla' WHERE (`idhabitat` = '1');
            String query = "UPDATE `zoologico_dis`.`habitat` SET "
                    + "`nombre` = '" + hab.getNombre() + "', "
                    + "`clima` = '" + hab.getClima() + "', "
                    + "`tipoVegetacion` = '" + hab.getTipoVegetacion() + "' "
                    + "WHERE (`idhabitat` = '" + hab.getIdHabitat() + "')";
            Connection con = conexion.crearConexion();
            Statement comando = con.createStatement();
            comando.executeUpdate(query);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public boolean eliminar(long id) {
        try {
            //DELETE FROM `zoologico_dis`.`habitat` WHERE (`idhabitat` = '1');
            String query = "DELETE FROM `zoologico_dis`.`habitat` WHERE (`idhabitat` = '" + id + "');";
            Connection con = conexion.crearConexion();
            Statement comando = con.createStatement();
            comando.executeUpdate(query);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public List<Habitat> consultarTodos() {
        List<Habitat> listaHabitats = new LinkedList<>();
        Habitat habitat;
        try {
            Connection conexion = this.conexion.crearConexion();

            //Creamos un objeto que empaquetará el comando SQL que enviaremos a la BD
            Statement comando = conexion.createStatement();

            String codigoSQL = String.format("SELECT * FROM habitat");

            ResultSet resultado = comando.executeQuery(codigoSQL);

            //Nos movemos dentro de los registros guardados uno a uno, devuelve false cuando 
            //se llega al final de los resultados
            while (resultado.next()) {
                Long idhabitat = resultado.getLong("idhabitat");
                String nombre = resultado.getString("nombre");
                String clima = resultado.getString("clima");
                String tipoVegetacion = resultado.getString("tipoVegetacion");
                habitat = new Habitat(idhabitat, nombre, clima, tipoVegetacion);
                listaHabitats.add(habitat);
            }
            conexion.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            return listaHabitats;
        }
    }

    public Habitat consultarHabitat(long id) {
        Habitat habitat = new Habitat();
        try {
            String query = "SELECT * FROM zoologico_dis.habitat WHERE idhabitat=" + id;
            Connection conexion = this.conexion.crearConexion();
            Statement comando = conexion.createStatement();
            ResultSet datos = comando.executeQuery(query);

            while (datos.next()) {
                habitat.setIdHabitat(datos.getLong("idhabitat"));
                habitat.setNombre(datos.getString("nombre"));
                habitat.setClima(datos.getString("clima"));
                habitat.setTipoVegetacion(datos.getString("tipoVegetacion"));
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            return habitat;
        }
    }
}
