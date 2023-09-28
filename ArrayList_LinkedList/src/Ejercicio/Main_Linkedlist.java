package Ejercicio;

import java.util.Iterator;
import java.util.LinkedList;

public class Main_Linkedlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  LinkedList<Vehiculo> vehiculos = new LinkedList();
	        int coche=0 , camion=0, furgoneta=0, moto=0;
	        for(int i=0;i<1000;i++) {
	            int numero = (int)(Math.random()*4);
	            if(numero==0) {
	                Vehiculo veh1= new Vehiculo (i,"Coche");
	                vehiculos.add(veh1);
	            }
	            if(numero==1) {
	                Vehiculo veh1= new Vehiculo (i,"Camion");
	                vehiculos.add(veh1);
	            }
	            if(numero==2) {
	                Vehiculo veh1= new Vehiculo (i,"Furgoneta");
	                vehiculos.add(veh1);
	            }
	            if(numero==3) {
	                Vehiculo veh1= new Vehiculo (i,"Moto");
	                vehiculos.add(veh1);
	            }

	        }
	        
	        for(Vehiculo vehiculo:vehiculos) {
	            if(vehiculo.tipo.equalsIgnoreCase("Coche")) {
	                coche=coche+1;
	            }
	            if(vehiculo.tipo.equalsIgnoreCase("camion")) {
	                camion=camion+1;
	            }
	            if(vehiculo.tipo.equalsIgnoreCase("furgoneta")) {
	                furgoneta=furgoneta+1;
	            }
	            if(vehiculo.tipo.equalsIgnoreCase("moto")) {
	                moto=moto+1;
	            }
	        }
	        System.out.println(" Tipos de vehiculos:");
	        System.out.println(" ");
	        System.out.println("Numero de coches: " +coche);
	        System.out.println("Numero de camiones: " +camion);
	        System.out.println("Numero de furgonetas: " +furgoneta);
	        System.out.println("Numero de motos: " +moto);
	        
	        
	        System.out.println(" ");
	        System.out.println("------------------------------------------");
	        System.out.println("Vehiculos solo de coches:");
	        System.out.println(" ");
	        
	        Iterator <Vehiculo> iterador= vehiculos.iterator();
	        
	        while(iterador.hasNext()) {
	            Vehiculo v=iterador.next() ;
	            if(!v.tipo.equals("Coche")) {
	                iterador.remove();
	            }           
	        }
	        
	        for(Vehiculo soloCoches: vehiculos ) {
	            System.out.println(soloCoches);
	        }
	        System.out.println(" ");
	        System.out.println("------------------------------------------");
	        System.out.println("Coches nuevos:");
	        System.out.println(" ");
	        int Ultimo = vehiculos.size()-1;
	        Vehiculo UltimoVehiculo = vehiculos.get(Ultimo);
	        int UltimoID = UltimoVehiculo.idVehiculo;
	        
	        for( int i= vehiculos.size(); i<1000;i++) {
	        	UltimoID++;
	        	vehiculos.add(new Vehiculo(UltimoID, "Coche"));   
	        }
	        
	        for(Vehiculo soloCoches: vehiculos ) {
	            System.out.println(soloCoches);
	        }    
	    }
	}

