package Controlador;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import Vista.VistaControlador;

public class ControladorProfesor {

    private Map<String, Double> notas;
    private VistaControlador vista;

    public ControladorProfesor() {
        notas = new HashMap<>();
        vista = new VistaControlador();

        vista.getBtnAgregar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarNota();
            }
        });

        vista.getBtnModificar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (notas.isEmpty()) {
                    JOptionPane.showMessageDialog(vista, "No hay alumnos para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    modificarNota();
                }
            }
        });

        vista.getBtnEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (notas.isEmpty()) {
                    JOptionPane.showMessageDialog(vista, "No hay alumnos para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    eliminarNota();
                }
            }
        });

        vista.getBtnListar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (notas.isEmpty()) {
                    JOptionPane.showMessageDialog(vista, "No hay alumnos para listar.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    listarNotas();
                }
            }
        });

    vista.getBtnCalcularMedia().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            calcularMedia();
        }
    });
    }
    private void calcularMedia() {
        try {
            String nombre = JOptionPane.showInputDialog(vista, "Ingrese el nombre del estudiante:", "Calcular Media", JOptionPane.PLAIN_MESSAGE);
            if (nombre == null) {
                return;
            }

            double sumaNotas = 0;
            int contador = 0;

            for (Map.Entry<String, Double> entry : notas.entrySet()) {
                if (entry.getKey().startsWith(nombre)) {
                    sumaNotas += entry.getValue();
                    contador++;
                }
            }

            if (contador > 0) {
                double media = sumaNotas / contador;
                JOptionPane.showMessageDialog(vista, "La media de las notas para " + nombre + " es: " + media, "Media de Notas", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(vista, "No hay notas para el estudiante " + nombre, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "La nota debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void agregarNota() {
        try {
            String nombre = JOptionPane.showInputDialog(vista, "Ingrese el nombre del estudiante:", "Agregar Nota", JOptionPane.PLAIN_MESSAGE);
            String asignatura = JOptionPane.showInputDialog(vista, "Ingrese la asignatura:", "Agregar Nota", JOptionPane.PLAIN_MESSAGE);
            String notaStr = JOptionPane.showInputDialog(vista, "Ingrese la nota:", "Agregar Nota", JOptionPane.PLAIN_MESSAGE);

            if (nombre == null || asignatura == null || notaStr == null) {
                return;
            }

            double nota = Double.parseDouble(notaStr);
            notas.put(nombre + " - " + asignatura, nota);
            limpiarCampos();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "La nota debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void modificarNota() {
        try {
            String nombre = JOptionPane.showInputDialog(vista, "Ingrese el nombre del estudiante:", "Modificar Nota", JOptionPane.PLAIN_MESSAGE);
            String asignatura = JOptionPane.showInputDialog(vista, "Ingrese la asignatura:", "Modificar Nota", JOptionPane.PLAIN_MESSAGE);
            String nuevaNotaStr = JOptionPane.showInputDialog(vista, "Ingrese la nueva nota:", "Modificar Nota", JOptionPane.PLAIN_MESSAGE);

            if (nombre == null || asignatura == null || nuevaNotaStr == null) {
                return;
            }

            double nuevaNota = Double.parseDouble(nuevaNotaStr);

            String clave = nombre + " - " + asignatura;
            if (notas.containsKey(clave)) {
                notas.put(clave, nuevaNota);
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(vista, "El estudiante no existe en la lista.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "La nota debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarNota() {
        try {
            String nombre = JOptionPane.showInputDialog(vista, "Ingrese el nombre del estudiante:", "Eliminar Nota", JOptionPane.PLAIN_MESSAGE);
            String asignatura = JOptionPane.showInputDialog(vista, "Ingrese la asignatura:", "Eliminar Nota", JOptionPane.PLAIN_MESSAGE);

            if (nombre == null || asignatura == null) {
                return;
            }

            String clave = nombre + " - " + asignatura;
            if (notas.containsKey(clave)) {
                notas.remove(clave);
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(vista, "El estudiante no existe en la lista.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "La nota debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void listarNotas() {
        vista.getTaListaNotas().setText("");
        for (Map.Entry<String, Double> entry : notas.entrySet()) {
            vista.getTaListaNotas().append(entry.getKey() + ": " + entry.getValue() + "\n");
        }
    }

    private void limpiarCampos() {
        vista.getTaListaNotas().setText("");
    }

    public VistaControlador getVista() {
        return vista;
    }
}