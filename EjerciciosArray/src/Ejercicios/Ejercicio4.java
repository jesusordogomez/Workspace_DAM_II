package Ejercicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Ejercicio4 {
  public static void main(String[] args) {
    ArrayList<Carta> cartas = new ArrayList<Carta>();
    Random random = new Random();

    String[] palos = {"Bastos", "Copas", "Espadas", "Oros"};
    String[] numeros = {"As", "2", "3", "4", "5", "6", "7", "Sota", "Caballo", "Rey"};

    while (cartas.size() < 10) {
      int randomPalo = random.nextInt(4);
      int randomNumero = random.nextInt(10);

      Carta carta = new Carta(palos[randomPalo], numeros[randomNumero]);
      if (!cartas.contains(carta)) {
        cartas.add(carta);
      }
    }

    Collections.sort(cartas);

    System.out.println("Cartas ordenadas:");
    for (Carta carta : cartas) {
      System.out.println(carta.toString());
    }
  }
}

class Carta implements Comparable<Carta> {
  private String palo;
  private String numero;

  public Carta(String palo, String numero) {
    this.palo = palo;
    this.numero = numero;
  }

  public String getPalo() {
    return palo;
  }

  public String getNumero() {
    return numero;
  }

  @Override
  public int compareTo(Carta o) {
    if (!this.palo.equals(o.palo)) {
      return this.palo.compareTo(o.palo);
    } else {
      return this.numero.compareTo(o.numero);
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Carta carta = (Carta) obj;
    return palo.equals(carta.palo) && numero.equals(carta.numero);
  }

  @Override
  public int hashCode() {
    int result = palo.hashCode();
    result = 31 * result + numero.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return palo + " " + numero;
  }
}