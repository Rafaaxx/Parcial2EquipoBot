import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

class NoTemaSeleccionadoException extends Exception {
    public NoTemaSeleccionadoException(String mensaje) {
        super(mensaje);
    }
}

class TituloVacioException extends Exception {
    public TituloVacioException(String mensaje) {
        super(mensaje);
    }
}


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
    private JPanel Panel_Principal;
    File archivolibros=new File("Registro_de_libros.dat");
    List<Libro> registrodelibros=new ArrayList<>();

    public Formulario(){
        guardarLibroButton.addActionListener(e -> {
            try {
                guardarArchivo();
            } catch (NoTemaSeleccionadoException | TituloVacioException ex) {
                throw new RuntimeException(ex);
            }
        });
        leerLibrosCargadosButton.addActionListener(e -> leerLibros());
        terminarButton.addActionListener(e ->finalizar());
    }

    public void guardarArchivo() throws NoTemaSeleccionadoException, TituloVacioException {
        Libro librohecho=null;
        //Definir array
        ArrayList<Tema> consiste_en = new ArrayList<>();
        Tema tema=null;
        if (romanceCheckBox.isSelected()) {
            consiste_en.add(tema=new Tema("Romance"));
        }
        if (historiaCheckBox.isSelected()) {
            consiste_en.add(tema=new Tema("Historia"));
        }
        if (cienciaFicciónCheckBox.isSelected()) {
            consiste_en.add(tema=new Tema("Ciencia Ficcion"));
        }
        if (comediaCheckBox.isSelected()) {
            consiste_en.add(tema=new Tema("Comedia"));
        }
        if (tragediaCheckBox.isSelected()) {
            consiste_en.add(tema=new Tema("Tragedia"));
        }
        if (terrorCheckBox.isSelected()) {
            consiste_en.add(tema=new Tema("Terror"));
        }

        //Crear el nuevo libro
        try {
             librohecho = new Libro(textField2.getText(), Integer.parseInt(textField1.getText()), textField3.getText());
             librohecho.setConsiste_en(consiste_en);
        }catch (NumberFormatException e){
            e.getMessage();
            JOptionPane.showMessageDialog(Panel_Principal, "Error: La respuesta del campo 'numero de libro' no es un numero.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        //Crear el ObjectInputStream
        if (archivolibros.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivolibros))) {
                registrodelibros = (List<Libro>) ois.readObject();

            } catch (IOException | ClassNotFoundException e) {
                JOptionPane.showMessageDialog(Panel_Principal, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
                e.printStackTrace();
            }
        }


        validarTitulo();
        validarTemas();


        registrodelibros.add(librohecho);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivolibros))) {
            oos.writeObject(registrodelibros);
            JOptionPane.showMessageDialog(Panel_Principal, "Libro guardado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(Panel_Principal, "Error al escribir el archivo", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            e.printStackTrace();
        }


    }

    private void validarTitulo() throws TituloVacioException {
        String titulo = textField2.getText().trim();
        if (titulo.trim().length() < 1) {
            JOptionPane.showMessageDialog(null, "El titulo esta vacio");
            throw new TituloVacioException("El titulo esta vacio");
        }

    }

    private void validarTemas() throws NoTemaSeleccionadoException {
        if (!romanceCheckBox.isSelected() && !cienciaFicciónCheckBox.isSelected() && !comediaCheckBox.isSelected() &&
                !terrorCheckBox.isSelected() && !historiaCheckBox.isSelected() && !tragediaCheckBox.isSelected()) {
            JOptionPane.showMessageDialog(null,"Debes elegir uno o más temas para tu libro");
            throw new NoTemaSeleccionadoException("No se eligio el tema");
        }
    }

    public void leerLibros(){
        if (!archivolibros.exists()) {
            JOptionPane.showMessageDialog(Panel_Principal, "No hay registros de libros guardados", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try {
            FileInputStream archivoInicial = new FileInputStream(archivolibros);
            ObjectInputStream lectorLibros = new ObjectInputStream(archivoInicial);
            registrodelibros = (List<Libro>) lectorLibros.readObject();
            lectorLibros.close();
            String textoLibros = "";
            for (Libro libro : registrodelibros) {
                textoLibros += "Título: " + libro.getTitulo() + "\n";
                textoLibros += "Número: " + libro.getNumero() + "\n";
                textoLibros += "Clasificación: " + libro.getClasificacion() + "\n";
                if (!libro.getConsiste_en().isEmpty()) {
                    textoLibros += "Temas: \n";
                    for (Tema tema : libro.getConsiste_en()) {
                        textoLibros += "- " + tema.getDenominacion() + "\n";
                    }
                }
                textoLibros += "\n";
            }
            JTextArea areaTextoLibros = new JTextArea(textoLibros);
            areaTextoLibros.setEditable(false);
            JScrollPane scroll = new JScrollPane(areaTextoLibros);
            scroll.setPreferredSize(new Dimension(250, 150));
            JOptionPane.showMessageDialog(Panel_Principal, scroll, "Libros guardados", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(Panel_Principal, "Ocurrió un error al leer el archivo", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void finalizar(){
        System.exit(0);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Formulario");
        frame.setContentPane(new Formulario().Panel_Principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
