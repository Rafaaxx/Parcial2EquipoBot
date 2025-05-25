import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Formulario {

    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JCheckBox romanceCheckBox;
    private JCheckBox cienciaFicciónCheckBox;
    private JCheckBox comediaCheckBox;
    private JCheckBox terrorCheckBox;
    private JCheckBox historiaCheckBox;
    private JCheckBox tragediaCheckBox;
    private JButton guardarLibroButton;
    private JButton leerLibrosCargadosButton;
    private JButton terminarButton;
    File archivolibros=new File("Registro_de_libros");
    List<Libro> registrodelibros=new ArrayList<>();

    public Formulario(){
        guardarLibroButton.addActionListener(e -> guardarArchivo());
        leerLibrosCargadosButton.addActionListener(e -> leerLibros());
        terminarButton.addActionListener(e ->finalizar());
    }
    public void guardarArchivo() {
        Libro librohecho=null;
        //Definir array
        ArrayList<String> array = new ArrayList<>();
        if (romanceCheckBox.isSelected()) {
            array.add("Romance");
        }
        if (historiaCheckBox.isSelected()) {
            array.add("Historia");
        }
        if (cienciaFicciónCheckBox.isSelected()) {
            array.add("Ciencia Ficción");
        }
        if (comediaCheckBox.isSelected()) {
            array.add("Comedia");
        }
        if (tragediaCheckBox.isSelected()) {
            array.add("Tragedia");
        }
        if (terrorCheckBox.isSelected()) {
            array.add("Terror");
        }

        //Crear el nuevo libro
        try {
             librohecho = new Libro(textField2.getText(), Integer.parseInt(textField1.getText()), textField3.getText(), array);
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
    public void leerLibros(){

    }
    public void finalizar(){
        System.exit(0);
    }
}
