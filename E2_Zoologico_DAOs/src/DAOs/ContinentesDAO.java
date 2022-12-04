package DAOs;

import Entidades.Continente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContinentesDAO {

    public IConexionDB conexion = new ConexionDB();

    public ContinentesDAO() {
    }

    public boolean agregar(Continente cont) {
        try {
            //INSERT INTO `zoologico_dis`.`continente` (`idcontinente`, `nombre`) VALUES ('1', 'Sur america');

            String query = "INSERT INTO `zoologico_dis`.`continente` (`idcontinente`, `nombre`) "
                    + "VALUES ('" + cont.getIdContinente() + "', '" + cont.getNombre() + "')";
            Connection con = conexion.crearConexion();
            Statement comando = con.createStatement();
            comando.executeUpdate(query);
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean actualizar(Continente cont) {
        try {
            //UPDATE `zoologico_dis`.`continente` SET `nombre` = 'Europa' WHERE (`idcontinente` = '1');
            String query = "UPDATE `zoologico_dis`.`continente` SET `nombre` = '" + cont.getNombre() + "' WHERE (`idcontinente` = '" + cont.getIdContinente() + "')";
            Connection con = conexion.crearConexion();
            Statement comando = con.createStatement();
            comando.executeUpdate(query);
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean eliminar(long id) {
        try {
            //DELETE FROM `zoologico_dis`.`continente` WHERE (`idcontinente` = '1');
            String query = "DELETE FROM `zoologico_dis`.`continente` WHERE (`idcontinente` = '" + id + "')";
            Connection con = conexion.crearConexion();
            Statement comando = con.createStatement();
            comando.executeUpdate(query);
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public List<Continente> consultarTodos() {
        try {
            List<Continente> list = new ArrayList();
            String query = "SELECT * FROM zoologico_dis.continente;";
            Connection con = conexion.crearConexion();
            Statement comando = con.createStatement();
            ResultSet datos = comando.executeQuery(query);
            while (datos.next()) {
                Continente cont = new Continente();
                cont.setIdContinente(datos.getLong("idespecie"));
                cont.setNombre(datos.getString("nombreEspanol"));

                list.add(cont);
            }
            con.close();
            return list;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    public Continente consultarEspecie(long id) {
        try {
            String query = "SELECT * FROM zoologico_dis.especie WHERE idespecie=" + id;
            Connection con = conexion.crearConexion();
            Statement comando = con.createStatement();
            ResultSet datos = comando.executeQuery(query);
            Continente contResultado = new Continente();

            while (datos.next()) {
                contResultado.setIdContinente(datos.getLong("idespecie"));
                contResultado.setNombre(datos.getString("nombreEspanol"));
            }

            con.close();
            return contResultado;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
