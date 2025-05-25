package Niko_Test.Vista;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;


public class FormularioVista extends JFrame {
    private JLabel tituloForm = new JLabel("Detalles del libro");

    private JLabel tituloLibro = new JLabel("Título del libro:");
    public JTextField textField1 = new JTextField(20);

    private JLabel labelClasificacion = new JLabel("Clasificación del libro:");
    public JTextField textField2 = new JTextField(20);

    private JLabel labelNumero = new JLabel("Número del libro:");
    public JTextField textField3 = new JTextField(20);

    public JCheckBox romanceCheckBox = new JCheckBox("Romance");
    public JCheckBox cienciaFiccionCheckBox = new JCheckBox("Ciencia Ficción");
    public JCheckBox comediaCheckBox = new JCheckBox("Comedia");
    public JCheckBox terrorCheckBox = new JCheckBox("Terror");
    public JCheckBox historiaCheckBox = new JCheckBox("Historia");
    public JCheckBox tragediaCheckBox = new JCheckBox("Tragedia");

    public JButton guardarLibroButton = new JButton("Guardar Libro");
    public JButton leerLibrosCargadosButton = new JButton("Leer Libros Cargados");
    public JButton terminarButton = new JButton("Terminar");

    public FormularioVista() {
        setTitle("Formulario Libro");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Título principal
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        tituloForm.setFont(new Font("Arial", Font.BOLD, 16));
        add(tituloForm, gbc);

        // Label + Campo Título
        gbc.gridy++;
        gbc.gridwidth = 1;
        add(tituloLibro, gbc);
        gbc.gridx = 1;
        add(textField1, gbc);

        // Label + Campo Clasificación
        gbc.gridy++;
        gbc.gridx = 0;
        add(labelClasificacion, gbc);
        gbc.gridx = 1;
        add(textField2, gbc);

        // Label + Campo Número
        gbc.gridy++;
        gbc.gridx = 0;
        add(labelNumero, gbc);
        gbc.gridx = 1;
        add(textField3, gbc);

        // Panel de Checkboxes (Temas)
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        JPanel temasPanel = new JPanel(new GridLayout(2, 3, 5, 5));
        temasPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                "Temas del libro",
                TitledBorder.LEFT, TitledBorder.TOP));
        temasPanel.add(romanceCheckBox);
        temasPanel.add(cienciaFiccionCheckBox);
        temasPanel.add(comediaCheckBox);
        temasPanel.add(terrorCheckBox);
        temasPanel.add(historiaCheckBox);
        temasPanel.add(tragediaCheckBox);
        add(temasPanel, gbc);

        // Botones
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        add(guardarLibroButton, gbc);
        gbc.gridx = 1;
        add(leerLibrosCargadosButton, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        add(terminarButton, gbc);

        setVisible(true);
    }

}
