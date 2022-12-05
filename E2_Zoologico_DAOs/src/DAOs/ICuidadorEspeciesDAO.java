package DAOs;

import dominio.CuidadorEspecie;
import java.sql.Date;
import java.util.List;

public interface ICuidadorEspeciesDAO {
    public boolean agregar(long id, long idCuidador, long idEspecie, Date fechaInicio);
    public boolean actualizar(long id, long idCuidador, long idEspecie, Date fechaInicio);
    public boolean eliminar(long id);
    public List<CuidadorEspecie> consultarTodos();
    public CuidadorEspecie consultarEspecie(long id);
}
