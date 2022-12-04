package DAOs;

import Entidades.Especie;
import java.util.List;

public interface IEspeciesDAO {
    public boolean agregar(Especie esp, long idHabitat);
    public boolean actualizar(Especie esp);
    public boolean eliminar(long id);
    public List<Especie> consultarTodos();
    public Especie consultarEspecie(long id);
}
