package amazon;

import java.util.List;
import java.util.Collection; 
import java.util.*; 



public class BubbleSort {
	
	ArrayList<Integer> array; 
	
    public BubbleSort(List<Integer> array) {
    	this.array = new ArrayList<Integer>(array); 
    }
    	

	public void printArray() {
		for (Integer val : array) {
			System.out.print(val + " " );
		}
		System.out.println();
	}
	
	public void sort() {
		for (int i=array.size() - 1; i>0; i--) {
			for (int j=0; j<i; j++) { 
				if (array.get(j) > array.get(i)) {
					swap(j, i); 
				}
			}
		}
	}
	
	public void swap(int index1, int index2) {
		System.out.println("Swap " + index1 + " " + index2); 
		int temp1 = array.get(index1);
		int temp2 = array.get(index2); 
		array.remove(index1);
		array.add(index1, temp2);
		array.remove(index2); 
		array.add(index2, temp1);
		printArray(); 
	}
	
	public static void main(String[] args) {
		
	List<Integer> c = new LinkedList<Integer>();
	c.add(10);
	c.add(2);
	c.add(1);
    c.add(14);
    
    BubbleSort bs = new BubbleSort(c); 
    bs.printArray(); 
    bs.sort();
	}
	
}

