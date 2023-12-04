package Principal;

import javax.swing.SwingUtilities;

import Controlador.ControladorProductos;
import Vista.VistaControlador;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ControladorProductos controlador = new ControladorProductos();
            VistaControlador vista = controlador.getVista();
            vista.setVisible(true);
        });
    }
}
