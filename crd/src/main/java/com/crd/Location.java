/**
 * Location class provides basic operations on a location. A location manages customers, cars and the 
 * reservations system. Location is responsible for orchestrating the relationships between cars, customers
 * and Reservations. 
 */

package com.crd;

import java.util.HashMap;
import java.util.ArrayList; 
import java.util.concurrent.ConcurrentHashMap;
import java.util.Date;
import java.util.HashSet; 
import java.util.LinkedList; 
import java.util.Collection;
import java.util.Iterator;
import java.util.ConcurrentModificationException; 

public class Location {
	HashMap<Long, Car> cars = new HashMap<Long, Car>();
	ConcurrentHashMap<Long, Reservation> reservations = new ConcurrentHashMap<Long, Reservation>();
	HashMap<Long, Customer> customers = new HashMap<Long, Customer>(); 

	synchronized public  void addCar(Car car) {
       cars.put(car.getId(), car); 
	}

	synchronized public void removeCar(Long id) {
	    cars.remove(id); 
	}

	synchronized public Car getCar(Long id) {
	    return cars.get(id); 
	}

	synchronized public void addCustomer(Customer customer) {
		customers.put(customer.getId(), customer); 
	}

    synchronized public void removeCustomer(Long id) {
		customers.remove(id); 
	}

	synchronized public Customer getCustomer(Long id) {
		return customers.get(id);
	}
     
     // Add a reservation. Make sure the car is available at the given time. 
    synchronized public void addReservation(Reservation reservation) throws ConcurrentModificationException {
    	// Check that the car is  available in the requested period
    	Long carId = reservation.getCarId(); 
    	LinkedList availableCars = getAvailableCars(reservation.getDateIn(), reservation.getDateOut()); 
    	if (availableCars.contains(carId)) {
    	   reservations.put(reservation.getId(), reservation);
    	} else {
    		throw new ConcurrentModificationException("Car is no longer available on requested date"); 
    	}
    }

    synchronized public void removeReservation(Long id) {
    	reservations.remove(id);
    }

    synchronized public Reservation getReservation(Long id) {
    	return reservations.get(id);
    }

    // Find all cars available between the in and out dates.
    // First find all the cars in use. All the other cars are free 
    // We're not synchronizing this since it will improve performance. 
    // Returns list of available cars. 
    public LinkedList<Long> getAvailableCars(Date dateIn, Date dateOut) {
    	HashSet<Long> carsInUse = new HashSet<Long>(); 
    	// Walk the list  and find all cars in use between dateIn and dateOut. 
    	// The rest are available
    	Collection reservationValues = reservations.values(); 
    	Iterator<Reservation> iterator = reservationValues.iterator();
 
        // while loop
        while (iterator.hasNext()) {
        	try {
	        	Reservation res = iterator.next(); 
	        	if (res != null) {
		    		if (dateOut.before(res.getDateIn())) {
		    			// car not is use
		    		} else if (dateIn.after(res.getDateOut())) {
		    			// car is not inuse
		    		} else if ( !dateIn.before(res.getDateIn()) &&  !dateOut.after(res.getDateOut())) {
		    			// We have a winner, this car is in use in the period in question
		                carsInUse.add(res.getCarId());
		    		} else {
		    			// there is some overlap
		    			carsInUse.add(res.getCarId());
		    		}
	    	    }
    	    } catch (ConcurrentModificationException ce) {
    	    	// list has changed since we got the reservation values. just keep going for the rest of the cars. 
    	    	System.out.println("Caught ConcurrentModificationException while looking for available cars. ");
    	    }
    	}

    	// Now find the available cars
    	LinkedList<Long> availableCars = new LinkedList<Long>();
    	// Walk the list of all the cars, if the car is not in use, add it to the available list
    	Collection carValues = cars.values(); 
    	Iterator<Car> carIterator = carValues.iterator();
        while (carIterator.hasNext()) {
        	 Car car = carIterator.next(); 
        	// If the car is not in use, add it to the available car list
        	if (!carsInUse.contains(car.getId())) {
        		availableCars.add(car.getId()); 
        	}
        }

        return availableCars; 
    }

}