package DAOs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import dominio.EspecieCuidador;

public class EspeciesCuidadoresDAO implements IEspeciesCuidadoresDAO{
    public IConexionDB conexion = new ConexionDB();

    public EspeciesCuidadoresDAO() {
    }
    
    /*
    El id de la entrada
    id del cuidador
    id de la especie
    boolean nombre experto
        true si es cuidador experto
        false si es basico
    */
    @Override
    public boolean agregar(long id, long idCuidador, long idEspecie, boolean experto){
        try {
            //INSERT INTO `zoologico_dis`.`especiecuidador` (`idespecieCuidador`, `idEspecie`, `idCuidador`, `esExperto`) VALUES ('1', '1', '1', b'0');
            
            int valorBooleano=0;
            if (experto) valorBooleano = 1;

            String query="INSERT INTO `zoologico_dis`.`especiecuidador` (`idespecieCuidador`, `idEspecie`, `idCuidador`, `esExperto`) "
                    + "VALUES ('"+id+"', "
                    + "'"+idEspecie+"', "
                    + "'"+idCuidador+"', "
                    + "b'"+valorBooleano
                    + "');";
            
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
    
    @Override
    public boolean actualizar(long id, long idCuidador, long idEspecie, boolean experto){
        try {
            //UPDATE `zoologico_dis`.`especiecuidador` SET `idEspecie` = '2', `idCuidador` = '4', `esExperto` = '1' WHERE (`idespecieCuidador` = '1');            
            int valorBooleano=0;
            if (experto) valorBooleano = 1;

            String query="UPDATE `zoologico_dis`.`especiecuidador` SET "
                    + "`idEspecie` = '"+idEspecie+"', "
                    + "`idCuidador` = '"+idCuidador+"', "
                    + "`esExperto` = '"+valorBooleano+"' "
                    + "WHERE (`idespecieCuidador` = '"+id+"');";
            
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
    @Override
    public boolean eliminar(long id){
        try {
            //DELETE FROM `zoologico_dis`.`especiecuidador` WHERE (`idespecieCuidador` = '1');
            String query="DELETE FROM `zoologico_dis`.`especiecuidador` WHERE (`idespecieCuidador` = '"+id+"');";
            
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
    @Override
    public List<EspecieCuidador> consultarTodos(){
        try{
            List<EspecieCuidador> list= new ArrayList();
            String query="SELECT * FROM zoologico_dis.especiecuidador";
            Connection con=conexion.crearConexion();
            Statement comando = con.createStatement();
            ResultSet datos = comando.executeQuery(query);
            while(datos.next()){
                EspecieCuidador esp =new EspecieCuidador();
                esp.setId(datos.getLong("idespecieCuidador"));
                esp.setIdCuidador(datos.getLong("idCuidador"));
                esp.setIdEspecie(datos.getLong("idEspecie"));
                
                esp.setExperto(false);
                if (datos.getBoolean("esExperto")) esp.setExperto(true);
                
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
    public EspecieCuidador consultarEspecie(long id){
        try {
            String query="SELECT * FROMzoologico_dis.especiecuidador WHERE idespecieCuidador="+id;
            Connection con=conexion.crearConexion();
            Statement comando = con.createStatement();
            ResultSet datos = comando.executeQuery(query);
            EspecieCuidador especieResultado = new EspecieCuidador();
            
            while (datos.next()) {
                especieResultado.setId(datos.getLong("idespecieCuidador"));
                especieResultado.setIdCuidador(datos.getLong("idCuidador"));
                especieResultado.setIdEspecie(datos.getLong("idEspecie"));
                
                especieResultado.setExperto(false);
                if (datos.getBoolean("esExperto")) especieResultado.setExperto(true);
            }            
            
            con.close();
            return especieResultado;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
