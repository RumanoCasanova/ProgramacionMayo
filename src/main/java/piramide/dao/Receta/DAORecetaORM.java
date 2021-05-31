package piramide.dao.Receta;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import piramide.db.DBConnectionORM;
import piramide.entities.Receta;

import java.sql.SQLException;
import java.util.List;

public class DAORecetaORM implements DAOReceta{
    Dao<Receta, String> daorecetasORM;

    public DAORecetaORM() throws SQLException{
        this.daorecetasORM = DaoManager.createDao(
                DBConnectionORM.getInstance(),Receta.class
        );
        DaoManager.registerDao(
                DBConnectionORM.getInstance(),daorecetasORM
        );
    }
    @Override
    public void insertaReceta(Receta receta) {
        try {
            daorecetasORM.queryForAll();
        } catch (SQLException throwables){

        }
    }

    @Override
    public List<Receta> listaRecetas() {
        try {
            return daorecetasORM.queryForAll();
        }catch (SQLException throwables){
            return null;
        }
    }

    @Override
    public void clear() {

    }
}
