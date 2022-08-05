class Areas {

	public static void main(String[] args) {
		
		Rectangulo rec = new Rectangulo();
		Triangulo tri = new Triangulo();
		
		System.out.println("Vamos a obtener área de un rectangulo");	
		
		//Área de rectangulo
		rec.obtenerDatos();
		rec.calculaArea();
		rec.muestraArea();
		
		
		System.out.println("Ahora vamos a obtener área de un triangulo");
		//Área de triangulo
		tri.obtenerDatos();
		tri.calculaArea();
		tri.muestraArea();

	}

}
