package DAOs;

import dominio.EspecieCuidador;
import java.util.List;

public interface IEspeciesCuidadoresDAO {
    public boolean agregar(long id, long idCuidador, long idEspecie, boolean experto);
    public boolean actualizar(long id, long idCuidador, long idEspecie, boolean experto);
    public boolean eliminar(long id);
    public List<EspecieCuidador> consultarTodos();
    public EspecieCuidador consultarEspecie(long id);
}
