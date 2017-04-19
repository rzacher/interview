import java.utils.*;

public class SelectionSort {

  // data
  int[] array; 


  public SelectionSort(int[] array) {
     array = array; 
  }


  public void printArray() {
    for (int i=0; i< array.length; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println(""); 
  }

  public void  sort() {
    for (int i=0; i<array.length; i++) {
       int iMin = i; // init 

       for (j=i; j<array.length; j++) {


       }

    }

  } // end sort

  private void swap(int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp; 
  }
  
}

