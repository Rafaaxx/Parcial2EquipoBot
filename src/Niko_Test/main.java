package Niko_Test;

import Niko_Test.Controlador.ControladorLibro;
import Niko_Test.Vista.FormularioVista;

public class main {
    public static void main(String[] args) {
        FormularioVista vista = new FormularioVista();
        new ControladorLibro(vista);
    }
}
