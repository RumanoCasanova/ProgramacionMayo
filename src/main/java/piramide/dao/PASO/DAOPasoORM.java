package piramide.dao.PASO;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import piramide.db.DBConnectionORM;
import piramide.entities.Paso;


import java.sql.SQLException;

public class DAOPasoORM implements DAOPaso{
    Dao<Paso, String> daopasosORM;

    public DAOPasoORM() throws SQLException {
        this.daopasosORM = DaoManager.createDao(
                DBConnectionORM.getInstance(), Paso.class
        );
        DaoManager.registerDao(
                DBConnectionORM.getInstance(),daopasosORM
        );
    }
    @Override
    public void insertaPaso(Paso paso) {
        try {
            daopasosORM.queryForAll();
        }catch (SQLException throwables){

        }
    }
}
