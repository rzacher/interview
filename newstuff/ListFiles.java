/**
 * list the files in a directory
**/

package com.newstuff; 

import java.util.*; 
import java.io.*; 

public class ListFiles {

  public ListFiles() {

  } 

  public File[] listFiles(String dir) {
     File folder = new File(dir);
     File[] listOfFiles = folder.listFiles();
     return listOfFiles; 
  }


  public static void main(String[] args) {
     String dir = "./"; 


      ListFiles fileList = new  ListFiles();

     File[] files = fileList.listFiles(dir); 
     for (File file: files) {
         System.out.println(file); 
     }
   

  }
}
