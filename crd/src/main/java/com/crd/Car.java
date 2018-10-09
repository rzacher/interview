/**
 * Car class provides basic operations on a car. 
 */

package com.crd;


public class Car {
	Size size; 
	Long id; 

	public Car(Size size, Long id) {
		this.size = size;
		this.id = id; 
	}

	public Long getId() { 
		return id;
	}

	public Size getSize() {
		return size; 
	}
}