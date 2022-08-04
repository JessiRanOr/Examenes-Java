
public class Rectangulo extends FiguraGeometrica implements InterfaceArea{
	//implementación del método abstracto muestraArea
	public void muestraArea() {
		System.out.println("El área del rectangulo es: " + super.area);
	}
	 //implementación del método abstracto calculaArea
	public void calculaArea() {
		super.area = (super.ladoA * super.ladoB);
	}
}
