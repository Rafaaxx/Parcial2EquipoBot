package Niko_Test.Modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Libro implements Serializable {
    private String titulo;
    private int numerolibro;
    private String clasificacion;
    protected ArrayList<Tema> consiste_en;

    public Libro(String titulo, int numerolibro, String clasificacion, ArrayList<Tema> temas) {
        this.titulo = titulo;
        this.numerolibro = numerolibro;
        this.clasificacion = clasificacion;
        this.consiste_en = temas;
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
        return consiste_en;
    }

    public void setTemas(ArrayList<Tema> temas) {
        this.consiste_en = temas;
    }
}
