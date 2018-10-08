package com.crd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import com.crd.Car; 
import com.crd.Size;

public class CarTest {
	@Test
    public void constructorTest() {
        Car car = new Car(Size.SMALL, new Long(1));
        assertEquals("Size", car.getSize(), com.crd.Size.SMALL);
        assertEquals("ID", car.getId(), new Long(1));
    }
	

}