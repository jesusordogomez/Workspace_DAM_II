package Principal;

import javax.swing.*;
import Controlador.ControladorProfesor;
import Vista.VistaControlador;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ControladorProfesor controlador = new ControladorProfesor();
            VistaControlador vista = controlador.getVista();
            vista.setVisible(true);
        });
    }
}
