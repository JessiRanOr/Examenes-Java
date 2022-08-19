package com.calculadora.v7;

public class Suma implements Operacion {

	int x;
	int y;
	
	public Suma(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Suma:[x=" + x + ", y=" + y + "]";
	}
	
	@Override
	public int ejecuta(){
		return x+y;
	}
	
	public int ejecutaImaginario() {
		return x+y+1000;
	}

}
