package com.examen2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CompositeTest {

	

	@Test
	void testSimpleProduct() {
		String name = "Pavilion";
		double price = 4.9;
		String brand = "HP";
		
		assertEquals(4.9,price);
		assertEquals("Pavilion", name);
		assertEquals("HP", brand);
	}
	
	
	@Test
	void  getPrice() {
        double price = 5000d;
        double priceadd = price + 1600;
       assertEquals(6600,priceadd);
    
    }
}
