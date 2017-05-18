package amazon;

import java.util.*;

public class KthMultiple {
	
	int getKthMagicNumber(int k) {
		if (k<0) return 0;
		
		int val = 1;
		Queue<Integer> q = new LinkedList<Integer>();
		addProducts(q, 1); // init the q
		for (int i=0; i<k; i++) {
			val = removeMin(q);
			System.out.println(val);
			addProducts(q, val);
		}
		return val;
	}
	
	int removeMin(Queue<Integer> q) {
		int min = q.peek(); 
		for (Integer v : q) {
			if (min > v) {
				min = v;
			}
		}
		
		while (q.contains(min)) {
			q.remove(min);
		}
		return min; 
	}
	
	void addProducts(Queue<Integer> q, int v) {
		q.add(3*v);
		q.add(5*v);
		q.add(7*v);
	}
	
	public static void main(String[] args) {
		System.out.println(args[0]);
		int k = Integer.parseInt(args[0]);
		KthMultiple km = new KthMultiple();
		int result = km.getKthMagicNumber(k);
		System.out.println("answer:" + result);
		
	}

}

