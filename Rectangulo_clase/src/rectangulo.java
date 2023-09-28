
public class rectangulo {
	/*Atributos del rectangulo*/
	protected int base;
	protected int altura;
	private long area;
	private long perimetro;
	
	/*Constructores*/
	
	public rectangulo(){
		this.base = 0;
		this.altura = 0;
		this.calcularArea();
		this.calcularPerimetro();
	}
	
	public rectangulo(int base, int altura) {
		this.base = base;
		this.altura = altura;
		this.calcularArea();
		this.calcularPerimetro();
	}

	public rectangulo(rectangulo dato) {
		this.base = dato.base;
		this.altura = dato.altura;
		this.calcularArea();
		this.calcularPerimetro();
	}
	
	/*getter y setter*/
	
	public void setBase(int base) {
		this.base=base;		
	}
	
	public void setAltura(int altura) {
		this.altura=altura;
	}
	

	
	public int getBase() {
		return this.base;
	}
	
	public int getAltura() {
		return this.altura;
	}
	
	public long getArea() {
		return this.area;
	}
	
	public long getPerimetro() {
		return this.perimetro;
	}
	
	/*metodos propios de rectangulo*/
	
	public void calcularArea() {
		this.area=this.getBase()*this.getAltura();
	}
	
	public void calcularPerimetro() {
		this.perimetro= 2*(this.getBase()+this.getAltura());
	}
	
	/*toString rectangulo*/
	
	public String toString() {
		String caracter = " ";
		caracter += " RECTANGULO de " + this.getBase() + " x " + this.getAltura();
		caracter += " --> AREA:  " +this.getArea() + " --> PERIMETRO:  " +this.getPerimetro();
		return caracter;
	}
	
	public void informaRectangulo() {
		System.out.println(this.toString());
		
		for (int i=0; i< this.getAltura();i++) {
			for(int j=0; j< this.getBase(); j++) {
				if(i==0|| i==this.getAltura()-1|| j==0|| j==this.getBase()-1) {
					System.out.print(" * ");
				} else {
					System.out.print("   ");
				}
			}
				System.out.println("");
		}
	}
	
	
}
