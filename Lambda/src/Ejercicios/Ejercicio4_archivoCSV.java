package Ejercicios;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio4_archivoCSV {

    public static void main(String[] args) {
        // Ruta del archivo CSV
        String rutaArchivo = "ruta/al/archivo.csv";

        try {
            // Lee el archivo CSV y calcula el precio medio utilizando una función lambda
            double precioMedio = calcularPrecioMedio(rutaArchivo);

            // Muestra el resultado en la consola
            System.out.println("El precio medio de los productos es: $" + precioMedio);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double calcularPrecioMedio(String rutaArchivo) throws IOException {
        // Crea un lector de CSV
        CSVReader reader = new CSVReaderBuilder(new FileReader(rutaArchivo)).build();

        // Lee todas las líneas del archivo CSV
        List<String[]> lineas = reader.readAll();

        // Cierra el lector de CSV
        reader.close();

        // Utiliza una función lambda para convertir cada línea a un Double y luego calcula el precio medio
        return lineas.stream()
                .mapToDouble(linea -> Double.parseDouble(linea[2])) // Suponiendo que el precio está en la tercera columna (índice 2)
                .average()
                .orElse(0.0); // Valor predeterminado si no hay productos o el archivo está vacío
    }
}