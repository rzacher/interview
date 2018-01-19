package com.newstuff; 

public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    Sex gender;
    String emailAddress;

    public int getAge() {
        return 19; 
    }

    public Sex getGender() {
      return Sex.MALE; 
    }
    
    public void printPerson() {
        // ...
    }
}
