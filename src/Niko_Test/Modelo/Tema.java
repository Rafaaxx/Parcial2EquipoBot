package Niko_Test.Modelo;

import java.io.Serializable;

public class Tema implements Serializable {
    public String denominacion;
    public Libro libro;

    public Tema(String denominacion, Libro libro){
        this.denominacion = denominacion;
        this.libro = libro;
    }
}
