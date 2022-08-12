package com.examen2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CompositeTest {
	

	

	@Test
	void testSimpleProduct() {
		double price = 4.9;
	
		assertEquals(4.9,price);
	}
	
	
	@Test
	void  getPrice() {
        double price = 5000d;
        double priceadd = price + 1600;
       assertEquals(6600,priceadd);
    
    }
}
