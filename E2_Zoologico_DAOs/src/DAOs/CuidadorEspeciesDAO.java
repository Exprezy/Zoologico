package DAOs;
import Entidades.CuidadorEspecie;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CuidadorEspeciesDAO implements ICuidadorEspeciesDAO{
    public IConexionDB conexion = new ConexionDB();

    public CuidadorEspeciesDAO() {
    }
    
    @Override
    public boolean agregar(long id, long idCuidador, long idEspecie, Date fechaInicio){
        try {
            //INSERT INTO `zoologico_dis`.`cuidadorespecie` (`idcuidadorEspecie`, `fechaInicio`, `cuidador`, `especie`) VALUES ('1', '2022-02-16', '1', '1');

            String query="INSERT INTO `zoologico_dis`.`cuidadorespecie` ( `fechaInicio`, `cuidador`, `especie`) "
                    + "VALUES ('"
                    + "'"+fechaInicio+"', "
                    + "'"+idCuidador+"', "
                    + "'"+idEspecie
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
    public boolean actualizar(long id, long idCuidador, long idEspecie, Date fechaInicio){
        try {
            //UPDATE `zoologico_dis`.`cuidadorespecie` SET `fechaInicio` = '2022-02-18', `cuidador` = '2', `especie` = '4' WHERE (`idcuidadorEspecie` = '1');          
            

            String query="UPDATE `zoologico_dis`.`cuidadorespecie` SET "
                    + "`fechaInicio` = '"+fechaInicio+"', "
                    + "`cuidador` = '"+idCuidador+"', "
                    + "`especie` = '"+idEspecie+"' "
                    + "WHERE (`idcuidadorEspecie` = '"+id+"');";
            
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
            //DELETE FROM `zoologico_dis`.`cuidadorespecie` WHERE (`idcuidadorEspecie` = '1');
            String query="DELETE FROM `zoologico_dis`.`cuidadorespecie` WHERE (`idcuidadorEspecie` = '"+id+"');";
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
    public List<CuidadorEspecie> consultarTodos(){
        try{
            List<CuidadorEspecie> list= new ArrayList();
            String query="SELECT * FROM zoologico_dis.cuidadorespecie";
            Connection con=conexion.crearConexion();
            Statement comando = con.createStatement();
            ResultSet datos = comando.executeQuery(query);
            while(datos.next()){
                CuidadorEspecie esp =new CuidadorEspecie();
                esp.setIdCuidadorEspecie(datos.getLong("idcuidadorEspecie"));
                esp.setIdCuidador(datos.getLong("idCuidador"));
                esp.setIdEspecie(datos.getLong("idEspecie"));
                esp.setFechaInicio(datos.getDate("fechaInicio"));
                
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
    public CuidadorEspecie consultarEspecie(long id){
        try {
            String query="SELECT * FROM zoologico_dis.cuidadorespecie WHERE idespecieCuidador="+id;
            Connection con=conexion.crearConexion();
            Statement comando = con.createStatement();
            ResultSet datos = comando.executeQuery(query);
            CuidadorEspecie especieResultado = new CuidadorEspecie();
            
            while (datos.next()) {
                especieResultado.setIdCuidador(datos.getLong("idespecieCuidador"));
                especieResultado.setIdCuidador(datos.getLong("idCuidador"));
                especieResultado.setIdEspecie(datos.getLong("idEspecie"));
                especieResultado.setFechaInicio(datos.getDate("fechaInicio"));
            }            
            
            con.close();
            return especieResultado;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
