package DAOs;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDB implements IConexionDB{
    
    public String cadenaConexion="jdbc:mysql://localhost/zoologico_dis";
    public String usuario="root";
    public String password="210568";

    public ConexionDB() {}    

    @Override
    public Connection crearConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(cadenaConexion, usuario, password);
            return conexion;
        } catch(Exception ex){
          System.err.println(ex.getMessage());
        }
        return null;
    }
}
