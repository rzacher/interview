package learn;

public class BinarySearch {
	int count = 0; 
	
	int binarySearchRecursive(int[] array, int low, int hi, int target) {
		int result; 
		if (count++ > 10) {
			System.exit(1);
		}
		int length = array.length; 
	    int mid = (hi + low)/2;
	    System.out.println("mid: " + mid); 
	    if (mid > 10) {
	    	System.exit(1);
	    }
	    if (low > hi) {
	    	System.exit(1); 
	    }
		
		if (target > array[mid]) {
			System.out.println("mid+1: " + (mid+1) + " hi: " + hi);
			return binarySearchRecursive(array, (mid+1), hi, target); 
		} else if (target < array[mid]) {
			return binarySearchRecursive(array, low, mid-1, target);
		} else {
			if (target == array[mid]) {
			   return array[mid]; 
			} else {
				System.out.println("value not found");
				return -100; 
			}
		}
	}
	
	int binarySearchLoop(int[] array, int low, int hi, int target) {
		while (low <= hi) {
			int mid = (low + hi)/2;
			if (target == array[mid]) {
				System.out.println("Found match"); 
				return target; 
			} else if (target > array[mid]) {
				low = mid+1;
			} else if (target < array[mid]) {
				hi = mid-1; 
			} else {
				System.out.println("No match found");
				return -100; 
			} 
		}
		System.out.println("No match found");
		return -100;
		
	}
	
	public static void main(String[] args) {
		System.out.println("Hi Bob"); 
		// 1- 15, no 10
		int[] myArray = {1,2,3,4,5,6,7,9,10};
		int target = 7; 
		
		
		BinarySearch bSearch = new BinarySearch(); 
		try {
			int len =  myArray.length;
			System.out.println("length: " + len); 
			//int result = bSearch.binarySearchRecursive(myArray, 0, len - 1,  target);
			int result = bSearch.binarySearchLoop(myArray, 0, len - 1,  target);
			System.out.println("found value " + result); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}

