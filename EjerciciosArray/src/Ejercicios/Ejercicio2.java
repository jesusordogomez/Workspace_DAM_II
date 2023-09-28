package Ejercicios;

import java.util.ArrayList;
import java.util.Random;

public class Ejercicio2 {
  public static void main(String[] args) {
    ArrayList<Integer> num = new ArrayList<Integer>();
    Random random = new Random();

    int lista = random.nextInt(11) + 10;
    for (int i = 0; i < lista; i++) {
      num.add(random.nextInt(101));
    }

    int sum = 0;
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int i : num) {
      sum += i;
      if (i < min) {
        min = i;
      }
      if (i > max) {
        max = i;
      }
    }

    double average = (double) sum / lista;
    System.out.println("Longitud de la lista: " + lista);
    System.out.println("Numeros: " + num);
    System.out.println("Suma: " + sum);
    System.out.println("Media: " + average);
    System.out.println("Mínimo: " + min);
    System.out.println("Máximo: " + max);
  }
}