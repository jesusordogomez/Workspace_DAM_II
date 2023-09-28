
public class principal {

	public static void main(String[] args) {
		
		rectangulo R1 = new rectangulo();
		System.out.println(R1.toString());
		
		System.out.println("------------------------------");
		
		rectangulo R2 = new rectangulo(5, 3);
		System.out.println(R2.toString());
		
		System.out.println("------------------------------");
		
		rectangulo R3 = new rectangulo(R2);
		System.out.println(R3.toString());
		
		System.out.println("------------------------------");
		
		
		
		//modifico valores de R"
		R2.setAltura(R2.getBase());
		R2.calcularArea();
		R2.calcularPerimetro();
		R2.informaRectangulo();
		System.out.println("");
		R3.informaRectangulo();
		
		
		
	}

}
