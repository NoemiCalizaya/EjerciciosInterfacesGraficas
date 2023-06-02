package Ventana1;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Ventana extends JFrame {
    public Ventana() {
        setTitle("Ventana con GridLayout");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear el GridLayout con 2 filas y 3 columnas
        setLayout(new GridLayout(2, 3));

        // Agregar etiquetas a la ventana utilizando el GridLayout
        add(new JLabel("Widget 1"));
        add(new JLabel("Widget 2"));
        add(new JLabel("Widget 3"));
        add(new JLabel("Widget 4"));
        add(new JLabel("Widget 5"));
        add(new JLabel("Widget 6"));
        
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }
}

