package menu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MenuInteractivo extends JFrame {

    private List<Persona> listaPersonas;
    private JPanel formularioPanel;
    private JTextField nombreTextField;
    private JTable tablaPersonas;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;

    public MenuInteractivo() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Menú Interactivo");
        setSize(400, 500);
        setLocationRelativeTo(null);
        listaPersonas = new ArrayList<>();

        // Crea la barra de menú
        JMenuBar menuBar = new JMenuBar();

        // Crea el menú "Personas"
        JMenu menuPersonas = new JMenu("Personas");

        // Crea el elemento de menú "Registrar"
        JMenuItem menuItemRegistrar = new JMenuItem("Registrar");
        menuItemRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarFormularioRegistro();
            }
        });

        // Crea el elemento de menú "Lista de Personas"
        JMenuItem menuItemListaPersonas = new JMenuItem("Lista de Personas");
        menuItemListaPersonas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarListaPersonas();
            }
        });

        // Agrega los elementos de menú al menú "Personas"
        menuPersonas.add(menuItemRegistrar);
        menuPersonas.add(menuItemListaPersonas);

        // Agrega el menú "Personas" a la barra de menú
        menuBar.add(menuPersonas);

        // Establece la barra de menú en el panel de contenido (content pane)
        setJMenuBar(menuBar);

        // Obtiene el panel de contenido (content pane) y establece su diseño como BorderLayout
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        
        JPanel inicio = new JPanel(new FlowLayout());
        JLabel titulo = new JLabel("Registro de Personas");
        titulo.setFont(new Font("Arial", 0, 23));
        inicio.add(titulo);
        contentPane.add(inicio, BorderLayout.NORTH);
        inicio.setVisible(true);

        // Crea un panel para el formulario de registro
        formularioPanel = new JPanel(new FlowLayout());

        // Crea un campo de texto para ingresar el nombre de la persona
        nombreTextField = new JTextField(20);
        formularioPanel.add(new JLabel("Nombre:"));
        formularioPanel.add(nombreTextField);

        // Crea el botón "Registrar"
        JButton botonRegistrar = new JButton("Registrar");
        botonRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreTextField.getText();
                if (!nombre.isEmpty()) {
                    Persona persona = new Persona(nombre);
                    listaPersonas.add(persona);
                    JOptionPane.showMessageDialog(null, "Persona registrada correctamente.");
                    ocultarFormularioRegistro();
                    nombreTextField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese un nombre válido.");
                }
            }
        });
        formularioPanel.add(botonRegistrar);

        // Agrega el panel de formulario al centro del panel de contenido
        contentPane.add(formularioPanel, BorderLayout.EAST);

        // Crea un modelo de tabla
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nombre");

        // Crea una tabla con el modelo de tabla
        tablaPersonas = new JTable(tableModel);

        // Agrega la tabla a un JScrollPane
        scrollPane = new JScrollPane(tablaPersonas);

        // Agrega el JScrollPane al centro del panel de contenido
        contentPane.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setVisible(false);
        
        formularioPanel.setVisible(false);
    }

    private void mostrarFormularioRegistro() {
    	scrollPane.setVisible(false);
        formularioPanel.setVisible(true);
    }

    private void ocultarFormularioRegistro() {
        formularioPanel.setVisible(false);
    }

    private void mostrarListaPersonas() {
    	formularioPanel.setVisible(false);
        tableModel.setRowCount(0);
        for (Persona persona : listaPersonas) {
            Object[] row = {persona.getNombre()};
            tableModel.addRow(row);
        }
        scrollPane.setVisible(true);
    }

    public static void main(String[] args) {
        MenuInteractivo frame = new MenuInteractivo();
        frame.setVisible(true);
    }

    private class Persona {
        private String nombre;

        public Persona(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }
    }
}
