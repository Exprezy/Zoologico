package DAOs;

import dominio.CuidadorEspecie;
import dominio.Empleado;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class EmpleadosDAO {

    public IConexionDB conexion = new ConexionDB();

    public EmpleadosDAO() {

    }

    /*
    El segundo atributo de tipodeEmpleado se utiliza para ver si el empleado
    que se acaba de agregar es un empleado normal, guia o cuidador
    
    0 = empleado normal (o cualquier numero que no sea ni 1 ni 2)
    1 = guia
    2 = cuidador
    
    Se utiliza para agregar el empleado a su tabla respectiva en caso de ser mas
    que un empleado regular
    
    
    Si algo explota en el query, probalmente es por la fecha
    utilizen el formato correcto de AAAA-MM-DD
     */
    public boolean agregar(Empleado emp, int tipoDeEmpleado) {
        try {
            //INSERT INTO `zoologico_dis`.`empleado` (`idempleado`, `nombre`, `direccion`, `telefono`, `fechaComienzo`) VALUES ('1', 'Alberto', 'Casa Blanca', '64422201111', '2022-04-15');
            String query = "INSERT INTO `zoologico_dis`.`empleado` (`idempleado`, `nombre`, `direccion`, `telefono`, `fechaComienzo`) "
                    + "VALUES ('" + emp.getIdEmpleado() + "', '" + emp.getNombre() + "', '" + emp.getDireccion() + "', '" + emp.getTelefono() + "', '" + emp.getFechaComienzo() + "')";
            Connection con = conexion.crearConexion();
            Statement comando = con.createStatement();
            comando.executeUpdate(query);
            if (tipoDeEmpleado == 1) {
                query = "INSERT INTO `zoologico_dis`.`guia` (`idguia`, `empleado`) " + "VALUES ('" + emp.getIdEmpleado() + "', '" + emp.getIdEmpleado() + "')";
                comando.executeUpdate(query);
            }
            if (tipoDeEmpleado == 2) {
                query = "INSERT INTO `zoologico_dis`.`cuidador` (`idcuidador`, `empleado`) " + "VALUES ('" + emp.getIdEmpleado() + "', '" + emp.getIdEmpleado() + "')";
                comando.executeUpdate(query);
            }
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean actualizar(Empleado emp) {
        try {
            //UPDATE `zoologico_dis`.`empleado` SET `nombre` = 'Maria', `direccion` = 'Hidalgo', `telefono` = '64422201211', `fechaComienzo` = '2022-04-16' WHERE (`idempleado` = '1');
            String query = "UPDATE `zoologico_dis`.`empleado` SET "
                    + "`nombre` = '" + emp.getNombre() + "', "
                    + "`direccion` = '" + emp.getDireccion() + "', "
                    + "`telefono` = '" + emp.getTelefono() + "', "
                    + "`fechaComienzo` = '" + emp.getFechaComienzo() + "' "
                    + "WHERE (`idempleado` = '" + emp.getIdEmpleado() + "');";
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
            //DELETE FROM `zoologico_dis`.`empleado` WHERE (`idempleado` = '1');
            String query = "DELETE FROM `zoologico_dis`.`empleado` WHERE (`idempleado` = '" + id + "');";
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

    public List<Empleado> consultarTodos() {
        List<Empleado> listaEmpleados = new LinkedList<>();
        Empleado empleado;

        try {
            Connection conexion = this.conexion.crearConexion();

            //Creamos un objeto que empaquetará el comando SQL que enviaremos a la BD
            Statement comando = conexion.createStatement();

            String codigoSQL = String.format("SELECT * FROM empleado");

            ResultSet resultado = comando.executeQuery(codigoSQL);

            //Nos movemos dentro de los registros guardados uno a uno, devuelve false cuando 
            //se llega al final de los resultados
            while (resultado.next()) {
                Long idempleado = resultado.getLong("idempleado");
                String nombre = resultado.getString("nombre");
                String direccion = resultado.getString("direccion");
                String telefono = resultado.getString("telefono");
                Date fechaComienzo = resultado.getDate("fechaComienzo");
                empleado = new Empleado(idempleado, nombre, direccion, telefono, fechaComienzo);
                listaEmpleados.add(empleado);
            }
            conexion.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            return listaEmpleados;
        }
    }

    public Empleado consultarEmpleado(long id) {
        Empleado empleado = new Empleado();
        try {
            String query = "SELECT * FROM zoologico_dis.empleado WHERE idempleado=" + id;
            Connection conexion = this.conexion.crearConexion();
            Statement comando = conexion.createStatement();
            ResultSet datos = comando.executeQuery(query);
            
            while (datos.next()) {
                empleado.setIdEmpleado(datos.getLong("idempleado"));
                empleado.setNombre(datos.getString("nombre"));
                empleado.setDireccion(datos.getString("direccion"));
                empleado.setTelefono(datos.getString("telefono"));
                empleado.setFechaComienzo(datos.getDate("fechaComienzo"));
            }

            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            return empleado;
        }
    }
}
