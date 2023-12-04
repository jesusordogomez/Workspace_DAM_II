package Ejercicios;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

public class Ejercicio5_Concurrente {
    public static void main(String[] args) {
        // Lista grande de números enteros
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

        // Número de partes en las que se dividirá la lista
        int numPartes = 4;

        // Calcula el tamaño de cada parte
        int tamanoParte = (int) Math.ceil((double) numeros.size() / numPartes);

        // Divide la lista en partes
        List<List<Integer>> partes = particionarLista(numeros, tamanoParte);

        // Utiliza Streams paralelos para calcular la suma de cada parte
        ForkJoinPool forkJoinPool = new ForkJoinPool(numPartes);
        int sumaTotal = forkJoinPool.submit(() ->
                partes.parallelStream()
                        .map(part -> part.stream().mapToInt(Integer::intValue).sum())
                        .peek(System.out::println) // Muestra los resultados parciales
                        .reduce(0, Integer::sum) // Suma los resultados parciales
        ).join();

        // Muestra el resultado final
        System.out.println("La suma total es: " + sumaTotal);
    }

    // Método para particionar la lista en partes
    private static <T> List<List<T>> particionarLista(List<T> lista, int tamanoParte) {
        return lista.stream()
                .collect(Collectors.groupingBy(it -> lista.indexOf(it) / tamanoParte))
                .values().stream()
                .collect(Collectors.toList());
    }
}
