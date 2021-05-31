package piramide.dao.Receta;

import piramide.entities.Receta;

import java.util.List;

public interface DAOReceta {
    public void insertaReceta(Receta receta);
    public List<Receta> listaRecetas();
    public void clear();
}
