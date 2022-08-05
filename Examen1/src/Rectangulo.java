public class Rectangulo extends FiguraGeometrica implements InterfaceArea {
	
	//implementación del método abstracto muestraArea
	@Override
	public void muestraArea() {
		System.out.println("El área del rectangulo es: " + super.area);
	}
	 //implementación del método abstracto calculaArea
	@Override
	public void calculaArea() {
		super.area = (super.base * super.altura);
	}
	
	
}