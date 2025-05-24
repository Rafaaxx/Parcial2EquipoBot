package Niko_Test.Modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Libro implements Serializable {
    private String titulo;
    private int numerolibro;
    private String clasificacion;
    private ArrayList<String> temas;

    public Libro(String titulo, int numerolibro, String clasificacion, ArrayList<String> temas) {
        this.titulo = titulo;
        this.numerolibro = numerolibro;
        this.clasificacion = clasificacion;
        this.temas = temas;
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

    public ArrayList<String> getTemas() {
        return temas;
    }

    public void setTemas(ArrayList<String> temas) {
        this.temas = temas;
    }
}
