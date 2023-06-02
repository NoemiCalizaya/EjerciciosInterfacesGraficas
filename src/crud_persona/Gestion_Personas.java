package crud_persona;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gestion_Personas extends JFrame {

    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField textFieldNombre;
    private JTextField textFieldEdad;

    public Gestion_Personas() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Registro de Personas");
        setSize(600, 300);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        getContentPane().add(panel);

        // Panel de entrada
        JPanel panelEntrada = new JPanel();
        									//fila - columna
        // Crear un contenedor con GridLayout de 2 filas y 4 columnas
        panelEntrada.setLayout(new GridLayout(2, 4));
        panel.add(panelEntrada, BorderLayout.NORTH);

        // Etiquetas y campos de texto
        JLabel labelNombre = new JLabel("Nombre:");
        textFieldNombre = new JTextField();
        JLabel labelEdad = new JLabel("Edad:");
        textFieldEdad = new JTextField();
        panelEntrada.add(labelNombre);
        panelEntrada.add(textFieldNombre);
        panelEntrada.add(labelEdad);
        panelEntrada.add(textFieldEdad);

        // Botones
        JButton buttonAgregar = new JButton("Agregar");
        							//formato RGB
        buttonAgregar.setBackground(new Color(9, 92, 174));
        buttonAgregar.setForeground(Color.WHITE);
        JButton buttonBuscar = new JButton("Buscar");
        JButton buttonActualizar = new JButton("Actualizar");
        JButton buttonEliminar = new JButton("Eliminar");
        panelEntrada.add(buttonAgregar);
        panelEntrada.add(buttonBuscar);
        panelEntrada.add(buttonActualizar);
        panelEntrada.add(buttonEliminar);

        // Tabla
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Edad");
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Acciones de los botones
        buttonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textFieldNombre.getText();
                String edad = textFieldEdad.getText();
                String[] rowData = {nombre, edad};
                tableModel.addRow(rowData);
                textFieldNombre.setText("");
                textFieldEdad.setText("");
            }
        });

        buttonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textFieldNombre.getText();
                boolean encontrado = false;
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    String nombreTabla = (String) tableModel.getValueAt(i, 0);
                    if (nombreTabla.equals(nombre)) {
                        table.setRowSelectionInterval(i, i);
                        /*"setRowSelectionInterval" es un método que se utiliza para establecer 
                         * el intervalo de selección de filas en una tabla.
							"i" se refiere al índice de la fila que se desea seleccionar. 
							Tanto el primer parámetro como el segundo parámetro están establecidos en
							"i", lo que indica que se está seleccionando una única fila específica.*/
                        table.scrollRectToVisible(table.getCellRect(i, 0, true));
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    JOptionPane.showMessageDialog(null, "Registro no encontrado.");
                }
                else JOptionPane.showMessageDialog(null, "Registro encontrado.");
            }
        });
        
        table.getSelectionModel().addListSelectionListener((ListSelectionListener) new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String nombre = (String) table.getValueAt(selectedRow, 0);
                    String edad = table.getValueAt(selectedRow, 1).toString();
                    textFieldNombre.setText(nombre);
                    textFieldEdad.setText(edad);
                }
            }
        });

        buttonActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String nombre = textFieldNombre.getText();
                    String edad = textFieldEdad.getText();
                    tableModel.setValueAt(nombre, selectedRow, 0);
                    tableModel.setValueAt(edad, selectedRow, 1);
                    textFieldNombre.setText("");
                    textFieldEdad.setText("");
                    table.clearSelection();
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un registro para actualizar.");
                }
            }
        });

        buttonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    tableModel.removeRow(selectedRow);
                    textFieldNombre.setText("");
                    textFieldEdad.setText("");
                    table.clearSelection();
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un registro para eliminar.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Gestion_Personas frame = new Gestion_Personas();
                frame.setVisible(true);
            }
        });
    }
}
