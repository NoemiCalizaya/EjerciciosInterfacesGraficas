package uso_jlist;

import javax.swing.*;
import java.awt.*;

public class GridLayoutWithJListExample extends JFrame {

    public GridLayoutWithJListExample() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("GridLayout with JList Example");

        // Crear un contenedor con GridLayout de 1 fila y 1 columna
        JPanel panel = new JPanel(new GridLayout(1, 1));
        getContentPane().add(panel);

        // Crear un modelo de lista y agregar elementos
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Elemento 1");
        listModel.addElement("Elemento 2");
        listModel.addElement("Elemento 3");
        listModel.addElement("Elemento 4");
        listModel.addElement("Elemento 5");

        // Crear una JList con el modelo de lista
        JList<String> list = new JList<>(listModel);

        // Agregar la JList al panel
        panel.add(list);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GridLayoutWithJListExample example = new GridLayoutWithJListExample();
                example.setVisible(true);
            }
        });
    }
}

