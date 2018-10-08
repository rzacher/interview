package com.crd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.assertEquals;

import com.crd.Customer;

public class CustomerTest {
	@Test
    public void constructorTest() {
       Customer customer = new Customer(new Long(1)); 
       assertEquals("ID", customer.getId(), new Long(1));
    }

}