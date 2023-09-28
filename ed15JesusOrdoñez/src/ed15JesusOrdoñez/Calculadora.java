package ed15JesusOrdoñez;

public class Calculadora {

		private Integer pantalla;
		
		public Calculadora() {
			pantalla = 0;
		}
		
		/** Suma al n�mero en pantalla el n�mero indicado por par�metro */
		public void suma(Integer numero) {
			pantalla += numero;
		}

		/** Resta al n�mero en pantalla el n�mero indicado por par�metro */
		public void resta(Integer numero) {
			pantalla -= numero;
		}

		/** Multiplica el n�mero en pantalla por el n�mero indicado por par�metro */
		public void multiplica(Integer numero) {
			pantalla = pantalla * numero;
		}

		/** Divide el n�mero en pantalla por n�mero indicado por par�metro si este es distinto de cero */
		public void divide(Integer numero) {
			if (numero != 0) {
				pantalla = pantalla / numero;
			}
		}

		/** Cambia el n�mero de la pantalla por el tanto por ciento del valor indicado */
		public void porcentaje(Integer numero) {
			pantalla = pantalla * numero / 100;
		}
		
		/** Cambia el numero de la pantalla a cero */
		public void resetea() {
			pantalla = 0;
		}
		
		/** Devuelve el n�mero en pantalla */
		public Integer getPantalla() {
			return pantalla;
		}
		
	}