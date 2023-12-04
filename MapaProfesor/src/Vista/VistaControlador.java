package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaControlador extends JFrame {

    private JTextArea taListaNotas;
    private JButton btnAgregar;
    private JButton btnModificar;
    private JButton btnEliminar;
    private JButton btnListar;
    private JButton btnCalcularMedia;

    public VistaControlador() {
        setTitle("Gestión de Notas");
        setSize(600, 200); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 5));

        btnAgregar = boton("Agregar");
        btnModificar = boton("Modificar");
        btnEliminar = boton("Eliminar");
        btnListar = boton("Listar");
        btnCalcularMedia = boton("Calcular Media");
 

        panelBotones.add(btnAgregar);
        panelBotones.add(btnModificar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnListar);
        panelBotones.add(btnCalcularMedia);

        JPanel panelPrincipal = new JPanel(new BorderLayout());

        taListaNotas = new JTextArea();
        taListaNotas.setEditable(false);
        
        JScrollPane scrollPane = new JScrollPane(taListaNotas);
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.NORTH);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panelPrincipal);
    }
    private JButton boton(String text) {
        JButton button = new JButton(text);
        button.setBackground(Color.YELLOW); 
        button.setForeground(Color.BLACK);  
        button.setFocusPainted(false);
        return button;
    }
    public JTextArea getTaListaNotas() {
        return taListaNotas;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public JButton getBtnModificar() {
        return btnModificar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JButton getBtnListar() {
        return btnListar;
    }
    public JButton getBtnCalcularMedia() {
        return btnCalcularMedia;
    }
}
