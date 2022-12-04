package DAOs;

import Entidades.Especie;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EspeciesDAO implements IEspeciesDAO{
    public IConexionDB conexion = new ConexionDB();

    public EspeciesDAO() {
    }
    
    /*
    
    */
    public boolean agregar(Especie esp, long idHabitat){        
        try {
            //INSERT INTO `zoologico_dis`.`especie` (`idespecie`, `nombreEspanol`, `nombreCientifico`, `descripcion`, `zona`) VALUES ('1', 'Capybara', 'Hydrochoerus ', 'ratonmassivo', '1');
            String query="INSERT INTO `zoologico_dis`.`especie` (`idespecie`, `nombreEspanol`, `nombreCientifico`, `descripcion`, `zona`) "+
                "VALUES ('"+
                    esp.getIdEspecie()+"', '"+
                    esp.getNombreEspanol()+"', '"+
                    esp.getNombreCientifico()+"', '"+
                    esp.getDescripcion()+"', '"+
                    esp.getIdZona()
                    +"');";
            Connection con = conexion.crearConexion();
            Statement comando = con.createStatement();
            comando.executeUpdate(query);
            
            
            //INSERT INTO `zoologico_dis`.`habitatcontinente` (`idhabitatContinente`, `habitat`, `continente`) VALUES ('1', '1', '1');
            /*Por default, para el ID de la entrada de zonaItinerario va a utilizar el ID del itinerario, esto es una muy
            mala idea pero por mientras se queda asi hasta que haya otra forma de darle un ID unico (probablemente obtener el 
            numero total de entradas de zonaItinerario+1 y hacer eso el ID).
            */
            query="INSERT INTO `zoologico_dis`.`habitatcontinente` (`idhabitatContinente`, `habitat`, `continente`) "+
                "VALUES ('"+
                    esp.getIdEspecie()+"', '"+
                    esp.getIdEspecie()+"', '"+
                    idHabitat
                    +"');";
            comando.executeUpdate(query);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
    public boolean actualizar(Especie esp){        
        try {
            //UPDATE `zoologico_dis`.`especie` SET `nombreEspanol` = 'Capybaraa', `nombreCientifico` = 'Hydrochoeruss', `descripcion` = 'ratonmassivoo', `zona` = '2' WHERE (`idespecie` = '1');

            String query="UPDATE `zoologico_dis`.`especie` SET "
                    + "`nombreEspanol` = '"+esp.getNombreEspanol()+"', "
                    + "`nombreCientifico` = '"+esp.getNombreCientifico()+"', "
                    + "`descripcion` = '"+esp.getDescripcion()+"', "
                    + "`zona` = '"+esp.getIdZona()+"' "
                    + "WHERE (`idespecie` = '"+esp.getIdEspecie()+"');";
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
    
    public boolean eliminar(long id){        
        try {
            //DELETE FROM `zoologico_dis`.`especie` WHERE (`idespecie` = '1');
            String query="DELETE FROM `zoologico_dis`.`especie` WHERE (`idespecie` = '"+id+"');";
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
    
    @Override
    public List<Especie> consultarTodos(){
        try{
            List<Especie> list= new ArrayList();
            String query="SELECT * FROM zoologico_dis.especie;";
            Connection con=conexion.crearConexion();
            Statement comando = con.createStatement();
            ResultSet datos = comando.executeQuery(query);
            while(datos.next()){
                Especie esp =new Especie();
                esp.setIdEspecie(datos.getLong("idespecie"));
                esp.setNombreEspanol(datos.getString("nombreEspanol"));
                esp.setNombreCientifico(datos.getString("nombreCientifico"));
                esp.setDescripcion(datos.getString("descripcion"));
                esp.setIdZona(datos.getLong("zona"));
                
                list.add(esp);
            }
            con.close();
            return list;
        }
        catch(Exception ex){
            System.out.println(ex);
            return null;
        }
    }
    
    @Override
    public Especie consultarEspecie(long id){
        try {
            String query="SELECT * FROM zoologico_dis.especie WHERE idespecie="+id;
            Connection con=conexion.crearConexion();
            Statement comando = con.createStatement();
            ResultSet datos = comando.executeQuery(query);
            Especie especieResultado = new Especie();
            
            while (datos.next()) {
                especieResultado.setIdEspecie(datos.getLong("idespecie"));
                especieResultado.setNombreEspanol(datos.getString("nombreEspanol"));
                especieResultado.setNombreCientifico(datos.getString("nombreCientifico"));
                especieResultado.setDescripcion(datos.getString("descripcion"));
                especieResultado.setIdZona(datos.getLong("zona"));
            }            
            
            con.close();
            return especieResultado;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
