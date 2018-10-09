/**
 * Reservation class provides basic operations on a Reservation. 
 */


package com.crd;

import com.crd.Customer;
import java.util.Date;  

public class Reservation {
	Long id; 
	Customer customer; 
	Date dateIn;
	Date dateOut;
	Long carId; 
    /**
     * id is the Reservation id
     * customerId
     * dateIn is the inclusive start date for the reservation
     * dateOut is the inclusive end date for the reservation. 
     * carId
     */ 
    public Reservation(Long id, Long customerId, Date dateIn, Date dateOut, Long carId) {
    	this.id = id; 
    	this.customer = customer;
    	this.dateIn = dateIn;
    	this.dateOut = dateOut; 
    	this.carId = carId; 
    }

    public Long getId() { return id;}
    public Customer getCustomer() { return customer;}
    public Date getDateIn() { return dateIn;}
    public Date getDateOut() { return dateOut;}
    public Long getCarId() { return carId;}
}