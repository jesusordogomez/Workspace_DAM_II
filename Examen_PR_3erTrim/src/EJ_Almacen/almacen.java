package EJ_Almacen;
/** CLASE ALMACÉN. 
 * Clase para incluir todo el código
 * para generar fichero aleatorio del almacén.
 * 
 * @author Juan Carlos
 * @version 1.0
 * @date May/2023
 *
 * @fichero almacen.dat
 * 
 * Nombre de fichero: "ALMACEN.DAT"
 */		

import java.io.*;
import java.util.Scanner;
public class almacen {
	// INSERTAR TODO EL CóDIGO NECESARIO PARA GESTIONAR EL FICHERO
	// Y RESOLVER EJERCICIO EXAMEN.
    private static final String FILE_PATH = "almacen.dat";
    private static final int RECORD_SIZE = 160;

    public static void main(String[] args) {
        try {
            insertarDatos();
            costeAlmacen();
            String codigoArticuloAEliminar = "AAA002";
            bajaArticulo(codigoArticuloAEliminar);
            String codigoArticuloVenta = "AAA010";
            int unidadesVenta = 3; 
            venta(codigoArticuloVenta, unidadesVenta);
            listarArticulos();
            int posicionRegistro = 6; 
            mostrarInformacionArticulo(posicionRegistro);
        } catch (IOException e) {
            e.printStackTrace();
        }   
    }
    public static void insertarDatos() throws IOException {
        RandomAccessFile file = new RandomAccessFile(FILE_PATH, "rw");

        String[] cod = {"AAA001","AAA002", "AAA003", "AAA004", "AAA005", "AAA006", "AAA007", "AAA008", "AAA009", "AAA010"};
        String[] descr = {"Camisa", "Pantalón", "Zapatos", "Reloj", "Teléfono", "Cámara", "Libro", "Bolígrafo", "Mochila", "Lámpara"};
        String[] caract = {"Azul", "Negro", "Marrón","Plateado", "Negro", "20MP", "Miedo","Azul", "Gris", "Sobremesa"};
        String[] depart = {"Ropa", "Ropa", "Calzado", "Accesorios", "Electrónica", "Electrónica","Libros", "Papelería", "Bolsos", "Iluminación"};
        double[] precio = {29.99, 49.99, 89.99, 199.99, 799.99, 399.99, 19.99, 1.99, 39.99, 24.99};
        int[] unidades = {50, 30, 20, 10, 5, 8, 12, 100, 15, 25};
        String[] proveedor = {"Fabricante A", "Fabricante B", "Fabricante C", "Fabricante D", "Fabricante E","Fabricante F", "Editorial G", "Fabricante H", "Fabricante I", "Fabricante J"};

        for (int i = 0; i < 10; i++) {
            articulos articulo = new articulos(cod[i], descr[i], caract[i],depart[i], precio[i], unidades[i], proveedor[i]);
            escribirRegistro(file, articulo, i);
        }

        file.close();
    }
    

    public static void escribirRegistro(RandomAccessFile file, articulos articulo, int posicion) throws IOException {
        file.seek(posicion * RECORD_SIZE);
        escribirString(file, articulo.getCod_art(), 6);
        escribirString(file, articulo.getDescr(), 20);
        escribirString(file, articulo.getCaract(), 20);
        escribirString(file, articulo.getDepart(), 10);
        file.writeDouble(articulo.getPrecio());
        file.writeInt(articulo.getUnidades());
        escribirString(file, articulo.getProveedor(), 20);
    }

    public static void escribirString(RandomAccessFile file, String cadena, int longitud) throws IOException {
        StringBuilder builder = new StringBuilder(cadena);
        builder.setLength(longitud);
        file.writeChars(builder.toString());
    }

    public static void costeAlmacen() throws IOException {
        RandomAccessFile file = new RandomAccessFile(FILE_PATH, "r");
        int numRegistros = (int) (file.length() / RECORD_SIZE);

        double costeTotal = 0.0;

        for (int i = 0; i < numRegistros; i++) {
            articulos articulo = leerRegistro(file, i);
            costeTotal += articulo.getPrecio() * articulo.getUnidades();
        }

        System.out.println("El coste del stock del almacen es: " + costeTotal + " €\n");

        file.close();
    }

    public static articulos leerRegistro(RandomAccessFile file, int posicion) throws IOException {
        file.seek(posicion * RECORD_SIZE);

        String codigoArticulo = leerString(file, 6);
        String descripcion = leerString(file, 20);
        String caracteristicas = leerString(file, 20);
        String departamento = leerString(file, 10);
        double precio = file.readDouble();
        int unidades = file.readInt();
        String proveedor = leerString(file, 20);

        return new articulos(codigoArticulo, descripcion, caracteristicas, departamento, precio, unidades, proveedor);
    }

    public static String leerString(RandomAccessFile file, int longitud) throws IOException {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < longitud; i++) {
            builder.append(file.readChar());
        }

        return builder.toString().trim();
    }

    public static void bajaArticulo(String codigoArticulo) throws IOException {
        RandomAccessFile file = new RandomAccessFile(FILE_PATH, "rw");
        int numRegistros = (int) (file.length() / RECORD_SIZE);

        for (int i = 0; i < numRegistros; i++) {
            articulos articulo = leerRegistro(file, i);
            if (articulo.getCod_art().equals(codigoArticulo)) {
                articulo.setCod_art(""); 
                escribirRegistro(file, articulo, i);
                System.out.println("Articulo eliminado correctamente."+ articulo);
                break;
            }
        }

        file.close();
    }

    public static void venta(String codigoArticulo, int unidadesVenta) throws IOException {
        RandomAccessFile file = new RandomAccessFile(FILE_PATH, "rw");
        int numRegistros = (int) (file.length() / RECORD_SIZE);

        for (int i = 0; i < numRegistros; i++) {
            articulos articulo = leerRegistro(file, i);
            if (articulo.getCod_art().equals(codigoArticulo)) {
                if (articulo.getUnidades() >= unidadesVenta) {
                    articulo.setUnidades(articulo.getUnidades() - unidadesVenta);
                    escribirRegistro(file, articulo, i);
                    System.out.println("Venta realizada: "+ articulo);
                } else {
                    System.out.println("No es posible la venta");
                }
                break;
            }
        }

        file.close();
    }

    public static void listarArticulos() throws IOException {
        RandomAccessFile file = new RandomAccessFile(FILE_PATH, "r");
        int numRegistros = (int) (file.length() / RECORD_SIZE);

        System.out.println("\t Stock articulos:");
        System.out.println("-------------------------------------------------------------------");

        for (int i = 0; i < numRegistros; i++) {
            articulos articulo = leerRegistro(file, i);
            if (!articulo.getCod_art().isEmpty()) {
                System.out.println(articulo);
            }
        }

        file.close();
    }

    public static void mostrarInformacionArticulo(int posicionRegistro) throws IOException {
        RandomAccessFile file = new RandomAccessFile(FILE_PATH, "r");

        if (posicionRegistro >= 0 && posicionRegistro < file.length() / RECORD_SIZE) {
            articulos articulo = leerRegistro(file, posicionRegistro);
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Datos del articulo " + (posicionRegistro + 1) + ":");
            System.out.println(articulo);
        } else {
            System.out.println("Error");
        }

        file.close();
    }
}


/*1. Tamaño del fichero: 1604 bytes
2. Número de registros en el fichero: 10
3. Tamaño de un registro: 160 bytes*/