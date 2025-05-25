package Niko_Test.Controlador;

import Niko_Test.Modelo.Libro;
import Niko_Test.Modelo.Tema;
import Niko_Test.Vista.FormularioVista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ControladorLibro {
    public FormularioVista vista;
    File archivolibros=new File("Registro_de_libros");
    List<Libro> registrodelibros=new ArrayList<>();

    public ControladorLibro(FormularioVista vista){
        this.vista = vista;

        this.vista.guardarLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarArchivo();
            }


        });


        this.vista.leerLibrosCargadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(registrodelibros.size());
            }
        });
    }

    public void guardarArchivo() {
        Libro librohecho=null;
        //Definir array
        ArrayList<Tema> array = new ArrayList<>();
        if (this.vista.romanceCheckBox.isSelected()) {
            array.add(new Tema("Romance", librohecho));
        }
        if (this.vista.historiaCheckBox.isSelected()) {
            array.add(new Tema("Historia", librohecho));
        }
        if (this.vista.cienciaFiccionCheckBox.isSelected()) {
            array.add(new Tema("Ciencia Ficción", librohecho));
        }
        if (this.vista.comediaCheckBox.isSelected()) {
            array.add(new Tema("Comedia", librohecho));
        }
        if (this.vista.tragediaCheckBox.isSelected()) {
            array.add(new Tema("Tragedia", librohecho));
        }
        if (this.vista.terrorCheckBox.isSelected()) {
            array.add(new Tema("Terror", librohecho));
        }

        //Crear el nuevo libro
        try {
            librohecho = new Libro(this.vista.textField1.getText(), Integer.parseInt(this.vista.textField3.getText()), this.vista.textField2.getText(), array);
        }catch (NumberFormatException e){
            e.getMessage();
            System.out.println("Error: La respuesta del campo 'numero de libro' no es un numero.");
            return;
        }

        //Crear el ObjectInputStream
        try(ObjectInputStream ois= new ObjectInputStream(new FileInputStream(archivolibros))){
            registrodelibros=(List<Libro>) ois.readObject();

        }catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        registrodelibros.add(librohecho);
        try(ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(archivolibros))){
            oos.writeObject(registrodelibros);
            System.out.println("Libro guardado.");
        }catch (IOException e){
            System.out.println("Error al escribir el archivo");
            e.printStackTrace();
        }


    }

    public void ObtenerLibroYTemas(){

    }

}
