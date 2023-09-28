package Ejercicio;

import java.util.ArrayList;

public class Parking {
	private ArrayList<String> matriculas;
    private String nombre;
    
    public Parking(String nombre, int numPlazas) {
        this.nombre = nombre;
        this.matriculas = new ArrayList<>(numPlazas);
        for (int i = 0; i < numPlazas; i++) {
            this.matriculas.add(null);
        }
    }

    public String getNombre() {
        return this.nombre;
    }

    public void entrada(String matricula, int plaza) throws ParkingException {
        if (matricula == null || matricula.length() < 4) {
            throw new ParkingException("Matricula incorrecta",matricula);
        }
        if(plaza<0 || plaza>matriculas.size()) {
        	throw new ParkingException("Numero de plaza incorrecto",matricula);
        }
        if (this.matriculas.get(plaza) != null) {
            throw new ParkingException("Plaza ocupada",matricula);
        }
        if (this.matriculas.contains(matricula)) {
            throw new ParkingException("Matricula repetida",matricula);
        }
        this.matriculas.set(plaza, matricula);
    }

    public int salida(String matricula) throws Exception {
        int plaza = this.matriculas.indexOf(matricula);
        if (plaza == -1) {
            throw new Exception("Matrícula no existente");
        }
        this.matriculas.set(plaza, null);
        return plaza;
    }

    public int getPlazasTotales() {
        return this.matriculas.size();
    }

    public int getPlazasOcupadas() {
        int ocupadas = 0;
        for (String matricula : this.matriculas) {
            if (matricula != null) {
                ocupadas++;
            }
        }
        return ocupadas;
    }

    public int getPlazasLibres() {
        return this.getPlazasTotales() - this.getPlazasOcupadas();
    }
    public String toString() {
        String cadena = this.nombre + "\n----------------\n";
        for (int i = 0; i < this.matriculas.size(); i++) {
        	cadena += "Plaza " + i + ": ";
            if (this.matriculas.get(i) == null) {
            	cadena += "-vacia-\n";
            } else {
            	cadena += this.matriculas.get(i) + "\n";
            }
        }
        return cadena;
    }

}