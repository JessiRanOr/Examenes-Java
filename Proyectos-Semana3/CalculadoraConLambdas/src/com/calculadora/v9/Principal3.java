package com.calculadora.v9;

import java.util.*;
import java.util.function.IntBinaryOperator;
import java.lang.Math;

public class Principal3 {

	public static void main(String[] args) {
		//potencia y raiz con lambdas
		IntBinaryOperator potencia = (x,y) -> (int)Math.pow(x,y);
		IntBinaryOperator raiz = (x,y) -> (int)Math.sqrt(x);
		
		IntBinaryOperator suma = (x,y) -> x+y;
		IntBinaryOperator resta = (x,y) -> x-y;
		IntBinaryOperator multi = (x,y) -> x*y;
		IntBinaryOperator div = (x,y) -> {
			int res = -1000;
			try {
				res = x/y;
			}catch(ArithmeticException e) {
				System.out.println("No se puede dividir entre 0");
				throw new UnsupportedOperationException();
			}
			return res;
		};
		
		
		List<IntBinaryOperator> listOpe = new ArrayList<>();
		listOpe.add(raiz);
		listOpe.add(potencia);
		listOpe.add(suma); //0
		listOpe.add(div); //1
		listOpe.add(resta); //2
		listOpe.add(multi); //3
		

		ejecutaOperaciones(listOpe);
	}
	
	static void ejecutaOperaciones(
			List<IntBinaryOperator> listOperaciones) {
		for (IntBinaryOperator ope:listOperaciones) { 
		
			try {
				System.out.println(ope.applyAsInt(9, 4));
			}catch(UnsupportedOperationException e) {
				System.out.println("La división no se pudo realizar");
			}
		
			
		}
	}
}
