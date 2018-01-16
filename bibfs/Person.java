package com.bibfs;

import java.util.*;

public class Person {
    final String fname;
    final String lname; 
    final int id;
    ArrayList<Integer> friends = new ArrayList<Integer>(); 
  
    public Person(int id, String fname, String lname) {
      this.id = id; 
      this.fname = fname; 
      this.lname = lname; 
    }
    
    public String getFname() {
      return fname;
    }
    
    public String getLname() {
      return lname;
    }
    
    public int getID() {
      return id; 
    }
    
    public void addFriend(int friendID) {
      friends.add(friendID); 
    }
    
    ArrayList<Integer> getFriends() {
      return friends; 
    }
    
    public String toString() {
      return fname + " " + lname + " id:" + id; 
    }

}


