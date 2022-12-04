package DAOs;
import Entidades.Itinerario;
import Entidades.Zona;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
public class ZonasDAO {
    public IConexionDB conexion = new ConexionDB();

    public ZonasDAO() {
    }
    
    public boolean agregar(Zona zon){
        try {
            //INSERT INTO `zoologico_dis`.`zona` (`idzona`, `nombreZona`, `extension`) VALUES ('1', 'America', '223');

            String query="INSERT INTO `zoologico_dis`.`zona` (`idzona`, `nombreZona`, `extension`)"+
                    "VALUES ('"+zon.getIdZona()+"', '"+zon.getNombreZona()+"', '"+zon.getExtension()+"')";
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
    
    public boolean actualizar(Zona zon){
        try {
            //UPDATE `zoologico_dis`.`zona` SET `idzona` = '2', `nombreZona` = 'Zona Bonitoa', `extension` = '444' WHERE (`idzona` = '1');

            String query="zoologico_dis`.`zona` SET "
                    +"`idzona` = '+"+zon.getIdZona()+"', "
                    +"`nombreZona` = '"+zon.getNombreZona()+"', "
                    +" `extension` = '"+zon.getExtension()+"'"
                    +" WHERE (`idzona` = '"+zon.getIdZona()+"');";
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
    
    public boolean eliminar(long id){
        try {
            //DELETE FROM `zoologico_dis`.`zona` WHERE (`idzona` = '1');
            String query="DELETE FROM `zoologico_dis`.`zona` WHERE (`idzona` = '"+id+"');";
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
    
        public List<Zona> consultarTodos() {
        List<Zona> listaZonas = new LinkedList<>();
        Zona zona;

        try {
            Connection conexion = this.conexion.crearConexion();

            //Creamos un objeto que empaquetará el comando SQL que enviaremos a la BD
            Statement comando = conexion.createStatement();

            String codigoSQL = String.format("SELECT * FROM zona");

            ResultSet resultado = comando.executeQuery(codigoSQL);

            //Nos movemos dentro de los registros guardados uno a uno, devuelve false cuando 
            //se llega al final de los resultados
            while (resultado.next()) {
                Long idzona = resultado.getLong("idzona");
                String nombreZona = resultado.getString("nombreZona");
                Double extension = resultado.getDouble("extension");
                
                zona = new Zona(idzona, nombreZona, extension);
                listaZonas.add(zona);
            }
            conexion.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            return listaZonas;
        }
    }

    public Zona consultarZona(long id) {
        Zona zona = new Zona();
        try {
            String query = "SELECT * FROM zoologico_dis.zona WHERE idzona=" + id;
            Connection conexion = this.conexion.crearConexion();
            Statement comando = conexion.createStatement();
            ResultSet datos = comando.executeQuery(query);

            while (datos.next()) {
                zona.setIdZona(datos.getLong("idzona"));
                zona.setNombreZona(datos.getString("nombreZona"));
                zona.setExtension(datos.getDouble("extension"));
            }

            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            return zona;
        }
    }
}
