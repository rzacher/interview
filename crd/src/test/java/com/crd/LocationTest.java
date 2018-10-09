/*
 * LocationTest is the most important test class, since the Location class manages the cars, customers and
 * Reservations
 */

package com.crd; 


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;

import java.util.*;  
import java.text.SimpleDateFormat; 
import java.text.ParseException; 

import com.crd.Location; 
import com.crd.Car;
import com.crd.Customer;



public class LocationTest {
	@Test
    public void basicTest() {
        Location location = new Location();
        assertEquals("Result", 1, 1);
    }

    @Test
    public void carTest() {
    	Location location = new Location(); 
        Car car1 = new Car(Size.SMALL, new Long(1));
        Car car2 = new Car(Size.MEDIUM, new Long(2));

        location.addCar(car1);
        location.addCar(car2);

        Car carRetrieved = location.getCar(new Long(2));

        assertEquals("Car retrieval", carRetrieved.getId(), new Long(2));
    }

    @Test
    public void customerTest() {
        Location location = new Location(); 
        Customer customer1 = new Customer(new Long(1));
        Customer customer2 = new Customer(new Long(2));

        location.addCustomer(customer1);
        location.addCustomer(customer2);

        Customer customerRetrieved = location.getCustomer(new Long(2));

        assertEquals("Customer retrieval", customerRetrieved.getId(), new Long(2));
    }

    private void reserve2Cars(Location location) throws ParseException {
        try {
	        Customer customer1 = new Customer(new Long(1));
	        Customer customer2 = new Customer(new Long(2));

	        location.addCustomer(customer1);
	        location.addCustomer(customer2);

	        Car car1 = new Car(Size.SMALL, new Long(1));
	        Car car2 = new Car(Size.MEDIUM, new Long(2));
	        Car car3 = new Car(Size.LARGE, new Long(3));

	        location.addCar(car1);
	        location.addCar(car2);
	        location.addCar(car3); 

	        // Convert string to date
		    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		    Date dateStart = dateFormat.parse("01-01-2001 12:00:00");
		    Date dateEnd = dateFormat.parse("01-02-2001 12:00:00");
	        Reservation res1 = new Reservation(new Long(1) , customer1.getId(), dateStart, dateEnd, car1.getId()); 
	        Reservation res2 = new Reservation(new Long(2), customer2.getId(), dateStart, dateEnd, car2.getId()); 

	        location.addReservation(res1);
	        location.addReservation(res2); 
        } catch (ParseException pe) {
            System.out.println("Caught ParseException creating date " + pe.getMessage()); 
            throw pe; 
        }
	}
	    
    // Lets make some reservations
    @Test 
    public void reservationTest() {
    	try {
	    	Location location = new Location(); 
	    	reserve2Cars(location); 
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            Date dateStart = dateFormat.parse("01-01-2001 12:00:00");
            Date dateEnd = dateFormat.parse("01-02-2001 12:00:00");
	        LinkedList<Long> availableCars = location.getAvailableCars(dateStart, dateEnd);
	        // Only Car 3 should be available
	        assertEquals("Number of avialable cars", availableCars.size(), 1);
	        assertEquals("Available car retrieval", availableCars.getFirst(), new Long(3));
        } catch (ParseException pe) {
        	System.out.println("Caught ParseException creating date " + pe.getMessage()); 
        }
    }

     // Try to reserve car 1  which is already reserved 
    @Test 
    public void reserveInUseCarTest() {
        try {
            boolean caughtExpectedException = false; 
            Location location = new Location(); 
            reserve2Cars(location); 
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            Date dateStart = dateFormat.parse("01-01-2001 12:00:00");
            Date dateEnd = dateFormat.parse("01-02-2001 12:00:00");
            try {
              Reservation res = new Reservation(new Long(1) , new Long(1), dateStart, dateEnd, new Long(1));
              location.addReservation(res); 
            } catch (ConcurrentModificationException ce) {
                caughtExpectedException = true; 
            }
            assertTrue("Caught expected ConcurrentModificationException", caughtExpectedException);
            // Only Car 3 should be available
        } catch (ParseException pe) {
            fail("Caught ParseException creating date " + pe.getMessage());
        } 
    }

    // Try to reserve car 1  which is already reserved with startDate overlapping with the already 
    // reserverd car
    @Test 
    public void reserveCarStartDateInMiddleTest() {
        try {
            boolean caughtExpectedException = false; 
            Location location = new Location(); 
            reserve2Cars(location); 
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            Date dateStart = dateFormat.parse("01-01-2001 18:00:00");
            Date dateEnd = dateFormat.parse("01-02-2001 18:00:00");
            try {
              Reservation res = new Reservation(new Long(1) , new Long(1), dateStart, dateEnd, new Long(1));
              location.addReservation(res); 
            } catch (ConcurrentModificationException ce) {
                caughtExpectedException = true; 
            }
            assertTrue("Caught expected ConcurrentModificationException", caughtExpectedException);
            // Only Car 3 should be available
        } catch (ParseException pe) {
            fail("Caught ParseException creating date " + pe.getMessage());
        } 
    }

    // Try to reserve car 1  which is already reserved with endDate overlapping with the already 
    // reserverd car
    @Test 
    public void reserveCarEndDateInMiddleTest() {
        try {
            boolean caughtExpectedException = false; 
            Location location = new Location(); 
            reserve2Cars(location); 
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            Date dateStart = dateFormat.parse("01-01-2001 01:00:00");
            Date dateEnd = dateFormat.parse("01-02-2001 01:00:00");
            try {
              Reservation res = new Reservation(new Long(1) , new Long(1), dateStart, dateEnd, new Long(1));
              location.addReservation(res); 
            } catch (ConcurrentModificationException ce) {
                caughtExpectedException = true; 
            }
            assertTrue("Caught expected ConcurrentModificationException", caughtExpectedException);
            // Only Car 3 should be available
        } catch (ParseException pe) {
            fail("Caught ParseException creating date " + pe.getMessage());
        } 
    }

    @Test 
    public void reserveCarEndBeforeAndStartAfterReservedDates() {
        try {
            boolean caughtExpectedException = false; 
            Location location = new Location(); 
            reserve2Cars(location); 
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            Date dateStart = dateFormat.parse("01-01-2001 01:00:00");
            Date dateEnd = dateFormat.parse("01-02-2001 08:00:00");
            try {
              Reservation res = new Reservation(new Long(1) , new Long(1), dateStart, dateEnd, new Long(1));
              location.addReservation(res); 
            } catch (ConcurrentModificationException ce) {
                caughtExpectedException = true; 
            }
            assertTrue("Caught expected ConcurrentModificationException", caughtExpectedException);
            // Only Car 3 should be available
        } catch (ParseException pe) {
            fail("Caught ParseException creating date " + pe.getMessage());
        } 
    }

    @Test 
    public void reserveCarNoOverlapReservedDates() {
        try {
            boolean caughtException = false; // must be set to false to pass
            Location location = new Location(); 
            reserve2Cars(location); 
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            Date dateStart = dateFormat.parse("01-03-2001 01:00:00");
            Date dateEnd = dateFormat.parse("01-04-2001 01:00:00");
            try {
              Reservation res = new Reservation(new Long(1) , new Long(1), dateStart, dateEnd, new Long(1));
              location.addReservation(res); 
            } catch (ConcurrentModificationException ce) {
                caughtException = true; 
            }
            assertFalse("Caught unexpected ConcurrentModificationException", caughtException);
            // Only Car 3 should be available
        } catch (ParseException pe) {
            fail("Caught ParseException creating date " + pe.getMessage());
        } 
    }
}