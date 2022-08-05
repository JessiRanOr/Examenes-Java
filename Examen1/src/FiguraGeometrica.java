import java.util.Scanner;

//clase abstracta: declara la existencia de métodos pero no los implementa
public abstract class FiguraGeometrica {
	int base;
	int altura;
	int area;

	
	//método obtener datos
	public void obtenerDatos() {
		Scanner lectura = new Scanner(System.in);
		
		System.out.println("Dame valor entero de la base: ");
		base = lectura.nextInt();
		
		System.out.println("Dame valor entero de la altura: ");
		altura = lectura.nextInt();
		
	}

	//método abstracto para mostrar el área: la implementación la realizan las subclases
	public abstract void muestraArea();
	
	

}
