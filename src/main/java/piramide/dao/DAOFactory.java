package piramide.dao;

import piramide.dao.PASO.DAOPaso;
import piramide.dao.PASO.DAOPasoORM;
import piramide.dao.PASO.DAOPasoSQL;
import piramide.dao.Receta.DAOReceta;
import piramide.dao.Receta.DAORecetaORM;
import piramide.dao.Receta.DAORecetaSQL;

import java.sql.SQLException;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOPaso daoPaso;
    private DAOReceta daoReceta;

    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }
    public DAOPaso getDaoPaso(Source source) throws SQLException {
        if (daoPaso == null){
            if (source == Source.SQL)
                daoPaso = new DAOPasoSQL();
        }else if (source == Source.ORM){
            daoPaso = new DAOPasoORM();
        }
        return daoPaso;
    }
    public DAOReceta getDaoReceta(Source source) throws SQLException{
        if (daoReceta == null){
            if (source == Source.SQL)
                daoReceta = new DAORecetaSQL();
        } else if (source == Source.ORM){
            daoReceta = new DAORecetaORM();
        }
        return daoReceta;
    }
}
