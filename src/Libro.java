import java.io.Serializable;
import java.util.ArrayList;

public class Libro implements Serializable {
    public String titulo;
    public int numero;
    public String clasificacion;
    protected ArrayList<Tema> temas;

    public Libro(String titulo, int numero, String clasificacion) {
        this.titulo = titulo;
        this.numero = numero;
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

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public ArrayList<Tema> getTemas() {
        return temas;
    }

    public void setTemas(ArrayList<Tema> temas) {
        this.temas = temas;
    }
    public void mostrardatos(){
        System.out.println("Titulo: "+titulo+" Numero: "+numero+" Clasificacion: "+clasificacion);
        for (int i = 0; i < temas.size(); i++) {
            System.out.println(temas.get(i).toString());

        }
    }

    public String toString(){
        return "Libro " + titulo + " Numero: " + numero;
    }
}
