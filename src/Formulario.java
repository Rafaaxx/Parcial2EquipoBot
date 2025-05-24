import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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
    public Formulario(){
        guardarLibroButton.addActionListener(e -> guardarArchivo());
    }
    public void guardarArchivo(){
        ArrayList<String> array=new ArrayList<>();

    }
}
