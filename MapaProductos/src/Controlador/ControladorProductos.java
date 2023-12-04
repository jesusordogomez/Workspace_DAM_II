package Controlador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import Vista.VistaControlador;

public class ControladorProductos {

    private Map<String, Producto> productos;
    private VistaControlador vista;

    public ControladorProductos() {
        productos = new HashMap<>();
        vista = new VistaControlador();

        productos.put("Patatas", new Producto("Patatas", 3.0, 50));
        productos.put("Leche", new Producto("Leche", 2.0, 30));
        productos.put("Huevos", new Producto("Huevos", 4.0, 40));
        productos.put("Cebolla", new Producto("Cebolla", 1.0, 20));
        productos.put("Aceite", new Producto("Aceite", 30.0, 10));

        vista.getBtnAgregar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarProducto();
            }
        });

        vista.getBtnModificar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (productos.isEmpty()) {
                    JOptionPane.showMessageDialog(vista, "No hay productos para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    modificarProducto();
                }
            }
        });

        vista.getBtnVender().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (productos.isEmpty()) {
                    JOptionPane.showMessageDialog(vista, "No hay productos para vender.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    venderProducto();
                }
            }
        });

        vista.getBtnEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (productos.isEmpty()) {
                    JOptionPane.showMessageDialog(vista, "No hay productos para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    eliminarProducto();
                }
            }
        });
        listarProductos();
        vista.getlistaProducto().setEditable(false);
        vista.getContentPane().add(new JScrollPane(vista.getlistaProducto()));

        vista.setSize(400, 300);
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setLayout(new BoxLayout(vista.getContentPane(), BoxLayout.Y_AXIS));
        vista.setVisible(true);
    }

    private void agregarProducto() {
        try {
            String nombre = JOptionPane.showInputDialog(vista, "Introduce el nombre del producto:", "Agregar Producto", JOptionPane.PLAIN_MESSAGE);
            String precioStr = JOptionPane.showInputDialog(vista, "Introduce el precio del producto:", "Agregar Producto", JOptionPane.PLAIN_MESSAGE);
            String cantidadStr = JOptionPane.showInputDialog(vista, "Introduce el stock del productos:", "Agregar Producto", JOptionPane.PLAIN_MESSAGE);

            if (nombre == null || precioStr == null || cantidadStr == null) {
                return;
            }

            double precio = Double.parseDouble(precioStr);
            int cantidad = Integer.parseInt(cantidadStr);

            if (productos.containsKey(nombre)) {
                Producto productoExistente = productos.get(nombre);
                productoExistente.setPrecio(precio);
                productoExistente.setCantidad(productoExistente.getCantidad() + cantidad);
            } else {
                Producto nuevoProducto = new Producto(nombre, precio, cantidad);
                productos.put(nombre, nuevoProducto);
            }

            limpiarCampos();
            listarProductos();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "El precio y la cantidad deben ser números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void modificarProducto() {
        try {
            String nombre = JOptionPane.showInputDialog(vista, "Ingrese el nombre del producto:", "Modificar Producto", JOptionPane.PLAIN_MESSAGE);
            String nuevoPrecioStr = JOptionPane.showInputDialog(vista, "Ingrese el nuevo precio del producto:", "Modificar Producto", JOptionPane.PLAIN_MESSAGE);
            String nuevaCantidadStr = JOptionPane.showInputDialog(vista, "Ingrese la nueva cantidad de productos:", "Modificar Producto", JOptionPane.PLAIN_MESSAGE);

            if (nombre == null || nuevoPrecioStr == null || nuevaCantidadStr == null) {
                return;
            }

            double nuevoPrecio = Double.parseDouble(nuevoPrecioStr);
            int nuevaCantidad = Integer.parseInt(nuevaCantidadStr);

            if (productos.containsKey(nombre)) {
                Producto productoExistente = productos.get(nombre);
                productoExistente.setPrecio(nuevoPrecio);
                productoExistente.setCantidad(nuevaCantidad);
                limpiarCampos();
                listarProductos();
            } else {
                JOptionPane.showMessageDialog(vista, "El producto no existe en la lista.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "El precio y la cantidad deben ser números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarProducto() {
        try {
            String nombre = JOptionPane.showInputDialog(vista, "Introduce el nombre del producto:", "Eliminar Producto", JOptionPane.PLAIN_MESSAGE);

            if (nombre == null) {
                return;
            }

            if (productos.containsKey(nombre)) {
                productos.remove(nombre);
                limpiarCampos();
                listarProductos();
            } else {
                JOptionPane.showMessageDialog(vista, "El producto no existe en la lista.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "La cantidad debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void listarProductos() {
        vista.getlistaProducto().setText("");
        for (Map.Entry<String, Producto> entry : productos.entrySet()) {
            Producto producto = entry.getValue();
            vista.getlistaProducto().append(producto.getNombre() + ": €" + producto.getPrecio() + " - Cantidad: " + producto.getCantidad() + "\n");
        }
    }

    private void venderProducto() {
        try {
            String nombre = JOptionPane.showInputDialog(vista, "Ingrese el nombre del producto:", "Vender Producto", JOptionPane.PLAIN_MESSAGE);
            String productoVendido = JOptionPane.showInputDialog(vista, "Ingrese la cantidad de productos a vender:", "Vender Producto", JOptionPane.PLAIN_MESSAGE);

            if (nombre == null || productoVendido == null) {
                return;
            }

            int cantidadVender = Integer.parseInt(productoVendido);

            if (productos.containsKey(nombre)) {
                Producto productoExistente = productos.get(nombre);
                int cantidadDisponible = productoExistente.getCantidad();

                if (cantidadVender > cantidadDisponible) {
                    JOptionPane.showMessageDialog(vista, "No hay suficientes productos en stock para vender.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    productoExistente.setCantidad(cantidadDisponible - cantidadVender);
                    limpiarCampos();
                    listarProductos();
                }
            } else {
                JOptionPane.showMessageDialog(vista, "El producto no existe en la lista.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "La cantidad debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        vista.getlistaProducto().setText("");
    }

    public VistaControlador getVista() {
        return vista;
    }

    private static class Producto {
        private String nombre;
        private double precio;
        private int cantidad;

        public Producto(String nombre, double precio, int cantidad) {
            this.nombre = nombre;
            this.precio = precio;
            this.cantidad = cantidad;
        }

        public String getNombre() {
            return nombre;
        }

        public double getPrecio() {
            return precio;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }
    }
}
