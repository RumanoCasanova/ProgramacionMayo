package piramide.dao.Receta;

import piramide.db.DBConnectionSQL;
import piramide.entities.Receta;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAORecetaSQL implements DAOReceta{
    @Override
    public void insertaReceta(Receta receta) {
        try {
            Statement statement = DBConnectionSQL.getInstance().createStatement();
            statement.execute("insert into recetas(receta,paso,descrippcion) values ('"+receta.getId()+"','"+receta.getNombre()+"')");
        } catch (SQLException exception) {
            if (exception.getErrorCode() == 1062){
                System.err.println("error insertar receta");
            }else {
                System.err.println(exception.getMessage());
            }
        }
    }

    @Override
    public List<Receta> listaRecetas() {
        List<Receta> recetas = new ArrayList<>();
        try {
            Statement statement = DBConnectionSQL.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from recetas");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String nombre = resultSet.getNString("nombre");
                recetas.add(new Receta(id,nombre));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return recetas;
    }

    @Override
    public void clear() {
        try {
            Statement statement = DBConnectionSQL.getInstance().createStatement();
            statement.execute("delete from recetas");
        } catch (SQLException exception){
            if (exception.getErrorCode() == 1062){
                System.err.println("error lista de aula");
            }else {
                System.err.println(exception.getMessage());
            }
        }
    }
}
