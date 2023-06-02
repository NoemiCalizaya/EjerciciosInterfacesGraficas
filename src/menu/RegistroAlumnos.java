package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class RegistroAlumnos extends JFrame {

    private List<String> listaAlumnos;

    public RegistroAlumnos() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Registro de Alumnos");
        setSize(300, 200);
        listaAlumnos = new ArrayList<>();

        // Crea la barra de menú
        JMenuBar menuBar = new JMenuBar();

        // Crea el menú "Alumnos"
        JMenu menuAlumnos = new JMenu("Alumnos");

        // Crea el elemento de menú "Registrar"
        JMenuItem menuItemRegistrar = new JMenuItem("Registrar");
        menuItemRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String alumno = JOptionPane.showInputDialog("Ingrese el nombre del alumno:");
                if (alumno != null && !alumno.isEmpty()) {
                    listaAlumnos.add(alumno);
                    JOptionPane.showMessageDialog(null, "Alumno registrado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese un nombre de alumno válido.");
                }
            }
        });

        // Crea el elemento de menú "Mostrar Lista"
        JMenuItem menuItemMostrarLista = new JMenuItem("Mostrar Lista");
        menuItemMostrarLista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder();
                if (listaAlumnos.isEmpty()) {
                    sb.append("No hay alumnos registrados.");
                } else {
                    sb.append("Lista de Alumnos:\n");
                    for (String alumno : listaAlumnos) {
                        sb.append(alumno).append("\n");
                    }
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });

        // Agrega los elementos de menú al menú "Alumnos"
        menuAlumnos.add(menuItemRegistrar);
        menuAlumnos.add(menuItemMostrarLista);

        // Agrega el menú "Alumnos" a la barra de menú
        menuBar.add(menuAlumnos);

        // Establece la barra de menú en el marco
        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        RegistroAlumnos frame = new RegistroAlumnos();
        frame.setVisible(true);
    }
}

