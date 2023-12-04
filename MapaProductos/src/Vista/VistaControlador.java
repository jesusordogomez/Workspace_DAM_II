package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaControlador extends JFrame {

    private JTextArea listaProducto;
    private JButton btnAgregar;
    private JButton btnModificar;
    private JButton btnVender;
    private JButton btnEliminar;

    public VistaControlador() {
        setTitle("Gestión de Productos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 384, 50); 
        panel.setLayout(new GridLayout(1, 4));
        panel.setBackground(Color.YELLOW);  
        
        btnAgregar = boton("Agregar");
        btnModificar = boton("Modificar");
        btnVender = boton("Vender");
        btnEliminar = boton("Eliminar");

        listaProducto = new JTextArea();
        listaProducto.setEditable(false);

        panel.add(btnAgregar);
        panel.add(btnModificar);
        panel.add(btnVender);
        panel.add(btnEliminar);

        getContentPane().setLayout(null);

        getContentPane().add(panel);
        JScrollPane scrollPane = new JScrollPane(listaProducto);
        scrollPane.setBounds(0, 50, 384, 250);  
        getContentPane().add(scrollPane);
    }

    private JButton boton(String text) {
        JButton button = new JButton(text);
        button.setBackground(Color.YELLOW);  
        button.setForeground(Color.BLACK);  
        button.setFocusPainted(false);
        return button;
    }

    public JTextArea getlistaProducto() {
        return listaProducto;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public JButton getBtnModificar() {
        return btnModificar;
    }

    public JButton getBtnVender() {
        return btnVender;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }
}
