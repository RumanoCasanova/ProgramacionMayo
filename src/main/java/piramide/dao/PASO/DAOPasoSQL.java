package piramide.dao.PASO;

import piramide.db.DBConnectionSQL;
import piramide.entities.Paso;

import java.sql.SQLException;
import java.sql.Statement;

public class DAOPasoSQL implements DAOPaso{
    @Override
    public void insertaPaso(Paso paso) {
        try {
            Statement statement = DBConnectionSQL.getInstance().createStatement();
          statement.execute("insert into pasos(receta,pasos,descripcion) values ('"+paso.getReceta()+"','"+paso.getPaso()+"','"+paso.getDescripcion()+"')");
        }catch (SQLException exception){
            if (exception.getErrorCode() == 1062){
                System.err.println("error insertar pasos");
            }else {
                System.err.println(exception.getMessage());
            }
        }
    }

}
