package Ejercicio3;

	public class Television extends Electrodomestico {
		
		/*atributos*/
		
		protected int pulgadas;
		protected boolean tdt;
		protected static final int PULGADAS=20;
		protected static final boolean TDT=false;
		protected static final String TIPO="television";
		
		/*getters y setters*/
		
		public int getPulgadas() {
			return pulgadas;
		}
		public void setPulgadas(int pulgadas) {
			this.pulgadas = pulgadas;
		}
		public boolean isTdt() {
			return tdt;
		}
		public void setTdt(boolean tdt) {
			this.tdt = tdt;
		}

		/*constructores*/

		public Television() {
			super();
			this.precioBase=PRECIOBASE;
			this.peso=PESO;
			this.color=COLOR;
			this.consumo=CONSUMO;
			this.pulgadas=PULGADAS;
			this.tdt=TDT;
			this.tipo=TIPO;
		}
		public Television(double precioBase, int peso, String color, char consumo, int pulgadas, boolean tdt) {
			super(precioBase, peso, color, consumo);
			this.pulgadas=pulgadas;
			this.tdt=tdt;
			this.tipo=TIPO;
			comprobarConsumoEnergetico(getConsumo());
			comprobarColor(getColor());
		}
		public Television(double precioBase, int peso) {
			super(precioBase, peso);
			this.color=COLOR;
			this.consumo=CONSUMO;
			this.pulgadas=PULGADAS;
			this.tdt=TDT;
			this.tipo=TIPO;
		}
		
		/*metodos*/
		
		public void precioFinal(){
			super.precioFinal();
			if (getPulgadas()>40) setPrecioBase(getPrecioBase()*1.3);
			if (isTdt()==true) setPrecioBase(getPrecioBase()+50);
		}
}
