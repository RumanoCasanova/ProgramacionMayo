package piramide.entities;

public class Paso {
    private int receta;
    private int paso;
    private String descripcion;

    public Paso(int receta, int paso, String descripcion) {
        this.receta = receta;
        this.paso = paso;
        this.descripcion = descripcion;
    }

    public int getReceta() {
        return receta;
    }

    public void setReceta(int receta) {
        this.receta = receta;
    }

    public int getPaso() {
        return paso;
    }

    public void setPaso(int paso) {
        this.paso = paso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Paso{" +
                "receta=" + receta +
                ", paso=" + paso +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
