import java.io.Serializable;
import java.util.ArrayList;

public class Libro implements Serializable {
    public String titulo;
    public int numero;
    public String clasificacion;
    protected ArrayList<Tema> consiste_en;

    public Libro(String titulo, int numero, String clasificacion) {
        this.titulo = titulo;
        this.numero = numero;
        this.clasificacion = clasificacion;
        this.consiste_en = new ArrayList<>();
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

    public ArrayList<Tema> getConsiste_en() {
        return consiste_en;
    }

    public void setConsiste_en(ArrayList<Tema> consiste_en) {
        this.consiste_en = consiste_en;
    }
    public void mostrardatos(){
        System.out.println("Titulo: "+titulo+" Numero: "+numero+" Clasificación: "+clasificacion);
        for (int i = 0; i < consiste_en.size(); i++) {
            System.out.println(consiste_en.get(i).toString());

        }
    }

    public String toString(){
        return "Libro " + titulo + " Numero: " + numero;
    }
}
