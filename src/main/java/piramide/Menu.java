package piramide;


import piramide.dao.DAOFactory;
import piramide.dao.Source;
import piramide.entities.Paso;
import piramide.entities.Receta;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Menu {

   Scanner scanner = new Scanner(System.in);
   public void menu(){
       System.out.println("Menú principal:");
       System.out.println("1. Ver las recetas");
       System.out.println("2. Nueva receta");
       System.out.println(("3. Borrar todas"));
       System.out.println("Opción:");
       String opcion = scanner.nextLine();
       if (opcion.equals("1")){
            menuRecetas();
       }else if (opcion.equals("2")){
            menuCrear();
       }else if (opcion.equals("3")){
           try {
               DAOFactory.getInstance().getDaoReceta(Source.SQL).clear();
           } catch (SQLException throwables) {
               throwables.printStackTrace();
           }
           return;
       }
   }
    private void menuRecetas(){
       System.out.println("Ver las recetas: ");
        try {
            DAOFactory.getInstance().getDaoReceta(Source.SQL).listaRecetas();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void menuCrear() {
       System.out.println("Opcion:");
       int id = scanner.nextInt();
       System.out.print("Nombre: ");
       String nombre = scanner.nextLine();
       Receta receta = new Receta(id,nombre);
        try {
            DAOFactory.getInstance().getDaoReceta(Source.SQL).insertaReceta(receta);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}

