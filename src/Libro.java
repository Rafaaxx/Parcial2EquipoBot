import java.io.Serializable;
import java.util.ArrayList;

public class Libro implements Serializable {
    private String titulo;
    private int numerolibro;
    private String clasificacion;
    private ArrayList<Tema> temas;

    public Libro(String titulo, int numerolibro, String clasificacion) {
        this.titulo = titulo;
        this.numerolibro = numerolibro;
        this.clasificacion = clasificacion;
        this.temas = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public int getNumerolibro() {
        return numerolibro;
    }

    public void setNumerolibro(int numerolibro) {
        this.numerolibro = numerolibro;
    }

    public ArrayList<Tema> getTemas() {
        return temas;
    }

    public void setTemas(ArrayList<Tema> temas) {
        this.temas = temas;
    }
    public void mostrardatos(){
        System.out.println("Titulo: "+titulo+" Numero: "+numerolibro+" Clasificacion: "+clasificacion);
        for (int i = 0; i < temas.size(); i++) {
            System.out.println(temas.get(i).toString());

        }
    }
}
