
class Areas {

	public static void main(String[] args) {
		
		FiguraGeometrica fig1 = new Rectangulo();
		calculos(fig1);

		FiguraGeometrica fig2 = new Triangulo();
		calculos(fig2);

	}

	private static void calculos(FiguraGeometrica fig) {
		System.out.println("Ahora vamos a obtener área de un: "+
				fig.toString());
		fig.obtenerDatos();
		((InterfaceArea)fig).calculaArea();//Polimorfismo
		fig.muestraArea();

	}

}

