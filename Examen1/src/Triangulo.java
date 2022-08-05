public class Triangulo extends FiguraGeometrica implements InterfaceArea{
	
	
	
	public void muestraArea() {
		System.out.println("El área del triangulo es: " + super.area);
	}
	public void calculaArea() {
		super.area = ((super.base * super.altura)/2);
	}
	
	
}
