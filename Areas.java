 class Areas {

	public static void main(String[] args) {
		
		Rectangulo rec = new Rectangulo();
		Triangulo tri = new Triangulo();
		
		//Área de rectangulo
		rec.obtenerDatos();
		rec.calculaArea();
		rec.muestraArea();
		
		//Área de triangulo
		tri.obtenerDatos();
		tri.calculaArea();
		tri.muestraArea();

	}

}
