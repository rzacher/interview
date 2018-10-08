This assignment should take 2-4 hours.

Design and prototype a car rental system using object-oriented principles. Please focus on delivering the following core features:

 

1.      The system should let a customer reserve a car of a given type at a desired date and time for a given number of days

2.     The number of cars of each type is limited, but customers should be able to reserve a single rental car for multiple, non-overlapping time frames++

3.      Provide a Junit test that illustrates the core reservation workflow and demonstrates its correctness

 

Please use Java as the implementation language.

 

While the solution should allow for extension to be exposed as a service, please note that

 

·        No UI needs to be provided

·        No need to explicitly suspend the solution in a web container, e.g. using spring boot

·        No need to explicitly integrate the solution with a database

 

If there are things that are not clear please feel free to make some assumptions and briefly mention those in the solution that you send back.


English description of object model

A Customer calls a Location. (Assume only one location). The customer provides a date/time and rental period (or a list of non-overlapping start dates and periods) and is shown a list of available cars types. He selects one and tries to reserve it. If successful, he gets a Reservation. Since both the Customer and the Location need and address, we will make that a separate object. 
We will provide four types of cars, Economy, mid-size sedan, large sedan and SUV. 

Since the goal is to eventually expose this as a service, we will stick to a CRUD interface to make the methods easily extensible to a REST service. Instead of a database, we will use in-memory storage. 

Customer 
first name
last name
license number
phone
email
Address
age

Location 
Address
phone

Car
Enum Type: small, medium, large, suv

How to store data for easy lookup





