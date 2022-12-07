package DAOs;

import dominio.Empleado;
import dominio.Itinerario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class ItinerariosDAO {

    public IConexionDB conexion = new ConexionDB();

    public ItinerariosDAO() {
    }

    /*
    Por como estan estructurada las tablas y este programa mismo, por favor
    no trate de hacer un itinerario si no hay al menos 1 zona.
    Ya que necesitamos una zona para un foreign key
     */
    public boolean agregar(Itinerario iti) {
        try {
            Connection con = conexion.crearConexion();
            Statement comando = con.createStatement();
            //INSERT INTO `zoologico_dis`.`itinerario` (`iditinerario`, `duracionRecorrido`, `longitud`, `visitasMaximas`, `numeroZonas`, `guia`) VALUES ('1', '30 horas', '24', '6', '2', '3');
            String codigoSQL = String.format("INSERT INTO itinerario(iditinerario, duracionRecorrido, longitud, visitasMaximas, numeroZonas, horas, dias, nombre, guia) VALUES('%d', '%s', '%f', '%d', '%d', '%s', '%s', '%s', '%d')",
                    iti.getIdItinerario(),
                    iti.getDuracionRecorrido(),
                    iti.getLongitud(),
                    iti.getVisitasMaximas(),
                    iti.getNumeroZonas(),
                    iti.getHoras(),
                    iti.getDias(),
                    iti.getNombre(),
                    iti.getIdGuia());
            comando.executeUpdate(codigoSQL);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public boolean actualizar(Itinerario iti) {
        try {
            //UPDATE `zoologico_dis`.`itinerario` SET `duracionRecorrido` = '30 minutos', `longitud` = '46', `visitasMaximas` = '15', `numeroZonas` = '4', `guia` = '2' WHERE (`iditinerario` = '1');
            String query = "zoologico_dis`.`zona` SET "
                    + "`duracionRecorrido` = '+" + iti.getDuracionRecorrido() + "', "
                    + "`longitud` = '" + iti.getLongitud() + "', "
                    + "`visitasMaximas` = '" + iti.getVisitasMaximas() + ", "
                    + "`numeroZonas` = '" + iti.getNumeroZonas() + ", "
                    + "`guia` = '" + iti.getIdGuia() + ", "
                    + " WHERE (`iditinerario` = '" + iti.getIdItinerario() + "');";
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
            //DELETE FROM `zoologico_dis`.`itinerario` WHERE (`iditinerario` = '1');
            String query = "DELETE FROM `zoologico_dis`.`itinerario` WHERE (`iditinerario` = '" + id + "');";
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

    public List<Itinerario> consultarTodos() {
        List<Itinerario> listaItinerarios = new LinkedList<>();
        Itinerario itinerario;

        try {
            Connection conexion = this.conexion.crearConexion();

            //Creamos un objeto que empaquetará el comando SQL que enviaremos a la BD
            Statement comando = conexion.createStatement();

            String codigoSQL = String.format("SELECT * FROM itinerario");

            ResultSet resultado = comando.executeQuery(codigoSQL);

            //Nos movemos dentro de los registros guardados uno a uno, devuelve false cuando 
            //se llega al final de los resultados
            while (resultado.next()) {
                Long iditinerario = resultado.getLong("iditinerario");
                String duracionRecorrido = resultado.getString("duracionRecorrido");
                Double longitud = resultado.getDouble("longitud");
                int visitasMaximas = resultado.getInt("visitasMaximas");
                int numeroZonas = resultado.getInt("numeroZonas");
                long idGuia = resultado.getLong("guia");
                String dias = resultado.getString("dias");
                String horas = resultado.getString("horas");
                String nombre = resultado.getString("nombre");
                itinerario = new Itinerario(iditinerario, idGuia, visitasMaximas, numeroZonas, longitud, duracionRecorrido, dias, horas, nombre);
                listaItinerarios.add(itinerario);
            }
            conexion.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            return listaItinerarios;
        }
    }

    public Itinerario consultarItinerario(long id) {
        Itinerario itinerario = new Itinerario();
        try {
            String query = "SELECT * FROM zoologico_dis.itinerario WHERE iditinerario=" + id;
            Connection conexion = this.conexion.crearConexion();
            Statement comando = conexion.createStatement();
            ResultSet datos = comando.executeQuery(query);

            while (datos.next()) {
                itinerario.setIdItinerario(datos.getLong("iditinerario"));
                itinerario.setDuracionRecorrido(datos.getString("duracionRecorrido"));
                itinerario.setLongitud(datos.getDouble("longitud"));
                itinerario.setVisitasMaximas(datos.getInt("visitasMaximas"));
                itinerario.setNumeroZonas(datos.getInt("numeroZonas"));
                itinerario.setDias(datos.getString("dias"));
                itinerario.setHoras(datos.getString("horas"));
                itinerario.setIdGuia(datos.getLong("guia"));
            }

            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            return itinerario;
        }
    }
}
