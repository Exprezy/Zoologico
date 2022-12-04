package DAOs;

import Entidades.Continente;
import java.util.List;

public interface IContinentesDAO {
    public boolean agregar(Continente cont);
    public boolean actualizar(Continente cont);
    public boolean eliminar(long id);
    public List<Continente> consultarTodos();
    public Continente consultarEspecie(long id);
}
